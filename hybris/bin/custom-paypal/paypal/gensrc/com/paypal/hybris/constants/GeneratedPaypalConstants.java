/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 15, 2020 12:43:10 PM                    ---
 * ----------------------------------------------------------------
 */
package com.paypal.hybris.constants;

/**
 * @deprecated use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast","PMD"})
public class GeneratedPaypalConstants
{
	public static final String EXTENSIONNAME = "paypal";
	public static class TC
	{
		public static final String PAYMENTACTIONTYPE = "PaymentActionType".intern();
		public static final String PAYPALPARTIALREFUNDENTRY = "PaypalPartialRefundEntry".intern();
		public static final String PAYPALPAYMENTINFO = "PaypalPaymentInfo".intern();
	}
	public static class Attributes
	{
		// no constants defined.
	}
	public static class Enumerations
	{
		public static class PaymentActionType
		{
			public static final String ORDER = "ORDER".intern();
			public static final String AUTHORIZATION = "AUTHORIZATION".intern();
			public static final String SALE = "SALE".intern();
		}
		public static class PaymentTransactionType
		{
			public static final String ORDER = "ORDER".intern();
			public static final String REAUTHORIZATION = "REAUTHORIZATION".intern();
			public static final String SALE = "SALE".intern();
			public static final String PARTIAL_REFUND = "PARTIAL_REFUND".intern();
			public static final String VOID = "VOID".intern();
		}
	}
	
	protected GeneratedPaypalConstants()
	{
		// private constructor
	}
	
	
}
