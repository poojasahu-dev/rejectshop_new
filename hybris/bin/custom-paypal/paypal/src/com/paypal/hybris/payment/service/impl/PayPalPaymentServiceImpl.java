package com.paypal.hybris.payment.service.impl;

import static org.apache.commons.lang.BooleanUtils.isTrue;

import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commerceservices.enums.CustomerType;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.core.model.order.payment.PaymentModeModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.order.CalculationService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.order.PaymentModeService;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.dto.TransactionStatusDetails;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.impl.DefaultPaymentServiceImpl;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.BusinessProcessEvent;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.processengine.model.ProcessTaskModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ebay.utils.PaypalStringUtils;
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
import com.paypal.hybris.data.PaymentInfoData;
import com.paypal.hybris.data.RefundTransactionRequestData;
import com.paypal.hybris.data.RefundTransactionResultData;
import com.paypal.hybris.data.SetExpressCheckoutRequestData;
import com.paypal.hybris.data.SetExpressCheckoutResultData;
import com.paypal.hybris.enums.PaymentActionType;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.payment.service.PayPalPaymentService;
import com.paypal.hybris.transaction.strategy.PayPalCreateTransactionStrategy;

import urn.ebay.api.PayPalAPI.DoReauthorizationRequestType;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoVoidRequestType;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.RefundTransactionRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;


public class PayPalPaymentServiceImpl extends DefaultPaymentServiceImpl implements PayPalPaymentService
{
    private static final Logger LOG = Logger.getLogger(PayPalPaymentServiceImpl.class);

	private static final String TRANSACTION_STATUS_VOIDED = "CANCELED";
	private static final String CHOICE_ORDER_CANCELED = "ORDER_CANCELED";

	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private ConfigurationService configurationService;
	private FlexibleSearchService flexibleSearchService;
	private CartService cartService;
	private ModelService modelService;
	private PaymentModeService paymentModeService;
	private CalculationService calculationService;
	private UserService userService;
	private SessionService sessionService;
	private Converter<AddressData, AddressModel> addressReverseConverter;
	private Map<String, PayPalCreateTransactionStrategy> transactionStrategyMap;

	@Resource
	private BusinessProcessService businessProcessService;

	@Override
	public PaypalPaymentInfoModel getPayPalPaymentInfo()
	{
		final CartModel cartModel = getCart();

		final PaymentInfoModel infoModel = cartModel.getPaymentInfo();
		if (infoModel instanceof PaypalPaymentInfoModel)
		{
			return (PaypalPaymentInfoModel) infoModel;
		}
		return null;
	}

	@Override
	public boolean authorizePayment(final DoExpressCheckoutPaymentResultData doExprCheckPaymentResData)
	{
		final CartModel cartModel = getCart();

		final List<PaymentInfoData> paymentInfoList = doExprCheckPaymentResData.getPaymentInfoList();

		final List<PaymentTransactionModel> paymentTransactions = new ArrayList<>();

		for (final PaymentInfoData paymentInfoData : paymentInfoList)
		{
			final List<PaymentTransactionEntryModel> paymentTransactionEntries = new ArrayList<>();

			final String transactionId = paymentInfoData.getTransactionId();

			try
			{
				getPayPalCreateTransactionStrategy().createPaymentTransaction(paymentInfoData, paymentTransactionEntries);
			}
			catch (final Exception exception)
			{
				LOG.error("[ERROR] Can't create payment transaction entry due to error " + exception.getMessage());
			}

			final PaymentTransactionModel paymentTransaction = getModelService().create(PaymentTransactionModel.class);
			paymentTransaction.setEntries(paymentTransactionEntries);
			paymentTransaction.setRequestId(transactionId);
			paymentTransaction.setRequestToken(((PaypalPaymentInfoModel) cartModel.getPaymentInfo()).getToken());
			paymentTransaction.setPaymentProvider(PaypalConstants.PAYMENT_PROVIDER_NAME);

			paymentTransactions.add(paymentTransaction);
		}

		cartModel.setPaymentTransactions(paymentTransactions);

		final PaymentModeModel paymentMode = paymentModeService.getPaymentModeForCode(PaypalConstants.PAY_PAL_DELIVERY_MODE);

		cartModel.setPaymentMode(paymentMode);
		final PaypalPaymentInfoModel paymentInfo = (PaypalPaymentInfoModel) cartModel.getPaymentInfo();
		final String billingAgreementID = doExprCheckPaymentResData.getBillingAgreementID();
		paymentInfo.setBillingAgreementID(billingAgreementID);

		getModelService().saveAll(paymentInfo, cartModel);

		try
		{
			calculationService.calculateTotals(cartModel, true);
		}
		catch (final CalculationException exception)
		{
			LOG.error("[ERROR] Exception during order recalculation: ", exception);
			throw new IllegalArgumentException("[ERROR] Can't recalculate order!");
		}

		return PaypalConstants.STATUS_SUCCESS.equals(doExprCheckPaymentResData.getAck());
	}

	@Override
	public SetExpressCheckoutResultData setExpressCheckout(final SetExpressCheckoutRequestData requestData)
	{
	    LOG.info("setExpressCheckout requestData: " + requestData);
		final SetExpressCheckoutResultData resultData = paypalPaymentIntegrationService.setExpressCheckout(requestData);

		if (PaypalConstants.STATUS_SUCCESS.equalsIgnoreCase(resultData.getAck()))
		{
			final PaypalPaymentInfoModel paymentInfo = modelService.create(PaypalPaymentInfoModel.class);
			final UserModel user = getUserService().getCurrentUser();
			paymentInfo.setToken(resultData.getToken());
			paymentInfo.setUser(user);
			paymentInfo.setPaymentAction(PaymentActionType.valueOf(resultData.getPaymentAction().toUpperCase()));

			paymentInfo.setUseReferenceTransaction(isPayPalReplenishmentFlow() ? Boolean.TRUE : Boolean.FALSE);

			final Boolean isCredit = sessionService.getAttribute(PaypalConstants.IS_PAYPAL_CREDIT);

			if (isTrue(isCredit))
			{
				paymentInfo.setCode(PaypalConstants.PAYPAL_CREDIT_PAYMENT_INFO_CODE);
			}
			else
			{
				paymentInfo.setCode(PaypalConstants.PAYPAL_PAYMENT_INFO_CODE);
			}

			modelService.save(paymentInfo);

			final CartModel cart = cartService.getSessionCart();
			cart.setPaymentInfo(paymentInfo);
			modelService.save(cart);
		}

		return resultData;
	}


	@Override
	public GetExpressCheckoutDetailsResultData getExpressCheckoutDetails()
	{
		GetExpressCheckoutDetailsResultData resultData = new GetExpressCheckoutDetailsResultData();

		final CartModel cart = getCart();
		final PaypalPaymentInfoModel paymentInfo = getPayPalPaymentInfo();

		final GetExpressCheckoutDetailsRequestData requestData = new GetExpressCheckoutDetailsRequestData();
		requestData.setToken(paymentInfo.getToken());

        if (cart != null && cart.getDeliveryAddress() != null && cart.getDeliveryAddress().getPostalcode() != null) {
            LOG.info("cart has Delivery to: " + cart.getDeliveryAddress().getStreetnumber() +
                    ", " + cart.getDeliveryAddress().getStreetname() +
                    ", " + cart.getDeliveryAddress().getPostalcode());
        } else {
            LOG.info("cart: " + cart);
        }

		LOG.info("getExpressCheckoutDetails requestData: " + requestData);
		resultData = paypalPaymentIntegrationService.getExpressCheckoutDetails(requestData);

		LOG.info("from response Delivery to: " + resultData.getDeliveryAddress().getFormattedAddress());

		if (PaypalConstants.STATUS_SUCCESS.equalsIgnoreCase(resultData.getAck()))
		{
			savePaymentInfoWithResponseData(resultData, paymentInfo, cart);
		}

		return resultData;
	}

	@Override
	public PaymentTransactionEntryModel getPaymentTransactionEntryByRequestID(final String requestId) {
		final String query = "SELECT {PK} FROM {PaymentTransactionEntry} WHERE {RequestId} = '" + requestId + "' AND {VersionID} IS NULL";
		LOG.info("query: " + query);

		final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);

		final SearchResult<PaymentTransactionEntryModel> result = flexibleSearchService.search(flexibleSearchQuery);
		LOG.info("result.getResult.size: " + result.getResult().size());

		if (result.getResult().isEmpty()) {
		    return null;
		}

		return result.getResult().iterator().next();
	}


	private void savePaymentInfoWithResponseData(final GetExpressCheckoutDetailsResultData resultData,
			final PaypalPaymentInfoModel paymentInfo, final CartModel cart)
	{
		paymentInfo.setPayerId(resultData.getPayerId());
		paymentInfo.setPayer(resultData.getPayer());
		paymentInfo.setFinancingFeeAmount(resultData.getFinancingFeeAmount());
		paymentInfo.setFinancingChangeTolerance(resultData.getFinancingChangeTolerance());
		paymentInfo.setFinancingTotalCost(resultData.getFinancingTotalCost());
		paymentInfo.setFinancingTerm(resultData.getFinancingTerm());
		paymentInfo.setFinancingMonthlyPayment(resultData.getFinancingMonthlyPayment());
		paymentInfo.setFinancingCurrencyCode(resultData.getFinancingCurrencyCode());
		paymentInfo.setIsFinancing(Boolean.valueOf(resultData.isIsFinancing()));

		final Boolean billingAddressRequired = isBillingAddressRequired();
		paymentInfo.setIsBillingAddressRequired(billingAddressRequired);

		final AddressModel billingAddress = createBillingAddress(resultData, cart);
		billingAddress.setOwner(paymentInfo);
		paymentInfo.setBillingAddress(billingAddress);

		modelService.saveAll(billingAddress, paymentInfo, cart);
	}

	private AddressModel createBillingAddress(final GetExpressCheckoutDetailsResultData resultData, final CartModel cart)
	{
		AddressModel billingAddress = modelService.create(AddressModel.class);
		if (resultData.getBillingAddress() != null && isBillingAddressRequired())
		{
			billingAddress = addressReverseConverter.convert(resultData.getBillingAddress(), billingAddress);
		}
		final UserModel user = cart.getUser();
		if (user instanceof CustomerModel && ((CustomerModel) user).getType() == CustomerType.GUEST)
		{
			billingAddress.setEmail(user.getUid().substring(user.getUid().indexOf("|") + 1));
		}
		else
		{
			billingAddress.setEmail(resultData.getPayer());
		}

		return billingAddress;
	}

	private boolean isBillingAddressRequired()
	{
		if (Boolean.TRUE.toString()
				.equalsIgnoreCase(getConfigurationService().getConfiguration().getString(PaypalConstants.REQUIRE_BILLING_ADDRESS)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public DoExpressCheckoutPaymentResultData doExpressCheckoutPayment(final DoExpressCheckoutPaymentRequestData request)
	{
	    LOG.info("doExpressCheckoutPayment request: " + request);
		return paypalPaymentIntegrationService.doExpressCheckoutPayment(request);
	}


	@Override
	public DoAuthorizationResultData doAuthorization(final DoAuthorizationRequestData request)
	{
		return paypalPaymentIntegrationService.doAuthorization(request);
	}


	@Override
	public DoCaptureResultData doCapture(final DoCaptureRequestData request)
	{
		return paypalPaymentIntegrationService.doCapture(request);
	}


	@Override
	public TransactionSearchResponseType transactionSearch(final TransactionSearchRequestType request)
	{
		return paypalPaymentIntegrationService.transactionSearch(request);
	}


	@Override
	public DoReferenceTransactionResultData doReferenceTransaction(final DoReferenceTransactionRequestData request)
	{
		return paypalPaymentIntegrationService.doReferenceTransaction(request);
	}


	@Override
	public RefundTransactionResultData refundTransaction(final RefundTransactionRequestData request)
	{
		return paypalPaymentIntegrationService.refundTransaction(request);
	}


	@Override
	public DoReauthorizationResponseType doReauthorization(final DoReauthorizationRequestType request)
	{
		return paypalPaymentIntegrationService.doReauthorization(request);
	}


	@Override
	public GetTransactionDetailsResultData getTransactionDetails(final GetTransactionDetailsRequestData request)
	{
		return paypalPaymentIntegrationService.getTransactionDetails(request);
	}

	@Override
	public DoVoidResponseType doVoid(final DoVoidRequestType request, final OrderModel order)
	{
		DoVoidResponseType response = paypalPaymentIntegrationService.doVoid(request);

		final PaymentTransactionModel paymentTransactionModel = order.getPaymentTransactions().get(0);

		PaymentTransactionEntryModel firstTransaction = paymentTransactionModel.getEntries().get(0);

		final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_void_stamp_" + System.currentTimeMillis();
		LOG.info("create Void-PaymentTransactionEntry with code: " + code);

		final PaymentTransactionEntryModel entry = getModelService().create(PaymentTransactionEntryModel.class);
		entry.setPaymentTransaction(paymentTransactionModel);
        entry.setCode(code);
        entry.setTime(PaypalStringUtils.getDateFromResponse(response.getTimestamp()));
        entry.setType(PaymentTransactionType.VOID);

		if (response.getAck() == AckCodeType.SUCCESS) {
		    PaymentTransactionEntryModel voidedransactionEntryModel = getPaymentTransactionEntryByRequestID(request.getAuthorizationID());
            voidedransactionEntryModel.setTransactionStatus(TRANSACTION_STATUS_VOIDED);
            modelService.save(voidedransactionEntryModel);

            entry.setTransactionStatus(TransactionStatus.ACCEPTED.name());
            entry.setTransactionStatusDetails(TransactionStatusDetails.SUCCESFULL.name() + ", for RequestID: " + request.getAuthorizationID());

//            firstTransaction.getType().equals(PaymentTransactionType.ORDER)
            if (firstTransaction.getRequestId().equals(request.getAuthorizationID())) {
                LOG.info("Cancel Hybris order-process is necessary");

                for (OrderProcessModel opm : order.getOrderProcess()) {
                    for (ProcessTaskModel ptm : opm.getCurrentTasks()) {
                        if (PaypalConstants.ORDER_PROCESS_ACTION_WAITFORTAKEPAYMENT.equals(ptm.getAction())) {
                            String eventName = ptm.getProcess().getCode() + PaypalConstants.EVENT_CONTINUE_ORDER_WITH_CHOICE;

                            LOG.error("To cancel hybris order-process issuing event: " + eventName + "." + CHOICE_ORDER_CANCELED);
                            final BusinessProcessEvent event = BusinessProcessEvent.builder(eventName).withChoice(CHOICE_ORDER_CANCELED).build();
                            businessProcessService.triggerEvent(event);
                        }
                    }
                }
            }
        } else {
            entry.setTransactionStatus(TransactionStatus.ERROR.name());
            entry.setTransactionStatusDetails(TransactionStatusDetails.NOT_VOIDABLE + ", for RequestID: " + request.getAuthorizationID());
        }

		getModelService().saveAll(entry, paymentTransactionModel, order);
		getModelService().refresh(order);

		return response;
	}

	@Override
	public RefundTransactionResultData doPartialRefund(final RefundTransactionRequestType request)
	{
		return paypalPaymentIntegrationService.doPartialRefund(request);
	}

	private String getTransactionStrategy(final String paymentAction)
	{
		if (PaypalConstants.ORDER_PAYMENT_ACTION_NAME.equals(paymentAction))
		{
			return PaypalConstants.ORDER_PAYMENT_ACTION_NAME;
		}
		else if (getConfigurationService().getConfiguration().getString(PaypalConstants.PAYMENT_ACTION)
				.equals(PaypalConstants.AUTHORIZATION_PAYMENT_ACTION_NAME))
		{
			return PaypalConstants.AUTHORIZATION_PAYMENT_ACTION_NAME;
		}
		else if (PaypalConstants.SALE_PAYMENT_ACTION_NAME.equalsIgnoreCase(paymentAction))
		{
			return PaypalConstants.SALE_PAYMENT_ACTION_NAME;
		}
		LOG.error("[ERROR] Can't find payment action.. Using default.");
		return PaypalConstants.DEFAULT_PAYMENT_ACTION_NAME;
	}

	private PayPalCreateTransactionStrategy getPayPalCreateTransactionStrategy()
	{
		final String paymentAction = StringUtils.capitalize(getPayPalPaymentInfo().getPaymentAction().getCode().toLowerCase());
		LOG.info("Payment action is: " + paymentAction);
		return transactionStrategyMap.get(getTransactionStrategy(paymentAction));
	}

	private CartModel getCart()
	{
		final CartModel cart = cartService.getSessionCart();
		if (cart != null)
		{
			return cart;
		}
		throw new IllegalArgumentException("[ERROR] No checkout cart!");
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
	 * @return the cartService
	 */
	public CartService getCartService()
	{
		return cartService;
	}

	/**
	 * @param cartService
	 *           the cartService to set
	 */
	public void setCartService(final CartService cartService)
	{
		this.cartService = cartService;
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
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the paymentModeService
	 */
	public PaymentModeService getPaymentModeService()
	{
		return paymentModeService;
	}

	/**
	 * @param paymentModeService
	 *           the paymentModeService to set
	 */
	public void setPaymentModeService(final PaymentModeService paymentModeService)
	{
		this.paymentModeService = paymentModeService;
	}

	/**
	 * @return the calculationService
	 */
	public CalculationService getCalculationService()
	{
		return calculationService;
	}

	/**
	 * @param calculationService
	 *           the calculationService to set
	 */
	public void setCalculationService(final CalculationService calculationService)
	{
		this.calculationService = calculationService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * @param userService
	 *           the userService to set
	 */
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * @return the sessionService
	 */
	public SessionService getSessionService()
	{
		return sessionService;
	}

	/**
	 * @param sessionService
	 *           the sessionService to set
	 */
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	/**
	 * @return the addressReverseConverter
	 */
	public Converter<AddressData, AddressModel> getAddressReverseConverter()
	{
		return addressReverseConverter;
	}

	/**
	 * @param addressReverseConverter
	 *           the addressReverseConverter to set
	 */
	public void setAddressReverseConverter(final Converter<AddressData, AddressModel> addressReverseConverter)
	{
		this.addressReverseConverter = addressReverseConverter;
	}

	/**
	 * @return the transactionStrategyMap
	 */
	public Map<String, PayPalCreateTransactionStrategy> getTransactionStrategyMap()
	{
		return transactionStrategyMap;
	}

	/**
	 * @param transactionStrategyMap
	 *           the transactionStrategyMap to set
	 */
	public void setTransactionStrategyMap(final Map<String, PayPalCreateTransactionStrategy> transactionStrategyMap)
	{
		this.transactionStrategyMap = transactionStrategyMap;
	}

	private boolean isPayPalReplenishmentFlow() {
		return getSessionService().getAttribute(PaypalConstants.PAYPAL_FLOW).equals(PaypalConstants.REPLENISHMENT_FLOW);
	}

	public FlexibleSearchService getFlexibleSearchService() {
		return flexibleSearchService;
	}

	@Override
	public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
		this.flexibleSearchService = flexibleSearchService;
	}
}
