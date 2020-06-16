/**
 * 
 */
package au.com.rejectshop.v2.controller;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.enums.ArticleApprovalStatus;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.commercefacades.catalog.data.CatalogsData;
import de.hybris.platform.commercefacades.product.ProductExportFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.ImageData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.ProductResultData;
import de.hybris.platform.commerceservices.price.CommercePriceService;
import de.hybris.platform.commercewebservicescommons.dto.catalog.CatalogListWsDTO;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.util.Config;
import de.hybris.platform.webservicescommons.mapping.DataMapper;
import de.hybris.platform.webservicescommons.mapping.FieldSetBuilder;
import de.hybris.platform.webservicescommons.mapping.impl.FieldSetBuilderContext;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.rejectshop.data.LassooProductBean;
import au.com.rejectshop.data.LassooProductListBean;
import au.com.rejectshop.dto.OffersWsDTO;

/**
 * @author soda.raveendra
 *
 */
@Controller
@RequestMapping(value = "/{baseSiteId}/export/lasooXml",headers = "Accept=application/xml,application/json")
public class RejectshopProductExportToLassooController extends BaseController
{
	private static final Logger LOG = Logger.getLogger(RejectshopProductExportToLassooController.class);

	private static final String CATALOG_ID = "rejectshopProductCatalog";

	private static final String VERSION = "Online";

	private static final int DEFAULT_START = 0;
	private static final int MAX_RESULTS = 2147483647;

	@Resource(name="productExportFacade")
	private ProductExportFacade productExportFacade;

	@Resource(name="productService")
	private ProductService productService;

	@Resource(name="catalogVersionService")
	private CatalogVersionService catalogVersionService;
	
	@Resource(name="commercePriceService")
	private CommercePriceService commercePriceService;
	
	
	@Resource(name = "fieldSetBuilder")
	private FieldSetBuilder fieldSetBuilder;
	
	@Secured("ROLE_TRUSTED_CLIENT")
	@RequestMapping(method = RequestMethod.GET,produces="application/xml")
	@ResponseBody
	public OffersWsDTO  exportProductsForLasoo(@RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields){
		
		Date today = Calendar.getInstance().getTime();
		List<ProductOption> options=null;
		
		final LassooProductListBean lassooProductListBean = new LassooProductListBean();
		CatalogVersionModel catalogVersionModel = catalogVersionService.getCatalogVersion(CATALOG_ID, VERSION);
		ProductResultData products = productExportFacade.getAllProductsForOptions(CATALOG_ID, VERSION, options, DEFAULT_START ,
				MAX_RESULTS);
		final FieldSetBuilderContext context = new FieldSetBuilderContext();
		//context.setRecurrencyLevel(1);

		List<LassooProductBean> lassooProductBean = new ArrayList<LassooProductBean>();
		for (ProductData productData : products.getProducts())
		{

			try
			{
				ProductModel product = productService.getProductForCode(catalogVersionModel, productData.getCode());
				if (product.getApprovalStatus().equals(ArticleApprovalStatus.APPROVED)
						&& (product.getOnlineDate() == null
						|| (product.getOnlineDate() != null && today.after(product.getOnlineDate())))
						&& (product.getOfflineDate() == null
						|| (product.getOfflineDate() != null && today.before(product.getOfflineDate()))))
				{
					LassooProductBean lassooBean = new LassooProductBean();
					lassooBean.setEan(product.getEan());
					lassooBean.setOfferDescription(productData.getDescription());
					
					  DecimalFormat decimalFormat = new DecimalFormat("##.00");
					LOG.info("commercePriceService.getWebPriceForProduct(product).getPriceValue().getValue()----"+commercePriceService.getWebPriceForProduct(product).getPriceValue().getValue());
					LOG.info("commercePriceService.getWebPriceForProduct(product).getPriceValue()---"+commercePriceService.getWebPriceForProduct(product).getPriceValue());
					  String price=decimalFormat.format(commercePriceService.getWebPriceForProduct(product).getPriceValue().getValue());
						LOG.info("price---"+price);
					if (price != null)
					{
									lassooBean.setOfferPrice(price);
					}
					lassooBean.setProductModelNumber(productData.getCode());
					lassooBean.setOfferName(productData.getName());
					lassooBean.setUrl(Config.getParameter("rejectshop.website.host") + "/p/" + productData.getCode());


					if (productData.getImages() != null)
					{


						for (ImageData imageData : productData.getImages())
						{
							if (imageData.getFormat().equalsIgnoreCase("miniZoom"))
							{
								lassooBean.setOfferImage(Config.getParameter("rejectshop.website.host") + imageData.getUrl());
							}
						}
					}

					for (CategoryData categoryData : productData.getCategories())
					{
						lassooBean.setCategory(categoryData.getName());
					}
					lassooProductBean.add(lassooBean);
				
				}
			}

			catch (Exception e)
			{
				LOG.error("Unable to export product " + productData.getCode() + " Reason:" + e.getMessage());
			}
		}
	
		lassooProductListBean.setLasooProductList(lassooProductBean);
		LOG.info("no of products:"+lassooProductBean.size());
		final Set<String> fieldSet = fieldSetBuilder.createFieldSet(OffersWsDTO.class, DataMapper.FIELD_PREFIX, fields,
				context);
	
		final OffersWsDTO offersdto = dataMapper.map(lassooProductListBean, OffersWsDTO.class, fieldSet);
		LOG.info("offersdto:"+offersdto.getOffer().size());
		return offersdto;
	}

}
