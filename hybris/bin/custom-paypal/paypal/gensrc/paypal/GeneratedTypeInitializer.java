

package paypal;

import java.util.*;
import java.io.Serializable;
import de.hybris.platform.util.*;
import de.hybris.platform.core.*;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.type.*;
import de.hybris.platform.persistence.type.*;
import de.hybris.platform.persistence.enumeration.*;
import de.hybris.platform.persistence.property.PersistenceManager;
import de.hybris.platform.persistence.*;

/**
 * Generated by hybris Platform.
 */
@SuppressWarnings({"cast","unused","boxing","null", "PMD"})
public class GeneratedTypeInitializer extends AbstractTypeInitializer
{
	/**
	 * Generated by hybris Platform.
	 */
	public GeneratedTypeInitializer( ManagerEJB manager, Map params )
	{
		super( manager, params );
	}


	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected void performRemoveObjects( ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// no-op by now
	}

	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performCreateTypes( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performCreateTypes
	
	
		createItemType(
			"PaypalPaymentInfo",
			"PaymentInfo",
			com.paypal.hybris.jalo.PaypalPaymentInfo.class,
			null,
			false,
			null,
			false
		);
	
		createItemType(
			"PaypalPartialRefundEntry",
			"GenericItem",
			com.paypal.hybris.jalo.PaypalPartialRefundEntry.class,
			"de.hybris.platform.persistence.paypal_PaypalPartialRefundEntry",
			false,
			null,
			false
		);
	
		createEnumerationType(
			"PaymentActionType",
			null
		);
	
	}

	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performModifyTypes( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performModifyTypes
	

	
	
				single_createattr_PaypalPaymentInfo_token();
			
				single_createattr_PaypalPaymentInfo_paymentAction();
			
				single_createattr_PaypalPaymentInfo_payerId();
			
				single_createattr_PaypalPaymentInfo_payer();
			
				single_createattr_PaypalPaymentInfo_billingAgreementID();
			
				single_createattr_PaypalPaymentInfo_useReferenceTransaction();
			
				single_createattr_PaypalPaymentInfo_financingFeeAmount();
			
				single_createattr_PaypalPaymentInfo_financingTerm();
			
				single_createattr_PaypalPaymentInfo_financingMonthlyPayment();
			
				single_createattr_PaypalPaymentInfo_financingTotalCost();
			
				single_createattr_PaypalPaymentInfo_financingChangeTolerance();
			
				single_createattr_PaypalPaymentInfo_financingCurrencyCode();
			
				single_createattr_PaypalPaymentInfo_isFinancing();
			
				single_createattr_PaypalPaymentInfo_isReplenishment();
			
				single_createattr_PaypalPaymentInfo_isBillingAddressRequired();
			
				single_createattr_PaypalPartialRefundEntry_orderEntry();
			
				single_createattr_PaypalPartialRefundEntry_percentRefuntValue();
			

	}

	
	public void single_createattr_PaypalPaymentInfo_token() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"token",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_paymentAction() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"paymentAction",  
					null,
					"PaymentActionType",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_payerId() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"payerId",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_payer() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"payer",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_billingAgreementID() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"billingAgreementID",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_useReferenceTransaction() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"useReferenceTransaction",  
					null,
					"java.lang.Boolean",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingFeeAmount() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingFeeAmount",  
					null,
					"java.math.BigDecimal",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingTerm() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingTerm",  
					null,
					"java.lang.Integer",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingMonthlyPayment() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingMonthlyPayment",  
					null,
					"java.math.BigDecimal",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingTotalCost() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingTotalCost",  
					null,
					"java.math.BigDecimal",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingChangeTolerance() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingChangeTolerance",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_financingCurrencyCode() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"financingCurrencyCode",  
					null,
					"java.lang.String",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_isFinancing() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"isFinancing",  
					null,
					"java.lang.Boolean",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_isReplenishment() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"isReplenishment",  
					null,
					"java.lang.Boolean",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPaymentInfo_isBillingAddressRequired() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPaymentInfo", 
					"isBillingAddressRequired",  
					null,
					"java.lang.Boolean",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPartialRefundEntry_orderEntry() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPartialRefundEntry", 
					"orderEntry",  
					null,
					"AbstractOrderEntry",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.OPTIONAL_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	
	public void single_createattr_PaypalPartialRefundEntry_percentRefuntValue() throws JaloBusinessException
	{
		
						Map sqlColumnDefinitions = null;
					
				createPropertyAttribute(
					"PaypalPartialRefundEntry", 
					"percentRefuntValue",  
					null,
					"java.lang.Double",
					de.hybris.platform.jalo.type.AttributeDescriptor.READ_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.WRITE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.REMOVE_FLAG|de.hybris.platform.jalo.type.AttributeDescriptor.SEARCH_FLAG,
					null,
					sqlColumnDefinitions
				);
			
	}
	


	/**
	 * Generated by hybris Platform.
	 */
	@Override
	protected final void performCreateObjects( final ManagerEJB manager, Map params ) throws JaloBusinessException
	{
		// performCreateObjects
	
	
		createEnumerationValues(
			"PaymentTransactionType",
			false,
			Arrays.asList( new String[] {
			
				"ORDER",
				"REAUTHORIZATION",
				"SALE",
				"PARTIAL_REFUND",
				"VOID"
			} )
		);
	
		createEnumerationValues(
			"PaymentActionType",
			false,
			Arrays.asList( new String[] {
			
				"ORDER",
				"AUTHORIZATION",
				"SALE"
			} )
		);
	
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"PaypalPaymentInfo",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_PaypalPaymentInfo_token();
		
			single_setAttributeProperties_PaypalPaymentInfo_paymentAction();
		
			single_setAttributeProperties_PaypalPaymentInfo_payerId();
		
			single_setAttributeProperties_PaypalPaymentInfo_payer();
		
			single_setAttributeProperties_PaypalPaymentInfo_billingAgreementID();
		
			single_setAttributeProperties_PaypalPaymentInfo_useReferenceTransaction();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingFeeAmount();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingTerm();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingMonthlyPayment();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingTotalCost();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingChangeTolerance();
		
			single_setAttributeProperties_PaypalPaymentInfo_financingCurrencyCode();
		
			single_setAttributeProperties_PaypalPaymentInfo_isFinancing();
		
			single_setAttributeProperties_PaypalPaymentInfo_isReplenishment();
		
			single_setAttributeProperties_PaypalPaymentInfo_isBillingAddressRequired();
		
				{
				Map customPropsMap = new HashMap();
				
				setItemTypeProperties(
					"PaypalPartialRefundEntry",
					false,
					true,
					true,
					null,
					customPropsMap
				);
				}
			
			single_setAttributeProperties_PaypalPartialRefundEntry_orderEntry();
		
			single_setAttributeProperties_PaypalPartialRefundEntry_percentRefuntValue();
		
				changeMetaType(
					"PaymentTransactionType",
					null,
					null
				);
			
				setDefaultProperties(
					"PaymentActionType",
					true,
					true,
					null
				);
			
	}


		
						public void single_setAttributeProperties_PaypalPaymentInfo_token() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"token",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_paymentAction() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"paymentAction",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_payerId() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"payerId",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_payer() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"payer",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_billingAgreementID() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"billingAgreementID",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_useReferenceTransaction() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"useReferenceTransaction",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingFeeAmount() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingFeeAmount",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingTerm() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingTerm",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingMonthlyPayment() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingMonthlyPayment",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingTotalCost() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingTotalCost",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingChangeTolerance() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingChangeTolerance",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_financingCurrencyCode() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"financingCurrencyCode",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_isFinancing() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"isFinancing",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_isReplenishment() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"isReplenishment",
								false, 
								false,
								"false",
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPaymentInfo_isBillingAddressRequired() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPaymentInfo", 
								"isBillingAddressRequired",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPartialRefundEntry_orderEntry() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPartialRefundEntry", 
								"orderEntry",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
						public void single_setAttributeProperties_PaypalPartialRefundEntry_percentRefuntValue() throws JaloBusinessException
						{
							
							
							
							Map customPropsMap = new HashMap();
							
							setAttributeProperties(
								"PaypalPartialRefundEntry", 
								"percentRefuntValue",
								false, 
								null,
								null,
								null,
								true,
								true,
								null,
								customPropsMap,
								null
							);
						}
					
}

	