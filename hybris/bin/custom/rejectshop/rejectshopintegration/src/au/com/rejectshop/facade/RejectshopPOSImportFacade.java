/**
 * 
 */
package au.com.rejectshop.facade;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopPOSImportFacade
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
