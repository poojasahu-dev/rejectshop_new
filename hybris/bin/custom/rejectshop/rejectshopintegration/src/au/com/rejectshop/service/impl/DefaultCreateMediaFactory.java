/**
 * 
 */
package au.com.rejectshop.service.impl;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.media.dao.MediaContainerDao;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.service.CreateMediaFactory;

/**
 * @author shaiknajeer.b
 *
 */
public class DefaultCreateMediaFactory implements CreateMediaFactory
{
	
	private static final Logger LOG = Logger.getLogger(DefaultCreateMediaFactory.class);
	private MediaContainerDao mediaContainerDao;
	private MediaService mediaService;
   private ModelService modelService;
	private String styleSwatchFormat;
	private String miniZoomFormat;
	private String zoomFormat;
	private String productFormat;
	private String thumbnailFormat;
	private String cartIconFormat;
	private static final String STRING_EMPTY = "";
	private static final String PRODUCT_CODES_CONTAINS = Config.getString("image.conversion.product.codes.removeHyphens", STRING_EMPTY);
	private static final String PRODUCT_CODES_CONTAINS_HYPHENS = Config.getString("image.conversion.product.codes.removeHyphens",STRING_EMPTY);
	private ProductService productService;
	
	
	
	/**
	 * @return the productService
	 */
	public ProductService getProductService()
	{
		return productService;
	}



	/**
	 * @param productService the productService to set
	 */
	@Required
	public void setProductService(ProductService productService)
	{
		this.productService = productService;
	}



	public MediaContainerDao getMediaContainerDao()
	{
		return mediaContainerDao;
	}



	/**
	 * @param mediaContainerDao the mediaContainerDao to set
	 */
	public void setMediaContainerDao(MediaContainerDao mediaContainerDao)
	{
		this.mediaContainerDao = mediaContainerDao;
	}



	/**
	 * @return the mediaService
	 */
	public MediaService getMediaService()
	{
		return mediaService;
	}



	/**
	 * @param mediaService the mediaService to set
	 */
	public void setMediaService(MediaService mediaService)
	{
		this.mediaService = mediaService;
	}



	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}



	/**
	 * @param modelService the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}


	
	

	/**
	 * @return the styleSwatchFormat
	 */
	public String getStyleSwatchFormat()
	{
		return styleSwatchFormat;
	}



	/**
	 * @param styleSwatchFormat the styleSwatchFormat to set
	 */
	public void setStyleSwatchFormat(String styleSwatchFormat)
	{
		this.styleSwatchFormat = styleSwatchFormat;
	}



	/**
	 * @return the miniZoomFormat
	 */
	public String getMiniZoomFormat()
	{
		return miniZoomFormat;
	}



	/**
	 * @param miniZoomFormat the miniZoomFormat to set
	 */
	public void setMiniZoomFormat(String miniZoomFormat)
	{
		this.miniZoomFormat = miniZoomFormat;
	}



	/**
	 * @return the zoomFormat
	 */
	public String getZoomFormat()
	{
		return zoomFormat;
	}



	/**
	 * @param zoomFormat the zoomFormat to set
	 */
	public void setZoomFormat(String zoomFormat)
	{
		this.zoomFormat = zoomFormat;
	}



	/**
	 * @return the productFormat
	 */
	public String getProductFormat()
	{
		return productFormat;
	}



	/**
	 * @param productFormat the productFormat to set
	 */
	public void setProductFormat(String productFormat)
	{
		this.productFormat = productFormat;
	}



	/**
	 * @return the thumbnailFormat
	 */
	public String getThumbnailFormat()
	{
		return thumbnailFormat;
	}



	/**
	 * @param thumbnailFormat the thumbnailFormat to set
	 */
	public void setThumbnailFormat(String thumbnailFormat)
	{
		this.thumbnailFormat = thumbnailFormat;
	}



	/**
	 * @return the cartIconFormat
	 */
	public String getCartIconFormat()
	{
		return cartIconFormat;
	}



	/**
	 * @param cartIconFormat the cartIconFormat to set
	 */
	public void setCartIconFormat(String cartIconFormat)
	{
		this.cartIconFormat = cartIconFormat;
	}



	@Override
	public MediaContainerModel createContainerAddMedia(final File imageFile,final File fileToConvert30,final File fileToConvert65,final File fileToConvert300,final File fileToConvert515,final File fileToConvert1200, CatalogVersionModel catalogVersion)
	{
		
		LOG.info("createContainerAddMedia Start");

		MediaContainerModel containerModel = null;
		List<MediaContainerModel> existedContainers = null;
		final String containerName = imageFile.getName();
		try
		{
			existedContainers = getMediaContainerDao().findMediaContainersByQualifier(containerName);

			for (final MediaContainerModel existedContainer : existedContainers)
			{
				if (existedContainer.getCatalogVersion().equals(catalogVersion))
				{
					containerModel = existedContainer;
				}
			}
		}
		catch (final Exception exception)
		{
			LOG.error("Could not be found the Media container with the qualifier" + exception);
			LOG.info("Could not be found the Media container with the qualifier" + containerName);
		}
		//Assigning master media to the existing media container
		if (CollectionUtils.isNotEmpty(existedContainers))
		{
			createMasterMedia(imageFile,fileToConvert30,fileToConvert65,fileToConvert300,fileToConvert515,fileToConvert1200, containerModel, catalogVersion);
		}
		//Creation of media container& assigning the master media to it.
		else
		{
			final MediaContainerModel newContainer = getModelService().create(MediaContainerModel.class);

			newContainer.setQualifier(containerName);
			/* newContainer.setConversionGroup(conversionGroup); */
			newContainer.setCatalogVersion(catalogVersion);
			getModelService().save(newContainer);

			containerModel = newContainer;

			createMasterMedia(imageFile,fileToConvert30,fileToConvert65,fileToConvert300,fileToConvert515,fileToConvert1200, containerModel, catalogVersion);
		}

		LOG.info("createContainerAddConvetMedia End");
		return containerModel;
	}

	/**
	 * @param imageFile
	 * @param containerModel
	 * @param catalogVersion
	 * @return
	 */
	private MediaModel createMasterMedia(final File imageFile,final File fileToConvert30,final File fileToConvert65,final File fileToConvert300,final File fileToConvert515,final File fileToConvert1200, final MediaContainerModel newContainer,
			final CatalogVersionModel catalogVersion)
	{
		MediaModel masterMediaModel = null;
   	MediaModel existedMediaModel = null;
   	
   	MediaModel styleswatch30Model = null;
   	MediaModel existstyleswatch30Model = null;
   	
   	MediaModel zoomFormat515Model = null;
   	MediaModel existzoomFormat515Model = null;
   	
   	MediaModel miniZoomFormat1200Model = null;
   	MediaModel existminiZoomFormat1200Model = null;
   	
   	MediaModel productFormat300Model = null;
   	MediaModel existproductFormat300Model = null;
   	
     	MediaModel cartIconFormat65Model = null;
   	MediaModel existcartIconFormat65Model = null;
   	
   	final List<MediaModel> thumbMedias = new ArrayList<MediaModel>();
		final List<MediaContainerModel> proMediaContainer = new ArrayList<MediaContainerModel>();
   	final List<MediaModel> otherMedias = new ArrayList<MediaModel>();
   	final List<MediaModel> normalMedias = new ArrayList<MediaModel>();
   	final List<MediaModel> detailMedias = new ArrayList<MediaModel>();
		final List<String> removeHyphensfromProductCode = populateHyphensList(PRODUCT_CODES_CONTAINS_HYPHENS);
		
		
		final String masterMediaName = imageFile.getName();
		final String styleswatch30Name = fileToConvert30.getName();
		final String zoomFormat515Name = fileToConvert515.getName();
		final String miniZoomFormat1200Name = fileToConvert1200.getName();
		final String productFormat300Name = fileToConvert300.getName();
		final String cartIconFormat65Name = fileToConvert65.getName();
		
		
		
		
	  	try
		{
			existedMediaModel= getMediaService().getMedia(catalogVersion, masterMediaName);
		}
		catch (final Exception exception)
		{
			LOG.error("Could not be found the Media with the qualifier", exception);
			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
		}
	   if (existedMediaModel == null)
		{
			final MediaModel newMediaModel = getModelService().create(MediaModel.class);
			newMediaModel.setCode(masterMediaName);
			newMediaModel.setMediaContainer(newContainer);
			newMediaModel.setRealFileName(masterMediaName);
			newMediaModel.setCatalogVersion(catalogVersion);
			newMediaModel.setMediaFormat(getMediaService().getFormat(thumbnailFormat));
			String mimeType = null;
			final String fileExtension = FilenameUtils.getExtension(masterMediaName);
			switch(fileExtension)
			{
				case RejectshopCoreConstants.JPEG_FORMAT:
					mimeType = "image/jpeg";
					break;
				case RejectshopCoreConstants.PNG_FORMAT:
					mimeType = "image/png";
					break;
				case RejectshopCoreConstants.GIF_FORMAT:
					mimeType = "image/gif";
					break;
				default:
					mimeType = "image/jpeg";
					break;
			}
			newMediaModel.setMime(mimeType);
			getModelService().save(newMediaModel);
			masterMediaModel = newMediaModel;
		  
	   	thumbMedias.add(masterMediaModel);
		}
	   
	   
		
		try
		{
			existstyleswatch30Model=getMediaService().getMedia(catalogVersion, styleswatch30Name);
		}
		catch (final Exception exception)
		{
			LOG.error("Could not be found the Media with the qualifier", exception);
			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
		}

	   if (existstyleswatch30Model==null)
		{
			final MediaModel swatchMediaModel = getModelService().create(MediaModel.class);
			swatchMediaModel.setCode(styleswatch30Name);
			swatchMediaModel.setMediaContainer(newContainer);
			swatchMediaModel.setRealFileName(styleswatch30Name);
			swatchMediaModel.setCatalogVersion(catalogVersion);
			swatchMediaModel.setMediaFormat(getMediaService().getFormat(styleSwatchFormat));
			String mimeType = null;
			final String fileExtension = FilenameUtils.getExtension(styleswatch30Name);
			switch(fileExtension)
			{
				case RejectshopCoreConstants.JPEG_FORMAT:
					mimeType = "image/jpeg";
					break;
				case RejectshopCoreConstants.PNG_FORMAT:
					mimeType = "image/png";
					break;
				case RejectshopCoreConstants.GIF_FORMAT:
					mimeType = "image/gif";
					break;
				default:
					mimeType = "image/jpeg";
					break;
			}
			swatchMediaModel.setMime(mimeType);
			getModelService().save(swatchMediaModel);
			styleswatch30Model = swatchMediaModel;
			otherMedias.add(swatchMediaModel);
	}
	   
	   
	   try
		{
	   	existzoomFormat515Model=getMediaService().getMedia(catalogVersion, zoomFormat515Name);
		}
		catch (final Exception exception)
		{
			LOG.error("Could not be found the Media with the qualifier", exception);
			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
		}

	   if (existzoomFormat515Model==null)
		{
			final MediaModel zoomMediaModel = getModelService().create(MediaModel.class);
			zoomMediaModel.setCode(zoomFormat515Name);
			zoomMediaModel.setMediaContainer(newContainer);
			zoomMediaModel.setRealFileName(zoomFormat515Name);
			zoomMediaModel.setCatalogVersion(catalogVersion);
			zoomMediaModel.setMediaFormat(getMediaService().getFormat(zoomFormat));
			String mimeType = null;
			final String fileExtension = FilenameUtils.getExtension(zoomFormat515Name);
			switch(fileExtension)
			{
				case RejectshopCoreConstants.JPEG_FORMAT:
					mimeType = "image/jpeg";
					break;
				case RejectshopCoreConstants.PNG_FORMAT:
					mimeType = "image/png";
					break;
				case RejectshopCoreConstants.GIF_FORMAT:
					mimeType = "image/gif";
					break;
				default:
					mimeType = "image/jpeg";
					break;
			}
			zoomMediaModel.setMime(mimeType);
			getModelService().save(zoomMediaModel);
			zoomFormat515Model = zoomMediaModel;
			otherMedias.add(zoomMediaModel);
	}   
	   
	   try
	 		{
	   	existminiZoomFormat1200Model=getMediaService().getMedia(catalogVersion, miniZoomFormat1200Name);
	 		}
	 		catch (final Exception exception)
	 		{
	 			LOG.error("Could not be found the Media with the qualifier", exception);
	 			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
	 		}

	 	   if (existminiZoomFormat1200Model==null)
	 		{
	 			final MediaModel zoomMediaModel1200 = getModelService().create(MediaModel.class);
	 			zoomMediaModel1200.setCode(miniZoomFormat1200Name);
	 			zoomMediaModel1200.setMediaContainer(newContainer);
	 			zoomMediaModel1200.setRealFileName(miniZoomFormat1200Name);
	 			zoomMediaModel1200.setCatalogVersion(catalogVersion);
	 			zoomMediaModel1200.setMediaFormat(getMediaService().getFormat(miniZoomFormat));
	 			String mimeType = null;
	 			final String fileExtension = FilenameUtils.getExtension(miniZoomFormat1200Name);
	 			switch(fileExtension)
	 			{
	 				case RejectshopCoreConstants.JPEG_FORMAT:
	 					mimeType = "image/jpeg";
	 					break;
	 				case RejectshopCoreConstants.PNG_FORMAT:
	 					mimeType = "image/png";
	 					break;
	 				case RejectshopCoreConstants.GIF_FORMAT:
	 					mimeType = "image/gif";
	 					break;
	 				default:
	 					mimeType = "image/jpeg";
	 					break;
	 			}
	 			zoomMediaModel1200.setMime(mimeType);
	 			getModelService().save(zoomMediaModel1200);
	 			miniZoomFormat1200Model = zoomMediaModel1200;
	 			detailMedias.add(zoomMediaModel1200);
	 			otherMedias.add(zoomMediaModel1200);
	 			
	 	}      
	   
	   
	 	  try
	 		{
	 		 existproductFormat300Model=getMediaService().getMedia(catalogVersion, productFormat300Name);
	 		}
	 		catch (final Exception exception)
	 		{
	 			LOG.error("Could not be found the Media with the qualifier", exception);
	 			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
	 		}

	 	   if (existproductFormat300Model==null)
	 		{
	 			final MediaModel productFormat300 = getModelService().create(MediaModel.class);
	 			productFormat300.setCode(productFormat300Name);
	 			productFormat300.setMediaContainer(newContainer);
	 			productFormat300.setRealFileName(productFormat300Name);
	 			productFormat300.setCatalogVersion(catalogVersion);
	 			productFormat300.setMediaFormat(getMediaService().getFormat(productFormat));
	 			String mimeType = null;
	 			final String fileExtension = FilenameUtils.getExtension(productFormat300Name);
	 			switch(fileExtension)
	 			{
	 				case RejectshopCoreConstants.JPEG_FORMAT:
	 					mimeType = "image/jpeg";
	 					break;
	 				case RejectshopCoreConstants.PNG_FORMAT:
	 					mimeType = "image/png";
	 					break;
	 				case RejectshopCoreConstants.GIF_FORMAT:
	 					mimeType = "image/gif";
	 					break;
	 				default:
	 					mimeType = "image/jpeg";
	 					break;
	 			}
	 			productFormat300.setMime(mimeType);
	 			getModelService().save(productFormat300);
	 			productFormat300Model = productFormat300;
	 			normalMedias.add(productFormat300Model);
	 	}
	 	   
	 	  try
	 		{
	 		 existcartIconFormat65Model=getMediaService().getMedia(catalogVersion, cartIconFormat65Name);
	 		}
	 		catch (final Exception exception)
	 		{
	 			LOG.error("Could not be found the Media with the qualifier", exception);
	 			LOG.info("Could not be found the Media with the qualifier" + masterMediaName);
	 		}

	 	   if (existcartIconFormat65Model==null)
	 		{
	 			final MediaModel cartIconFormat65= getModelService().create(MediaModel.class);
	 			cartIconFormat65.setCode(cartIconFormat65Name);
	 			cartIconFormat65.setMediaContainer(newContainer);
	 			cartIconFormat65.setRealFileName(cartIconFormat65Name);
	 			cartIconFormat65.setCatalogVersion(catalogVersion);
	 			cartIconFormat65.setMediaFormat(getMediaService().getFormat(cartIconFormat));
	 			String mimeType = null;
	 			final String fileExtension = FilenameUtils.getExtension(cartIconFormat65Name);
	 			switch(fileExtension)
	 			{
	 				case RejectshopCoreConstants.JPEG_FORMAT:
	 					mimeType = "image/jpeg";
	 					break;
	 				case RejectshopCoreConstants.PNG_FORMAT:
	 					mimeType = "image/png";
	 					break;
	 				case RejectshopCoreConstants.GIF_FORMAT:
	 					mimeType = "image/gif";
	 					break;
	 				default:
	 					mimeType = "image/jpeg";
	 					break;
	 			}
	 			cartIconFormat65.setMime(mimeType);
	 			getModelService().save(cartIconFormat65);
	 			cartIconFormat65Model = cartIconFormat65;
	 			otherMedias.add(cartIconFormat65);
	 	}      
	   
	
	   final String productCode = FilenameUtils.getBaseName(masterMediaName);
	   ProductModel product = getProductService().getProductForCode(catalogVersion,
		removeHyphenfromProductCode(productCode, removeHyphensfromProductCode));
	   product.setThumbnail(masterMediaModel);
	   product.setThumbnails(thumbMedias);
	   product.setPicture(productFormat300Model);
	   product.setOthers(otherMedias);
	   product.setDetail(detailMedias);
	   
	   proMediaContainer.add(newContainer);
	   product.setGalleryImages(proMediaContainer);
		getModelService().save(product);  
			
			
		
		FileInputStream fileInputStream96= null;
		FileInputStream fileInputStream30 =null;
		FileInputStream fileInputStream515=null;
		FileInputStream fileInputStream1200 =null;
		FileInputStream fileInputStream300=null;
		FileInputStream fileInputStream65=null;
		DataInputStream dataInputStream96 = null;
		DataInputStream dataInputStream30 = null;
		DataInputStream dataInputStream515= null;
		DataInputStream dataInputStream1200= null;
		DataInputStream dataInputStream300 = null;
		DataInputStream dataInputStream65 = null;
	 
		
		
		try
		{
			fileInputStream96= new FileInputStream(imageFile);
			dataInputStream96=new DataInputStream(fileInputStream96);
   		getMediaService().setStreamForMedia(masterMediaModel, dataInputStream96, masterMediaModel.getRealFileName(),
					masterMediaModel.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		
   		fileInputStream30	= new FileInputStream(fileToConvert30);
			dataInputStream30=new DataInputStream(fileInputStream30);
   		getMediaService().setStreamForMedia(styleswatch30Model, dataInputStream30,styleswatch30Model.getRealFileName(),
   				styleswatch30Model.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		
   		
   		fileInputStream515 = new FileInputStream(fileToConvert515);
			dataInputStream515=new DataInputStream(fileInputStream515);
   		getMediaService().setStreamForMedia(zoomFormat515Model, dataInputStream515, zoomFormat515Model.getRealFileName(),
   				zoomFormat515Model.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		
   		fileInputStream1200= new FileInputStream(fileToConvert1200);
   		dataInputStream1200=new DataInputStream(fileInputStream1200);
   		getMediaService().setStreamForMedia(miniZoomFormat1200Model, dataInputStream1200, masterMediaModel.getRealFileName(),
					miniZoomFormat1200Model.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		
   		fileInputStream300= new FileInputStream(fileToConvert300);
   		dataInputStream300=new DataInputStream(fileInputStream300);
   		getMediaService().setStreamForMedia(productFormat300Model, dataInputStream300, productFormat300Model.getRealFileName(),
   				productFormat300Model.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		
   		fileInputStream65= new FileInputStream(fileToConvert65);
   		dataInputStream65=new DataInputStream(fileInputStream65);
   		getMediaService().setStreamForMedia(cartIconFormat65Model, dataInputStream65, cartIconFormat65Model.getRealFileName(),
   				cartIconFormat65Model.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));
   		   		

		}
		catch (final FileNotFoundException fileNotFoundException)
		{
			LOG.error("Image File Not Found", fileNotFoundException);

		}
		finally
		{
			if (dataInputStream96 != null)
			{
				try
				{
					dataInputStream96.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}
			}
			if (fileInputStream96 != null)
			{

				try
				{
					fileInputStream96.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}
			if (dataInputStream30 != null)
			{
				try
				{
					dataInputStream30.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}

			}
			if (fileInputStream30 != null)
			{

				try
				{
					fileInputStream30.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}

			if (dataInputStream515 != null)
			{
				try
				{
					dataInputStream515.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}

			}
			
			if (fileInputStream515 != null)
			{

				try
				{
					fileInputStream515.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}

			if (dataInputStream1200 != null)
			{
				try
				{
					dataInputStream1200.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}

			}
			
			if (fileInputStream1200 != null)
			{

				try
				{
					fileInputStream1200.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}
			
			if (dataInputStream300 != null)
			{
				try
				{
					dataInputStream300.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}

			}
			
			if (fileInputStream300 != null)
			{

				try
				{
					fileInputStream300.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}

			if (dataInputStream65 != null)
			{
				try
				{
					dataInputStream65.close();

				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}

			}
			
			if (fileInputStream65 != null)
			{

				try
				{
					fileInputStream65.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}

		}


		return masterMediaModel;
	}
	
	private List<String> populateHyphensList(final String hyPhenString)
	{
		final String hyphenList[] = StringUtils.split(hyPhenString, ",");
		return Arrays.asList(hyphenList);
	}
	
	
	private String removeHyphenfromProductCode(String itemCode, final List<String> removeHyphensfromProductCode)
	{

		for (final String codewithHypen : removeHyphensfromProductCode)
		{
			if (StringUtils.contains(itemCode, codewithHypen))
			{
				itemCode = StringUtils.replace(itemCode, codewithHypen, STRING_EMPTY);
				break;
			}
		}
		return itemCode;
	}
	
}
	