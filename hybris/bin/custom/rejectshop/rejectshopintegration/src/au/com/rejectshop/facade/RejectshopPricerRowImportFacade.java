/**
 * 
 */
package au.com.rejectshop.facade;

/**
 * @author suryanarayana.d
 *
 */
public interface RejectshopPricerRowImportFacade
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
	public void processImportPriceRows(String inputDir, String processDir, String errorDir);

}
