package au.com.rejectshop.convertors;


import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import au.com.rejecshop.xml.price.beans.Price;
import au.com.rejecshop.xml.price.beans.PriceCommonData;
import au.com.rejecshop.xml.price.beans.PriceCommonDataExtension;
import au.com.rejecshop.xml.price.beans.PriceDerivationType;
import au.com.rejecshop.xml.price.beans.PriceMessageType;
import au.com.rejecshop.xml.price.beans.PriceRuleSetType;
import au.com.rejecshop.xml.price.beans.PriceRuleType;
import au.com.rejectshop.data.PriceBean;
import au.com.rejectshop.data.ProductBean;


/**
 * The Class PriceConverter.
 */
public class PriceConverter implements Converter<File, List<ProductBean>>
{

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(PriceConverter.class);

	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public List<ProductBean> convert(File file) throws ConversionException
	{
		final List<ProductBean> productdataList = new ArrayList<ProductBean>();
		return convert(file, productdataList);
	}


	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object, java.lang.Object)
	 */
	@Override
	public List<ProductBean> convert(File path, List<ProductBean> productdataList) throws ConversionException
	{
		ProductBean productdata = null;

		try
		{
			final JAXBContext jaxbContext = JAXBContext.newInstance(Price.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final Price price = (Price) jaxbUnmarshaller.unmarshal(path);

			if (price != null && CollectionUtils.isNotEmpty(price.getPriceMessage()))
			{
				for (final PriceMessageType priceMessageType : price.getPriceMessage())
				{
					final List<PriceRuleSetType> priceRuleSetTypes = priceMessageType.getPriceRuleSet();
					
					if (CollectionUtils.isNotEmpty(priceRuleSetTypes))
					{
						for (final PriceRuleSetType priceRuleSetType : priceRuleSetTypes)
							
						{
							final List<PriceRuleType> priceRuleTypes = (List<PriceRuleType>) (List<?>) priceRuleSetType
									.getPriceRuleIDOrPriceRule();
							if (CollectionUtils.isNotEmpty(priceRuleTypes))
							{
								for (final PriceRuleType priceRuleType : priceRuleTypes)
								{
									productdata = new ProductBean();
									PriceBean priceBean = new PriceBean();
									final List<PriceBean> priceBeanList = new ArrayList<PriceBean>();
									if(priceRuleType.getPriceRuleID()!=null){
					                 String priceRuleId=priceRuleType.getPriceRuleID();
					                   priceBean.setPriceRuleID(priceRuleId);
					                   }
									// Set Product Id
									if(priceRuleType.getEligibility() != null 
													&& priceRuleType.getEligibility().getItemCollection() != null){
										productdata.setCode(priceRuleType.getEligibility().getItemCollection().getItemCollectionID());
									}
									final PriceDerivationType priceDerivationType = priceRuleType.getDerivation();
									if (priceDerivationType != null)
									{
										final List<PriceCommonDataExtension> newprice = (List<PriceCommonDataExtension>) (List<?>) priceDerivationType
												.getNewPriceOrNewPriceType();
										if (CollectionUtils.isNotEmpty(newprice))
										{
											for (final PriceCommonData priceCommonData : newprice)
											{
												// Set Price
												if (priceCommonData.getValue() != null)
												{
													priceBean.setPrice(priceCommonData.getValue().doubleValue());
												}
												priceBeanList.add(priceBean);
											}
										} 
									}
									// Set Start Date
									if(priceRuleType.getEffectiveDateTimestamp() != null 
												&& priceRuleType.getEffectiveDateTimestamp().toGregorianCalendar() != null){
										priceBean.setStartDate(priceRuleType.getEffectiveDateTimestamp().toGregorianCalendar().getTime());
									}
									// Set End Date
									if(priceRuleType.getExpirationDateTimestamp() != null 
											&& priceRuleType.getExpirationDateTimestamp().toGregorianCalendar() != null){
									priceBean.setEndDate(priceRuleType.getExpirationDateTimestamp().toGregorianCalendar().getTime());
								}
									productdata.setPrice(priceBeanList);
									productdata.setImportFileName(path.getName());
									productdataList.add(productdata);

								} 
							}
						} 
					}
				}
			}
		}
		catch (Exception exception)
		{

			LOG.error("[ Error Occured while Processing XML file " + exception + "]");

		}
		return productdataList;
	}
}
