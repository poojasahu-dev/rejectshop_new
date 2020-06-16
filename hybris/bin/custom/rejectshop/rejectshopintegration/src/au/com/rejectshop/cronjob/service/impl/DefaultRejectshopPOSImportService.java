package au.com.rejectshop.cronjob.service.impl;

import de.hybris.platform.basecommerce.enums.PointOfServiceTypeEnum;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.store.BaseStoreModel;
import de.hybris.platform.store.services.BaseStoreService;
import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.data.AddressData;
import de.hybris.platform.storelocator.model.PointOfServiceModel;
import de.hybris.platform.storelocator.pos.PointOfServiceService;
import de.hybris.platform.util.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import au.com.rejectshop.convertors.PointOfServiceConverter;
import au.com.rejectshop.cronjob.service.RejectshopPOSImportService;
import au.com.rejectshop.data.AddressBean;
import au.com.rejectshop.data.ErrorBean;
import au.com.rejectshop.data.SkipBean;
import au.com.rejectshop.data.StoreBean;
import au.com.rejectshop.facade.impl.DateUtils;
import au.com.rejectshop.service.storefinder.RejectshopGoogleMapsServiceWrapper;
import au.com.rejectshop.util.EmailUtils;
import au.com.rejectshop.util.FileIOUtilities;


/**
 * The Class DefaultRejectshopPOSImportService.
 *
 */
public class DefaultRejectshopPOSImportService implements RejectshopPOSImportService
{

	/** The Constant DELIMITER_COMMA. */
	private static final String DELIMITER_COMMA = ",";
	
	/** The Constant REGION_99. */
	private static final String SITE_REGION = Config.getString("site.region", "");
	
	/** The Constant POS_Id_Empty. */
	private static final String POS_Id_Empty = Config.getString("pos.id.empty", "");

	/** The Constant Replenishment_Type. */
	private static final String POS_Region_Empty = Config.getString("pos.region.empty", "");
	
	/** The Constant Pricerow_empty. */
	private static final String POS_Address_Empty = Config.getString("pos.address.empty", "");
	
	/** The Constant Skipped_Records_Message. */
	private static final String Skipped_Records_Message = Config.getString("skippedrecords.message", "");

	/** The Constant REJECTSHOP. */
	private static final String REJECTSHOP = "rejectshop";

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(DefaultRejectshopPOSImportService.class);

	/** The model service. */
	private ModelService modelService;

	/** The common I 18 N service. */
	private CommonI18NService commonI18NService;

	/** The pos converter. */
	private PointOfServiceConverter posConverter;

	/** The point of service service. */
	private PointOfServiceService pointOfServiceService;
	
	/** The base store service. */
	private BaseStoreService baseStoreService;

	/** The error count. */
	private int errorCount;
	
	/** The success count. */
	private int successCount;
	
	private int skipCount;
	
	@Autowired
	RejectshopGoogleMapsServiceWrapper rejectshopGoogleMapsGeoServiceWrapper;
	
	/** The error direc. */
	private String errorDirec = null;
	List<ErrorBean> errorPOS = new ArrayList<ErrorBean>();
	List<SkipBean> skipCounts = new ArrayList<SkipBean>();

	/* (non-Javadoc)
	 * @see au.com.rejectshop.cronjob.service.RejectshopPOSImportService#processImportPOS(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void processImportPOS(String inputDir, String processDir, String errorDir) 
	{
		errorDirec = errorDir;
		 errorPOS = new ArrayList<ErrorBean>();
		 skipCounts = new ArrayList<SkipBean>();
		List<File> processFiles = FileIOUtilities.processImportProdcuts(inputDir, processDir, errorDir);

		if (CollectionUtils.isNotEmpty(processFiles))
		{
			for (File file : processFiles)
			{
				try
				{
					final List<StoreBean> pintOfServiceBeans = posConverter.convert(file);
					createOrUpdatePOS(pintOfServiceBeans, errorPOS);
				}
				catch (Exception exception)
				{
					ErrorBean error = new ErrorBean();
					error.setFileName(file.getName());
					errorPOS.add(error);
					errorCount++;
					LOG.error(exception);
				}
			}
			try
			{
				EmailUtils.sendPOSNotification(errorPOS,skipCounts,errorDirec, successCount,errorCount,skipCount);
				resetCounters();
			}
			catch (Exception exception)
			{
				LOG.error("Unable to send notificaiton "+exception);
			}
		}
		else
		{
			LOG.warn("No Files To Process::");
		}

	}
	
	/**
	 * Creates the or update POS.
	 *
	 * @param pintOfServiceBeans the pint of service beans
	 * @param errorPOS the error POS
	 */
	private void createOrUpdatePOS(List<StoreBean> pintOfServiceBeans, List<ErrorBean> errorPOS)
	{
		BaseStoreModel baseStoreModel = baseStoreService.getBaseStoreForUid(REJECTSHOP);
		try
		{
			if (CollectionUtils.isNotEmpty(pintOfServiceBeans))
			{
				for (StoreBean posBean : pintOfServiceBeans)
				{
					AddressModel addressModel = null;
					if (validateStoreData(posBean, errorPOS))
					{
						PointOfServiceModel pointOfServiceModel = getPointOfServiceService()
								.getPointOfServiceForName(posBean.getSiteId());
						// Create Point of service
						if (pointOfServiceModel == null)
						{
							if(!isValidRegion(posBean))
							{
								pointOfServiceModel = createPointofService(posBean, baseStoreModel, pointOfServiceModel);
								addressModel = createAddress(addressModel, posBean, pointOfServiceModel);
								if(addressModel != null) {
									pointOfServiceModel.setAddress(addressModel);
								}
								getModelService().save(pointOfServiceModel);
								successCount++;
							}
							else
							{
								updateSkipcount(posBean);

								LOG.info("File processings has skipped .." + posBean.getImportFileName());
							}
						}
						// Update POS
						else if (validateStorUpdateRules(pointOfServiceModel, posBean))
						{

							addressModel = pointOfServiceModel.getAddress();
							if (addressModel == null)
							{
								addressModel = createAddress(addressModel, posBean, pointOfServiceModel);
								pointOfServiceModel.setAddress(addressModel);
							}
							else
							{
								addressModel = updateAddress(posBean, addressModel);
							}
							pointOfServiceModel = updatePointofService(pointOfServiceModel, posBean);
							pointOfServiceModel.setAddress(addressModel);
							getModelService().save(pointOfServiceModel);
							successCount++;
						}
						else
						{
							updateSkipcount(posBean);

							LOG.info("File processings has skipped .." + posBean.getImportFileName());
						}
					}
					else
					{
						LOG.info("Missing Mandatory filelds::" + posBean.getImportFileName());
					}
				} 
			}
		}
		catch (Exception exception)
		{
			LOG.error(" [ Error while creating the Stores ] " + exception.getMessage(),exception);
   		}
	
	}

	/**
	 * @param posBean
	 */
	private void updateSkipcount(StoreBean posBean)
	{
		skipCount++;
		SkipBean skipBean = new SkipBean();
		skipBean.setStoreId(posBean.getSiteId());
		skipBean.setMessage(Skipped_Records_Message);
		skipCounts.add(skipBean);
	}

	/**
	 * Update pointof service.
	 *
	 * @param pointOfServiceModel the point of service model
	 * @param posBean the pos bean
	 * @return the point of service model
	 */
	private PointOfServiceModel updatePointofService(PointOfServiceModel pointOfServiceModel, StoreBean posBean)
	{
		pointOfServiceModel.setDisplayName(WordUtils.capitalizeFully(posBean.getDescription()));
		pointOfServiceModel.setRegion(posBean.getRegion());
		if(isValidRegion(posBean)){
			pointOfServiceModel.setIsActive(false);
		}
		
		AddressData addressData=new AddressData();
		addressData.setCity(posBean.getAddress().getCity());
		addressData.setCountryCode(posBean.getAddress().getCountry());
		//addressData.setName(addressBean.getAddrLine1()+", "+addressBean.getAddrLine2());
		addressData.setStreet(WordUtils.capitalizeFully(posBean.getAddress().getAddrLine1()));
		addressData.setZip(posBean.getAddress().getPostalCode());
		GPS gps=	rejectshopGoogleMapsGeoServiceWrapper.geocodeAddress(addressData);
		pointOfServiceModel.setLatitude(Double.valueOf(gps.getDecimalLatitude()));
		pointOfServiceModel.setLongitude(Double.valueOf(gps.getDecimalLongitude()));
		
		
		return pointOfServiceModel;
		
	}

	/**
	 * Checks if is valid region.
	 *
	 * @param posBean the pos bean
	 * @return true, if is valid region
	 */
	private boolean isValidRegion(StoreBean posBean)
	{
		boolean isRegion = false;
		String[] regions = null;

		if (StringUtils.isNotBlank(SITE_REGION))
		{
			regions = StringUtils.split(SITE_REGION, DELIMITER_COMMA);
		}
		if (ArrayUtils.isNotEmpty(regions) && CollectionUtils.isNotEmpty(Arrays.asList(regions)))
		{
			for (String region : Arrays.asList(regions))
			{

				if (StringUtils.equalsIgnoreCase(region, posBean.getRegion()))
				{
					isRegion = true;
				}
			}
		}
		return isRegion;

	}
	/**
	 * Update address.
	 *
	 * @param posBean the pos bean
	 * @param addressModel the address model
	 * @return the address model
	 */
	private AddressModel updateAddress(StoreBean posBean, AddressModel addressModel)
	{
		AddressBean addressBean = posBean.getAddress();
		addressModel.setLastname(StringUtils.EMPTY);
		addressModel.setLine1(WordUtils.capitalizeFully(addressBean.getAddrLine1()));
		addressModel.setLine2(WordUtils.capitalizeFully(addressBean.getAddrLine2()));
		addressModel.setCountry(commonI18NService.getCountry(addressBean.getCountry()));
		addressModel.setTown(WordUtils.capitalizeFully(addressBean.getCity()));
		addressModel.setPostalcode(addressBean.getPostalCode());
		addressModel.setPhone1(addressBean.getTelephoneNo());
		addressModel.setFax(addressBean.getFax());
		getModelService().save(addressModel);
		return addressModel;
		
	}

	/**
	 * Creates the address.
	 *
	 * @param addressModel the address model
	 * @param posBean the pos bean
	 * @param pointOfServiceModel the point of service model
	 * @return the address model
	 */
	private AddressModel createAddress(AddressModel addModel, StoreBean posBean,
															PointOfServiceModel pointOfServiceModel) {
		if(posBean.getAddress() != null){
			addModel = modelService.create(AddressModel.class);
			 	AddressBean addressBean = posBean.getAddress();
			 	addModel.setLastname(StringUtils.EMPTY);
			 	addModel.setLine1(WordUtils.capitalizeFully(addressBean.getAddrLine1()));
			 	addModel.setLine2(WordUtils.capitalizeFully(addressBean.getAddrLine2()));
			 	addModel.setCountry(commonI18NService.getCountry(addressBean.getCountry()));
			 	addModel.setTown(WordUtils.capitalizeFully(addressBean.getCity()));
			 	addModel.setPostalcode(addressBean.getPostalCode());
			 	addModel.setPhone1(addressBean.getTelephoneNo());
				addModel.setFax(addressBean.getFax());
				addModel.setOwner(pointOfServiceModel);
				
				
				
				getModelService().save(addModel);
		}
		
		 return addModel;
	}

	/**
	 * Creates the pointof service.
	 *
	 * @param posBean the pos bean
	 * @param baseStoreModel the base store model
	 * @param pointOfServiceModel the point of service model
	 * @return the point of service model
	 */
	private PointOfServiceModel createPointofService(StoreBean posBean, BaseStoreModel baseStoreModel,
												PointOfServiceModel posesModel)
	{
		posesModel = modelService.create(PointOfServiceModel.class);
		posesModel.setName(posBean.getSiteId());
		posesModel.setDisplayName(WordUtils.capitalizeFully(posBean.getDescription()));
		posesModel.setType(PointOfServiceTypeEnum.STORE);
		posesModel.setRegion(posBean.getRegion());
		posesModel.setStartDate(posBean.getStartDate());
		posesModel.setEndDate(posBean.getEndDate());
		posesModel.setBaseStore(baseStoreModel);
			
			
			AddressData addressData=new AddressData();
			addressData.setCity(WordUtils.capitalizeFully(posBean.getAddress().getCity()));
			addressData.setCountryCode(posBean.getAddress().getCountry());
			//addressData.setName(addressBean.getAddrLine1()+", "+addressBean.getAddrLine2());
			addressData.setStreet(WordUtils.capitalizeFully(posBean.getAddress().getAddrLine1()));
			addressData.setZip(WordUtils.capitalizeFully(posBean.getAddress().getPostalCode()));
			GPS gps=	rejectshopGoogleMapsGeoServiceWrapper.geocodeAddress(addressData);
			posesModel.setLatitude(Double.valueOf(gps.getDecimalLatitude()));
			posesModel.setLongitude(Double.valueOf(gps.getDecimalLongitude()));
			
		
		return posesModel;
	}

	

	/**
	 * Validate store data.
	 *
	 * @param posBean the pos bean
	 * @param errors the errors
	 * @return true, if successful
	 */
	private boolean validateStoreData(StoreBean posBean, List<ErrorBean> errors)
	{
		boolean isValid = true;
		if (StringUtils.isEmpty(posBean.getSiteId()) || StringUtils.isEmpty(posBean.getRegion())
				|| posBean.getAddress() == null || posBean.getStartDate().after(DateUtils.getDateOnlyFromDate(new Date()))
)
		{
			ErrorBean error = new ErrorBean();
			error.setFileName(posBean.getImportFileName());
			error.setStoreId(posBean.getSiteId());
			error.setField("Site ID");
			error.setMessage(getPOStValidationMessage(posBean));
			errors.add(error);
			isValid = false;
			errorCount++;
		}
		return isValid;
	}
	
	/**
	 * Gets the PO st validation message.
	 *
	 * @param posBean the pos bean
	 * @return the PO st validation message
	 */
	private String getPOStValidationMessage(StoreBean posBean){
		
		if(StringUtils.isBlank(posBean.getSiteId())){
			return POS_Id_Empty;
		}
		if(StringUtils.isBlank(posBean.getRegion())){
			return  POS_Region_Empty;
		}
		if(posBean.getAddress() == null){
			return  POS_Address_Empty;
		}
		
		return errorDirec;
		
	}
	/**
	 * Validate stor update rules.
	 *
	 * @param pointOfServiceModel the point of service model
	 * @param posBean the pos bean
	 * @return true, if successful
	 */
	private boolean validateStorUpdateRules(PointOfServiceModel pointOfServiceModel,StoreBean posBean )
	{
		boolean isValid = false;
		
			if (!StringUtils.equals(pointOfServiceModel.getName(), posBean.getSiteId()))
			{
				isValid = true;
			}
			if (!StringUtils.equals(pointOfServiceModel.getRegion(), posBean.getRegion()))
			{
				isValid = true;
			}
			if (!StringUtils.equals(pointOfServiceModel.getDisplayName(), posBean.getName()))
			{
				isValid = true;
			}
			if (pointOfServiceModel.getAddress() != null)
			{
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getPhone1(), posBean.getAddress().getTelephoneNo()))
				{
					isValid = true;
				}
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getTown(), posBean.getAddress().getCity()))
				{
					isValid = true;
				}
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getFax(), posBean.getAddress().getFax()))
				{
					isValid = true;
				}
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getLine1(), posBean.getAddress().getAddrLine1()))
				{
					isValid = true;
				}
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getLine2(), posBean.getAddress().getAddrLine2()))
				{
					isValid = true;
				}
				if (!StringUtils.equals(pointOfServiceModel.getAddress().getLine2(), posBean.getAddress().getAddrLine2()))
				{
					isValid = true;
				}
			}
		
		return isValid;
	}

	/**
	 * Reset counters.
	 */
	private void resetCounters()
	{
		
		successCount = 0;
		errorCount = 0;
		skipCount=0;
		errorPOS = new ArrayList<ErrorBean>();
		skipCounts = new ArrayList<SkipBean>();
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
	 * @param modelService           the modelService to set
	 */
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
	 * @param commonI18NService           the commonI18NService to set
	 */
	public void setCommonI18NService(CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	/**
	 * Gets the pos converter.
	 *
	 * @return the posConverter
	 */
	public PointOfServiceConverter getPosConverter()
	{
		return posConverter;
	}

	/**
	 * Sets the pos converter.
	 *
	 * @param posConverter           the posConverter to set
	 */
	public void setPosConverter(PointOfServiceConverter posConverter)
	{
		this.posConverter = posConverter;
	}

	/**
	 * Gets the point of service service.
	 *
	 * @return the pointOfServiceService
	 */
	public PointOfServiceService getPointOfServiceService()
	{
		return pointOfServiceService;
	}

	/**
	 * Sets the point of service service.
	 *
	 * @param pointOfServiceService the pointOfServiceService to set
	 */
	public void setPointOfServiceService(PointOfServiceService pointOfServiceService)
	{
		this.pointOfServiceService = pointOfServiceService;
	}

	/**
	 * Gets the base store service.
	 *
	 * @return the base store service
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

	/**
	 * Gets the error count.
	 *
	 * @return the errorCount
	 */
	public int getErrorCount()
	{
		return errorCount;
	}

	/**
	 * Sets the error count.
	 *
	 * @param errorCount           the errorCount to set
	 */
	public void setErrorCount(int errorCount)
	{
		this.errorCount = errorCount;
	}

	/**
	 * Gets the success count.
	 *
	 * @return the successCount
	 */
	public int getSuccessCount()
	{
		return successCount;
	}

	/**
	 * Sets the success count.
	 *
	 * @param successCount           the successCount to set
	 */
	public void setSuccessCount(int successCount)
	{
		this.successCount = successCount;
	}

}
