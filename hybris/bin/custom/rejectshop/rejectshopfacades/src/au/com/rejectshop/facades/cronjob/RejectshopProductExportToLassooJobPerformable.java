/**
 *
 */
package au.com.rejectshop.facades.cronjob;

import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import au.com.rejectshop.facades.product.RejectshopProductExportFacade;


/**
 * @author Suresh.putrevu
 *
 */
public class RejectshopProductExportToLassooJobPerformable extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(RejectshopProductExportToLassooJobPerformable.class);

	private RejectshopProductExportFacade rejectshopProductExportFacade;

	private static final String CATALOG_ID = "rejectshopProductCatalog";

	private static final String VERSION = "Online";

	private static final int DEFAULT_START = 0;


	private static final int MAX_RESULTS = 2147483647;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.
	 * CronJobModel)
	 */
	@Override
	public PerformResult perform(final CronJobModel arg0)
	{

		final List<ProductOption> options = new ArrayList<ProductOption>(Arrays.asList(ProductOption.BASIC, ProductOption.PRICE,
				ProductOption.DESCRIPTION, ProductOption.GALLERY, ProductOption.CATEGORIES));


		rejectshopProductExportFacade.exportProductsForLasoo(CATALOG_ID, VERSION, options, DEFAULT_START, MAX_RESULTS);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	/**
	 * @return the rejectshopProductExportFacade
	 */
	public RejectshopProductExportFacade getRejectshopProductExportFacade()
	{
		return rejectshopProductExportFacade;
	}

	/**
	 * @param rejectshopProductExportFacade
	 *           the rejectshopProductExportFacade to set
	 */
	public void setRejectshopProductExportFacade(final RejectshopProductExportFacade rejectshopProductExportFacade)
	{
		this.rejectshopProductExportFacade = rejectshopProductExportFacade;
	}

}
