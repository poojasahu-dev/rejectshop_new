/**
 *
 */
package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.mediaconversion.model.ConversionGroupModel;
import de.hybris.platform.util.Config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.cronjob.dao.ConversionGroupDAO;
import au.com.rejectshop.cronjob.service.MediaContainerFactory;
import au.com.rejectshop.cronjob.service.ProductImageConversionService;
import au.com.rejectshop.cronjob.service.ProductToMediaService;
import au.com.rejectshop.util.FileIOUtilities;


/**
 * Reads the files from the input folder and create the media container, master media. converts the master media to all
 * other supported formats. Assign the media to product.
 *
 */
public class DefaultProductImageConversionService implements ProductImageConversionService
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DefaultProductImageConversionService.class);

	/** The Constant CATALOG_ID. */
	private final static String CATALOG_ID = Config.getString(RejectshopCoreConstants.CATALOG_ID, "ProductCatalog");

	/** The Constant CATALOG_VERSION. */
	private final static String CATALOG_VERSION = Config.getString(RejectshopCoreConstants.CATALOG_VERSION_STAGED, "Staged");

	/** The Constant MEDIA_TYPE. */
	private final static String MEDIA_TYPE = Config.getString(RejectshopCoreConstants.MEDIA_TYPES, "jpeg");

	/** The Constant FILE_TYPE. */
	private final static String FILE_TYPE = Config.getString(RejectshopCoreConstants.ZIP_TYPES, "zip");

	/** The Constant CONVGROUP_CODE. */
	private final static String CONVGROUP_CODE = Config.getString(RejectshopCoreConstants.DEFAULT_CONVERSION_GROUP,
			"MediaConversionGroup");

	/** The conversion group. */
	private ConversionGroupDAO conversionGroup;

	/** The catalog version. */
	private CatalogVersionService catalogVersion;

	/** The media container. */
	private MediaContainerFactory mediaContainer;

	/** The product to media. */
	private ProductToMediaService productToMedia;

	/** The inputdir. */
	private String inputdir = null;

	/** The processdir. */
	private String processdir = null;

	/** The errordir. */
	private String errordir = null;

	/*
	 * Pickup the files from the input directory and filters the file.
	 */
	@Override
	public void autoconversionImage(final String inputDir, final String processDir, final String errorDir)
	{
		inputdir = inputDir;
		processdir = processDir;
		errordir = errorDir;

		final File[] inputFiles = new File(inputdir).listFiles();

		if (inputFiles.length > 0)
		{
			final List<File> fileToProcess = getFilesToProcess(inputFiles);

			if (CollectionUtils.isNotEmpty(fileToProcess))
			{
				for (final File fileToConvert : fileToProcess)
				{

					processFile(fileToConvert);
				}
			}
			else
			{
				LOG.warn("No Files To Process");
			}
		}
		else
		{
			LOG.warn("No Files To Read");
		}
	}

	/**
	 * Valid format files will allow to the process. gets the media container with all the hybris supported formats.
	 * Assigns the media to the product.
	 *
	 * @param fileToConvert
	 *           the file to convert
	 */
	private void processFile(final File fileToConvert)
	{
		final String fileName = fileToConvert.getName();
		final String fileExtension = FilenameUtils.getExtension(fileName);


		final CatalogVersionModel catalogVersion = getCatalogVersion().getCatalogVersion(CATALOG_ID, CATALOG_VERSION);

		final ConversionGroupModel defaultConversionGroup = getConversionGroup().getDefaultConversionGroup(CONVGROUP_CODE);

		try
		{

			if (isValidFileFormat(fileExtension, MEDIA_TYPE))
			{

				final MediaContainerModel mediaContainer = getMediaContainer().createContainerAndConvertMedia(fileToConvert,
						defaultConversionGroup, catalogVersion);
				if (mediaContainer == null)
				{
					LOG.info("MediaContainer Model is Not found");
				}
				else
				{
					final List<ProductModel> productModel = getProductToMedia().setMediasToProduct(fileName, mediaContainer,
							catalogVersion);
					if (CollectionUtils.isEmpty(productModel))
					{
						LOG.error("ProductModel is Not found, Moving File To Error folder filename:::" + fileName);
						movefileToErrorDir(fileToConvert.getName());
					}
			
				}

			}
			else
			{
				LOG.error(" \n Invalid File Format. Ignoring media conversion Please upload (.JPG or .PNG or .GIF) files" + "\b"
						+ fileName);
				movefileToErrorDir(fileToConvert.getName());
			}
		}
		catch (final Exception exception)
		{
			LOG.info("Error while processing the File ", exception);
			movefileToErrorDir(fileToConvert.getName());
		}

	}

	/**
	 * Reads all the files from the process directory and compare the file names with the input directory file names. If
	 * any duplicates are there then the duplicate file in the process directory moves to the error directory. After that
	 * all the files from the input directory moves to the process directory for process.
	 *
	 * @param inputFiles
	 *           the input files
	 * @return List<File>
	 */
	private List<File> getFilesToProcess(final File[] inputFiles)
	{
		final List<File> filesToProcess = new ArrayList<File>();
		final Map<String, String> filesOfproDir = new HashMap<String, String>();
		String fileName = null;

		final File processDir = new File(processdir);

		final File[] filesInProcessDir = processDir.listFiles();

		if (filesInProcessDir.length > 0)
		{

			for (final File fileInProcessDir : filesInProcessDir)
			{
				filesOfproDir.put(fileInProcessDir.getName(), fileInProcessDir.getName());
			}

		}

		for (final File file : inputFiles)
		{

			fileName = filesOfproDir.get(file.getName());

			if (fileName != null)
			{
				movefileToErrorDir(fileName);
			}

			FileIOUtilities.moveFile(inputdir.concat(File.separator).concat(file.getName()), processdir);

			final File fileInProcess = new File(processdir + File.separator + file.getName());


			if (isValidFileFormat(FilenameUtils.getExtension(fileInProcess.getName()), FILE_TYPE))
			{
				LOG.info("Unzipping file: {}" + fileInProcess.getPath());

				filesToProcess.addAll(unzip(fileInProcess, processDir));
			}
			else
			{
				filesToProcess.add(fileInProcess);

			}
		}
		return filesToProcess;
	}

	/**
	 * Moves the file from the process directory to the error directory by appending the file name with the timestamp.
	 *
	 * @param fileName
	 *           the file name
	 */
	private void movefileToErrorDir(final String fileName)
	{
		final long timestamp = new Date().getTime();
		final String targetFileName = FilenameUtils.getBaseName(fileName).concat("_" + timestamp + ".")
				.concat(FilenameUtils.getExtension(fileName));
		final File sourceFile = new File(processdir + File.separator + fileName);
		final File renameFile = new File(processdir + File.separator + targetFileName);

		try
		{
			if (sourceFile.renameTo(renameFile))
			{
				FileIOUtilities.moveFile(processdir + File.separator + renameFile.getName(), errordir);
			}
			else
			{
				LOG.info("Rename of the file to move error dir has failed");
			}
		}
		catch (final Exception exception)
		{
			LOG.info("Error While Moving File From ProcessDir To Error", exception);
		}
	}


	/**
	 * validates whether the file extension is in supported types.
	 *
	 * @param fileExtension
	 *           the file extension
	 * @param types
	 *           the types
	 * @return boolean
	 */
	private boolean isValidFileFormat(final String fileExtension, final String types)
	{

		final String[] list = types.split(",");

		final List<String> fileEx = Arrays.asList(list);

		return fileEx.contains(fileExtension) ? true : false;
	}

	/**
	 * unzip the zip file and returns the entries.
	 *
	 * @param zipFile
	 *           the zip file
	 * @param targetDir
	 *           the target dir
	 * @return List<File>
	 */
	public List<File> unzip(final File zipFile, final File targetDir)
	{
		final List<File> files = new ArrayList<File>();
		ZipFile zip = null;

		try
		{
			zip = new ZipFile(zipFile);
			for (final ZipEntry entry : Collections.list(zip.entries()))
			{
				final InputStream input = zip.getInputStream(entry);
				try
				{
					if (!targetDir.exists())
					{
						targetDir.mkdirs();
					}
					final File target = new File(targetDir, entry.getName());
					FileUtils.copyInputStreamToFile(input, target);
					files.add(target);
				}
				finally
				{
					IOUtils.closeQuietly(input);
				}
			}
		}
		catch (final Exception exception)
		{
			LOG.error("Error while Reading the zip File "+ exception);
			FileIOUtilities.moveFile(processdir.concat(File.separator).concat(zipFile.getName()), errordir);
		}
		finally
		{
			try
			{
				if (zip != null)
				{
					zip.close();
				}
			}
			catch (final IOException exception)
			{
				LOG.error("Error while Closing the zip File ", exception);
			}
		}
		return files;
	}

	/**
	 * Gets the conversion group.
	 *
	 * @return conversionGroup
	 */
	public ConversionGroupDAO getConversionGroup()
	{
		return conversionGroup;
	}

	/**
	 * Sets the conversion group.
	 *
	 * @param conversionGroup
	 *           the new conversion group
	 */
	@Required
	public void setConversionGroup(final ConversionGroupDAO conversionGroup)
	{
		this.conversionGroup = conversionGroup;
	}

	/**
	 * Gets the catalog version.
	 *
	 * @return catalogVersion
	 */
	public CatalogVersionService getCatalogVersion()
	{
		return catalogVersion;
	}

	/**
	 * Sets the catalog version.
	 *
	 * @param catalogVersion
	 *           the new catalog version
	 */
	@Required
	public void setCatalogVersion(final CatalogVersionService catalogVersion)
	{
		this.catalogVersion = catalogVersion;
	}

	/**
	 * Gets the media container.
	 *
	 * @return mediaContainer
	 */
	public MediaContainerFactory getMediaContainer()
	{
		return mediaContainer;
	}

	/**
	 * Sets the media container.
	 *
	 * @param mediaContainer
	 *           the new media container
	 */
	@Required
	public void setMediaContainer(final MediaContainerFactory mediaContainer)
	{
		this.mediaContainer = mediaContainer;
	}

	/**
	 * Gets the product to media.
	 *
	 * @return productToMedia
	 */
	public ProductToMediaService getProductToMedia()
	{
		return productToMedia;
	}

	/**
	 * Sets the product to media.
	 *
	 * @param productToMedia
	 *           the new product to media
	 */

	public void setProductToMedia(final ProductToMediaService productToMedia)
	{
		this.productToMedia = productToMedia;
	}
}
