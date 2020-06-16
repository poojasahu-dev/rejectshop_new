/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package au.com.rejectshop.storefront.controllers.cms;


import de.hybris.platform.acceleratorcms.model.components.ProductReferencesComponentModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.ProductReferenceData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import de.hybris.platform.util.Config;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import au.com.rejectshop.storefront.controllers.ControllerConstants;


/**
 * Controller for CMS ProductReferencesComponent
 */
@Controller("ProductReferencesComponentController")
@Scope("tenant")
@RequestMapping(value = ControllerConstants.Actions.Cms.ProductReferencesComponent)
public class ProductReferencesComponentController
		extends AbstractAcceleratorCMSComponentController<ProductReferencesComponentModel>
{
	private static final Logger LOG = Logger.getLogger(ProductReferencesComponentController.class);
	private static final List<ProductOption> PRODUCT_OPTIONS = Arrays.asList(ProductOption.BASIC, ProductOption.PRICE,ProductOption.CATEGORIES);

	private static final String DELIMITER_COMMA = ",";

	@Resource(name = "accProductFacade")
	private ProductFacade productFacade;

	@Resource(name = "productService")
	private ProductService productService;

	private static final String catalugeCategoryCode= "category.catalogue.products";
	private String catalogueProductCategory=Config.getParameter(catalugeCategoryCode);

	@Override
	protected void fillModel(final HttpServletRequest request, final Model model, final ProductReferencesComponentModel component) {
		final ProductModel currentProduct = getRequestContextData(request).getProduct();
		ProductData productData;
		int pick;
		try{
		List<String> categoryList = Arrays.asList(StringUtils.split(catalogueProductCategory, DELIMITER_COMMA));
		//String [] justlandedCategory = {};
		/* categoryList.forEach(category ->{
			 if (category.contains("S-Just")) justlandedCategory[0]=category;
		 });*/
		if (currentProduct != null) {

			final List<ProductData> productReferencesRandom = new ArrayList<>();

			final List<ProductReferenceData> productReferences = productFacade.getProductReferencesForCode(currentProduct.getCode(),
					component.getProductReferenceTypes(), PRODUCT_OPTIONS, component.getMaximumNumberProducts());


			//getting the current product super categories
			final Collection<CategoryModel> sc = currentProduct.getSupercategories();
			CategoryModel productCategoryModel = new CategoryModel();
			boolean isproductCategory = false;
			CategoryModel catalogueCategory = null;
			for (CategoryModel categoryModel : sc
			) {
				if (isproductCategory == false && NumberUtils.isNumber(categoryModel.getCode())) {
					LOG.debug("inside setting category code" + categoryModel.getCode());
					isproductCategory = true;
					productCategoryModel = categoryModel;
				}
				LOG.debug(categoryModel.getCode() + "---Name--" + categoryModel.getName());
				//LOG.info("Supper Categories"+categoryModel.getSupercategories().toString());
				//	LOG.debug("category code from config property "+catalogueProductCategory);
				CategoryModel[] parentCategory = {new CategoryModel()};
				if (categoryModel.getCode().contains("S-EDM") || categoryModel.getCode().contains("S-LAND")) {
					categoryModel.getSupercategories().forEach(categoryModel1 -> {
						LOG.debug(categoryModel1.getCode() + "--- super category name--" + categoryModel1.getName());

						boolean b = categoryList.contains(categoryModel1.getCode());
						LOG.debug("categoryList contains c" + b);
						if (categoryList.contains(categoryModel1.getCode())) {
							parentCategory[0] = categoryModel1;
						} else {
							categoryModel1.getSupercategories().forEach(categoryModel2 -> {
								LOG.debug("---super category code loop" + categoryModel2.getCode() + "---name---" + categoryModel2.getCode());
								if (categoryList.contains(categoryModel2.getCode())) {
									parentCategory[0] = categoryModel2;
								}
							});
						}
					});

					LOG.debug("----parentCategory[0].getCode()--" + parentCategory[0].getCode());
					if (parentCategory[0].getCode() != null && !parentCategory[0].getCode().equalsIgnoreCase("")) {
						catalogueCategory = parentCategory[0];
					}
					//catalogueCategory=categoryModel;
				}


			}
			LOG.debug("product category ---" + productCategoryModel.getCode());
			LOG.debug("catalogueCategory---" + catalogueCategory);

			int categoryLoopCnt = 0;
			for (final Iterator iterator = sc.iterator(); iterator.hasNext(); ) {
				LOG.debug("productReferencesRandom.size()" + productReferencesRandom.size());

				if (productReferencesRandom.size() < 3) {
					CategoryModel categoryModel = (CategoryModel) iterator.next();
					LOG.debug("categoryModel.getCode().equalsIgnoreCase(catalogueCategory.getCode())----" + categoryModel.getCode());
					if (catalogueCategory != null && !categoryModel.getCode().equalsIgnoreCase(catalogueCategory.getCode())) {
						if (categoryLoopCnt == 0) {
							categoryModel = catalogueCategory;
						} else {
							categoryModel = productCategoryModel;
						}
					} else {
						categoryModel = productCategoryModel;
					}
					categoryLoopCnt = categoryLoopCnt + 1;
					LOG.debug("Loop cnt" + categoryLoopCnt);
					LOG.debug("Category Code" + categoryModel.getCode());

					final List<ProductModel> listProducts = productService.getProductsForCategory(categoryModel);
					LOG.debug(listProducts.size() + "-----number of product for category---- " + categoryModel.getCode());

					final Random rand = new Random();


					//for (int j = 0; j < listProducts.size(); j++)
					for (ProductModel p : listProducts) {
						//In case of catalogue category go through all product else pick random products
						if (categoryList.contains(categoryModel.getCode())) {
							productData = productFacade.getProductForOptions(p, PRODUCT_OPTIONS);
						} else {
							pick = rand.nextInt(listProducts.size());
							productData = productFacade.getProductForOptions(listProducts.get(pick), PRODUCT_OPTIONS);
							final int[] newpick = {pick};
							final String productCode = productData.getCode();

							// verify random product should not be parent product
							productReferencesRandom.forEach(productData1 -> {
								if (productData1.getCode().equalsIgnoreCase(productCode)) {
									newpick[0] = 9999;
								}
							});

							// if random product is ame then pick another product
							if (newpick[0] == 9999) {
								pick = rand.nextInt(listProducts.size());
								productData = productFacade.getProductForOptions(listProducts.get(pick), PRODUCT_OPTIONS);
							}
						}
						LOG.debug("productCategoryModel ----" + productCategoryModel.getCode());
						//verify product again and with business logic
						if (!productData.getCode().equalsIgnoreCase(currentProduct.getCode()) && inreferenceList(productReferencesRandom, productData, productCategoryModel)) {
							LOG.debug("Product added to list " + productData.getCode() + "--- Code and Name---" + productData.getName());
							productReferencesRandom.add(productData);

						}
						LOG.debug("Product reference list size" + productReferencesRandom.size());
						if (productReferencesRandom.size() >= 3) break;
					}
					final ListIterator<ProductData> listIterator = productReferencesRandom.listIterator();
					while (listIterator.hasNext()) {
						final ProductData productData2 = listIterator.next();
						if (productData2.getCode().contains((currentProduct.getCode()))) {
							listIterator.remove();
						}

					}

				} else {
					//LOG.info("Inside else block-----");
					iterator.next();
					break;
				}
			}

			model.addAttribute("title", component.getTitle());
			if (!productReferences.isEmpty()) {
				model.addAttribute("productReferences", productReferences);

			} else {
				model.addAttribute("productReferencesRandom", productReferencesRandom);
			}
		}
	}catch(Exception e){
			LOG.warn("Error in fillModel:" + e.getMessage());
		}
	}

	/**
	 * Bussiness logics to verify if we are good to add product into reference list
	 * verify stock code and verify if category code is same
	 * @param productReferencesRandom list of products in you may like section
	 * @param productData product details
	 * @param productCategory current product category
     * @return  return if we can add this product or not
     */
	private boolean inreferenceList(List<ProductData> productReferencesRandom,ProductData productData,CategoryModel productCategory){
		boolean b=false;
		int [] newpick ={999};
		LOG.debug("product category code ="+productCategory.getCode());

		//verify if produt exits in reference list
		productReferencesRandom.forEach(productData1 -> {
			//verify stock code if already in list then
			if(productData1.getCode().equalsIgnoreCase(productData.getCode())){
				newpick[0] = 1;
				LOG.debug("already is list Skip product ------"+productData1.getCode()+"-----"+productData1.getName());
			}
		});

		//verify product's category should be same
		productData.getCategories().forEach(categoryData -> {
			LOG.debug("stock Code----"+productData.getCode()+"---category-----" + categoryData.getCode() + "--- parent category ---" + productCategory.getCode());
			if (categoryData.getCode().equalsIgnoreCase(productCategory.getCode())) {
				//if already in list skip
			   if (newpick[0]!=1)newpick[0] = 2;
				LOG.debug("product data----" + productData.getCode() + "-----" + productData.getName());

			}
		});



		//category code is same then we are good to add product
		if(newpick[0] ==2 )b=true;

		return b;
	}

}

