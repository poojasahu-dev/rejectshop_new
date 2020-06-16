/**
 *
 */
package com.paypal.hybris.facade;

import com.paypal.hybris.enums.PaymentActionType;
import com.paypal.hybris.model.PaypalPaymentInfoModel;
import de.hybris.platform.b2bacceleratorfacades.checkout.data.PlaceOrderData;
import de.hybris.platform.b2bacceleratorfacades.exception.EntityValidationException;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BCommentData;
import de.hybris.platform.b2bacceleratorfacades.order.data.B2BReplenishmentRecurrenceEnum;
import de.hybris.platform.b2bacceleratorfacades.order.data.TriggerData;
import de.hybris.platform.b2bacceleratorfacades.order.impl.DefaultB2BAcceleratorCheckoutFacade;
import de.hybris.platform.b2bacceleratorservices.enums.CheckoutPaymentType;
import de.hybris.platform.commercefacades.order.data.AbstractOrderData;
import de.hybris.platform.commercefacades.order.data.CCPaymentInfoData;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import java.util.List;

import static de.hybris.platform.util.localization.Localization.getLocalizedString;


public class PayPalB2BCheckoutFacadeImpl extends DefaultB2BAcceleratorCheckoutFacade implements PayPalB2BCheckoutFacade
{
	private static final String CART_CHECKOUT_TRANSACTION_NOT_AUTHORIZED = "cart.transation.notAuthorized";
	private static final String CART_CHECKOUT_TERM_UNCHECKED = "cart.term.unchecked";
	private static final String CART_CHECKOUT_NO_QUOTE_DESCRIPTION = "cart.no.quote.description";
	private static final String CART_CHECKOUT_REPLENISHMENT_NO_STARTDATE = "cart.replenishment.no.startdate";
	private static final String CART_CHECKOUT_REPLENISHMENT_NO_FREQUENCY = "cart.replenishment.no.frequency";

	@Resource(name = "payPalCheckoutFacade")
	private PayPalCheckoutFacade payPalCheckoutFacade;

	@Override
	public boolean authorizePayment(final String securityCode)
	{
		final CartModel cart = getCartService().getSessionCart();
		if (CheckoutPaymentType.ACCOUNT.equals(cart.getPaymentType()))
		{
			return super.authorizePayment(securityCode);
		}
		return payPalCheckoutFacade.authorizePayment(securityCode);
	}

	@Override
	protected CCPaymentInfoData getPaymentDetails()
	{
		return payPalCheckoutFacade.getPaymentDetails();
	}

	@Override
	public boolean setPaymentDetails(final String paymentInfoId)
	{
		return payPalCheckoutFacade.setPaymentDetails(paymentInfoId);
	}

	@Override
	public void setCardPaymentType()
	{
		final CartModel cart = getCart();
		cart.setPaymentType(CheckoutPaymentType.CARD);
		getModelService().save(cart);
	}

	@Override
	public <T extends AbstractOrderData> T placeOrder(final PlaceOrderData placeOrderData) throws InvalidCartException
	{
		// term must be checked
		if (!placeOrderData.getTermsCheck().equals(Boolean.TRUE))
		{
			throw new EntityValidationException(getLocalizedString(CART_CHECKOUT_TERM_UNCHECKED));
		}

		// for CARD type, transaction must be authorized before placing order
		final boolean isCardtPaymentType = CheckoutPaymentType.CARD.equals(getCart().getPaymentType());
		if (isCardtPaymentType && !isPayPalPaymentActionOrder() )
		{
			final List<PaymentTransactionModel> transactions = getCart().getPaymentTransactions();
			boolean authorized = false;
			for (final PaymentTransactionModel transaction : transactions)
			{
				for (final PaymentTransactionEntryModel entry : transaction.getEntries())
				{
					if (entry.getType().equals(PaymentTransactionType.AUTHORIZATION)
							&& TransactionStatus.ACCEPTED.name().equals(entry.getTransactionStatus()))
					{
						authorized = true;
						break;
					}
				}
			}
			if (!authorized)
			{
				// FIXME - change error message
				throw new EntityValidationException(getLocalizedString(CART_CHECKOUT_TRANSACTION_NOT_AUTHORIZED));
			}
		}

		if (isValidCheckoutCart(placeOrderData))
		{
			// validate quote negotiation
			if (placeOrderData.getNegotiateQuote() != null && placeOrderData.getNegotiateQuote().equals(Boolean.TRUE))
			{
				if (StringUtils.isBlank(placeOrderData.getQuoteRequestDescription()))
				{
					throw new EntityValidationException(getLocalizedString(CART_CHECKOUT_NO_QUOTE_DESCRIPTION));
				}
				else
				{
					final B2BCommentData b2BComment = new B2BCommentData();
					b2BComment.setComment(placeOrderData.getQuoteRequestDescription());

					final CartData cartData = new CartData();
					cartData.setB2BComment(b2BComment);

					updateCheckoutCart(cartData);
				}
			}

			// validate replenishment
			if (placeOrderData.getReplenishmentOrder() != null && placeOrderData.getReplenishmentOrder().equals(Boolean.TRUE))
			{
				if (placeOrderData.getReplenishmentStartDate() == null)
				{
					throw new EntityValidationException(getLocalizedString(CART_CHECKOUT_REPLENISHMENT_NO_STARTDATE));
				}

				if (placeOrderData.getReplenishmentRecurrence().equals(B2BReplenishmentRecurrenceEnum.WEEKLY)
						&& CollectionUtils.isEmpty(placeOrderData.getNDaysOfWeek()))
				{
					throw new EntityValidationException(getLocalizedString(CART_CHECKOUT_REPLENISHMENT_NO_FREQUENCY));
				}

				final TriggerData triggerData = new TriggerData();
				populateTriggerDataFromPlaceOrderData(placeOrderData, triggerData);

				return (T) scheduleOrder(triggerData);
			}

			return (T) super.placeOrder();
		}

		return null;
	}

    private boolean isPayPalPaymentActionOrder() {
        PaymentInfoModel paymentInfo = getCart().getPaymentInfo();
        return paymentInfo instanceof PaypalPaymentInfoModel &&
                ((PaypalPaymentInfoModel) paymentInfo).getPaymentAction().equals(PaymentActionType.ORDER);
    }
}
