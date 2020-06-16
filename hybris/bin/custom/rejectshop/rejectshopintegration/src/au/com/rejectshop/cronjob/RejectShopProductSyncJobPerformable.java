/**
 * 
 */
package au.com.rejectshop.cronjob;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.jalo.Catalog;
import de.hybris.platform.catalog.jalo.CatalogManager;
import de.hybris.platform.catalog.jalo.CatalogVersion;
import de.hybris.platform.catalog.jalo.SyncItemCronJob;
import de.hybris.platform.catalog.jalo.SyncItemJob;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.jalo.CronJob;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;


/**
 * The Class RejectShopProductSyncJobPerformable.
 *
 * @author subrahmanyam.n
 */
@SuppressWarnings("deprecation")
public class RejectShopProductSyncJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	/** The Constant LOG. */
	private final static Logger LOG = Logger.getLogger(RejectShopProductSyncJobPerformable.class);
	/** The catalog version service. */
	private CatalogVersionService catalogVersionService;

	/** The catalog id. */
	private String catalogId;

	/** The catalog version name. */
	private String catalogVersionName;

	/**
	 * Gets the catalog version service.
	 *
	 * @return the catalogVersionService
	 */
	public CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}

	/**
	 * Sets the catalog version service.
	 *
	 * @param catalogVersionService
	 *           the catalogVersionService to set
	 */
	public void setCatalogVersionService(CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}

	/**
	 * Gets the catalog id.
	 *
	 * @return the catalogId
	 */
	public String getCatalogId()
	{
		return catalogId;
	}

	/**
	 * Sets the catalog id.
	 *
	 * @param catalogId
	 *           the catalogId to set
	 */
	public void setCatalogId(String catalogId)
	{
		this.catalogId = catalogId;
	}

	/**
	 * Gets the catalog version name.
	 *
	 * @return the catalogVersionName
	 */
	public String getCatalogVersionName()
	{
		return catalogVersionName;
	}

	/**
	 * Sets the catalog version name.
	 *
	 * @param catalogVersionName
	 *           the catalogVersionName to set
	 */
	public void setCatalogVersionName(String catalogVersionName)
	{
		this.catalogVersionName = catalogVersionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel
	 * )
	 */
	@Override
	public PerformResult perform(CronJobModel cronJobModel)
	{
		PerformResult performResult = null;
		try
		{
			CatalogVersionModel catalogVersionModel = catalogVersionService.getCatalogVersion(catalogId, catalogVersionName);
			performResult = executeCatalogSyncJob(catalogVersionModel.getCatalog().getId());
			modelService.save(cronJobModel);
		}
		catch (ModelSavingException modelSaveException)
		{
			LOG.error(modelSaveException);
		}
		return new PerformResult(performResult.getResult(), performResult.getStatus());
	}

	/**
	 * Execute catalog sync job.
	 *
	 * @param id
	 *           the id
	 * @return the perform result
	 */
	@SuppressWarnings("deprecation")
	private PerformResult executeCatalogSyncJob(String id)
	{
		final SyncItemJob catalogSyncJob = getCatalogSyncJob(catalogId);
		if (catalogSyncJob != null)
		{
			final SyncItemCronJob syncJob = getLastFailedSyncCronJob(catalogSyncJob);
			syncJob.setLogToDatabase(false);
			syncJob.setLogToFile(false);
			syncJob.setForceUpdate(false);

			LOG.info("########## Created cronjob [" + syncJob.getCode() + "] to synchronize catalog [" + catalogId
					+ "] staged to online version. ##########");
			LOG.info("########## Configuring full version sync ##########");
			catalogSyncJob.configureFullVersionSync(syncJob);
			LOG.info("########## Starting synchronization, this may take a while ... ##########");
			catalogSyncJob.perform(syncJob, true);
			LOG.info("########## Synchronization completed for catalog [" + catalogId + "] ##########");
			final CronJobResult result = modelService.get(syncJob.getResult());
			final CronJobStatus status = modelService.get(syncJob.getStatus());
			return new PerformResult(result, status);
		}
		LOG.error("########## Couldn't find 'SyncItemJob' for catalog [" + catalogId + "] ##########");
		return new PerformResult(CronJobResult.UNKNOWN, CronJobStatus.UNKNOWN);

	}

	/**
	 * Gets the catalog sync job.
	 *
	 * @param catalogId
	 *           the catalog id
	 * @return the catalog sync job
	 */
	@SuppressWarnings("deprecation")
	protected SyncItemJob getCatalogSyncJob(final String catalogId)
	{
		// Lookup the catalog name
		final Catalog catalog = CatalogManager.getInstance().getCatalog(catalogId);
		if (catalog != null)
		{
			final CatalogVersion source = catalog.getCatalogVersion(CatalogManager.OFFLINE_VERSION);
			final CatalogVersion target = catalog.getCatalogVersion(CatalogManager.ONLINE_VERSION);

			if (source != null && target != null)
			{
				return CatalogManager.getInstance().getSyncJob(source, target);
			}
		}
		return null;
	}

	/**
	 * Returns the last cronjob if exists and failed or the new one otherwise.
	 *
	 * @param syncItemJob
	 *           the sync item job
	 * @return synchronization cronjob - new one or the last one if failed
	 */
	@SuppressWarnings("deprecation")
	protected SyncItemCronJob getLastFailedSyncCronJob(final SyncItemJob syncItemJob)
	{
		SyncItemCronJob syncCronJob = null;
		if (CollectionUtils.isNotEmpty(syncItemJob.getCronJobs()))
		{
			final List<CronJob> cronjobs = new ArrayList<CronJob>(syncItemJob.getCronJobs());
			Collections.sort(cronjobs, new Comparator<CronJob>()
			{
				@Override
				public int compare(final CronJob o1, final CronJob o2)
				{
					if (o1 == null || o1.getEndTime() == null || o2 == null || o2.getEndTime() == null)
					{
						return 0;
					}
					return o1.getEndTime().compareTo(o2.getEndTime());
				}
			});
			final SyncItemCronJob latestCronJob = (SyncItemCronJob) cronjobs.get(cronjobs.size() - 1);
			final CronJobResult result = modelService.get(latestCronJob.getResult());
			final CronJobStatus status = modelService.get(latestCronJob.getStatus());
			if (CronJobStatus.FINISHED.equals(status) && !CronJobResult.SUCCESS.equals(result))
			{
				syncCronJob = latestCronJob;
			}
		}
		if (syncCronJob == null)
		{
			syncCronJob = syncItemJob.newExecution();
		}
		return syncCronJob;
	}

}
