/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.jalo;

import com.paypal.hybris.constants.PaypalConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.order.payment.PaymentInfo;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.order.payment.PaymentInfo PaypalPaymentInfo}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedPaypalPaymentInfo extends PaymentInfo
{
	/** Qualifier of the <code>PaypalPaymentInfo.token</code> attribute **/
	public static final String TOKEN = "token";
	/** Qualifier of the <code>PaypalPaymentInfo.paymentAction</code> attribute **/
	public static final String PAYMENTACTION = "paymentAction";
	/** Qualifier of the <code>PaypalPaymentInfo.payerId</code> attribute **/
	public static final String PAYERID = "payerId";
	/** Qualifier of the <code>PaypalPaymentInfo.payer</code> attribute **/
	public static final String PAYER = "payer";
	/** Qualifier of the <code>PaypalPaymentInfo.billingAgreementID</code> attribute **/
	public static final String BILLINGAGREEMENTID = "billingAgreementID";
	/** Qualifier of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute **/
	public static final String USEREFERENCETRANSACTION = "useReferenceTransaction";
	/** Qualifier of the <code>PaypalPaymentInfo.financingFeeAmount</code> attribute **/
	public static final String FINANCINGFEEAMOUNT = "financingFeeAmount";
	/** Qualifier of the <code>PaypalPaymentInfo.financingTerm</code> attribute **/
	public static final String FINANCINGTERM = "financingTerm";
	/** Qualifier of the <code>PaypalPaymentInfo.financingMonthlyPayment</code> attribute **/
	public static final String FINANCINGMONTHLYPAYMENT = "financingMonthlyPayment";
	/** Qualifier of the <code>PaypalPaymentInfo.financingTotalCost</code> attribute **/
	public static final String FINANCINGTOTALCOST = "financingTotalCost";
	/** Qualifier of the <code>PaypalPaymentInfo.financingChangeTolerance</code> attribute **/
	public static final String FINANCINGCHANGETOLERANCE = "financingChangeTolerance";
	/** Qualifier of the <code>PaypalPaymentInfo.financingCurrencyCode</code> attribute **/
	public static final String FINANCINGCURRENCYCODE = "financingCurrencyCode";
	/** Qualifier of the <code>PaypalPaymentInfo.isFinancing</code> attribute **/
	public static final String ISFINANCING = "isFinancing";
	/** Qualifier of the <code>PaypalPaymentInfo.isReplenishment</code> attribute **/
	public static final String ISREPLENISHMENT = "isReplenishment";
	/** Qualifier of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute **/
	public static final String ISBILLINGADDRESSREQUIRED = "isBillingAddressRequired";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(PaymentInfo.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TOKEN, AttributeMode.INITIAL);
		tmp.put(PAYMENTACTION, AttributeMode.INITIAL);
		tmp.put(PAYERID, AttributeMode.INITIAL);
		tmp.put(PAYER, AttributeMode.INITIAL);
		tmp.put(BILLINGAGREEMENTID, AttributeMode.INITIAL);
		tmp.put(USEREFERENCETRANSACTION, AttributeMode.INITIAL);
		tmp.put(FINANCINGFEEAMOUNT, AttributeMode.INITIAL);
		tmp.put(FINANCINGTERM, AttributeMode.INITIAL);
		tmp.put(FINANCINGMONTHLYPAYMENT, AttributeMode.INITIAL);
		tmp.put(FINANCINGTOTALCOST, AttributeMode.INITIAL);
		tmp.put(FINANCINGCHANGETOLERANCE, AttributeMode.INITIAL);
		tmp.put(FINANCINGCURRENCYCODE, AttributeMode.INITIAL);
		tmp.put(ISFINANCING, AttributeMode.INITIAL);
		tmp.put(ISREPLENISHMENT, AttributeMode.INITIAL);
		tmp.put(ISBILLINGADDRESSREQUIRED, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.billingAgreementID</code> attribute.
	 * @return the billingAgreementID
	 */
	public String getBillingAgreementID(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BILLINGAGREEMENTID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.billingAgreementID</code> attribute.
	 * @return the billingAgreementID
	 */
	public String getBillingAgreementID()
	{
		return getBillingAgreementID( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.billingAgreementID</code> attribute. 
	 * @param value the billingAgreementID
	 */
	public void setBillingAgreementID(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BILLINGAGREEMENTID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.billingAgreementID</code> attribute. 
	 * @param value the billingAgreementID
	 */
	public void setBillingAgreementID(final String value)
	{
		setBillingAgreementID( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingChangeTolerance</code> attribute.
	 * @return the financingChangeTolerance
	 */
	public String getFinancingChangeTolerance(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FINANCINGCHANGETOLERANCE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingChangeTolerance</code> attribute.
	 * @return the financingChangeTolerance
	 */
	public String getFinancingChangeTolerance()
	{
		return getFinancingChangeTolerance( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingChangeTolerance</code> attribute. 
	 * @param value the financingChangeTolerance
	 */
	public void setFinancingChangeTolerance(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FINANCINGCHANGETOLERANCE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingChangeTolerance</code> attribute. 
	 * @param value the financingChangeTolerance
	 */
	public void setFinancingChangeTolerance(final String value)
	{
		setFinancingChangeTolerance( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingCurrencyCode</code> attribute.
	 * @return the financingCurrencyCode
	 */
	public String getFinancingCurrencyCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FINANCINGCURRENCYCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingCurrencyCode</code> attribute.
	 * @return the financingCurrencyCode
	 */
	public String getFinancingCurrencyCode()
	{
		return getFinancingCurrencyCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingCurrencyCode</code> attribute. 
	 * @param value the financingCurrencyCode
	 */
	public void setFinancingCurrencyCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FINANCINGCURRENCYCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingCurrencyCode</code> attribute. 
	 * @param value the financingCurrencyCode
	 */
	public void setFinancingCurrencyCode(final String value)
	{
		setFinancingCurrencyCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingFeeAmount</code> attribute.
	 * @return the financingFeeAmount
	 */
	public BigDecimal getFinancingFeeAmount(final SessionContext ctx)
	{
		return (BigDecimal)getProperty( ctx, FINANCINGFEEAMOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingFeeAmount</code> attribute.
	 * @return the financingFeeAmount
	 */
	public BigDecimal getFinancingFeeAmount()
	{
		return getFinancingFeeAmount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingFeeAmount</code> attribute. 
	 * @param value the financingFeeAmount
	 */
	public void setFinancingFeeAmount(final SessionContext ctx, final BigDecimal value)
	{
		setProperty(ctx, FINANCINGFEEAMOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingFeeAmount</code> attribute. 
	 * @param value the financingFeeAmount
	 */
	public void setFinancingFeeAmount(final BigDecimal value)
	{
		setFinancingFeeAmount( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingMonthlyPayment</code> attribute.
	 * @return the financingMonthlyPayment
	 */
	public BigDecimal getFinancingMonthlyPayment(final SessionContext ctx)
	{
		return (BigDecimal)getProperty( ctx, FINANCINGMONTHLYPAYMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingMonthlyPayment</code> attribute.
	 * @return the financingMonthlyPayment
	 */
	public BigDecimal getFinancingMonthlyPayment()
	{
		return getFinancingMonthlyPayment( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingMonthlyPayment</code> attribute. 
	 * @param value the financingMonthlyPayment
	 */
	public void setFinancingMonthlyPayment(final SessionContext ctx, final BigDecimal value)
	{
		setProperty(ctx, FINANCINGMONTHLYPAYMENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingMonthlyPayment</code> attribute. 
	 * @param value the financingMonthlyPayment
	 */
	public void setFinancingMonthlyPayment(final BigDecimal value)
	{
		setFinancingMonthlyPayment( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTerm</code> attribute.
	 * @return the financingTerm
	 */
	public Integer getFinancingTerm(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, FINANCINGTERM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTerm</code> attribute.
	 * @return the financingTerm
	 */
	public Integer getFinancingTerm()
	{
		return getFinancingTerm( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @return the financingTerm
	 */
	public int getFinancingTermAsPrimitive(final SessionContext ctx)
	{
		Integer value = getFinancingTerm( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @return the financingTerm
	 */
	public int getFinancingTermAsPrimitive()
	{
		return getFinancingTermAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @param value the financingTerm
	 */
	public void setFinancingTerm(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, FINANCINGTERM,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @param value the financingTerm
	 */
	public void setFinancingTerm(final Integer value)
	{
		setFinancingTerm( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @param value the financingTerm
	 */
	public void setFinancingTerm(final SessionContext ctx, final int value)
	{
		setFinancingTerm( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTerm</code> attribute. 
	 * @param value the financingTerm
	 */
	public void setFinancingTerm(final int value)
	{
		setFinancingTerm( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTotalCost</code> attribute.
	 * @return the financingTotalCost
	 */
	public BigDecimal getFinancingTotalCost(final SessionContext ctx)
	{
		return (BigDecimal)getProperty( ctx, FINANCINGTOTALCOST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.financingTotalCost</code> attribute.
	 * @return the financingTotalCost
	 */
	public BigDecimal getFinancingTotalCost()
	{
		return getFinancingTotalCost( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTotalCost</code> attribute. 
	 * @param value the financingTotalCost
	 */
	public void setFinancingTotalCost(final SessionContext ctx, final BigDecimal value)
	{
		setProperty(ctx, FINANCINGTOTALCOST,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.financingTotalCost</code> attribute. 
	 * @param value the financingTotalCost
	 */
	public void setFinancingTotalCost(final BigDecimal value)
	{
		setFinancingTotalCost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute.
	 * @return the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public Boolean isIsBillingAddressRequired(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISBILLINGADDRESSREQUIRED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute.
	 * @return the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public Boolean isIsBillingAddressRequired()
	{
		return isIsBillingAddressRequired( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @return the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public boolean isIsBillingAddressRequiredAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsBillingAddressRequired( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @return the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public boolean isIsBillingAddressRequiredAsPrimitive()
	{
		return isIsBillingAddressRequiredAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @param value the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public void setIsBillingAddressRequired(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISBILLINGADDRESSREQUIRED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @param value the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public void setIsBillingAddressRequired(final Boolean value)
	{
		setIsBillingAddressRequired( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @param value the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public void setIsBillingAddressRequired(final SessionContext ctx, final boolean value)
	{
		setIsBillingAddressRequired( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isBillingAddressRequired</code> attribute. 
	 * @param value the isBillingAddressRequired - Defines if billing address is required for order
	 */
	public void setIsBillingAddressRequired(final boolean value)
	{
		setIsBillingAddressRequired( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isFinancing</code> attribute.
	 * @return the isFinancing
	 */
	public Boolean isIsFinancing(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISFINANCING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isFinancing</code> attribute.
	 * @return the isFinancing
	 */
	public Boolean isIsFinancing()
	{
		return isIsFinancing( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @return the isFinancing
	 */
	public boolean isIsFinancingAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsFinancing( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @return the isFinancing
	 */
	public boolean isIsFinancingAsPrimitive()
	{
		return isIsFinancingAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @param value the isFinancing
	 */
	public void setIsFinancing(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISFINANCING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @param value the isFinancing
	 */
	public void setIsFinancing(final Boolean value)
	{
		setIsFinancing( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @param value the isFinancing
	 */
	public void setIsFinancing(final SessionContext ctx, final boolean value)
	{
		setIsFinancing( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isFinancing</code> attribute. 
	 * @param value the isFinancing
	 */
	public void setIsFinancing(final boolean value)
	{
		setIsFinancing( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute.
	 * @return the isReplenishment
	 */
	public Boolean isIsReplenishment(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ISREPLENISHMENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute.
	 * @return the isReplenishment
	 */
	public Boolean isIsReplenishment()
	{
		return isIsReplenishment( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @return the isReplenishment
	 */
	public boolean isIsReplenishmentAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isIsReplenishment( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @return the isReplenishment
	 */
	public boolean isIsReplenishmentAsPrimitive()
	{
		return isIsReplenishmentAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @param value the isReplenishment
	 */
	public void setIsReplenishment(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ISREPLENISHMENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @param value the isReplenishment
	 */
	public void setIsReplenishment(final Boolean value)
	{
		setIsReplenishment( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @param value the isReplenishment
	 */
	public void setIsReplenishment(final SessionContext ctx, final boolean value)
	{
		setIsReplenishment( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.isReplenishment</code> attribute. 
	 * @param value the isReplenishment
	 */
	public void setIsReplenishment(final boolean value)
	{
		setIsReplenishment( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.payer</code> attribute.
	 * @return the payer - Payer for payment information display
	 */
	public String getPayer(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PAYER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.payer</code> attribute.
	 * @return the payer - Payer for payment information display
	 */
	public String getPayer()
	{
		return getPayer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.payer</code> attribute. 
	 * @param value the payer - Payer for payment information display
	 */
	public void setPayer(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PAYER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.payer</code> attribute. 
	 * @param value the payer - Payer for payment information display
	 */
	public void setPayer(final String value)
	{
		setPayer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.payerId</code> attribute.
	 * @return the payerId - PayerId for DoExpressCheckoutPayment PayPal operation
	 */
	public String getPayerId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PAYERID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.payerId</code> attribute.
	 * @return the payerId - PayerId for DoExpressCheckoutPayment PayPal operation
	 */
	public String getPayerId()
	{
		return getPayerId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.payerId</code> attribute. 
	 * @param value the payerId - PayerId for DoExpressCheckoutPayment PayPal operation
	 */
	public void setPayerId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PAYERID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.payerId</code> attribute. 
	 * @param value the payerId - PayerId for DoExpressCheckoutPayment PayPal operation
	 */
	public void setPayerId(final String value)
	{
		setPayerId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.paymentAction</code> attribute.
	 * @return the paymentAction - Payment action for PayPal operations chain
	 */
	public EnumerationValue getPaymentAction(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, PAYMENTACTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.paymentAction</code> attribute.
	 * @return the paymentAction - Payment action for PayPal operations chain
	 */
	public EnumerationValue getPaymentAction()
	{
		return getPaymentAction( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.paymentAction</code> attribute. 
	 * @param value the paymentAction - Payment action for PayPal operations chain
	 */
	public void setPaymentAction(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, PAYMENTACTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.paymentAction</code> attribute. 
	 * @param value the paymentAction - Payment action for PayPal operations chain
	 */
	public void setPaymentAction(final EnumerationValue value)
	{
		setPaymentAction( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.token</code> attribute.
	 * @return the token - Token for PayPal operations chain
	 */
	public String getToken(final SessionContext ctx)
	{
		return (String)getProperty( ctx, TOKEN);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.token</code> attribute.
	 * @return the token - Token for PayPal operations chain
	 */
	public String getToken()
	{
		return getToken( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.token</code> attribute. 
	 * @param value the token - Token for PayPal operations chain
	 */
	public void setToken(final SessionContext ctx, final String value)
	{
		setProperty(ctx, TOKEN,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.token</code> attribute. 
	 * @param value the token - Token for PayPal operations chain
	 */
	public void setToken(final String value)
	{
		setToken( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute.
	 * @return the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public Boolean isUseReferenceTransaction(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, USEREFERENCETRANSACTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute.
	 * @return the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public Boolean isUseReferenceTransaction()
	{
		return isUseReferenceTransaction( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @return the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public boolean isUseReferenceTransactionAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isUseReferenceTransaction( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @return the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public boolean isUseReferenceTransactionAsPrimitive()
	{
		return isUseReferenceTransactionAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @param value the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public void setUseReferenceTransaction(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, USEREFERENCETRANSACTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @param value the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public void setUseReferenceTransaction(final Boolean value)
	{
		setUseReferenceTransaction( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @param value the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public void setUseReferenceTransaction(final SessionContext ctx, final boolean value)
	{
		setUseReferenceTransaction( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>PaypalPaymentInfo.useReferenceTransaction</code> attribute. 
	 * @param value the useReferenceTransaction - Defines if the reference transaction(billing agreement) is used for order
	 */
	public void setUseReferenceTransaction(final boolean value)
	{
		setUseReferenceTransaction( getSession().getSessionContext(), value );
	}
	
}
