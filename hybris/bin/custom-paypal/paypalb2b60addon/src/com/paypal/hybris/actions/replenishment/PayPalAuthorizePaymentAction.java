/**
 *
 */
package com.paypal.hybris.actions.replenishment;

import de.hybris.platform.b2bacceleratoraddon.actions.replenishment.AuthorizePaymentAction;
import de.hybris.platform.b2bacceleratorservices.model.process.ReplenishmentProcessModel;
import de.hybris.platform.commerceservices.impersonation.ImpersonationContext;
import de.hybris.platform.commerceservices.impersonation.ImpersonationService;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.PaymentTransactionEntryModel;
import de.hybris.platform.payment.model.PaymentTransactionModel;
import de.hybris.platform.processengine.model.BusinessProcessParameterModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.paypal.hybris.addon.constants.Paypalb2b60addonConstants;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.integration.service.PaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;


public class PayPalAuthorizePaymentAction extends AuthorizePaymentAction
{
	private PaypalPaymentIntegrationService paypalPaymentIntegrationService;

	@Override
	public Transition executeAction(final ReplenishmentProcessModel process) throws Exception
	{
		final BusinessProcessParameterModel clonedCartParameter = processParameterHelper.getProcessParameterByName(process, "cart");

		final BusinessProcessParameterModel originalCartParameter = processParameterHelper.getProcessParameterByName(process,
				Paypalb2b60addonConstants.ORIGINAL_CART);

		final CartModel originalCart = (CartModel) originalCartParameter.getValue();

		final CartModel clonedCart = (CartModel) clonedCartParameter.getValue();
		getModelService().refresh(clonedCart);

		final ImpersonationContext context = new ImpersonationContext();
		context.setOrder(clonedCart);
		return getImpersonationService().executeInContext(context,
				new ImpersonationService.Executor<Transition, ImpersonationService.Nothing>()
				{
					@Override
					public Transition execute()
					{
						PaymentTransactionEntryModel paymentTransactionEntryModel = null;
						if (clonedCart.getPaymentInfo() instanceof PaypalPaymentInfoModel)
						{
							paymentTransactionEntryModel = getAuthorizationTransaction(originalCart);

							if (paymentTransactionEntryModel == null
									|| !TransactionStatus.ACCEPTED.name().equals(paymentTransactionEntryModel.getTransactionStatus()))
							{
								clonedCart.setStatus(OrderStatus.B2B_PROCESSING_ERROR);
								modelService.save(clonedCart);
								return Transition.NOK;
							}
						}
						addPaymentTransaction(clonedCart, paymentTransactionEntryModel, originalCart);
						return Transition.OK;
					}
				});
	}

    private PaymentTransactionEntryModel getAuthorizationTransaction(final CartModel cart)
    {
        for (final PaymentTransactionModel transaction : cart.getPaymentTransactions())
        {
            for (final PaymentTransactionEntryModel entry : transaction.getEntries())
            {
                if ((entry.getType().equals(PaymentTransactionType.AUTHORIZATION) && TransactionStatus.ACCEPTED.name().equals(entry.getTransactionStatus()))
                        ||
                     entry.getType().equals(PaymentTransactionType.ORDER))
                {
                    PaymentTransactionEntryModel fakeAuthorization = modelService.clone(entry);
                    fakeAuthorization.setType(PaymentTransactionType.AUTHORIZATION);
                    fakeAuthorization.setRequestId("N/A");
                    fakeAuthorization.setTransactionStatus(TransactionStatus.ACCEPTED.name());
                    fakeAuthorization.setTransactionStatusDetails("Added to allow further CAPTURE.");
                    modelService.save(fakeAuthorization);
                    return fakeAuthorization;
                }
            }
        }
        return null;
    }

	private void addPaymentTransaction(final CartModel cart, final PaymentTransactionEntryModel paymentTransactionEntry,
			final CartModel originalCart)
	{
		if (paymentTransactionEntry != null)
		{

			final PaymentTransactionEntryModel clonePaymentTransactionEntry = modelService
					.create(PaymentTransactionEntryModel.class);

			clonePaymentTransactionEntry.setType(paymentTransactionEntry.getType());
			clonePaymentTransactionEntry.setTransactionStatus(paymentTransactionEntry.getTransactionStatus());
			clonePaymentTransactionEntry.setTransactionStatusDetails(paymentTransactionEntry.getTransactionStatusDetails());
			clonePaymentTransactionEntry.setRequestId(paymentTransactionEntry.getRequestId());
			clonePaymentTransactionEntry.setType(paymentTransactionEntry.getType());
			clonePaymentTransactionEntry.setTransactionStatus(paymentTransactionEntry.getTransactionStatus());
			clonePaymentTransactionEntry.setTransactionStatusDetails(paymentTransactionEntry.getTransactionStatusDetails());

			final String code = PaypalConstants.PAYMENT_PROVIDER_NAME + "_cart_" + cart.getCode() + "_stamp_"
					+ System.currentTimeMillis();
			clonePaymentTransactionEntry.setCode(code);

			clonePaymentTransactionEntry.setCurrency(paymentTransactionEntry.getCurrency());

			clonePaymentTransactionEntry.setAmount(paymentTransactionEntry.getAmount());

			clonePaymentTransactionEntry.setTime(new Date());

			final PaypalPaymentInfoModel payPalPaymentInfo = ((PaypalPaymentInfoModel) cart.getPaymentInfo());
			payPalPaymentInfo.setIsReplenishment(Boolean.TRUE);
			payPalPaymentInfo.setBillingAgreementID(payPalPaymentInfo.getBillingAgreementID());

			final List<PaymentTransactionModel> paymentTransactions = new ArrayList<PaymentTransactionModel>();
			final ArrayList<PaymentTransactionEntryModel> paymentTransactionEntries = new ArrayList<PaymentTransactionEntryModel>();
			final PaymentTransactionModel transaction = new PaymentTransactionModel();
			transaction.setPaymentProvider(PaypalConstants.PAYMENT_PROVIDER_NAME);
			transaction.setRequestToken(PaypalConstants.PAY_PAL_REPLENISHMENT_CAPTURE);
			transaction.setRequestId(originalCart.getPk().toString());

			paymentTransactionEntries.add(clonePaymentTransactionEntry);
			transaction.setEntries(paymentTransactionEntries);
			paymentTransactions.add(transaction);
			cart.setPaymentTransactions(paymentTransactions);

			modelService.saveAll(payPalPaymentInfo, cart);
		}
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

}
