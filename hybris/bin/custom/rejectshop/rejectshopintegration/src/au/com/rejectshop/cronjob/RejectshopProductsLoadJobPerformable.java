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

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.facade.RejectshopProductImportFacade;
import au.com.rejectshop.util.FileIOUtilities;

/**
 * The Class ProductsLoadJobPerformable.
 */
public class RejectshopProductsLoadJobPerformable extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(RejectshopProductsLoadJobPerformable.class);
	
	/** The input dir. */
	private String inputDir = null;
	
	/** The process dir. */
	private String processDir = null;
	
	/** The error dir. */
	private String errorDir = null;
	
	/** The rejectshop product import facade. */
	private RejectshopProductImportFacade rejectshopProductImportFacade;
	
	/**
	 * Instantiates a new products load job performable.
	 */
	public RejectshopProductsLoadJobPerformable()
	{
		inputDir = Config.getString(RejectshopCoreConstants.PRODUCT_INPUT_DIR, StringUtils.EMPTY);
		processDir = Config.getString(RejectshopCoreConstants.PRODUCT_PROCESS_DIR, StringUtils.EMPTY);
		errorDir = Config.getString(RejectshopCoreConstants.PRODUCT_ERROR_DIR, StringUtils.EMPTY);
	}

	@Override
	public PerformResult perform(CronJobModel arg0)
	{
		long startTime = FileIOUtilities.getCurrentTimeMillis();
		LOG.debug("********** Store Import CronJob Executing ************************"+startTime);
		if (!FileIOUtilities.validateDirectories(inputDir, processDir, errorDir))
		{
			LOG.error("Invalid directory configuration. Can not proceed");
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
      rejectshopProductImportFacade.processImportProdcuts(inputDir, processDir, errorDir);
			
      long endTime = FileIOUtilities.getCurrentTimeMillis();
      String totalexecutionTime = FileIOUtilities.msToString(startTime - endTime);
		LOG.debug("********** Store Import CronJob Execution Completed ************************"+endTime);
		LOG.info("********** Job execution time"+" hours : mins : secs  ************************"+totalexecutionTime);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	/**
	 * @return the rejectshopProductImportFacade
	 */
	public RejectshopProductImportFacade getRejectshopProductImportFacade()
	{
		return rejectshopProductImportFacade;
	}

	/**
	 * @param rejectshopProductImportFacade
	 *           the rejectshopProductImportFacade to set
	 */
	public void setRejectshopProductImportFacade(RejectshopProductImportFacade rejectshopProductImportFacade)
	{
		this.rejectshopProductImportFacade = rejectshopProductImportFacade;
	}

}
