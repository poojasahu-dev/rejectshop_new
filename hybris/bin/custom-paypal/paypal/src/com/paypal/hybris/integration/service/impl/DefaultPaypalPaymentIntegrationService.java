package com.paypal.hybris.integration.service.impl;

import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.log4j.Logger;

import com.paypal.core.Constants;
import com.paypal.core.credential.CertificateCredential;
import com.paypal.core.credential.ICredential;
import com.paypal.core.credential.SignatureCredential;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoAuthorizationRequestData;
import com.paypal.hybris.data.DoAuthorizationResultData;
import com.paypal.hybris.data.DoCaptureRequestData;
import com.paypal.hybris.data.DoCaptureResultData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentRequestData;
import com.paypal.hybris.data.DoExpressCheckoutPaymentResultData;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsRequestData;
import com.paypal.hybris.data.GetExpressCheckoutDetailsResultData;
import com.paypal.hybris.data.GetTransactionDetailsRequestData;
import com.paypal.hybris.data.GetTransactionDetailsResultData;
import com.paypal.hybris.data.RefundTransactionRequestData;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;

import urn.ebay.api.PayPalAPI.DoAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoAuthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoCaptureReq;
import urn.ebay.api.PayPalAPI.DoCaptureRequestType;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoReauthorizationReq;
import urn.ebay.api.PayPalAPI.DoReauthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionReq;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionRequestType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.api.PayPalAPI.DoVoidReq;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsReq;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.RefundTransactionReq;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.api.PayPalAPI.RefundTransactionResponseType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.apis.eBLBaseComponents.AbstractResponseType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.RefundType;
import urn.ebay.apis.eBLBaseComponents.SeverityCodeType;


public class DefaultPaypalPaymentIntegrationService implements PaypalPaymentIntegrationService
{
	private final static Logger LOG = Logger.getLogger(DefaultPaypalPaymentIntegrationService.class);

	private static final String ISO_8601_FORMATTER = "yyyy-MM-dd'T'HH:mm:ssX";

	private ConfigurationService configurationService;
	private Converter<SetExpressCheckoutRequestData, SetExpressCheckoutRequestType> setExprCheckoutReqDataConverter;
	private Converter<SetExpressCheckoutResponseType, SetExpressCheckoutResultData> setExprCheckoutResConverter;
	private Converter<GetExpressCheckoutDetailsRequestData, GetExpressCheckoutDetailsRequestType> getExprCheckoutDetReqDataConverter;
	private Converter<GetExpressCheckoutDetailsResponseType, GetExpressCheckoutDetailsResultData> getExprCheckoutDetResConverter;
	private Converter<DoExpressCheckoutPaymentRequestData, DoExpressCheckoutPaymentRequestType> doExprCheckoutPaymentReqDataConverter;
	private Converter<DoExpressCheckoutPaymentResponseType, DoExpressCheckoutPaymentResultData> doExprCheckoutPaymentResConverter;
	private Converter<DoAuthorizationRequestData, DoAuthorizationRequestType> doAuthorizationReqDataConverter;
	private Converter<DoAuthorizationResponseType, DoAuthorizationResultData> doAuthorizationResConverter;
	private Converter<DoCaptureRequestData, DoCaptureRequestType> doCaptureReqDataConverter;
	private Converter<DoCaptureResponseType, DoCaptureResultData> doCaptureResConverter;
	private Converter<DoReferenceTransactionRequestData, DoReferenceTransactionRequestType> doRefTransactionReqDataConverter;
	private Converter<DoReferenceTransactionResponseType, DoReferenceTransactionResultData> doRefTransactionResConverter;
	private Converter<GetTransactionDetailsRequestData, GetTransactionDetailsRequestType> getTransactionDetailsReqDataConverter;
	private Converter<GetTransactionDetailsResponseType, GetTransactionDetailsResultData> getTransactionDetailsResConverter;
	private Converter<RefundTransactionRequestData, RefundTransactionRequestType> refundTransReqDataConverter;
	private Converter<RefundTransactionResponseType, RefundTransactionResultData> refundTransResConverter;



	@Override
	public SetExpressCheckoutResultData setExpressCheckout(final SetExpressCheckoutRequestData requestData)
	{
		final SetExpressCheckoutRequestType request = setExprCheckoutReqDataConverter.convert(requestData);

		final SetExpressCheckoutResponseType response = setExpressCheckout(request);

		final List<PaymentDetailsType> paymentDetails = request.getSetExpressCheckoutRequestDetails().getPaymentDetails();

		final SetExpressCheckoutResultData resultData = setExprCheckoutResConverter.convert(response);

		final String paymentAction = CollectionUtils.isNotEmpty(paymentDetails)
				? paymentDetails.iterator().next().getPaymentAction().getValue()
				: configurationService.getConfiguration().getString(PaypalConstants.DEFAULT_PAYMENT_ACTION_NAME);

		resultData.setPaymentAction(paymentAction);

		return resultData;
	}

	private SetExpressCheckoutResponseType setExpressCheckout(final SetExpressCheckoutRequestType request)
	{
		SetExpressCheckoutResponseType response;
		try
		{
			final SetExpressCheckoutReq req = new SetExpressCheckoutReq();
			req.setSetExpressCheckoutRequest(request);
			response = getPayPalAPIService().setExpressCheckout(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'setExpressCheckout' web service call: " + e.getMessage(), e);
			response = new SetExpressCheckoutResponseType();
			addGeneralErrorInfo(response);
		}

		return response;
	}


	@Override
	public GetExpressCheckoutDetailsResultData getExpressCheckoutDetails(final GetExpressCheckoutDetailsRequestData requestData)
	{
		final GetExpressCheckoutDetailsRequestType request = getExprCheckoutDetReqDataConverter.convert(requestData);

		final GetExpressCheckoutDetailsResponseType response = getExpressCheckoutDetails(request);

		LOG.info("convert with: " + getExprCheckoutDetResConverter);
		return getExprCheckoutDetResConverter.convert(response);
	}

	private GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails(final GetExpressCheckoutDetailsRequestType request)
	{
		GetExpressCheckoutDetailsResponseType response;
		try
		{
			final GetExpressCheckoutDetailsReq req = new GetExpressCheckoutDetailsReq();
			req.setGetExpressCheckoutDetailsRequest(request);
			response = getPayPalAPIService().getExpressCheckoutDetails(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'getExpressCheckoutDetails' web service call: " + e.getMessage(), e);
			response = new GetExpressCheckoutDetailsResponseType();
			addGeneralErrorInfo(response);
		}

		return response;
	}

	@Override
	public DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(final DoExpressCheckoutPaymentRequestData requestData)
	{
		final DoExpressCheckoutPaymentRequestType request = doExprCheckoutPaymentReqDataConverter.convert(requestData);
		final DoExpressCheckoutPaymentResponseType response = doExpressCheckoutPayment(request);

		return doExprCheckoutPaymentResConverter.convert(response);
	}

	private DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment(final DoExpressCheckoutPaymentRequestType request)
	{
		DoExpressCheckoutPaymentResponseType response;
		try
		{
			final DoExpressCheckoutPaymentReq req = new DoExpressCheckoutPaymentReq();
			req.setDoExpressCheckoutPaymentRequest(request);
			response = getPayPalAPIService().doExpressCheckoutPayment(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'getExpressCheckoutDetails' web service call: " + e.getMessage(), e);
			response = new DoExpressCheckoutPaymentResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	@Override
	public DoAuthorizationResultData doAuthorization(final DoAuthorizationRequestData requestData)
	{
		final DoAuthorizationRequestType request = doAuthorizationReqDataConverter.convert(requestData);
		final DoAuthorizationResponseType response = doAuthorization(request);

		return doAuthorizationResConverter.convert(response);
	}

	private DoAuthorizationResponseType doAuthorization(final DoAuthorizationRequestType request)
	{
		DoAuthorizationResponseType response;
		try
		{
			final DoAuthorizationReq req = new DoAuthorizationReq();
			req.setDoAuthorizationRequest(request);
			response = getPayPalAPIService().doAuthorization(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'doAuthorization' web service call: " + e.getMessage(), e);
			response = new DoAuthorizationResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	@Override
	public DoCaptureResultData doCapture(final DoCaptureRequestData requestData)
	{
		final DoCaptureRequestType request = doCaptureReqDataConverter.convert(requestData);
		final DoCaptureResponseType response = doCapture(request);

		return doCaptureResConverter.convert(response);
	}

	@Override
	public DoCaptureResponseType doCapture(final DoCaptureRequestType request)
	{
		DoCaptureResponseType response;
		try
		{
			final DoCaptureReq req = new DoCaptureReq();
			req.setDoCaptureRequest(request);
			response = getPayPalAPIService().doCapture(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'doCapture' web service call: " + e.getMessage(), e);
			response = new DoCaptureResponseType();
			addGeneralErrorInfo(response);
		}

		return response;
	}

	@Override
	public DoReferenceTransactionResultData doReferenceTransaction(final DoReferenceTransactionRequestData requestData)
	{
		final DoReferenceTransactionRequestType request = doRefTransactionReqDataConverter.convert(requestData);
		final DoReferenceTransactionResponseType response = doReferenceTransaction(request);

		return doRefTransactionResConverter.convert(response);
	}

	private DoReferenceTransactionResponseType doReferenceTransaction(final DoReferenceTransactionRequestType request)
	{
		LOG.debug("Initiate payment with reference transaction");
		DoReferenceTransactionResponseType response = null;

		try
		{
			final DoReferenceTransactionReq req = new DoReferenceTransactionReq();
			req.setDoReferenceTransactionRequest(request);
			response = getPayPalAPIService().doReferenceTransaction(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'doReferenceTransaction' web service call: " + e.getMessage(), e);
			response = new DoReferenceTransactionResponseType();
			addGeneralErrorInfo(response);
		}

		return response;
	}

	@Override
	public GetTransactionDetailsResultData getTransactionDetails(final GetTransactionDetailsRequestData requestData)
	{
		final GetTransactionDetailsRequestType request = getTransactionDetailsReqDataConverter.convert(requestData);
		final GetTransactionDetailsResponseType responseType = getTransactionDetails(request);

		return getTransactionDetailsResConverter.convert(responseType);
	}

	private GetTransactionDetailsResponseType getTransactionDetails(final GetTransactionDetailsRequestType request)
	{
		GetTransactionDetailsResponseType response = null;
		try
		{
			final GetTransactionDetailsReq req = new GetTransactionDetailsReq();
			req.setGetTransactionDetailsRequest(request);
			response = getPayPalAPIService().getTransactionDetails(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'getTransactionDetails' web service call: " + e.getMessage(), e);
			response = new GetTransactionDetailsResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	@Override
	public RefundTransactionResultData refundTransaction(final RefundTransactionRequestData requestData)
	{
	    LOG.info("refundTransaction, requestData: " + requestData);

		final RefundTransactionRequestType request = refundTransReqDataConverter.convert(requestData);
		final RefundTransactionResponseType response = refundTransaction(request);

		return refundTransResConverter.convert(response);
	}

    private PayPalAPIInterfaceServiceService getPayPalAPIService() {
        final String envProfile = getConfigurationService().getConfiguration().getString(PaypalConstants.PAYPAL_ENV_PROFILE);

        final String serverUrl = getConfigurationService().getConfiguration().getString(PaypalConstants.PP_PREFIX + envProfile + PaypalConstants.SETT_ENDPOINT);
        LOG.info("serverUrl: " + serverUrl);
        final Map<String, String> configurationMap = new HashMap<String, String>();
        configurationMap.put(Constants.ENDPOINT, serverUrl);

        final PayPalAPIInterfaceServiceService payPalAPIService = new PayPalAPIInterfaceServiceService(configurationMap);

        return payPalAPIService;
    }

	protected boolean shouldUseSsl()
	{
		return getConfigurationService().getConfiguration().getBoolean(PaypalConstants.USE_CERTIFICATE, Boolean.FALSE)
				.booleanValue();
	}

	@Override
	public DoReauthorizationResponseType doReauthorization(final DoReauthorizationRequestType request)
	{
		DoReauthorizationResponseType response = null;
		try
		{
			final DoReauthorizationReq req = new DoReauthorizationReq();
			req.setDoReauthorizationRequest(request);
			response = getPayPalAPIService().doReauthorization(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'doReauthorization' web service call: " + e.getMessage(), e);
			response = new DoReauthorizationResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	/**
	 * @see com.paypal.hybris.integration.service.PaypalPaymentIntegrationService#transactionSearch(TransactionSearchRequestType)
	 */
	@Override
	public TransactionSearchResponseType transactionSearch(final TransactionSearchRequestType request)
	{
		TransactionSearchResponseType response = null;
		try
		{
			final TransactionSearchReq req = new TransactionSearchReq();
			req.setTransactionSearchRequest(request);
			response = getPayPalAPIService().transactionSearch(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'transactionSearch' web service call: " + e.getMessage(), e);
			response = new TransactionSearchResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	@Override
	public DoVoidResponseType doVoid(final DoVoidRequestType request)
	{
		DoVoidResponseType response = null;
		try
		{
			final DoVoidReq req = new DoVoidReq();
			req.setDoVoidRequest(request);
			response = getPayPalAPIService().doVoid(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'doVoid' web service call: " + e.getMessage(), e);
			response = new DoVoidResponseType();
			addGeneralErrorInfo(response);
		}
		return response;
	}

	@Override
	public RefundTransactionResultData doPartialRefund(final RefundTransactionRequestType request)
	{
		request.setRefundType(RefundType.PARTIAL);
		final RefundTransactionResponseType response = refundTransaction(request);
		return refundTransResConverter.convert(response);
	}

	private RefundTransactionResponseType refundTransaction(final RefundTransactionRequestType request)
	{
		RefundTransactionResponseType response;
		try
		{
			final RefundTransactionReq req = new RefundTransactionReq();
			req.setRefundTransactionRequest(request);
			response = getPayPalAPIService().refundTransaction(req, getCredentials());
		}
		catch (final Exception e)
		{
			LOG.error("Error during 'refundTransaction' web service call: " + e.getMessage(), e);
			response = new RefundTransactionResponseType();
			addGeneralErrorInfo(response);
		}

		return response;
	}

	private ICredential getCredentials()
	{
		final Configuration configuration = getConfigurationService().getConfiguration();

		ICredential credentials = new SignatureCredential(configuration.getString(PaypalConstants.SETT_USERNAME),
				configuration.getString(PaypalConstants.SETT_PASSWORD), configuration.getString(PaypalConstants.SETT_SIGNATURE));

		if (shouldUseSsl())
		{
			credentials = new CertificateCredential(configuration.getString(PaypalConstants.SETT_USERNAME),
					configuration.getString(PaypalConstants.SETT_PASSWORD),
					configuration.getString(PaypalConstants.CERTIFICATE_FILENAME),
					configuration.getString(PaypalConstants.CERTIFICATE_PASSWORD));
		}

		return credentials;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}

	private void addGeneralErrorInfo(final AbstractResponseType response)
	{
        String currentTimestamp = new SimpleDateFormat(ISO_8601_FORMATTER).format(new Date());

		final ErrorType generalError = new ErrorType();
		generalError.setErrorCode("00000");
		generalError.setSeverityCode(SeverityCodeType.ERROR);
		generalError.setShortMessage("Error during service method call");
		generalError.setLongMessage("Error during communication with service");
		response.getErrors().add(generalError);
		response.setTimestamp(currentTimestamp);
		response.setAck(AckCodeType.FAILURE);
	}

	/**
	 * @return the setExprCheckoutReqDataConverter
	 */
	public Converter<SetExpressCheckoutRequestData, SetExpressCheckoutRequestType> getSetExprCheckoutReqDataConverter()
	{
		return setExprCheckoutReqDataConverter;
	}

	/**
	 * @param setExprCheckoutReqDataConverter
	 *           the setExprCheckoutReqDataConverter to set
	 */
	public void setSetExprCheckoutReqDataConverter(
			final Converter<SetExpressCheckoutRequestData, SetExpressCheckoutRequestType> setExprCheckoutReqDataConverter)
	{
		this.setExprCheckoutReqDataConverter = setExprCheckoutReqDataConverter;
	}

	/**
	 * @return the setExprCheckoutResConverter
	 */
	public Converter<SetExpressCheckoutResponseType, SetExpressCheckoutResultData> getSetExprCheckoutResConverter()
	{
		return setExprCheckoutResConverter;
	}

	/**
	 * @param setExprCheckoutResConverter
	 *           the setExprCheckoutResConverter to set
	 */
	public void setSetExprCheckoutResConverter(
			final Converter<SetExpressCheckoutResponseType, SetExpressCheckoutResultData> setExprCheckoutResConverter)
	{
		this.setExprCheckoutResConverter = setExprCheckoutResConverter;
	}

	/**
	 * @return the getExprCheckoutDetReqDataConverter
	 */
	public Converter<GetExpressCheckoutDetailsRequestData, GetExpressCheckoutDetailsRequestType> getGetExprCheckoutDetReqDataConverter()
	{
		return getExprCheckoutDetReqDataConverter;
	}

	/**
	 * @param getExprCheckoutDetReqDataConverter
	 *           the getExprCheckoutDetReqDataConverter to set
	 */
	public void setGetExprCheckoutDetReqDataConverter(
			final Converter<GetExpressCheckoutDetailsRequestData, GetExpressCheckoutDetailsRequestType> getExprCheckoutDetReqDataConverter)
	{
		this.getExprCheckoutDetReqDataConverter = getExprCheckoutDetReqDataConverter;
	}

	/**
	 * @return the getExprCheckoutDetResConverter
	 */
	public Converter<GetExpressCheckoutDetailsResponseType, GetExpressCheckoutDetailsResultData> getGetExprCheckoutDetResConverter()
	{
		return getExprCheckoutDetResConverter;
	}

	/**
	 * @param getExprCheckoutDetResConverter
	 *           the getExprCheckoutDetResConverter to set
	 */
	public void setGetExprCheckoutDetResConverter(
			final Converter<GetExpressCheckoutDetailsResponseType, GetExpressCheckoutDetailsResultData> getExprCheckoutDetResConverter)
	{
		this.getExprCheckoutDetResConverter = getExprCheckoutDetResConverter;
	}

	/**
	 * @return the doExprCheckoutPaymentReqDataConverter
	 */
	public Converter<DoExpressCheckoutPaymentRequestData, DoExpressCheckoutPaymentRequestType> getDoExprCheckoutPaymentReqDataConverter()
	{
		return doExprCheckoutPaymentReqDataConverter;
	}

	/**
	 * @param doExprCheckoutPaymentReqDataConverter
	 *           the doExprCheckoutPaymentReqDataConverter to set
	 */
	public void setDoExprCheckoutPaymentReqDataConverter(
			final Converter<DoExpressCheckoutPaymentRequestData, DoExpressCheckoutPaymentRequestType> doExprCheckoutPaymentReqDataConverter)
	{
		this.doExprCheckoutPaymentReqDataConverter = doExprCheckoutPaymentReqDataConverter;
	}

	/**
	 * @return the doExprCheckoutPaymentResConverter
	 */
	public Converter<DoExpressCheckoutPaymentResponseType, DoExpressCheckoutPaymentResultData> getDoExprCheckoutPaymentResConverter()
	{
		return doExprCheckoutPaymentResConverter;
	}

	/**
	 * @param doExprCheckoutPaymentResConverter
	 *           the doExprCheckoutPaymentResConverter to set
	 */
	public void setDoExprCheckoutPaymentResConverter(
			final Converter<DoExpressCheckoutPaymentResponseType, DoExpressCheckoutPaymentResultData> doExprCheckoutPaymentResConverter)
	{
		this.doExprCheckoutPaymentResConverter = doExprCheckoutPaymentResConverter;
	}

	/**
	 * @return the doAuthorizationReqDataConverter
	 */
	public Converter<DoAuthorizationRequestData, DoAuthorizationRequestType> getDoAuthorizationReqDataConverter()
	{
		return doAuthorizationReqDataConverter;
	}

	/**
	 * @param doAuthorizationReqDataConverter
	 *           the doAuthorizationReqDataConverter to set
	 */
	public void setDoAuthorizationReqDataConverter(
			final Converter<DoAuthorizationRequestData, DoAuthorizationRequestType> doAuthorizationReqDataConverter)
	{
		this.doAuthorizationReqDataConverter = doAuthorizationReqDataConverter;
	}

	/**
	 * @return the doAuthorizationResConverter
	 */
	public Converter<DoAuthorizationResponseType, DoAuthorizationResultData> getDoAuthorizationResConverter()
	{
		return doAuthorizationResConverter;
	}

	/**
	 * @param doAuthorizationResConverter
	 *           the doAuthorizationResConverter to set
	 */
	public void setDoAuthorizationResConverter(
			final Converter<DoAuthorizationResponseType, DoAuthorizationResultData> doAuthorizationResConverter)
	{
		this.doAuthorizationResConverter = doAuthorizationResConverter;
	}

	/**
	 * @return the doCaptureReqDataConverter
	 */
	public Converter<DoCaptureRequestData, DoCaptureRequestType> getDoCaptureReqDataConverter()
	{
		return doCaptureReqDataConverter;
	}

	/**
	 * @param doCaptureReqDataConverter
	 *           the doCaptureReqDataConverter to set
	 */
	public void setDoCaptureReqDataConverter(final Converter<DoCaptureRequestData, DoCaptureRequestType> doCaptureReqDataConverter)
	{
		this.doCaptureReqDataConverter = doCaptureReqDataConverter;
	}

	/**
	 * @return the doCaptureResConverter
	 */
	public Converter<DoCaptureResponseType, DoCaptureResultData> getDoCaptureResConverter()
	{
		return doCaptureResConverter;
	}

	/**
	 * @param doCaptureResConverter
	 *           the doCaptureResConverter to set
	 */
	public void setDoCaptureResConverter(final Converter<DoCaptureResponseType, DoCaptureResultData> doCaptureResConverter)
	{
		this.doCaptureResConverter = doCaptureResConverter;
	}

	/**
	 * @return the doRefTransactionReqDataConverter
	 */
	public Converter<DoReferenceTransactionRequestData, DoReferenceTransactionRequestType> getDoRefTransactionReqDataConverter()
	{
		return doRefTransactionReqDataConverter;
	}

	/**
	 * @param doRefTransactionReqDataConverter
	 *           the doRefTransactionReqDataConverter to set
	 */
	public void setDoRefTransactionReqDataConverter(
			final Converter<DoReferenceTransactionRequestData, DoReferenceTransactionRequestType> doRefTransactionReqDataConverter)
	{
		this.doRefTransactionReqDataConverter = doRefTransactionReqDataConverter;
	}

	/**
	 * @return the doRefTransactionResConverter
	 */
	public Converter<DoReferenceTransactionResponseType, DoReferenceTransactionResultData> getDoRefTransactionResConverter()
	{
		return doRefTransactionResConverter;
	}

	/**
	 * @param doRefTransactionResConverter
	 *           the doRefTransactionResConverter to set
	 */
	public void setDoRefTransactionResConverter(
			final Converter<DoReferenceTransactionResponseType, DoReferenceTransactionResultData> doRefTransactionResConverter)
	{
		this.doRefTransactionResConverter = doRefTransactionResConverter;
	}

	/**
	 * @return the getTransactionDetailsReqDataConverter
	 */
	public Converter<GetTransactionDetailsRequestData, GetTransactionDetailsRequestType> getGetTransactionDetailsReqDataConverter()
	{
		return getTransactionDetailsReqDataConverter;
	}

	/**
	 * @param getTransactionDetailsReqDataConverter
	 *           the getTransactionDetailsReqDataConverter to set
	 */
	public void setGetTransactionDetailsReqDataConverter(
			final Converter<GetTransactionDetailsRequestData, GetTransactionDetailsRequestType> getTransactionDetailsReqDataConverter)
	{
		this.getTransactionDetailsReqDataConverter = getTransactionDetailsReqDataConverter;
	}

	/**
	 * @return the getTransactionDetailsResConverter
	 */
	public Converter<GetTransactionDetailsResponseType, GetTransactionDetailsResultData> getGetTransactionDetailsResConverter()
	{
		return getTransactionDetailsResConverter;
	}

	/**
	 * @param getTransactionDetailsResConverter
	 *           the getTransactionDetailsResConverter to set
	 */
	public void setGetTransactionDetailsResConverter(
			final Converter<GetTransactionDetailsResponseType, GetTransactionDetailsResultData> getTransactionDetailsResConverter)
	{
		this.getTransactionDetailsResConverter = getTransactionDetailsResConverter;
	}

	/**
	 * @return the refundTransReqDataConverter
	 */
	public Converter<RefundTransactionRequestData, RefundTransactionRequestType> getRefundTransReqDataConverter()
	{
		return refundTransReqDataConverter;
	}

	/**
	 * @param refundTransReqDataConverter
	 *           the refundTransReqDataConverter to set
	 */
	public void setRefundTransReqDataConverter(
			final Converter<RefundTransactionRequestData, RefundTransactionRequestType> refundTransReqDataConverter)
	{
		this.refundTransReqDataConverter = refundTransReqDataConverter;
	}

	/**
	 * @return the refundTransResConverter
	 */
	public Converter<RefundTransactionResponseType, RefundTransactionResultData> getRefundTransResConverter()
	{
		return refundTransResConverter;
	}

	/**
	 * @param refundTransResConverter
	 *           the refundTransResConverter to set
	 */
	public void setRefundTransResConverter(
			final Converter<RefundTransactionResponseType, RefundTransactionResultData> refundTransResConverter)
	{
		this.refundTransResConverter = refundTransResConverter;
	}
}
