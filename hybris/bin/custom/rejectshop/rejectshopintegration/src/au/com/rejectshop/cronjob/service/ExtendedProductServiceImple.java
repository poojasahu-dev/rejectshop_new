/**
 * 
 */
package au.com.rejectshop.cronjob.service;

import de.hybris.platform.basecommerce.enums.PointOfServiceTypeEnum;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.storelocator.model.PointOfServiceModel;

import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.cronjob.dao.ExtendedProductDAO;

/**
 * The Class ExtendedProductServiceImple.
 */
public class ExtendedProductServiceImple implements ExtendedProductService
{
	
	/** The extended product DAO. */
	ExtendedProductDAO extendedProductDAO;
	
	/** The model service. */
	private ModelService modelService;
	
	/** The common I 18 N service. */
	private CommonI18NService commonI18NService;
	
	/** The base store service. */
	private BaseStoreService baseStoreService;


	/**
	 * Gets the extended product DAO.
	 *
	 * @return the extendedProductDAO
	 */
	public ExtendedProductDAO getExtendedProductDAO()
	{
		return extendedProductDAO;
	}

	/**
	 * Sets the extended product DAO.
	 *
	 * @param extendedProductDAO the extendedProductDAO to set
	 */
	@Required
	public void setExtendedProductDAO(ExtendedProductDAO extendedProductDAO)
	{
		this.extendedProductDAO = extendedProductDAO;
	}


	/**
	 * Gets the model service.
	 *
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}


	/**
	 * Sets the model service.
	 *
	 * @param modelService the modelService to set
	 */
	@Required
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	
	
	/**
	 * Gets the common I 18 N service.
	 *
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	/**
	 * Sets the common I 18 N service.
	 *
	 * @param commonI18NService the commonI18NService to set
	 */
	@Required
	public void setCommonI18NService(CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
	
	

	/**
	 * Gets the base store service.
	 *
	 * @return the baseStoreService
	 */
	public BaseStoreService getBaseStoreService()
	{
		return baseStoreService;
	}

	/**
	 * Sets the base store service.
	 *
	 * @param baseStoreService the baseStoreService to set
	 */
	@Required
	public void setBaseStoreService(BaseStoreService baseStoreService)
	{
		this.baseStoreService = baseStoreService;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.ExtendedProductService#getProduct(java.lang.String, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	public ProductModel  getProduct(String pCode, CatalogVersionModel catalogVersion)
	{
		ProductModel productsModels=extendedProductDAO.getProduct(pCode, catalogVersion);
		return productsModels;
	}		
	
	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.ExtendedProductService#createOrUpdateCategory(java.lang.String, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	public CategoryModel createOrUpdateCategory(String code, CatalogVersionModel catalogVersion)
	{
		CategoryModel categoryModel=extendedProductDAO.createOrUpdateCategory(code, catalogVersion);
		return categoryModel;
	}
	
	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.ExtendedProductService#getAddressForPos(de.hybris.platform.storelocator.model.PointOfServiceModel, de.hybris.platform.core.model.user.AddressModel, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	public AddressModel getAddressForPos(PointOfServiceModel pointOfServiceModel,AddressModel addrModel, CatalogVersionModel catalogVersion)
	{
		PointOfServiceModel pos=extendedProductDAO.getAddressForPos(pointOfServiceModel, catalogVersion);
		if (pos == null)
		{
			modelService.save(pointOfServiceModel);
		   return createOrUpdateAddress(addrModel,pointOfServiceModel);
		}
		
			if (pos.getAddress() == null)
			{
				 return createOrUpdateAddress(addrModel,pos);
			}
			
			return addrModel;
		}		
	/**
	 * Creates the or update address.
	 *
	 * @param addr the addr
	 * @param pointOfServiceModel the point of service model
	 * @return the address model
	 */
	private AddressModel createOrUpdateAddress(AddressModel addr, PointOfServiceModel pointOfServiceModel)
	{ 
		AddressModel address = modelService.create(AddressModel.class);
		if (address.getOwner() == null)
		{			
			/*address.setCountry(commonI18NService.getCountry(addr.getCountry()));*/
			address.setLastname(addr.getLastname());
			address.setFirstname(addr.getFirstname());
			address.setLine1(addr.getLine1());
			address.setLine2(addr.getLine1());
			address.setPostalcode(addr.getPostalcode());
			address.setTown(addr.getTown());
			address.setPhone1(addr.getPhone1());
			address.setFax(addr.getFax());
			address.setOwner(pointOfServiceModel);
		/*	modelService.save(address);*/
			
		}
		return address;
	}

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.ExtendedProductService#createOrUpdatePOS(de.hybris.platform.storelocator.model.PointOfServiceModel, de.hybris.platform.catalog.model.CatalogVersionModel)
	 */
	@Override
	public void createOrUpdatePOS(PointOfServiceModel pointOfServiceModel, CatalogVersionModel catalogVersion)
	{
		
		BaseStoreModel baseStoreModel=baseStoreService.getBaseStoreForUid("rejectshop");
		PointOfServiceModel pos=extendedProductDAO.createOrUpdatePOS(pointOfServiceModel, catalogVersion);
		if(pos == null)
		{		
			modelService.save(pointOfServiceModel);
		}
		else{
			
			pos.setName(pointOfServiceModel.getName());
			pos.setOpeningSchedule(pointOfServiceModel.getOpeningSchedule());
			pos.setAddress(pointOfServiceModel.getAddress());			
			pos.setType(PointOfServiceTypeEnum.STORE);
			pos.setDisplayName(pointOfServiceModel.getDisplayName());
			pos.setBaseStore(baseStoreModel);
			modelService.save(pos);
		}	
	}
}
