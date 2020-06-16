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
import au.com.rejectshop.cronjob.service.RejectshopPOSImportService;
import au.com.rejectshop.util.FileIOUtilities;


/**
 * The Class RejectshopPOSImportJobPerfomable.
 */
public class RejectshopPOSImportJobPerfomable extends AbstractJobPerformable<CronJobModel>
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectshopPOSImportJobPerfomable.class);

	/** The rejectshop POS import service. */
	private RejectshopPOSImportService rejectshopPOSImportService;

	/**
	 * Gets the rejectshop POS import service.
	 *
	 * @return the rejectshopPOSImportService
	 */
	public RejectshopPOSImportService getRejectshopPOSImportService()
	{
		return rejectshopPOSImportService;
	}

	/**
	 * Sets the rejectshop POS import service.
	 *
	 * @param rejectshopPOSImportService the rejectshopPOSImportService to set
	 */
	public void setRejectshopPOSImportService(RejectshopPOSImportService rejectshopPOSImportService)
	{
		this.rejectshopPOSImportService = rejectshopPOSImportService;
	}

	/**
	 * Instantiates a new rejectshop product import job perfomable.
	 */
	public RejectshopPOSImportJobPerfomable()
	{
	}

	@Override
	public PerformResult perform(CronJobModel arg0)
	{
		long startTime = FileIOUtilities.getCurrentTimeMillis();
		LOG.debug("********** Store Import CronJob Executing ************************"+startTime);

		String inputDir = Config.getString(RejectshopCoreConstants.STORE_INPUT_DIR, StringUtils.EMPTY);
		String processDir = Config.getString(RejectshopCoreConstants.STORE_PROCESS_DIR, StringUtils.EMPTY);
		String errorDir = Config.getString(RejectshopCoreConstants.STORE_ERROR_DIR, StringUtils.EMPTY);
		LOG.info("input dir "+inputDir);
		LOG.info("process dir"+processDir);
		LOG.info("error dir "+errorDir);
		if (!FileIOUtilities.validateDirectories(inputDir, processDir, errorDir))
		{
			LOG.error("Invalid directory configuration. Can not proceed");
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}

		rejectshopPOSImportService.processImportPOS(inputDir, processDir, errorDir);

		long endTime = FileIOUtilities.getCurrentTimeMillis();
		String totalexecutionTime = FileIOUtilities.msToString(startTime - endTime);
		LOG.debug("********** Store Import CronJob Execution Completed ************************"+endTime);
		LOG.info("********** Job execution time"+" hours : mins : secs  ************************"+totalexecutionTime);

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
