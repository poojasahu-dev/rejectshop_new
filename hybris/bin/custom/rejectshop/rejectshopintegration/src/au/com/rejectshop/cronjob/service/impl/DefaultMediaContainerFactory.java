/**
 *
 */
package au.com.rejectshop.cronjob.service.impl;

/**
 * @author Venkatapavani.t
 *
 */
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.mediaconversion.MediaConversionService;
import de.hybris.platform.mediaconversion.enums.ConversionStatus;
import de.hybris.platform.mediaconversion.model.ConversionGroupModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.media.dao.MediaContainerDao;
import de.hybris.platform.servicelayer.model.ModelService;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.cronjob.service.MediaContainerFactory;

/**
 * A factory for creating DefaultMediaContainer objects.
 */
public class DefaultMediaContainerFactory implements MediaContainerFactory
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DefaultMediaContainerFactory.class);

	/** The conversion service. */
	private MediaConversionService conversionService;

	/** The media container dao. */
	private MediaContainerDao mediaContainerDao;

	/** The media service. */
	private MediaService mediaService;

	/** The model service. */
	private ModelService modelService;

	/** The super zoom format. */
	private String superZoomFormat;

	/*
	 * Checks whether the media container exists with the input file name or not. If container exists skipping the
	 * creation process otherwise creating new container. Assign master media to the container. performing conversion
	 * operation. Finally returns the container with medias of all formats.
	 */

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.MediaContainerFactory#createContainerAndConvetMedia(java.io.File, de.hybris.platform.mediaconversion.model.ConversionGroupModel, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	@SuppressWarnings("deprecation")
	public MediaContainerModel createContainerAndConvertMedia(final File imageFile, final ConversionGroupModel conversionGroup,
			final CatalogVersionModel catalogVersion) throws ModelSavingException
	{
		LOG.info("createContainerAndConvetMedia Start");

		Assert.notNull(imageFile, "imageFile can't be null");
		Assert.notNull(conversionGroup, "conversionGroup can't be null");
		Assert.notNull(catalogVersion, "catalogversion can't be null");

		MediaContainerModel containerModel = null;
		List<MediaContainerModel> existedContainers = null;
		final String containerName = "gallary_".concat(imageFile.getName());
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
			LOG.error("Could not be found the Media container with the qualifier"+ exception);
		}
		//Assigning master media to the existing media container
		if (CollectionUtils.isNotEmpty(existedContainers))
		{
			createMasterMedia(imageFile, containerModel, catalogVersion);
		}
		//Creation of media container& assigning the master media to it.
		else
		{
			final MediaContainerModel newContainer = getModelService().create(MediaContainerModel.class);

			newContainer.setQualifier(containerName);
			newContainer.setConversionGroup(conversionGroup);
			newContainer.setCatalogVersion(catalogVersion);
			getModelService().save(newContainer);

			containerModel = newContainer;

			createMasterMedia(imageFile, containerModel, catalogVersion);
		}

		// Conversion Operation

		if (containerModel != null && containerModel.getMaster() != null)
		{
			getConversionService().convertMedias(containerModel);
		}
		else
		{
			LOG.error("Interuption In conversion. Missing MediaContainer or MasterMedia");
		}

		if (getConversionService().getConversionStatus(containerModel).equals(ConversionStatus.CONVERTED))
		{
			LOG.info("Image [" + imageFile.getName() + "] converted successfully");
		}
		else
		{
			LOG.warn("There are still conversion formats (either in the associated ConversionGroup or in general) which do not have a representation in the MediaContainer."
					+ "/n Status" + ConversionStatus.PARTIALLY_CONVERTED + imageFile.getName());
		}

		LOG.info("createContainerAndConvetMedia End");
		return containerModel;
	}

	/**
	 * Checks whether the media file exists with the input file name or not. If exists skipping the creation otherwise
	 * creating new container.
	 *
	 * @param imageFile
	 *           the image file
	 * @param newContainer
	 *           the new container
	 * @param catalogVersion
	 *           the catalog version
	 * @return MediaModel
	 */
	private MediaModel createMasterMedia(final File imageFile, final MediaContainerModel newContainer,
			final CatalogVersionModel catalogVersion)
	{

		MediaModel masterMediaModel = null;
		MediaModel existedMediaModel = null;
		final String masterMediaName = "masterMedia_".concat(imageFile.getName());
		try
		{
			existedMediaModel = getMediaService().getMedia(catalogVersion, masterMediaName);
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
			newMediaModel.setMediaFormat(getMediaService().getFormat(superZoomFormat));
			String mimeType = null;
			final String fileExtension = FilenameUtils.getExtension(masterMediaName);

			switch (fileExtension)
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
		}
		else
		{
			masterMediaModel = existedMediaModel;
		}
		DataInputStream dataInputStream = null;
		FileInputStream fileInputStream=null;
		try
		{
			fileInputStream =new FileInputStream(imageFile);
			dataInputStream = new DataInputStream(fileInputStream);

			getMediaService().setStreamForMedia(masterMediaModel, dataInputStream, masterMediaModel.getRealFileName(),
					masterMediaModel.getMime(), getMediaService().getFolder(RejectshopCoreConstants.MEDIA_FOLDER));

		}
		catch (final FileNotFoundException fileNotFoundException)
		{
			LOG.error("Image File Not Found", fileNotFoundException);

		}
		finally
		{
			if (dataInputStream != null)
			{
				try
				{
					dataInputStream.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the DataInputStream ", ioException);
				}
			}
			
			if (fileInputStream != null)
			{

				try
				{
					fileInputStream.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IOException while closing the FileInputStream ", ioException);
				}
			}
		}

		return masterMediaModel;
	}

	/**
	 * Gets the conversion service.
	 *
	 * @return conversionService
	 */
	public MediaConversionService getConversionService()
	{
		return conversionService;
	}

	/**
	 * Sets the conversion service.
	 *
	 * @param conversionService
	 *           the new conversion service
	 */
	public void setConversionService(final MediaConversionService conversionService)
	{
		this.conversionService = conversionService;
	}

	/**
	 * Gets the media service.
	 *
	 * @return mediaService
	 */
	public MediaService getMediaService()
	{
		return mediaService;
	}

	/**
	 * Sets the media service.
	 *
	 * @param mediaService
	 *           the new media service
	 */
	@Required
	public void setMediaService(final MediaService mediaService)
	{
		this.mediaService = mediaService;
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
	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * Gets the media container dao.
	 *
	 * @return mediaContainerDao
	 */
	public MediaContainerDao getMediaContainerDao()
	{
		return mediaContainerDao;
	}

	/**
	 * Sets the media container dao.
	 *
	 * @param mediaContainerDao
	 *           the new media container dao
	 */
	@Required
	public void setMediaContainerDao(final MediaContainerDao mediaContainerDao)
	{
		this.mediaContainerDao = mediaContainerDao;
	}

	/**
	 * Sets the super zoom format.
	 *
	 * @param superZoomFormat
	 *           the new super zoom format
	 */
	@Required
	public void setSuperZoomFormat(final String superZoomFormat)
	{
		this.superZoomFormat = superZoomFormat;
	}

	/**
	 * Gets the super zoom format.
	 *
	 * @return superZoomFormat
	 */
	public String getSuperZoomFormat()
	{
		return superZoomFormat;
	}
}
