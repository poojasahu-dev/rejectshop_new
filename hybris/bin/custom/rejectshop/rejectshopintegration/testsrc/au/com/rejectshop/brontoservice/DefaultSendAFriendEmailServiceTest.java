
package au.com.rejectshop.brontoservice;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.product.ProductService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bronto.api.BrontoApi;

import au.com.rejectshop.brontoservice.impl.DefaultSendAFriendEmailService;
import au.com.rejectshop.facades.product.data.EmailProductData;

/**
 * 
 * @author soda.raveendra
 *
 */

@UnitTest
public class DefaultSendAFriendEmailServiceTest
{

	private String apiToken = "7AA9A703-09FA-45FE-991B-6D931BD5C01E";
	private String mailingListId = "Website Transactional List";
	private String emailName= "Harsh Test Send to Friend";
	private String emailTempalte = "Confirmation Email";
	private String sendToFriend = "Harsh Test Send to Friend";
	private String userID = "";
	private String messageID = "";
	private static final Logger LOG = Logger.getLogger(DefaultSendAFriendEmailServiceTest.class);
	private static final String API_TOKEN="sendtofriend.apiToken";
	private static final String EMAIL_TEMPLATE="sendtofriend.emailTemplate";
	private static final String MAILING_LIST_ID="sendtofriend.mailinglistid";
	private BrontoApi connection;
	
	@Mock
	private DefaultSendAFriendEmailService defaultSendAFriendEmailService;
	
	@Mock
	private EmailProductData emailProductData;
	
	@Resource
	private ProductService productService;

	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSendMailFriend()
	{
		LOG.info("testSendMailFriend start");
		LOG.info("Send A Friend Email");		
		
		/*EmailProductData emailProductData = new EmailProductData();
		emailProductData.setFromEmail("hkhurana@rejectshop.com.au");
		emailProductData.setFromName("harsh khurana");
		emailProductData.setToEmail("soda.raveendra@happiestminds.com");
		emailProductData.setToName("soda raveendra");
		emailProductData.setMessage("Good");
		emailProductData.setProductCode("22243690");
		emailProductData.setProductName("EVEREADY-BATTERY-GOLD-9V");
		emailProductData.setProductPrice("$5");
		emailProductData.setProductUrl("All-Products/Home-%26-Garden/ELECTRICAL-ACCESSORIES/EVEREADY-BATTERY-GOLD-9V/p/22243690#");
		emailProductData.setProductImageUrl("/medias/masterMedia-22243690.jpg-media-300Wx300H?context=bWFzdGVyfGltYWdlc3wxNjMwM3xpbWFnZS9qcGVnfGltYWdlcy9oN2YvaGRkLzg3OTYyMjY0NTM1MzQuanBnfGM1MDgzMWVkYjU0ZTE3NTkyZmVlZTEwYTJkYzA2ZWY0MTQxNTg5ZTdjNjBhZmFiNTYzMjNmOWU2NzU5MzA4NzE");*/
		defaultSendAFriendEmailService.sendMailFriend(emailProductData);
		LOG.info("testSendMailFriend end");

	}
	
	@Test
	public void testSendEmailRemainder(){
		LOG.info("testSendEmailRemainder start");
		LOG.info("Send reminder Email");	
		
		defaultSendAFriendEmailService.sendEmailRemainder(emailProductData);
		
		LOG.info("testSendEmailRemainder end");
	}
	
}
