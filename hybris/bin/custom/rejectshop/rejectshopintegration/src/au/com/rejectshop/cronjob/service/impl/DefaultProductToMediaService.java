/**
 *
 */
package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.media.Media;
import de.hybris.platform.jalo.media.MediaContainer;
import de.hybris.platform.jalo.media.MediaFormat;
import de.hybris.platform.jalo.media.MediaManager;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import au.com.rejectshop.cronjob.service.ProductToMediaService;
import au.com.rejectshop.cronjob.service.RejectshopProductImportService;


/**
 * The Class DefaultProductToMediaService.
 */
public class DefaultProductToMediaService implements ProductToMediaService
{

	/** The Constant STRING_EMPTY. */
	private static final String STRING_EMPTY = "";

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DefaultProductToMediaService.class);

	/** The Constant PRODUCT_CODES_CONTAINS. */
	private static final String PRODUCT_CODES_CONTAINS = Config.getString("image.conversion.product.codes.removeHyphens", STRING_EMPTY);

	/** The Constant PRODUCT_CODES_CONTAINS_HYPHENS. */
	private static final String PRODUCT_CODES_CONTAINS_HYPHENS = Config.getString("image.conversion.product.codes.removeHyphens",
			STRING_EMPTY);

	/** The mini zoom format. */
	private String miniZoomFormat;

	/** The zoom format. */
	private String zoomFormat;

	/** The product format. */
	private String productFormat;

	private String styleSwatchFormat;

	/** The thumbnail format. */
	private String thumbnailFormat;

	/** The cart icon format. */
	private String cartIconFormat;

	/** The product service. */
	private ProductService productService;

	/** The model service. */
	private ModelService modelService;

	private RejectshopProductImportService rejectshopProductImportService;

	/*
	 * gets the product model based on the filename. If productmodel exists assigns the converted medias and media
	 * container to the product.
	 */

	/**
	 * @return the rejectshopProductImportService
	 */
	public RejectshopProductImportService getRejectshopProductImportService()
	{
		return rejectshopProductImportService;
	}

	/**
	 * @param rejectshopProductImportService
	 *           the rejectshopProductImportService to set
	 */
	public void setRejectshopProductImportService(RejectshopProductImportService rejectshopProductImportService)
	{
		this.rejectshopProductImportService = rejectshopProductImportService;
	}

	@Override
	public List<ProductModel> setMediasToProduct(final String imageFileName, final MediaContainerModel mediaContainerModel,
			final CatalogVersionModel catalogVersion)
	{
		LOG.info("setMediasToProduct started");

		Assert.notNull(imageFileName, "filename can't be null");
		Assert.notNull(mediaContainerModel, "media container can't be null");
		Assert.notNull(catalogVersion, "catalogversion can't be null");

		List<ProductModel> productModelist = new ArrayList<ProductModel>();
		final List<String> productCodeswithHyphen = populateHyphensList(PRODUCT_CODES_CONTAINS);
		final List<String> removeHyphensfromProductCode = populateHyphensList(PRODUCT_CODES_CONTAINS_HYPHENS);

		final String productCode = FilenameUtils.getBaseName(imageFileName);

		try
		{
			final ProductModel product = getProductService().getProductForCode(catalogVersion,
					removeHyphenfromProductCode(productCode, removeHyphensfromProductCode));
			if (product != null)
			{
				productModelist.add(product);
			}

		}
		catch (final Exception exception)
		{
			LOG.info("Exception :::" + exception);
			LOG.info("No product with the provided Code :::" + StringUtils.replace(productCode, "-1", STRING_EMPTY));
		}

		try
		{
			if (CollectionUtils.isEmpty(productModelist))
			{
				productModelist = rejectshopProductImportService.getProductForActualCode(catalogVersion,
						removeHyphenfromProductCode(productCode, removeHyphensfromProductCode));
			}
			LOG.info("Product with the provided Code :::" + StringUtils.replace(productCode, "-1", STRING_EMPTY));
		}
		catch (final Exception ex)
		{
			LOG.info("Exception :::" + ex);
			LOG.info("No product with the provided Code :::" + StringUtils.replace(productCode, "-1", STRING_EMPTY));
		}

		if (CollectionUtils.isNotEmpty(productModelist))
		{

			final MediaContainer mediaContainer = getModelService().getSource(mediaContainerModel);
			final Media miniZoom = mediaContainer.getMedia(getPictureFormat(miniZoomFormat));
			//final Media elevateZoom = mediaContainer.getMedia(getPictureFormat(elevateZoomFormat));
			//final Media superZoom = mediaContainer.getMedia(getPictureFormat(superZoomFormat));
			final Media zoom = mediaContainer.getMedia(getPictureFormat(zoomFormat));
			final Media product = mediaContainer.getMedia(getPictureFormat(productFormat));
			final Media cartIcon = mediaContainer.getMedia(getPictureFormat(cartIconFormat));
			final Media thumbnail = mediaContainer.getMedia(getPictureFormat(thumbnailFormat));
			final Media styleSwatch = mediaContainer.getMedia(getPictureFormat(styleSwatchFormat));

			for (final ProductModel productModel : productModelist)
			{
				final List<MediaModel> otherMedias = new ArrayList<MediaModel>();
				final List<MediaModel> detailMedias = new ArrayList<MediaModel>();
				final List<MediaModel> normalMedias = new ArrayList<MediaModel>();
				final List<MediaModel> thumbMedias = new ArrayList<MediaModel>();
				final List<MediaContainerModel> proMediaContainer = new ArrayList<MediaContainerModel>();

				if (productModel != null && prodcutcodeContainsHyphen(productCode, productCodeswithHyphen) && zoom != null
						&& cartIcon != null)
				{
					otherMedias.add((MediaModel) getModelService().get(miniZoom));
					//otherMedias.add((MediaModel) getModelService().get(elevateZoom));
					otherMedias.add((MediaModel) getModelService().get(zoom));
					otherMedias.add((MediaModel) getModelService().get(cartIcon));
					otherMedias.add((MediaModel) getModelService().get(styleSwatch));

					final HashMap mediaMap = (HashMap) setOtherMedias(productModel, otherMedias);

					final MediaModel productMedia = (MediaModel) getModelService().get(product);
					normalMedias.add(productMedia);
					productModel.setNormal(normalMedias);
					productModel.setOthers(new ArrayList<MediaModel>(mediaMap.values()));
					getModelService().save(productModel);
					LOG.info("The Zoom, cartIcon, styleSwatch media format Added To the Product with Hyphen");

				}

				if (productModel != null && !prodcutcodeContainsHyphen(productCode, productCodeswithHyphen))
				{
					if (miniZoom != null)
					{
						detailMedias.add((MediaModel) getModelService().get(miniZoom));

						if (productModel.getDetail() == null || !detailMedias.equals(productModel.getDetail()))
						{
							productModel.setDetail(detailMedias);
						}

						LOG.info("The super Zoom media format Added To the Product");
					}
					else
					{
						LOG.warn(" Super Zoom Image is null:::: Skipping Assignment To Product");
					}

					if (zoom != null && cartIcon != null)
					{
						otherMedias.add((MediaModel) getModelService().get(miniZoom));
						//otherMedias.add((MediaModel) getModelService().get(elevateZoom));
						otherMedias.add((MediaModel) getModelService().get(zoom));
						otherMedias.add((MediaModel) getModelService().get(cartIcon));
						otherMedias.add((MediaModel) getModelService().get(styleSwatch));

						final HashMap otherMediaMap = (HashMap) setOtherMedias(productModel, otherMedias);

						if (productModel.getOthers() == null || !otherMedias.equals(productModel.getOthers()))
						{
							productModel.setOthers(new ArrayList<MediaModel>(otherMediaMap.values()));
						}
						LOG.info("The Zoom, cartIcon, styleSwatch media format Added To the Product");
					}
					else
					{
						LOG.warn("Missing Media formats In ZOOM or CARTICON or STYLESWATCH");
					}
					if (product != null)
					{
						final MediaModel productMedia = (MediaModel) getModelService().get(product);
						normalMedias.add(productMedia);

						if (productModel.getNormal() == null || !normalMedias.equals(productModel.getNormal()))
						{
							productModel.setNormal(normalMedias);
						}
						if (productMedia != null
								&& (productModel.getPicture() == null || !productMedia.equals(productModel.getPicture())))
						{
							productModel.setPicture(productMedia);
						}
						LOG.info("The product media format Added To the Product");
					}
					else
					{
						LOG.warn("Missing Media formats In ZOOM or Product");
					}
					if (thumbnail != null)
					{
						final MediaModel thumbnailMedia = (MediaModel) getModelService().get(thumbnail);
						thumbMedias.add(thumbnailMedia);

						if (productModel.getThumbnails() == null || !thumbMedias.equals(productModel.getThumbnails()))
						{
							productModel.setThumbnails(thumbMedias);
						}
						if (thumbnailMedia != null
								&& (productModel.getThumbnail() == null || !thumbnailMedia.equals(productModel.getThumbnail())))
						{
							productModel.setThumbnail(thumbnailMedia);
						}
						LOG.info("The thumbnail media format Added To the Product");
					}
					else
					{
						LOG.warn("Missing Media formats In Thumbnails");
					}

				}
				proMediaContainer.add(mediaContainerModel);
				if (productModel.getGalleryImages() == null || !proMediaContainer.equals(productModel.getGalleryImages()))
				{
					if (CollectionUtils.isNotEmpty(productModel.getGalleryImages()))
					{
						for (MediaContainerModel container : productModel.getGalleryImages())
						{

							proMediaContainer.add(container);
						}
					}
					for (MediaContainerModel container : proMediaContainer)
					{
						LOG.info(container);
					}

					Collections.sort(proMediaContainer, new MediaContainerComparator());
					Collections.reverse(proMediaContainer);

					//List<MediaContainerModel> sortedMediaContainerList = sortMediaContainerList(proMediaContainer);

					productModel.setGalleryImages(proMediaContainer);

				}
				getModelService().save(productModel);
			}
			LOG.info("setMediasToProduct Ended");
		}
		return productModelist;
	}




	/**
	 * @param proMediaContainer
	 */
	private List<MediaContainerModel> sortMediaContainerList(List<MediaContainerModel> proMediaContainer)
	{
		List<String> qualifiers = new ArrayList<String>();
		Map<String, MediaContainerModel> mediaConMap = new HashMap<String, MediaContainerModel>();
		for (MediaContainerModel mcm : proMediaContainer)
		{
			String qualifier = mcm.getQualifier();
			qualifiers.add(qualifier);
			mediaConMap.put(qualifier, mcm);
		}
		Collections.sort(qualifiers);
		List<MediaContainerModel> sortedMediaConList = new ArrayList<MediaContainerModel>();

		for (String qualifier : qualifiers)
		{
			sortedMediaConList.add(mediaConMap.get(qualifier));
		}
		return sortedMediaConList;
	}

	/**
	 * Sets the other medias.
	 * 
	 * @param productModel
	 *           the product model
	 * @param otherMedias
	 *           the other medias
	 * @return the map
	 */
	private Map setOtherMedias(final ProductModel productModel, final List<MediaModel> otherMedias)
	{
		final Collection<MediaModel> mediaMidelList = new ArrayList<MediaModel>();
		final Collection<MediaModel> mediaModels = productModel.getOthers();
		final HashMap mediaMap = new HashMap<String, MediaModel>();
		mediaMidelList.addAll(mediaModels);

		for (final MediaModel otherMedia : otherMedias)
		{
			mediaMidelList.add(otherMedia);
		}
		// Removing Duplicate entries
		for (final MediaModel mediaModel : mediaMidelList)
		{
			mediaMap.put(mediaModel.getCode(), mediaModel);
		}
		return mediaMap;
	}

	/**
	 * Removes the hyphenfrom product code.
	 * 
	 * @param productCode
	 *           the product code
	 * @param removeHyphensfromProductCode
	 *           the remove hyphensfrom product code
	 * @return string
	 */
	private String removeHyphenfromProductCode(String products_Code, final List<String> removeHyphensfromProductCode)
	{

		for (final String codewithHypen : removeHyphensfromProductCode)
		{
			if (StringUtils.contains(products_Code, codewithHypen))
			{
				products_Code = StringUtils.replace(products_Code, codewithHypen, STRING_EMPTY);
				break;
			}
		}
		return products_Code;
	}

	/**
	 * Prodcutcode contains hyphen.
	 * 
	 * @param productCode
	 *           the product code
	 * @param productCodeswithHyphen
	 *           the product codeswith hyphen
	 * @return boolean
	 */
	private boolean prodcutcodeContainsHyphen(final String productCode, final List<String> productCodeswithHyphen)
	{
		boolean hyPhenflag = false;

		for (final String codewithHypen : productCodeswithHyphen)
		{
			if (StringUtils.contains(productCode, codewithHypen))
			{
				hyPhenflag = true;
				break;
			}
		}
		return hyPhenflag;
	}

	/**
	 * Populate hyphens list.
	 * 
	 * @param hyPhenString
	 *           the hy phen string
	 * @return list
	 */
	private List<String> populateHyphensList(final String hyPhenString)
	{
		final String hyphenList[] = StringUtils.split(hyPhenString, ",");
		return Arrays.asList(hyphenList);
	}

	/**
	 * Gets the picture format.
	 * 
	 * @param mediaFormat
	 *           the media format
	 * @return MediaFormat
	 */
	private static MediaFormat getPictureFormat(final String mediaFormat)
	{
		return MediaManager.getInstance().getMediaFormatByQualifier(mediaFormat);
	}



	/**
	 * Gets the mini zoom format.
	 * 
	 * @return miniZoomFormat
	 */
	public String getMiniZoomFormat()
	{
		return miniZoomFormat;
	}

	/**
	 * Sets the mini zoom format.
	 * 
	 * @param miniZoomFormat
	 *           the new mini zoom format
	 */
	public void setMiniZoomFormat(final String miniZoomFormat)
	{
		this.miniZoomFormat = miniZoomFormat;
	}



	/**
	 * Gets the zoom format.
	 * 
	 * @return zoomFormat
	 */
	public String getZoomFormat()
	{
		return zoomFormat;
	}

	/**
	 * Sets the zoom format.
	 * 
	 * @param zoomFormat
	 *           the new zoom format
	 */
	public void setZoomFormat(final String zoomFormat)
	{
		this.zoomFormat = zoomFormat;
	}

	/**
	 * Gets the product format.
	 * 
	 * @return productFormat
	 */
	public String getProductFormat()
	{
		return productFormat;
	}

	/**
	 * Sets the product format.
	 * 
	 * @param productFormat
	 *           the new product format
	 */
	public void setProductFormat(final String productFormat)
	{
		this.productFormat = productFormat;
	}

	/**
	 * Gets the thumbnail format.
	 * 
	 * @return thumbnailFormat
	 */
	public String getThumbnailFormat()
	{
		return thumbnailFormat;
	}

	/**
	 * Sets the thumbnail format.
	 * 
	 * @param thumbnailFormat
	 *           the new thumbnail format
	 */
	public void setThumbnailFormat(final String thumbnailFormat)
	{
		this.thumbnailFormat = thumbnailFormat;
	}

	/**
	 * Gets the cart icon format.
	 * 
	 * @return cartIconFormat
	 */
	public String getCartIconFormat()
	{
		return cartIconFormat;
	}

	/**
	 * Sets the cart icon format.
	 * 
	 * @param cartIconFormat
	 *           the new cart icon format
	 */
	public void setCartIconFormat(final String cartIconFormat)
	{
		this.cartIconFormat = cartIconFormat;
	}

	/**
	 * Gets the model service.
	 * 
	 * @return modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * Sets the model service.
	 * 
	 * @param modelService
	 *           the new model service
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * Gets the product service.
	 * 
	 * @return productService
	 */
	public ProductService getProductService()
	{
		return productService;
	}

	/**
	 * Sets the product service.
	 * 
	 * @param productService
	 *           the new product service
	 */
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}

	/**
	 * @return the styleSwatchFormat
	 */
	public String getStyleSwatchFormat()
	{
		return styleSwatchFormat;
	}

	/**
	 * @param styleSwatchFormat
	 *           the styleSwatchFormat to set
	 */
	public void setStyleSwatchFormat(String styleSwatchFormat)
	{
		this.styleSwatchFormat = styleSwatchFormat;
	}

}
