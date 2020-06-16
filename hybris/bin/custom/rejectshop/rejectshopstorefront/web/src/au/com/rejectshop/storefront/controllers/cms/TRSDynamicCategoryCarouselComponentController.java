/**
 *
 */
package au.com.rejectshop.storefront.controllers.cms;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.cms2lib.model.components.ProductCarouselComponentModel;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.core.model.components.TRSDynamicCategoryCarouselComponentModel;
import au.com.rejectshop.storefront.controllers.ControllerConstants;
import reactor.util.CollectionUtils;


@Controller("TRSDynamicCategoryCarouselComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.TRSDynamicCategoryCarouselComponent)
public class TRSDynamicCategoryCarouselComponentController
		extends AbstractAcceleratorCMSComponentController<TRSDynamicCategoryCarouselComponentModel>
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(TRSDynamicCategoryCarouselComponentController.class);
	protected static final List<ProductOption> PRODUCT_OPTIONS = Arrays.asList(ProductOption.BASIC, ProductOption.PRICE);
	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@Resource(name = "accProductFacade")
	private ProductFacade productFacade;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController#fillModel(javax.
	 * servlet.http.HttpServletRequest, org.springframework.ui.Model,
	 * de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel)
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final TRSDynamicCategoryCarouselComponentModel component)
	{
		final List<ProductData> products = new ArrayList<>();
		final CategoryModel categoryModel = getRequestContextData(request).getCategory();
		if (categoryModel != null)
		{
			LOG.debug("category code ::" + categoryModel.getCode());
			final Collection<CategoryModel> childCategories = categoryService.getAllSubcategoriesForCategory(categoryModel);
			if (childCategories != null)
			{
				component.setCategories(childCategories.stream().collect(Collectors.toList()));
			}

			final List<String> includeCategories = component.getIncludeCategories();
			if (!CollectionUtils.isEmpty(includeCategories))
			{
				component.setVisible(includeCategories.contains(categoryModel.getCode()) ? Boolean.TRUE : Boolean.FALSE);
			}
			else
			{
				component.setVisible(Boolean.FALSE);
			}
		}
		products.addAll(collectLinkedProducts(component));
		model.addAttribute("title", component.getTitle());
		model.addAttribute("productData", products);
	}


	protected List<ProductData> collectLinkedProducts(final TRSDynamicCategoryCarouselComponentModel component)
       {
             final List<ProductData> products = new ArrayList<>();

             for (final ProductModel productModel : component.getProducts())
             {
               
                    if (null != component.getMaxLimit() && products.size() >= component.getMaxLimit())
                    {
                          break;
                    }
				 products.add(productFacade.getProductForOptions(productModel, PRODUCT_OPTIONS));
				
             }
             for (final CategoryModel categoryModel : component.getCategories())
             {
                    for (final ProductModel productModel : categoryModel.getProducts())
                    {
                       
                          if (null != component.getMaxLimit() && products.size() >= component.getMaxLimit())
                          {
                                 break;
                          }
						  products.add(productFacade.getProductForOptions(productModel, PRODUCT_OPTIONS));

                    }
             }

             return products;
       }


}
