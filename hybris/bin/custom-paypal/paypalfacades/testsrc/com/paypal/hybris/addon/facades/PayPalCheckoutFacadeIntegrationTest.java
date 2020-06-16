package com.paypal.hybris.addon.facades;

import static org.junit.Assert.assertTrue;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.order.CalculationService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Collections;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.paypal.hybris.facade.PayPalCheckoutFacade;
import com.paypal.hybris.integration.service.impl.DefaultPaypalPaymentIntegrationService;
import com.paypal.hybris.model.PaypalPaymentInfoModel;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;


public class PayPalCheckoutFacadeIntegrationTest extends ServicelayerTransactionalTest
{

	private static final String TEST_USER_ID = "cartTestUser";
	private static final String TEST_PRODUCT_A_ID = "pA";
	private static final String CURRENCY_ISO_CODE = "EUR";
	private static final String SECURITY_CODE = "3534534-DFFG";

	@Resource
	PayPalCheckoutFacade payPalCheckoutFacade;

	@Resource
	private DefaultPaypalPaymentIntegrationService paypalPaymentService;
	@Resource
	private ModelService modelService;
	@Resource
	private UserService userService;
	@Resource
	private CommonI18NService commonI18NService;
	@Resource
	private CartService cartService;
	@Resource
	private ProductService productService;
	@Resource
	private CalculationService calculationService;

	private DefaultPaypalPaymentIntegrationService paypalPaymentServicePartMock;
	private DoExpressCheckoutPaymentResponseType doExpressCheckoutPaymentResponse;

	@Before
	public void setUp() throws Exception
	{
		createCoreData();
		createTestCatalog();
		createSessionCart();
		createMocks();
	}

	@Test
	public void testAuthorizePayment()
	{
		final boolean isAuthorized = payPalCheckoutFacade.authorizePayment(SECURITY_CODE);
		assertTrue(isAuthorized);
	}

	private void createMocks()
	{
		/*
		 * doExpressCheckoutPaymentResponse = new DoExpressCheckoutPaymentResponseType();
		 * doExpressCheckoutPaymentResponse.setAck(AckCodeType.SUCCESS); doExpressCheckoutPaymentResponse.setTimestamp(new
		 * XMLGregorianCalendarImpl((GregorianCalendar) GregorianCalendar.getInstance()));
		 *
		 * paypalPaymentServicePartMock = spy(paypalPaymentService);
		 * doReturn(doExpressCheckoutPaymentResponse).when(paypalPaymentServicePartMock).doExpressCheckoutPayment(any(
		 * DoExpressCheckoutPaymentRequestType.class));
		 *
		 * payPalCheckoutFacade.setPayPalPaymentService(paypalPaymentServicePartMock);
		 */
	}

	private void createTestCatalog() throws ImpExException
	{
		importCsv("/paypaladdon/test/testOrderCalculations.csv", "utf-8");
	}

	/**
	 * Utility method to create cart and set it as session cart
	 */
	private void createSessionCart()
	{
		final CartModel cart = modelService.create(CartModel.class);

		final CustomerModel customer = modelService.create(CustomerModel.class);
		customer.setUid(TEST_USER_ID);
		customer.setSessionCurrency(commonI18NService.getCurrency(CURRENCY_ISO_CODE));
		customer.setSessionLanguage(commonI18NService.getLanguage("en"));
		customer.setGroups(Collections.<PrincipalGroupModel> singleton(userService.getUserGroupForUID("customergroup")));
		customer.setName("Test customer");
		modelService.save(customer);

		userService.setCurrentUser(customer);

		cart.setUser(customer);
		cart.setCurrency(commonI18NService.getCurrency(CURRENCY_ISO_CODE));
		cart.setDate(new Date());
		cart.setNet(Boolean.TRUE);

		final PaypalPaymentInfoModel paypalPaymentInfo = modelService.create(PaypalPaymentInfoModel.class);
		paypalPaymentInfo.setToken("324234234-FD");
		modelService.save(paypalPaymentInfo);
		cart.setPaymentInfo(paypalPaymentInfo);

		modelService.save(cart);
		cartService.setSessionCart(cart);
	}

}
