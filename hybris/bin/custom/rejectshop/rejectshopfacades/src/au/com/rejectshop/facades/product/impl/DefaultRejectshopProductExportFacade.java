/**
 *
 */
package au.com.rejectshop.facades.product.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.enums.ArticleApprovalStatus;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commercefacades.product.ProductExportFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.ProductResultData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.util.Config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.apache.commons.collections.buffer.AbstractBufferDecorator;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import au.com.rejectshop.data.LassooProductBean;
import au.com.rejectshop.data.LassooProductListBean;
import au.com.rejectshop.facades.product.RejectshopProductExportFacade;
import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;


/**
 *
 *
 */
public class DefaultRejectshopProductExportFacade implements RejectshopProductExportFacade
{

	private static final Logger LOG = Logger.getLogger(DefaultRejectshopProductExportFacade.class);
	private ProductExportFacade productExportFacade;


	private PromotionDataPriceFacade promotionDataPriceFacade;

	private static final String PRODUCT = "product";

	private ProductService productService;

	private CatalogVersionService catalogVersionService;



	/*
	 * (non-Javadoc)
	 *
	 * @see au.com.rejectshop.facades.product.RejectshopProductExportFacade#exportProductsForLasoo(java.lang.String,
	 * java.lang.String, int, int, java.lang.String)
	 */
	public void exportProductsForLasoo(final String catalogId, final String catalogVersion, final List<ProductOption> options,
			final int start, final int count)
	{
		final CatalogVersionModel catalogVersionModel = catalogVersionService.getCatalogVersion(catalogId, catalogVersion);
		final ProductResultData products = productExportFacade.getAllProductsForOptions(catalogId, catalogVersion, options, start,
				count);

		final LassooProductListBean productList = new LassooProductListBean();
		final List<LassooProductBean> lassooProductList = new ArrayList<LassooProductBean>();


		final Date today = Calendar.getInstance().getTime();

		for (final ProductData productData : products.getProducts())
		{

			try
			{
				final ProductModel product = productService.getProductForCode(catalogVersionModel, productData.getCode());
				if (product.getApprovalStatus().equals(ArticleApprovalStatus.APPROVED)
						&& (product.getOnlineDate() == null
								|| (product.getOnlineDate() != null && today.after(product.getOnlineDate())))
						&& (product.getOfflineDate() == null
								|| (product.getOfflineDate() != null && today.before(product.getOfflineDate()))))
				{

					promotionDataPriceFacade.setPricePromotionData(productData, product);

					final LassooProductBean lassooBean = new LassooProductBean();
					lassooBean.setEan(product.getEan());
					lassooBean.setOfferDescription(productData.getDescription());
					if (productData.getPrice() != null)
					{
						lassooBean.setOfferPrice(productData.getPrice().getValue().toString());
					}
					lassooBean.setProductModelNumber(productData.getCode());
					lassooBean.setOfferName(productData.getName());
					lassooBean.setUrl(Config.getParameter("rejectshop.website.host") + "/p/" + productData.getCode());


					if (productData.getImages() != null)
					{


						for (final ImageData imageData : productData.getImages())
						{
							if (imageData.getFormat().equalsIgnoreCase("miniZoom"))
							{
								final String imageZoom = imageData.getUrl();
								LOG.debug(imageZoom);
								lassooBean.setOfferImage(Config.getParameter("rejectshop.website.host") + imageZoom);
							}


							/*
							 * if (PRODUCT.equalsIgnoreCase(imageData.getFormat())) {
							 * LOG.info(Config.getParameter("rejectshop.website.host") + imageData.getUrl());
							 *
							 *
							 */


							/* lassooBean.setOfferImage(lassooBean.getURL() + "/image"); */
						}
					}

					for (final CategoryData categoryData : productData.getCategories())
					{
						lassooBean.setCategory(categoryData.getName());
					}
					lassooProductList.add(lassooBean);
				}
			}

			catch (final Exception e)
			{
				LOG.error("Unable to export product " + productData.getCode() + " Reason:" + e.getMessage());
			}
		}


		productList.setLasooProductList(lassooProductList);

		final XStream xstream = new XStream(new DomDriver());
		xstream.alias("Offers", LassooProductListBean.class);
		xstream.addImplicitCollection(LassooProductListBean.class, "lasooProductList");
		xstream.alias("Offer", LassooProductBean.class);
		xstream.aliasField("OfferName", LassooProductBean.class, "offerName");
		xstream.aliasField("OfferImage", LassooProductBean.class, "offerImage");
		xstream.aliasField("ProductModelNumber", LassooProductBean.class, "productModelNumber");
		xstream.aliasField("OfferDescription", LassooProductBean.class, "offerDescription");
		xstream.aliasField("Category", LassooProductBean.class, "category");
		xstream.aliasField("EAN", LassooProductBean.class, "ean");
		xstream.aliasField("URL", LassooProductBean.class, "url");
		xstream.aliasField("OfferPrice", LassooProductBean.class, "offerPrice");


		final String xmlOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" + xstream.toXML(productList);
		LOG.debug(xmlOutput);

		addRecord(Config.getParameter("lasoo.export.dir"), Config.getParameter("lasoo.export.filename"), xmlOutput);
		sendFileViaSFTP();

	}

	/**
	 */

	private void addRecord(final String srcDir, final String fileName, final String record)
	{
		File file = null;
		FileWriter writer = null;
		try
		{
			file = new File(srcDir.concat(File.separator).concat(fileName));
			if (file.exists())
			{
				file.delete();
			}
			file.createNewFile();
			writer = new FileWriter(file, true);
			writer.write(record);
			writer.flush();
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


	private void sendFileViaSFTP(){
		String fileDirectory= Config.getParameter("lasoo.export.dir");
		String fileName= Config.getParameter("lasoo.export.filename");
		String sftpHostName = Config.getParameter("lasoo.sftp.host");
		String sftpUser = Config.getParameter("lasoo.sftp.username");
		String sftpPassword =  Config.getParameter("lasoo.sftp.password");
		String remoteDirectory =  Config.getParameter("lasoo.sftp.remoteDirectory");
		StandardFileSystemManager manager = new StandardFileSystemManager();
		LOG.info("Start SFTP connection "+sftpHostName);

		try {

			//check if the file exists
			String filepath = fileDirectory +"/"+  fileName;
			File file = new File(filepath);
			if (!file.exists()) {
				LOG.error("File does not exists for ");
				throw new RuntimeException("Error. Local file not found");

			}

			//Initializes the file manager
			manager.init();

			//Setup our SFTP configuration
			FileSystemOptions opts = new FileSystemOptions();
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
			SftpFileSystemConfigBuilder.getInstance().setPreferredAuthentications(opts,"password");
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
			SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);
			//Proxy setting for Dev environment only
			/*String proxyHost ="ssc.proxy.rejectshop.com.au";
			int proxyPort =1080 ;
			SftpFileSystemConfigBuilder.getInstance().setProxyHost(opts, proxyHost);
			SftpFileSystemConfigBuilder.getInstance().setProxyPort(opts, proxyPort);
			SftpFileSystemConfigBuilder.getInstance().setProxyType(opts, SftpFileSystemConfigBuilder.PROXY_SOCKS5);
*/

			//Create the SFTP URI using the host name, userid, password,  remote path and file name
			String sftpUri = "sftp://" + sftpUser + ":" + sftpPassword+  "@" + sftpHostName + "/" +
				remoteDirectory+	 fileName;
			LOG.debug("sftpUri = " + sftpUri);

			// Create local file object
			FileObject localFile = manager.resolveFile(file.getAbsolutePath());

			// Create remote file object
			FileObject remoteFile = manager.resolveFile(sftpUri, opts);

			// Copy local file to sftp server
			remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);

			LOG.info("File upload successful");

		}
		catch (Exception ex) {
			ex.printStackTrace();
			LOG.error(ex.getMessage());


			//return false;
		}
		finally {
			manager.close();
		}

	}


	/**
	 * @return the productExportFacade
	 */
	public ProductExportFacade getProductExportFacade()
	{
		return productExportFacade;
	}

	/**
	 * @param productExportFacade
	 *           the productExportFacade to set
	 */
	public void setProductExportFacade(final ProductExportFacade productExportFacade)
	{
		this.productExportFacade = productExportFacade;
	}

	/**
	 * @return the promotionDataPriceFacade
	 */
	public PromotionDataPriceFacade getPromotionDataPriceFacade()
	{
		return promotionDataPriceFacade;
	}

	/**
	 * @param promotionDataPriceFacade
	 *           the promotionDataPriceFacade to set
	 */
	public void setPromotionDataPriceFacade(final PromotionDataPriceFacade promotionDataPriceFacade)
	{
		this.promotionDataPriceFacade = promotionDataPriceFacade;
	}

	/**
	 * @return the productService
	 */
	public ProductService getProductService()
	{
		return productService;
	}

	/**
	 * @param productService
	 *           the productService to set
	 */
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}


	/**
	 * @return the catalogVersionService
	 */
	public CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}


	/**
	 * @param catalogVersionService
	 *           the catalogVersionService to set
	 */
	public void setCatalogVersionService(final CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
	}
}
