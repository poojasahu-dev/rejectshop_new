/**
 * 
 */
package au.com.rejectshop.facade;

/**
 * The Interface RejectshopProductImportFacade.
 */
public interface RejectshopProductImportFacade
{
	
	/**
	 * Process import prodcuts.
	 *
	 * @param inputDir the input dir
	 * @param processDir the process dir
	 * @param errorDir the error dir
	 */
	public void processImportProdcuts(String inputDir, String processDir, String errorDir);
	public void processImportPriceRows(String inputDir, String processDir, String errorDir);

	

	
}
