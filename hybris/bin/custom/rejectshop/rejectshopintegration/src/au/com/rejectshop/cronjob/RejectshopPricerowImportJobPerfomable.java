/**
 * 
 */
package au.com.rejectshop.cronjob;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.facade.RejectshopPricerRowImportFacade;
import au.com.rejectshop.facade.RejectshopProductImportFacade;
import au.com.rejectshop.util.FileIOUtilities;

/**
 * The Class RejectshopPricerowImportJobPerfomable.
 */
public class RejectshopPricerowImportJobPerfomable extends AbstractJobPerformable<CronJobModel>
{

	/** The rejectshop product import facade. */
	private RejectshopProductImportFacade rejectshopProductImportFacade;

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopPricerowImportJobPerfomable.class);


	/** The product import facade. */
	private RejectshopPricerRowImportFacade rejectshopPricerRowImportFacade;	


	/** The input dir. */
	private String inputDir = null;
	
	/** The process dir. */
	private String processDir = null;
	
	/** The error dir. */
	private String errorDir = null;

	
	/**
	 * Instantiates a new rejectshop pricerow import job perfomable.
	 */
	public RejectshopPricerowImportJobPerfomable()
	{
		inputDir = Config.getString(RejectshopCoreConstants.PRICEROW_INPUT_DIR, StringUtils.EMPTY);
		processDir = Config.getString(RejectshopCoreConstants.PRICEROW_PROCESS_DIR, StringUtils.EMPTY);
		errorDir = Config.getString(RejectshopCoreConstants.PRICEROW_ERROR_DIR, StringUtils.EMPTY);
	}

	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel)
	 */
	@Override
	public PerformResult perform(CronJobModel arg0)
	{
		LOG.info("********** Pricerow Import CronJob Executing ************************"+System.currentTimeMillis());
		if (!FileIOUtilities.validateDirectories(inputDir, processDir, errorDir))
		{
			LOG.error("Invalid directory configuration. Can not proceed");
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		rejectshopProductImportFacade.processImportPriceRows(inputDir, processDir, errorDir);

		LOG.info("********** Pricerow Import CronJob Execution Completed ************************"+System.currentTimeMillis());
		
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	/**
	 * Gets the rejectshop pricer row import facade.
	 *
	 * @return the rejectshopPricerRowImportFacade
	 */
	public RejectshopPricerRowImportFacade getRejectshopPricerRowImportFacade()
	{
		return rejectshopPricerRowImportFacade;
	}

	/**
	 * Sets the rejectshop pricer row import facade.
	 *
	 * @param rejectshopPricerRowImportFacade the rejectshopPricerRowImportFacade to set
	 */
	public void setRejectshopPricerRowImportFacade(RejectshopPricerRowImportFacade rejectshopPricerRowImportFacade)
	{
		this.rejectshopPricerRowImportFacade = rejectshopPricerRowImportFacade;
	}

	/**
	 * Gets the rejectshop product import facade.
	 *
	 * @return the rejectshopProductImportFacade
	 */
	public RejectshopProductImportFacade getRejectshopProductImportFacade()
	{
		return rejectshopProductImportFacade;
	}

	/**
	 * Sets the rejectshop product import facade.
	 *
	 * @param rejectshopProductImportFacade the rejectshopProductImportFacade to set
	 */
	@Required
	public void setRejectshopProductImportFacade(RejectshopProductImportFacade rejectshopProductImportFacade)
	{
		this.rejectshopProductImportFacade = rejectshopProductImportFacade;
	}
	
	

}
