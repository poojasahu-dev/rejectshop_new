/**
 * 
 */
package au.com.rejectshop.cronjob.service;


/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopPOSImportService
{
	
	/**
	 * Process import priceRows.
	 *
	 * @param inputDir
	 *           the input dir
	 * @param processDir
	 *           the process dir
	 * @param errorDir
	 *           the error dir
	 */
	public void processImportPOS(String inputDir, String processDir, String errorDir);
	

	
}
