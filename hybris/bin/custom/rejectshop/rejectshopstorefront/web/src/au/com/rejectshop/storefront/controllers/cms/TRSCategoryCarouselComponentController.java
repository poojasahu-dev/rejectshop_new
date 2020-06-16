/**
 *
 */
package au.com.rejectshop.storefront.controllers.cms;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.ProductSearchFacade;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.core.model.components.TRSCategoryCarouselComponentModel;
import au.com.rejectshop.storefront.controllers.ControllerConstants;


/**
 * @author Soda.raveendra
 *
 */
@Controller("TRSCategoryCarouselComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.TRSCategoryCarouselComponent)
public class TRSCategoryCarouselComponentController
		extends AbstractAcceleratorCMSComponentController<TRSCategoryCarouselComponentModel>
{
	private static final Logger LOG = Logger.getLogger(TRSCategoryCarouselComponentController.class);
	@Resource(name = "productSearchFacade")
	private ProductSearchFacade<ProductData> productSearchFacade;

	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@Resource(name = "categoryUrlConverter")
	private Converter<CategoryModel, CategoryData> categoryUrlConverter;

	@Resource(name = "categoryPopulator")
	private Populator<CategoryModel, CategoryData> categoryPopulator;


	/**
	 *
	 */
	@Override
	protected void fillModel(final HttpServletRequest request, final Model model,
			final TRSCategoryCarouselComponentModel component)
	{

		LOG.debug("TRSCategoryCarouselComponentController start");
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		final Object path = request.getAttribute("javax.servlet.forward.request_uri");
		if (path.toString().contains("/c/"))
		{
			categoryList = productsForCategory(request, component, categoryList);
		}

		model.addAttribute("title", component.getTitle());
		model.addAttribute("categoryData", categoryList);
		LOG.debug("TRSCategoryCarouselComponentController end");

	}

	/**
	 *
	 * @param request
	 * @param component
	 * @return
	 */
	protected List<CategoryData> productsForCategory(final HttpServletRequest request,
			final TRSCategoryCarouselComponentModel component, final List<CategoryData> categoryList)
	{
		LOG.debug("TRSCategoryCarouselComponentController.productsForCategory START");

		final String path = request.getAttribute("javax.servlet.forward.request_uri").toString();
		try
		{

			LOG.debug("url path:" + path);
			final String catagory = path.substring(path.lastIndexOf("/")).substring(1);
			LOG.debug("last index Catagory :" + catagory);
			final CategoryModel catModel2 = categoryService.getCategoryForCode(catagory);
			final CategoryModel superCategory = catModel2.getSupercategories().get(0);
			if (superCategory.getCode() != null && !superCategory.getCode().equalsIgnoreCase("TRS"))
			{
				final Collection<CategoryModel> allSubCategories = superCategory.getAllSubcategories();
				for (final CategoryModel categoryModel : allSubCategories)
				{
					if (!categoryModel.equals(catModel2) && categoryModel.getProducts() != null
							&& !categoryModel.getProducts().isEmpty() && categoryModel.getLogo() != null
							&& !categoryModel.getLogo().isEmpty())
					{
						final CategoryData cat = categoryUrlConverter.convert(categoryModel);
						categoryPopulator.populate(categoryModel, cat);
						categoryList.add(cat);

					}
				}
			}
		}
		catch (

		final Exception e)
		{
			LOG.error("CategoryCarousel" + e.getMessage());
		}
		LOG.debug("TRSCategoryCarouselComponentController.productsForCategory END");
		return categoryList;
	}
}
