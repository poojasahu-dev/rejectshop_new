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
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.core.model.components.TRSTableTreeCategoryCarouselComponentModel;
import au.com.rejectshop.storefront.controllers.ControllerConstants;


@Controller("TRSTableTreeCategoryCarouselComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.TRSTableTreeCategoryCarouselComponent)
public class TRSTableTreeCategoryCarouselComponentController
		extends AbstractAcceleratorCMSComponentController<TRSTableTreeCategoryCarouselComponentModel>
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(TRSTableTreeCategoryCarouselComponentController.class);
	protected static final List<ProductOption> PRODUCT_OPTIONS = Arrays.asList(ProductOption.BASIC, ProductOption.PRICE);
	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@Resource(name = "accProductFacade")
	private ProductFacade productFacade;

	@Resource(name = "modelService")
	private ModelService modelService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController#fillModel(javax.
	 * servlet.http.HttpServletRequest, org.springframework.ui.Model,
	 * de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final TRSTableTreeCategoryCarouselComponentModel component)
	{
		final List<ProductData> products = new ArrayList<>();
		final CategoryModel categoryModel = getRequestContextData(request).getCategory();
		final String treeTableDecCatalogs = Config.getParameter("display.savvy.carousal.category");
		//final String flagTableDec

		if (categoryModel != null)
		{
			LOG.debug("category code ::" + categoryModel.getCode());
			final Collection<CategoryModel> childCategories = categoryService.getAllSubcategoriesForCategory(categoryModel);
			if (treeTableDecCatalogs.contains(categoryModel.getCode()))
			{
				final List<CategoryModel> subCategoryListSorted = new ArrayList<CategoryModel>();
				subCategoryListSorted.addAll(childCategories);
				subCategoryListSorted.sort(Comparator.comparing(CategoryModel::getCode));

				final CategoryModel categoryModelTable = categoryService.getCategory(subCategoryListSorted.get(0).getCode());
				component.setProducts(categoryModelTable.getProducts());
				component.setVisible(Boolean.TRUE);
				component.setCategoryCode(categoryModelTable.getCode());
				model.addAttribute("categoryDescription", categoryModelTable.getDescription());

			}
		}
		else
		{
			final CategoryModel categoryModelTable = categoryService.getCategory(request.getParameter("category"));
			component.setProducts(categoryModelTable.getProducts());
			component.setCategoryCode(categoryModelTable.getCode());
			model.addAttribute("categoryDescription", categoryModelTable.getDescription());
		}
		products.addAll(collectLinkedProducts(component));
		model.addAttribute("title", component.getTitle());
		model.addAttribute("productData", products);

	}


	protected List<ProductData> collectLinkedProducts(final TRSTableTreeCategoryCarouselComponentModel component)
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


             return products;
       }


}
