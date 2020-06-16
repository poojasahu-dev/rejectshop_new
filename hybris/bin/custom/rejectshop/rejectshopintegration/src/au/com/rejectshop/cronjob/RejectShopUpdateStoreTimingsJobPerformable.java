/**
 * 
 */
package au.com.rejectshop.cronjob;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.impex.constants.ImpExConstants;
import de.hybris.platform.impex.jalo.ImpExManager;
import de.hybris.platform.impex.jalo.ImpExMedia;
import de.hybris.platform.impex.jalo.cronjob.ImpExImportCronJob;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;

/**
 * @author sudheer K Tummala
 *
 */
public class RejectShopUpdateStoreTimingsJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	/** The log. */
	private static final Logger LOG = Logger.getLogger(RejectShopUpdateStoreTimingsJobPerformable.class);
	
	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel)
	 */
	@Override
	public PerformResult perform(CronJobModel cronJobModel)
	{
		// Creating import media

		final String impexURL = Config.getString(RejectshopCoreConstants.STORE_OPENINGHRS_FILEPATH, StringUtils.EMPTY);
		//File impexFile = new File(impexURL);
		for (File file : getFiles(impexURL)){
            perfromCronJob(file);
            LOG.info("Job finished--remove file ");
            file.delete();
        }


		LOG.info("########## Align customers to RD system, Cron Job successfully executed. ##########");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}


	protected List<File> getFiles(String path){

        LOG.info("file path--"+path);
		File[] inputFiles=null;
		try {
			inputFiles = new File(path).getCanonicalFile().listFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<File> files = new ArrayList<File>();
        Collections.addAll(files, inputFiles);
        for(File file : inputFiles) {
            LOG.info("files in collection--" + file.getAbsolutePath());
        }
        return files;



	}

	protected  void perfromCronJob(File file){
		final ImpExMedia jobMedia;
		try {
			jobMedia = ImpExManager.getInstance().createImpExMedia("myImportScript", "UTF-8");
			jobMedia.setFieldSeparator(';');
			jobMedia.setQuoteCharacter('\\');

			final InputStream inputStream = new FileInputStream(file);
			jobMedia.setData(inputStream, jobMedia.getCode() + "." + ImpExConstants.File.EXTENSION_IMPEX,ImpExConstants.File.MIME_TYPE_IMPEX);

			// create cronjob
			final ImpExImportCronJob cronJob = ImpExManager.getInstance().createDefaultImpExImportCronJob();
			cronJob.setEnableCodeExecution(true);
			cronJob.setJobMedia(jobMedia);

			// process import
			cronJob.getJob().perform(cronJob, true);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        LOG.info("Job is processed --");

	}


}
