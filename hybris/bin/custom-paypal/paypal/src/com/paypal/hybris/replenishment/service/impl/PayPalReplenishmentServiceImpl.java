package com.paypal.hybris.replenishment.service.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.payment.commands.request.CaptureRequest;
import de.hybris.platform.payment.commands.result.CaptureResult;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.model.ModelService;

import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.DoReferenceTransactionRequestData;
import com.paypal.hybris.data.DoReferenceTransactionResultData;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import com.paypal.hybris.replenishment.service.PayPalReplenishmentService;


public class PayPalReplenishmentServiceImpl implements PayPalReplenishmentService
{
	private static final Logger LOG = Logger.getLogger(PayPalReplenishmentServiceImpl.class);

	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;
	private CatalogVersionService catalogVersionService;
	private ConfigurationService configurationService;
	private Converter<CartModel, CartData> cartConverter;
	private Converter<DoReferenceTransactionResultData, CaptureResult> replenishmentResponseCaptureConverter;
	private ModelService modelService;

	@Override
	public CaptureResult proceedReplenishmentPlaceOrder(final CaptureRequest captureRequest)
	{
		catalogVersionService.setSessionCatalogVersion(PaypalConstants.DEFAULT_CATALOG_VERSION,
				configurationService.getConfiguration().getString(PaypalConstants.CATALOG_NAME));

		final String cartPK = captureRequest.getRequestId();

		LOG.info("[REPLENISHMENT] Proceed capture cloned cart #" + cartPK);

		final CartModel cartForReplenishment = getModelService().get(PK.parse(cartPK));

		if (cartForReplenishment != null)
		{
			final CartData cartData = cartConverter.convert(cartForReplenishment);

			final PaypalPaymentInfoModel payPalPaymentInfoModel = ((PaypalPaymentInfoModel) cartForReplenishment.getPaymentInfo());
			final String billingAgreementId = payPalPaymentInfoModel.getBillingAgreementID();

			final DoReferenceTransactionRequestData requestData = new DoReferenceTransactionRequestData();
			requestData.setCartData(cartData);

			requestData.setReferenceId(billingAgreementId);

			final String code = payPalPaymentInfoModel.getCode();
			if (PaypalConstants.PAYPAL_CREDIT_PAYMENT_INFO_CODE.equals(code))
			{
				requestData.setCredit(true);
			}
			else
			{
				requestData.setCredit(false);
			}

			final DoReferenceTransactionResultData resultData = getPaypalPaymentIntegrationService()
					.doReferenceTransaction(requestData);

			final CaptureResult captureResult = replenishmentResponseCaptureConverter.convert(resultData);

			return captureResult;
		}

		throw new IllegalArgumentException("[REPLENISHMENT] Can't capture replenishment. Not found cart #" + cartPK);
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
	 * @return the cartConverter
	 */
	public Converter<CartModel, CartData> getCartConverter()
	{
		return cartConverter;
	}

	/**
	 * @param cartConverter
	 *           the cartConverter to set
	 */
	public void setCartConverter(final Converter<CartModel, CartData> cartConverter)
	{
		this.cartConverter = cartConverter;
	}

	/**
	 * @return the catalogVersionService
	 */
	public CatalogVersionService getCatalogVersionService()
	{
		return catalogVersionService;
	}

	/**
	 * @param catalogVersionService
	 *           the catalogVersionService to set
	 */
	public void setCatalogVersionService(final CatalogVersionService catalogVersionService)
	{
		this.catalogVersionService = catalogVersionService;
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
	 * @return the replenishmentResponseCaptureConverter
	 */
	public Converter<DoReferenceTransactionResultData, CaptureResult> getReplenishmentResponseCaptureConverter()
	{
		return replenishmentResponseCaptureConverter;
	}

	/**
	 * @param replenishmentResponseCaptureConverter
	 *           the replenishmentResponseCaptureConverter to set
	 */
	public void setReplenishmentResponseCaptureConverter(
			final Converter<DoReferenceTransactionResultData, CaptureResult> replenishmentResponseCaptureConverter)
	{
		this.replenishmentResponseCaptureConverter = replenishmentResponseCaptureConverter;
	}

}
