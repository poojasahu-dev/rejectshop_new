/**
 *
 */
package com.paypal.hybris.jobs;

import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.order.process.OrderCompleteProcessService;

import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.CompleteCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;


public class PayPalCapturingJob extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(PayPalCapturingJob.class);

	private ConfigurationService configurationService;
	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private ModelService modelService;
	private CommonI18NService commonI18NService;
	private OrderCompleteProcessService orderCompleteProcessService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.
	 * CronJobModel )
	 */
	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{

		LOG.info("Perform PayPal capturing process..");

		final StringBuilder query = new StringBuilder();
		query.append(
				"select {pk} from {order} where {status} in ({{select {pk} from {orderstatus} where {code} like 'PAYMENT_NOT_CAPTURED' or {code} like 'APPROVED'}})");
		//query.append("select {pk} from {order} where {status} in ({{select {pk} from {orderstatus} where {code} like 'FRAUD_CHECKED'}})");
		final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query.toString());
		final SearchResult result = flexibleSearchService.search(searchQuery);

		final List res = result.getResult();
		for (final Iterator it = res.iterator(); it.hasNext();)
		{

			final OrderModel order = (OrderModel) it.next();
			final PaymentInfoModel paymentInfoModel = order.getPaymentInfo();
			if (paymentInfoModel != null && paymentInfoModel instanceof PaypalPaymentInfoModel
					&& Boolean.FALSE.equals(((PaypalPaymentInfoModel) paymentInfoModel).getUseReferenceTransaction()))
			{
				final DoCaptureRequestType request = prepareCaptureRequest(order);

				final DoCaptureResponseType response = getPaypalPaymentIntegrationService().doCapture(request);

				// create payment entry
				if (AckCodeType.SUCCESS.equals(response.getAck()))
				{
					final String currencyID = order.getCurrency().getIsocode().toString();
					final PaymentTransactionEntryModel transactionEntry = createTransactionEntry(order.getPaymentTransactions().get(0),
							PaymentTransactionType.CAPTURE, TransactionStatus.ACCEPTED, TransactionStatusDetails.SUCCESFULL,
							response.getDoCaptureResponseDetails().getPaymentInfo().getTransactionID(), currencyID,
							order.getTotalPrice().toString(), PaypalStringUtils.getDateFromResponse(response.getTimestamp()));

					for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
					{
						if (PaypalConstants.PAYMENT_PROVIDER_NAME.equals(paymentTransactionModel.getPaymentProvider()))
						{
							final List<PaymentTransactionEntryModel> transactionEntries = removeCaptureTransactionIfExist(
									paymentTransactionModel.getEntries());

							final List<PaymentTransactionEntryModel> entries = new ArrayList<>(transactionEntries);
							entries.add(transactionEntry);
							paymentTransactionModel.setEntries(entries);
							getModelService().save(paymentTransactionModel);
						}
					}

					// update order status
					order.setStatus(OrderStatus.PAYMENT_CAPTURED);

					getModelService().saveAll(transactionEntry, order);
					orderCompleteProcessService.startOrderCompletionProcess(order);

				}
			}

		}


		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	private final List<PaymentTransactionEntryModel> removeCaptureTransactionIfExist(
			final List<PaymentTransactionEntryModel> transactions)
	{
		final List<PaymentTransactionEntryModel> results = new ArrayList<PaymentTransactionEntryModel>();

		for (final PaymentTransactionEntryModel paymentTransactionEntry : transactions)
		{
			if (!paymentTransactionEntry.getType().equals(PaymentTransactionType.CAPTURE))
			{
				results.add(paymentTransactionEntry);
			}
		}

		return results;

	}

	/**
	 * @param order
	 * @return
	 */
	private DoCaptureRequestType prepareCaptureRequest(final OrderModel order)
	{
		final DoCaptureRequestType request = new DoCaptureRequestType();
		request.setVersion(PaypalConstants.SOAP_API_VERSION);

		final CurrencyCodeType currencyCode = CurrencyCodeType.fromValue(order.getCurrency().getIsocode());

		for (final PaymentTransactionModel paymentTransactionModel : order.getPaymentTransactions())
		{
			for (final PaymentTransactionEntryModel paymentTransactionEntryModel : paymentTransactionModel.getEntries())
			{
				if (PaymentTransactionType.AUTHORIZATION.equals(paymentTransactionEntryModel.getType()))
				{
					request.setAuthorizationID(paymentTransactionEntryModel.getRequestId());
				}
			}
		}

		if (StringUtils.isBlank(currencyCode.toString()))
		{
			throw new ConversionException("Missing required currency iso code value");
		}

		final BasicAmountType amount = createBasicAmountType(order.getTotalPrice().doubleValue(), currencyCode);
		request.setAmount(amount);

		// capture all amount at once
		request.setCompleteType(CompleteCodeType.COMPLETE);

		return request;
	}

	private PaymentTransactionEntryModel createTransactionEntry(final PaymentTransactionModel transaction,
			final PaymentTransactionType type, final TransactionStatus status, final TransactionStatusDetails statusDetails,
			final String requestId, final String currencyIsoCode, final String amount, final Date timeStamp)
	{
		final PaymentTransactionEntryModel paymentTransactionEntry = getModelService().create(PaymentTransactionEntryModel.class);

		paymentTransactionEntry.setPaymentTransaction(transaction);
		paymentTransactionEntry.setRequestId(requestId);
		paymentTransactionEntry.setType(type);
		paymentTransactionEntry.setTransactionStatus(status.name());
		paymentTransactionEntry.setTransactionStatusDetails(statusDetails.name());

		final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_reauthorization_stamp_" + System.currentTimeMillis();
		paymentTransactionEntry.setCode(code);

		final CurrencyModel currency = getCommonI18NService().getCurrency(currencyIsoCode);
		paymentTransactionEntry.setCurrency(currency);

		final BigDecimal transactionAmount = new BigDecimal(amount.replace(",", ""));
		paymentTransactionEntry.setAmount(transactionAmount);

		paymentTransactionEntry.setTime(timeStamp);

		return paymentTransactionEntry;
	}

	protected BasicAmountType createBasicAmountType(final double amount, final CurrencyCodeType currencyCode)
	{
		final BasicAmountType basicAmount = new BasicAmountType();
		basicAmount.setValue(PaypalStringUtils.formatNumber(amount));
		basicAmount.setCurrencyID(currencyCode);
		return basicAmount;
	}

	public OrderCompleteProcessService getOrderCompleteProcessService()
	{
		return orderCompleteProcessService;
	}

	public void setOrderCompleteProcessService(final OrderCompleteProcessService orderCompleteProcessService)
	{
		this.orderCompleteProcessService = orderCompleteProcessService;
	}

	/**
	 * @return the configurationService
	 */
	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	/**
	 * @param configurationService
	 *           the configurationService to set
	 */
	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	/**
	 * @return the paypalPaymentIntegrationService
	 */
	public PaypalPaymentIntegrationService getPaypalPaymentIntegrationService()
	{
		return paypalPaymentIntegrationService;
	}

	/**
	 * @param paypalPaymentIntegrationService
	 *           the paypalPaymentIntegrationService to set
	 */
	public void setPaypalPaymentIntegrationService(final PaypalPaymentIntegrationService paypalPaymentIntegrationService)
	{
		this.paypalPaymentIntegrationService = paypalPaymentIntegrationService;
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	@Override
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	/**
	 * @param commonI18NService
	 *           the commonI18NService to set
	 */
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}


}
