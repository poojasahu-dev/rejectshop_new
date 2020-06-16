/**
 * 
 */
package au.com.rejectshop.convertors;

import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import au.com.rejectshop.data.AddressBean;
import au.com.rejectshop.data.StoreBean;
import au.com.rejectshop.xml.store.beans.AddressType;
import au.com.rejectshop.xml.store.beans.ContactInformationType;
import au.com.rejectshop.xml.store.beans.Customer;
import au.com.rejectshop.xml.store.beans.CustomerStatusType;
import au.com.rejectshop.xml.store.beans.Customers;
import au.com.rejectshop.xml.store.beans.EntityInformationType;
import au.com.rejectshop.xml.store.beans.OrganizationType;
import au.com.rejectshop.xml.store.beans.OrganizationType.OrganizationHierarchy;

/**
 * The Class PointOfServiceConverter.
 */
public class PointOfServiceConverter implements Converter<File, List<StoreBean>>
{

	/** The Constant REGION. */
	private static final String REGION = "Region";
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(PointOfServiceConverter.class);

	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public List<StoreBean> convert(File file) throws ConversionException
	{
		final List<StoreBean> pointOfServiceBeans = new ArrayList<StoreBean>();
		return convert(file, pointOfServiceBeans);
	}


	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.dto.converter.Converter#convert(java.lang.Object, java.lang.Object)
	 */
	@Override
	public List<StoreBean> convert(File file, List<StoreBean> pointOfServiceBeans) throws ConversionException
	{
		LOG.debug("Converting POS Bean");
		try
		{
			final JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final Customers cutomers = (Customers) jaxbUnmarshaller.unmarshal(file);
			final List<Customer> customers = cutomers.getCustomer();

			if (CollectionUtils.isNotEmpty(customers))
			{
				for (final Customer customer : customers)
				{
					final AddressBean addressBean = new AddressBean();
					final StoreBean posBean = new StoreBean();
					// Set POS Id
					if(customer.getSiteID() != null) {
						posBean.setSiteId(customer.getSiteID().getValue());
					}
					
					 String posName=customer.getSiteID().getLegacy();
					 posBean.setName(posName);
				
					if (CollectionUtils.isNotEmpty(customer.getEntityInformation()))
					{
						for (final EntityInformationType entityInformationType : customer.getEntityInformation())
						{
							final List<OrganizationType> organizationTypes = entityInformationType.getOrganization();

							if (CollectionUtils.isNotEmpty(organizationTypes))
							{
								for (final OrganizationType organizationType : organizationTypes)
								{
									final List<String> description = organizationType.getName();
                               
								
									// Set POS Name
									if (CollectionUtils.isNotEmpty(description))
									{
										posBean.setDescription(description.get(0));
									}

									final ContactInformationType contactInformationType = organizationType.getContactInformation();
									if (contactInformationType != null)
									{
										// Set Telephone
										final List<ContactInformationType.Telephone> telephoneTypes = contactInformationType.getTelephone();
										if (CollectionUtils.isNotEmpty(telephoneTypes))
										{
											for (final ContactInformationType.Telephone telephoneType : telephoneTypes)
											{
												final String telephoneno = telephoneType.getTelephoneNumber();
												addressBean.setTelephoneNo(telephoneno);
											}
										}
										// Set Fax
										if (CollectionUtils.isNotEmpty(contactInformationType.getFax()))
										{
											for (final ContactInformationType.Fax fax : contactInformationType.getFax())
											{
												final String faxno = fax.getTelephoneNumber();
												addressBean.setFax(faxno);
											}
										}
										// Set Address
										if (CollectionUtils.isNotEmpty(contactInformationType.getAddress()))
										{
											for(AddressType addressType : contactInformationType.getAddress() ){
												if(addressType.getAddressLine1() != null) {
													addressBean.setAddrLine1(addressType.getAddressLine1().getValue());
												}
												if(addressType.getAddressLine2() != null) {
													addressBean.setAddrLine2(addressType.getAddressLine2().getValue());
												}
												addressBean.setCity(addressType.getCity());
												addressBean.setCountry(addressType.getCountry());
												addressBean.setPostalCode(addressType.getPostalCode());
												if (addressType.getTerritory() != null)
												{
													addressBean.setState(addressType.getTerritory().getValue());
												}
												posBean.setAddress(addressBean);
												break;
											}
										}
									}

									// Set Region
									if (CollectionUtils.isNotEmpty(organizationType.getOrganizationHierarchy()))
									{
										for (OrganizationHierarchy organizationHierarchy : organizationType.getOrganizationHierarchy())
										{
											if (StringUtils.equals(organizationHierarchy.getLevel(), REGION))
											{
												posBean.setRegion(organizationHierarchy.getValue());
											}
											
											if (StringUtils.equals(organizationHierarchy.getLevel(), "District"))
											{
												posBean.setDistrict(organizationHierarchy.getValue());
											}
											
											if (StringUtils.equals(organizationHierarchy.getLevel(), "OperatingCompany"))
											{
												posBean.setOperatingCompany(organizationHierarchy.getValue());
											}

										} 
									}
								} 
							}
						} 
					}
					// Customer Status Start Date
					
					CustomerStatusType customerStatus = customer.getCustomerStatus();
					if (customerStatus != null)
					{
						final XMLGregorianCalendar startDate = customerStatus.getStartDate();
						final XMLGregorianCalendar endDate = customerStatus.getEndDate();
						if (startDate.toGregorianCalendar() != null && endDate.toGregorianCalendar() != null)
						{

							posBean.setStartDate(startDate.toGregorianCalendar().getTime());
							posBean.setEndDate(endDate.toGregorianCalendar().getTime());
						}
					}
						
					posBean.setImportFileName(file.getName());
					pointOfServiceBeans.add(posBean);
				} 
			}
		}
		catch (Exception exception)
		{
			LOG.error("XML Conversion exception ::"+ exception);
		}
		return pointOfServiceBeans;
	}

}
