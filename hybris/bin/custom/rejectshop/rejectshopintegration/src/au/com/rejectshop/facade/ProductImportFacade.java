/**
 * 
 */
package au.com.rejectshop.facade;

/**
 * The Interface ProductImportFacade.
 *
 * @author subrahmanyam.n
 */
public interface ProductImportFacade
{

	/**
	 * Process import prodcuts.
	 *
	 * @param inputDir
	 *           the input dir
	 * @param processDir
	 *           the process dir
	 * @param errorDir
	 *           the error dir
	 */
	public void processImportProdcuts(String inputDir, String processDir, String errorDir);
	
	
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
	
	public Void loadproducts();
}
