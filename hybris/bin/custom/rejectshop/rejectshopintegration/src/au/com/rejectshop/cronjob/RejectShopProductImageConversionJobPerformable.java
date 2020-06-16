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
import au.com.rejectshop.cronjob.service.ProductImageConversionService;
import au.com.rejectshop.util.FileIOUtilities;


/**
 * The Class ProductImageConversionJobPerformable.
 *
 * @author subrahmanyam.n
 */
public class RejectShopProductImageConversionJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(RejectShopProductImageConversionJobPerformable.class);

	/** The product image conversion service. */
	private ProductImageConversionService productImageConversionService;

	/**
	 * Gets the product image conversion service.
	 *
	 * @return the productImageConversionService
	 */
	public ProductImageConversionService getProductImageConversionService()
	{
		return productImageConversionService;
	}

	/**
	 * Sets the product image conversion service.
	 *
	 * @param productImageConversionService
	 *           the productImageConversionService to set
	 */
	public void setProductImageConversionService(final ProductImageConversionService productImageConversionService)
	{
		this.productImageConversionService = productImageConversionService;
	}

	/** The input dir. */
	private String inputDir = null;

	/** The process dir. */
	private String processDir = null;

	/** The error dir. */
	private String errorDir = null;

	/**
	 * Instantiates a new product image conversion job performable.
	 */
	public RejectShopProductImageConversionJobPerformable()
	{

		inputDir = Config.getString(RejectshopCoreConstants.MEDIA_INPUT_DIR, StringUtils.EMPTY);
		processDir = Config.getString(RejectshopCoreConstants.MEDIA_PROCESS_DIR, StringUtils.EMPTY);
		errorDir = Config.getString(RejectshopCoreConstants.MEDIA_ERROR_DIR, StringUtils.EMPTY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel
	 * )
	 */
	@Override
	public PerformResult perform(final CronJobModel cronJobModel)
	{
		LOG.debug("**********Product Image Conversion CronJob Executing************************");
		if (!FileIOUtilities.validateDirectories(inputDir, processDir, errorDir))
		{
			LOG.error("Invalid directory configuration. Can not proceed");
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		productImageConversionService.autoconversionImage(inputDir, processDir, errorDir);

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
