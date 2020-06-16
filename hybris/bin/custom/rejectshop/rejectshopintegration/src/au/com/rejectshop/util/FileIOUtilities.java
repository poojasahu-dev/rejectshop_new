/**
 *
 */
package au.com.rejectshop.util;

import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.util.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.apache.commons.lang.StringUtils;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.facade.impl.DateUtils;


/**
 * The Class FileIOUtilities.
 */
public class FileIOUtilities {
	
	/** The Constant LOG. */
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(FileIOUtilities.class);
	/** The Constant FILE_TYPE. */
	private final static String FILE_TYPE = Config.getString(RejectshopCoreConstants.ZIP_TYPES, "zip");
	

	/** The inputdir. */
	private static String inputdir = null;

	/** The processdir. */
	private static String processdir = null;

	/** The errordir. */
	private static String errordir = null;

	/**
	 * This method is used to move the file from one directory to other directory.
	 *
	 * @param source the source
	 * @param destination the destination
	 */
	public static void moveFile(final String source, final String destination) {
		final String methodName = "moveFile(source,destination)";
		LOG.debug(methodName + " Start");
		 File srcFile = new File(source.trim());
		try {
			srcFile = new File(source.trim()).getCanonicalFile();
		} catch (IOException e) {
			LOG.error("Not able to read sublink "+e);
		}
		final File destFile = new File(destination);
		if (srcFile.exists() && destFile.exists())
		{
			try
			{
				FileUtils.copyFileToDirectory(srcFile, destFile);
				LOG.debug("Moved the file from " + source + " to " + destination);
				if (srcFile.delete())
				{
					LOG.info("File " + source + " deleted sucessfully");
				}
				else
				{
					LOG.error("Unable to delete the file " + srcFile);
				}
			}
			catch (final IOException ioException)
			{
				LOG.error("Error while moving the file from :", ioException);
				LOG.error("Error while moving the file from :" + source + "to" + destination);
			}
		}
		else
		{
			LOG.error("File[ " + source + "] not exist");

		}
		LOG.debug(methodName + " End");
	}

	/**
	 * This method is used to validate the directory for the existence and also checks the read/write permissions for the
	 * file/directory.
	 *
	 * @param directory the directory
	 * @return boolean
	 */
	public static boolean validateDirectory(final String directory)
	{
		final File file = new File(directory);
		if (file.exists())
		{
			if (!file.canRead() && !file.canWrite())
			{
				LOG.error("File/Directory " + directory + " does not have read/write permissions");
				return false;
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * This method will clean up the specified directory.
	 *
	 * @param inputDir the input dir
	 * @return boolean
	 */
	public static boolean cleanDir(final String inputDir)
	{
		final String methodName = "cleanDir(String inputDir)";
		LOG.debug(methodName + " Start.");
		boolean dirClean = true;
		try
		{
			final File dir = new File(inputDir).getCanonicalFile();
			final String[] files = dir.list();
			File file = null;
			for (int i = 0; i < files.length; i++)
			{
				file = new File(inputDir + File.separator + files[i]);
				if (file.delete())
				{
					LOG.debug("File successfully deleted.");
				}
			}
		}
		catch (final Exception exception)
		{
			LOG.error("Error while deleting the Enquiry file", exception);
			dirClean = false;
		}
		LOG.info("Output Directory cleaned successfully.");
		LOG.debug(methodName + " End.");
		return dirClean;
	}



	/**
	 * Checks if is error file exist.
	 *
	 * @param errorDir the error dir
	 * @param fileName the file name
	 * @return boolean
	 */
	public static boolean isErrorFileExist(final String errorDir, final String fileName)
	{
		boolean isExist = false;
		final File file = new File(errorDir.concat(File.separator).concat(fileName)
				.concat(RejectshopCoreConstants.ERROR_FILE_SUFFIX).concat("_" + DateUtility.getDateInString("ddMMyyyy"))
				.concat(RejectshopCoreConstants.FILE_EXTENSION));
		if (file.exists())
		{
			isExist = true;
		}
		return isExist;
	}

	/**
	 * This method creates error file.
	 *
	 * @param errorDir           - directory in which the error file needs to be created
	 * @param fileName           - error file name
	 * @return boolean - true if the error file is created, else returns false
	 */
	public static boolean createErrorFile(final String errorDir, final String fileName)
	{
		boolean fileCreated = false;
		try
		{
			final File file = new File(errorDir.concat(File.separator).concat(fileName)
					.concat(RejectshopCoreConstants.ERROR_FILE_SUFFIX).concat("_" + DateUtility.getDateInString("ddMMyyyy"))
					.concat(RejectshopCoreConstants.FILE_EXTENSION));
			fileCreated = file.createNewFile();
		}
		catch (final IOException ioException)
		{
			LOG.error("Failed to create the File ", ioException);
		}
		return fileCreated;
	}



	/**
	 * Add Error Record to File.
	 *
	 * @param srcDir the src dir
	 * @param fileName the file name
	 * @param record the record
	 */
	public static void addErrorRecord(final String srcDir, final String fileName, final String record)
	{
		File file = null;
		FileWriter writer = null;
		try
		{
			file = new File(srcDir.concat(File.separator).concat(fileName)
					.concat(RejectshopCoreConstants.ERROR_FILE_SUFFIX).concat("_" + DateUtility.getDateInString("ddMMyyyy"))
					.concat(RejectshopCoreConstants.FILE_EXTENSION));
			if (file.exists())
			{
				writer = new FileWriter(file, true);
				writer.write(record + "\n");
				writer.flush();
			}
		}
		catch (final IOException ioException)
		{
			LOG.error("IO Error while adding Error Record to File ", ioException);
		}
		finally
		{
			if (writer != null)
			{
				try
				{
					writer.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("Error while closing File Writer ", ioException);
				}
			}
		}
	}



	/**
	 * Add Record to File.
	 *
	 * @param srcDir the src dir
	 * @param fileName the file name
	 * @param record the record
	 */
	public static void addRecord(final String srcDir, final String fileName, final String record)
	{
		File file = null;
		FileWriter writer = null;
		try
		{
			file = new File(srcDir.concat(File.separator).concat(fileName));
			if (file.exists())
			{
				writer = new FileWriter(file, true);
				writer.write(record);
				writer.flush();
			}
			else
			{
				file.createNewFile();
				addRecord(srcDir, fileName, record);
			}
		}
		catch (final IOException ioException)
		{
			LOG.error("IO Error while adding the Record to File  ", ioException);
		}
		finally
		{
			if (writer != null)
			{
				try
				{
					writer.close();
				}
				catch (final IOException ioException)
				{
					LOG.error("IO Error closing the File Writer ", ioException);
				}
			}
		}
	}


	/**
	 * This method closes the file handler.
	 *
	 * @param reader the reader
	 */
	public static void closeFileHandlers(final BufferedReader reader)
	{
		if (reader != null)
		{
			try
			{
				reader.close();
			}
			catch (final IOException ioException)
			{
				LOG.error("IO Error while closing the Buffered Reader ", ioException);
			}
		}
	}


	/**
	 * Close file stream.
	 *
	 * @param stream the stream
	 */
	public static void closeFileStream(final InputStream stream)
	{
		if (stream != null)
		{
			try
			{
				stream.close();
			}
			catch (final IOException ioException)
			{
				LOG.error("IO Error while closing the File Streams ", ioException);
			}
		}
	}


	/**
	 * This method will validate the directories and its existence.
	 *
	 * @param directories the directories
	 * @return boolean
	 */
	public static boolean validateDirectories(final String... directories)
	{
		boolean status = false;
		for (final String folderPath : directories)
		{
			if (StringUtils.isNotBlank(folderPath))
			{
				Path p = Paths.get(folderPath);
				LOG.info("path --"+p.toString());
				LOG.info("files exists==="+Files.exists(p));
				LOG.info("symbolic link--"+Files.isSymbolicLink(p));
				if (Files.exists(p)|| Files.isSymbolicLink(p))
				{
					status = true;
				}
				else
				{
					LOG.warn("Directory not exist");
					return status;
				}
			}
			else
			{
				LOG.warn("Directory is Null or Empty");
				return status;
			}
		}
		return status;
	}


	/**
	 * Read file as string.
	 *
	 * @param filePath the file path
	 * @return File as String
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String readFileAsString(final String filePath) throws IOException
	{
		final StringBuilder fileData = new StringBuilder();
		final BufferedReader reader = new BufferedReader(new FileReader(filePath));
		final char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1)
		{
			final String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
		}
		reader.close();
		return fileData.toString();
	}

	/**
	 * Gets the catalog version.
	 *
	 * @param flexibleSearchService the flexible search service
	 * @return CatalogVersionModel
	 */
	public static CatalogVersionModel getCatalogVersion(final FlexibleSearchService flexibleSearchService)
	{
		CatalogVersionModel catalogVersion = null;
		final String queryString = "SELECT {" + CatalogVersionModel._TYPECODE + ":" + CatalogVersionModel.PK + "} FROM {"
				+ CatalogVersionModel._TYPECODE + " as " + CatalogVersionModel._TYPECODE + " JOIN " + CatalogModel._TYPECODE + " as "
				+ CatalogModel._TYPECODE + " ON {" + CatalogModel._TYPECODE + ":" + CatalogModel.PK + " } = {"
				+ CatalogVersionModel._TYPECODE + ":" + CatalogVersionModel.CATALOG + "}" + "} WHERE {"
				+ CatalogVersionModel._TYPECODE + ":" + CatalogVersionModel.VERSION + "} = \""
				+ Config.getString("catalog.version.staged", "Staged") + "\" AND {" + CatalogModel._TYPECODE + ":" + CatalogModel.ID
				+ "} LIKE \'%" + Config.getString("masterCatalog.name", "bgwMasterProductCatalog") + "%\'";
		final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(queryString);
		final SearchResult<CatalogVersionModel> result = flexibleSearchService.search(fQuery);
		if (result.getResult() != null)
		{
			catalogVersion = result.getResult().get(0);
		}
		return catalogVersion;
	}
	
	
	/**
	 * Process import prodcuts.
	 *
	 * @param inputDir the input dir
	 * @param processDir the process dir
	 * @param errorDir the error dir
	 * @return the list
	 */
	public static List<File> processImportProdcuts(String inputDir, String processDir, String errorDir)  {
		List<File> filesToProcess = new ArrayList<File>();
		inputdir = inputDir;
		processdir = processDir;
		errordir = errorDir;

		 File[] inputFiles=null;
		try {
			inputFiles = new File(inputdir).getCanonicalFile().listFiles();
		} catch (IOException e) {
			LOG.info("Not able to read sublink directory"+e);
		}

		if (inputFiles.length > 0)
		{
			filesToProcess = getFilesToProcess(inputFiles);

			if (CollectionUtils.isNotEmpty(filesToProcess))
			{
				return filesToProcess;
			}
		}
		else
		{
			LOG.warn("No Files To Read");
		}
		return filesToProcess;
		
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
	private static List<File> getFilesToProcess(final File[] inputFiles)
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


			moveFile(inputdir.concat(File.separator).concat(file.getName()), processdir);



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
	private static void movefileToErrorDir(final String fileName)
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
	private static boolean isValidFileFormat(final String fileExtension, final String types)
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
	public static List<File> unzip(final File zipFile, final File targetDir)
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
			LOG.error("Error while Reading the zip File ", exception);

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
	 * Gets the error file path.
	 *
	 * @param errorDir the error dir
	 * @param fileName the file name
	 * @return the error file path
	 */
	public static String getErrorFilePath(final String errorDir, final String fileName)
	{
		String errorFile = null;
		final File file = new File(errorDir.concat(File.separator).concat(fileName)
				.concat(RejectshopCoreConstants.ERROR_FILE_SUFFIX).concat("_" + DateUtils.getDateInString("ddMMyyyy"))
				.concat(RejectshopCoreConstants.FILE_EXTENSION));
		if (file.exists())
		{
			errorFile = file.getPath();
		}
		return errorFile;
	}	
	
	
	/**
	 * Process error record.
	 *
	 * @param errorDirec the error direc
	 * @param record the record
	 * @param fileName the file name
	 */
	public static void processErrorRecord(final String errorDirec,  final String record, final String fileName)
	{
		LOG.debug("Start of processing Error Record in the file" + fileName);
		if (FileIOUtilities.isErrorFileExist(errorDirec, fileName))
		{
			addErrorRecord(errorDirec, fileName, record);
		}
		else
		{
			if (FileIOUtilities.createErrorFile(errorDirec, fileName))
			{
				addErrorRecord(errorDirec, fileName, record);
			}
		}
		
		LOG.debug("End of Processing Error Record in the file" + fileName);
		
	 }
	
	/**
	 * Gets the current time millis.
	 *
	 * @return the current time millis
	 */
	public static long getCurrentTimeMillis(){
		return System.currentTimeMillis();
	}
		
		/**
		 * Ms to string.
		 *
		 * @param ms the ms
		 * @return the string
		 */
	public static String msToString(long ms)
	{
		long totalSecs = ms / 1000;
		long hours = (totalSecs / 3600);
		long mins = (totalSecs / 60) % 60;
		long secs = totalSecs % 60;
		String minsString = (mins == 0) ? "00" : ((mins < 10) ? "0" + mins : Long.toString(mins));
		String secsString = (secs == 0) ? "00" : ((secs < 10) ? "0" + secs : Long.toString(secs));
		if (hours > 0)
			return Long.toString(hours) + ":" + minsString + ":" + secsString;
		else if (mins > 0)
			return Long.toString(mins) + ":" + secsString;
		else
			return ":" + secsString;
	}
	
}
