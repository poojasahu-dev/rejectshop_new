/**
 * 
 */
package au.com.rejectshop.brontoservice.impl;

import com.bronto.api.model.*;
import de.hybris.platform.util.Config;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bronto.api.BrontoApi;
import com.bronto.api.BrontoApiAsync;
import com.bronto.api.BrontoClient;
import com.bronto.api.BrontoClientAsync;
import com.bronto.api.ObjectOperationsAsync;
import com.bronto.api.operation.ContactOperations;
import com.bronto.api.operation.MailListOperations;
import com.bronto.api.operation.MessageOperations;
import com.bronto.api.request.ContactReadRequest;
import com.bronto.api.request.MailListReadRequest;
import com.bronto.api.request.MessageReadRequest;

import au.com.rejectshop.brontoservice.SendAFriendEmailService;
import au.com.rejectshop.facades.product.data.EmailProductData;



/**
 * @author soda.raveendra
 *
 */
public class DefaultSendAFriendEmailService implements SendAFriendEmailService
{
	private static final Logger LOG = Logger.getLogger(DefaultSendAFriendEmailService.class);
	private static final String API_TOKEN = "sendtofriend.apiToken";
	private static final String EMAIL_TEMPLATE = "sendtofriend.emailTemplate";
	private static final String REMINDER_EMAIL_TEMPLATE="sendemailremainder.emailTemplate";
	private static final String MAILING_LIST_ID = "sendtofriend.mailinglistid";
	private static final String PRODUCT_NAME = "bronto.email.field.name.productname";
	private static final String PRODUCT_DESC = "bronto.email.field.name.productdesc";
	private static final String PRODUCT_PRICE = "bronto.email.field.name.productprice";
	private static final String PRODUCT_URL = "bronto.email.field.name.producturl";
	private static final String PRODUCT_IMAGE_URL = "bronto.email.field.name.productimageurl";
	private static final String SENDERS_NAME = "bronto.email.field.sendersName";
	private static final String FIRST_NAME = "bronto.email.field.firstname";
	private static final String REMAINDER_FROMEMAIL = "bronto.email.fromemail";
	private static final String EMAIL_FROM_NAME ="bronto.email.fromname";
	private static final String EMAIL_REPLY_TO="bronto.email.replyto";
	private static final String TRANSACTION_TYPE = "transactional";
	private static final String FIRST_NAME_ID="bronto.email.field.firstnameID";
	private   String contactId;
	private BrontoApi connection;
	private static final String contentType = "html";
	ObjectOperationsAsync<DeliveryObject> deliveryOps;
	DeliveryObject delivery;
	

	 
	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.brontoservice.SendAFriendEmailService#sendMailFriend(au.com.rejectshop.storefront.forms.
	 * SendAFriendForm)
	 */
	@Override
	public void sendMailFriend(EmailProductData emailProductData)
	{
		LOG.info("Email..." + emailProductData.getFromEmail() + "recipient email" + emailProductData.getToEmail());
		contactId = createContact(emailProductData);
		if (StringUtils.isEmpty(contactId))
		{
			LOG.error("Unable to create contact ");
			return;
		}
		deliveryOps = getAsyncConnection().transportAsync(DeliveryObject.class);

		DeliveryRecipientObject recipient = new DeliveryRecipientObject();
		recipient.setDeliveryType(DeliveryRecipientSelection.SELECTED.getApiValue());
		recipient.setType(DeliveryRecipientType.CONTACT.getApiValue());
		recipient.setId(contactId);
		LOG.info("recipient:" + recipient.getId());
		delivery = new DeliveryObject();
		delivery.setType(DeliveryType.TRANSACTIONAL.getApiValue());
		delivery.setMessageId(getMessage(EMAIL_TEMPLATE));
		delivery.setFromEmail(Config.getParameter(REMAINDER_FROMEMAIL));
		delivery.setFromName(Config.getParameter(EMAIL_FROM_NAME));
		delivery.setReplyEmail(Config.getParameter(EMAIL_REPLY_TO));
		delivery.setType(TRANSACTION_TYPE);
		delivery.getRecipients().add(recipient);
		//setBrontoAttribes(emailProductData);
		addMessageFields(emailProductData);
		
		
		try
		{
			GregorianCalendar cal = new GregorianCalendar();
			XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			
			delivery.setStart(calendar);
			WriteResult result = deliveryOps.add(delivery).get();
			List<ResultItem> output = result.getResults();
			for (ResultItem item : output)
			{
				LOG.info("item.getErrorString() = " + item.getErrorString());
			}
		
		}
		catch (Exception e)
		{
		LOG.error(e.getMessage());
		}
		
		
		
	}
	
	/**
	 * setting attributes for bronto
	 * @param emailProductData
	 * 
	 */
	
	private MessageFieldObject createMessageFieldObj(String fieldName,String fieldContent){
		MessageFieldObject messageField = new MessageFieldObject();
		messageField.setName(fieldName);
		messageField.setContent(fieldContent);
		messageField.setType(contentType);
		return messageField;
	}
	
	private void addMessageFields(EmailProductData emailProductData){
		delivery.getFields().add(createMessageFieldObj(Config.getParameter(SENDERS_NAME),emailProductData.getFromName()));
		delivery.getFields().add(createMessageFieldObj(Config.getParameter(PRODUCT_NAME),emailProductData.getProductName()));
		delivery.getFields().add(createMessageFieldObj( Config.getParameter(PRODUCT_DESC),emailProductData.getProductDescription()));
		delivery.getFields().add(createMessageFieldObj(Config.getParameter(PRODUCT_PRICE),emailProductData.getProductPrice()));
		delivery.getFields().add(createMessageFieldObj( Config.getParameter(PRODUCT_IMAGE_URL),emailProductData.getProductImageUrl()));
		delivery.getFields().add(createMessageFieldObj(Config.getParameter(PRODUCT_URL),emailProductData.getProductUrl()));
		delivery.getFields().add(createMessageFieldObj(Config.getParameter(FIRST_NAME),emailProductData.getToName()));
	}

	/**
	 * 
	 * @return connection
	 */
	private BrontoApi getConnection()
	{
		if (connection == null)
		{
			BrontoApi client = new BrontoClient(Config.getParameter(API_TOKEN));
			String sessionId = client.login();
			LOG.info("sessionId = " + sessionId);
			connection = client;
		}
		return connection;
	}
	

	/**
	 * 
	 * @return connection
	 */
	private BrontoApiAsync getAsyncConnection()
	{
			BrontoApiAsync  client =new BrontoClientAsync(Config.getParameter(API_TOKEN));
			String sessionId = client.login();
			LOG.info("sessionId = " + sessionId);
			return client ;
	}

	/**
	 * 
	 * @return
	 */
	private String getMessage(String messageTemplete)
	{
		MessageOperations messageOps = new MessageOperations(getConnection());
		String sendToFriend = Config.getParameter(messageTemplete);
		MessageObject message = messageOps.get(new MessageReadRequest().withName(sendToFriend));
		LOG.info("message template" + message.getName());
		return message.getId();

	}

	private String getMailListId(){
		String listId = Config.getParameter(MAILING_LIST_ID);

		MailListOperations listOps = new MailListOperations(getConnection());
		MailListObject list = listOps.get(new MailListReadRequest().withName(listId));
		return list.getId();
	}

	/**
	 * Returns the existing lists for the passed for the contact if exists
	 * @param email
	 * @return
	 */
	private String createContact(EmailProductData emailProductData)
	{
		ContactOperations contactOps = new ContactOperations(connection);

        String listId = getMailListId();

		final ContactReadRequest readContacts = new ContactReadRequest()
				.withEmail(FilterOperator.EQUAL_TO, emailProductData.getToEmail())
				.withIncludeLists(true);
		List<ContactObject> contacts = contactOps.read(readContacts);
		ContactObject contactObject = new ContactObject();
		if (!contacts.isEmpty()) { //contact exists
			List<String> listIds = new ArrayList<String>();
			for (ContactObject contact : contacts) {
				if (contact.getListIds().contains(listId)){
					//No action required contact exists in list
					return contact.getId();
				}
				// add contact to new list and update contact
				contact.getListIds().add(listId);
				contactObject=contact;

			}
			return addOrUpdateContact(contactOps,contactObject);
		}else { //create new contact as transactional

			contactObject = contactOps.newObject()
					.add("listIds", listId)
					.set("email", emailProductData.getToEmail())
					.set("status", ContactStatus.TRANSACTIONAL.getApiValue())
					.get();
			ContactField firstName = new ContactField();
			firstName.setFieldId(Config.getParameter(FIRST_NAME_ID));
			firstName.setContent(emailProductData.getToName());

			contactObject.getFields().add(firstName);
		}
		return  addOrUpdateContact(contactOps,contactObject);

	}
	/**
	 * 
	 * @param emailProductData
	 * @return
	 */
	private String addOrUpdateContact(ContactOperations contactOps, ContactObject contactObject)
	{
		String contactId = StringUtils.EMPTY;
		try
		{
			WriteResult result = contactOps.addOrUpdate(contactObject);
			
			for (ResultItem res : result.getResults())
			{
				LOG.debug(res.isIsError() + "..." + res.isIsNew() + "...." + res.getErrorCode() + "..." + res.getErrorString() + "..."
						+ res.getId());
				contactId = res.getId();
			}
		}
		catch (Exception e)
		{
			LOG.error(e.getMessage());
			return StringUtils.EMPTY;
		}
		return contactId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.com.rejectshop.brontoservice.SendAFriendEmailService#sendEmailRemainder(au.com.rejectshop.facades.product.data.
	 * EmailProductData)
	 */
	@Override
	public void sendEmailRemainder(EmailProductData emailProductData)
	{
		LOG.info("FromEmail:"+emailProductData.getFromEmail() + " " + "Name:" + emailProductData.getFromName() + " " + "Code:" + emailProductData.getProductCode());
		contactId = createContact(emailProductData);
		if (StringUtils.isEmpty(contactId))
		{
			LOG.error("Unable to create contact ");
			return;
		}
		
		DeliveryRecipientObject recipient = new DeliveryRecipientObject();
		recipient.setDeliveryType(DeliveryRecipientSelection.SELECTED.getApiValue());
		recipient.setType(DeliveryRecipientType.CONTACT.getApiValue());
		recipient.setId(contactId);
		
		LOG.info("recipient:" + recipient.getId());
		
		delivery = new DeliveryObject();
		delivery.setType(DeliveryType.TRANSACTIONAL.getApiValue());
		delivery.setMessageId(getMessage(REMINDER_EMAIL_TEMPLATE));
		delivery.setFromEmail(Config.getParameter(REMAINDER_FROMEMAIL));
		delivery.setFromName(Config.getParameter(EMAIL_FROM_NAME));
		delivery.setReplyEmail(Config.getParameter(EMAIL_REPLY_TO));
		delivery.setType(TRANSACTION_TYPE);
		delivery.getRecipients().add(recipient);
		deliveryOps = getAsyncConnection().transportAsync(DeliveryObject.class);
		LOG.info("recipient:" + recipient.getId());
		addMessageFields(emailProductData);

		try
		{
			
			final String dateSplit[] = emailProductData.getReminderDate().split("/");
			//final String timeSplit[] = emailProductData.getReminderTime().split(":");
			/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
			Date  dt = simpleDateFormat.parse(emailProductData.getReminderTime());
*/
			int day=Integer.parseInt(dateSplit[0]);
			int month=Integer.parseInt(dateSplit[1])-1;
			int year=Integer.parseInt(dateSplit[2]);
			//int sec=Integer.parseInt("0");


			GregorianCalendar calDate = new GregorianCalendar(year,month,day,9,0,0);
			//if time is before current time set to send now.
			LOG.info("Reminder time ---"+calDate.getTime());
			if (calDate.getTime().before(new Date())) calDate.setTime(new Date());

			XMLGregorianCalendar calendarRemainder = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(calDate);
			//calendarRemainder.setTime(hour,minute,sec);
			LOG.info("year:"+calendarRemainder.getYear()+"month:"+calendarRemainder.getMonth()+"day:"+calendarRemainder.getDay()+"hour:"+calendarRemainder.getHour()+"minute:"+calendarRemainder.getMinute()+"sec:"+calendarRemainder.getSecond());
			delivery.setStart(calendarRemainder);
			LOG.info("delivery.getId() = " + delivery.getId());
			WriteResult result = deliveryOps.add(delivery).get();
			List<ResultItem> output = result.getResults();
			for (ResultItem item : output)
			{
				LOG.info("item.getErrorString() = " + item.getErrorString());
			}
		}
		catch (Exception e)
		{
			LOG.error(e.getMessage());
		}
		
	}
}
