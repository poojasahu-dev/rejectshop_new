/**
 *
 */
package au.com.rejectshop.cronjob.service;

/**
 * The Interface ProductImageConversionService.
 */
public interface ProductImageConversionService
{

	/**
	 * Perform the media conversion operation and assigns the converted medias to the product.
	 *
	 * @param inputDir
	 *           the input dir
	 * @param processDir
	 *           the process dir
	 * @param errorDir
	 *           the error dir
	 */
	void autoconversionImage(String inputDir, String processDir, String errorDir);
}
