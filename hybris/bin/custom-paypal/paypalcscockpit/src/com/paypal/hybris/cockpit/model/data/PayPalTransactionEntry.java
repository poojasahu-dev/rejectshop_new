/**
 *
 */
package com.paypal.hybris.cockpit.model.data;

public class PayPalTransactionEntry
{
	private String transactionId;
	private String transactionType;
	private String payerId;
	private String paymentDate;

	/**
	 * @param transactionId
	 * @param payerId
	 * @param paymentDate
	 */
	public PayPalTransactionEntry(final String transactionId, final String transactionType, final String payerId, final String paymentDate)
	{
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.payerId = payerId;
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * @param transactionId
	 *           the transactionId to set
	 */
	public void setTransactionId(final String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType()
	{
		return transactionType;
	}

	/**
	 * @param transactionType
	 *           the transactionType to set
	 */
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}

	/**
	 * @return the payerId
	 */
	public String getPayerId()
	{
		return payerId;
	}

	/**
	 * @param payerId
	 *           the payerId to set
	 */
	public void setPayerId(final String payerId)
	{
		this.payerId = payerId;
	}

	/**
	 * @return the token
	 */
	public String getPaymentDate()
	{
		return paymentDate;
	}

	/**
	 * @param paymentDate
	 *           the paymentDate to set
	 */
	public void setPaymentDate(final String paymentDate)
	{
		this.paymentDate = paymentDate;
	}
}
