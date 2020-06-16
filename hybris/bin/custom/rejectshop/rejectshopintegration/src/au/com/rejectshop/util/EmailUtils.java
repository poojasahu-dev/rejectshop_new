/**
 * 
 */
package au.com.rejectshop.util;

import de.hybris.platform.util.Config;

import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;
import au.com.rejectshop.data.ErrorBean;
import au.com.rejectshop.data.SkipBean;

/**
 * EmailUtility This class is implemented to implement the Utility operations for an Email Service.
 */
public class EmailUtils
{

	/** The host. */
	private final String host;
	
	/** The port. */
	private final int port;
	
	/** The user. */
	private final String user;
	
	/** The password. */
	private final String password;
	
	/** The send from. */
	private final String sendFrom;

	/** The email util. */
	private static EmailUtils emailUtil = null;
	
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(EmailUtils.class);

	
	/**
	 * Gets the single instance of EmailUtils.
	 *
	 * @return EmailUtil
	 */
	public static EmailUtils getInstance()
	{
		if (emailUtil == null)
		{
			emailUtil = new EmailUtils();
		}
		return emailUtil;
	}

	/**
	 * Constructor.
	 */
	public EmailUtils()
	{
		host = Config.getString(RejectshopCoreConstants.SMTP_HOST, StringUtils.EMPTY);
		port = Config.getInt(RejectshopCoreConstants.SMTP_PORT, 25);
		user = Config.getString(RejectshopCoreConstants.SMTP_USER, StringUtils.EMPTY);
		password = Config.getString(RejectshopCoreConstants.SMTP_PASSWORD, StringUtils.EMPTY);
		sendFrom = Config.getString(RejectshopCoreConstants.SMTP_FROM, StringUtils.EMPTY);
	}

	/**
	 * This method is used to send an Email.
	 *
	 * @param attchmentPath the attchment path
	 * @param sendTo the send to
	 * @param setSubject the set subject
	 * @param setHtmlMsg the set html msg
	 * @throws EmailException the email exception
	 */
	public void sendEmail(final String attchmentPath, final String sendTo, final String setSubject,
										final String setHtmlMsg) throws EmailException
	{
		final HtmlEmail htmlEmail = new HtmlEmail();
		if (attchmentPath != null)
		{
			final EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(attchmentPath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			htmlEmail.attach(attachment);
		}
		htmlEmail.setHostName(host);
		htmlEmail.setSmtpPort(port);
		htmlEmail.setAuthentication(user, password);
		htmlEmail.addTo(sendTo);
		htmlEmail.setFrom(sendFrom);
		htmlEmail.setSubject(setSubject);
		htmlEmail.setHtmlMsg(setHtmlMsg);

		htmlEmail.send();
	}
	
	/**
	 * Send notification.
	 *
	 * @param errorProducts the error products
	 * @throws Exception the exception
	 */
	public static void sendProductNotification(List<ErrorBean> errorProducts,List<SkipBean> skipCounts, String errorDirec,
									int successCount , int errorCount,int skipCount)
	{
		String sendTo = null;
		sendTo = Config.getString("mail.notification.sendtoemail", StringUtils.EMPTY);
		String fileName=null;

			if (CollectionUtils.isNotEmpty(errorProducts))
		    {
			for (ErrorBean errorBean : errorProducts)
			{
				fileName = "ProductFile";
				String fname = errorBean.getFileName();
				String productId=errorBean.getStoreId();
				String record = "File Name :::"+fname+" "+"\n"+" Sku ID : "+productId+"\n" +" Reason : "+errorBean.getMessage()+"\n";
		    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
			}
			
			 for(SkipBean skipBean:skipCounts){
					fileName = "ProductFile";
					String fname = skipBean.getFileName();
					String productId=skipBean.getStoreId();
			   	String record = "File Name :::"+fname+" "+"\n"+" Sku ID : "+productId+"\n" +" Reason : "+skipBean.getMessage()+"\n";
			    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
				}
			 
			 
			final String subject = "[Failure] Products Loading Notification";
			String attachmentPath = null;
			if (fileName != null)
			{
				attachmentPath = FileIOUtilities.getErrorFilePath(errorDirec, fileName);
			}
			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			msgBuilder.append("No of records Processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of records Skipped     : ").append(skipCount).append("<br/>");
			msgBuilder.append("No of records failed              : ").append(errorCount).append("<br />");
			try
			{
				EmailUtils.getInstance().sendEmail(attachmentPath, sendTo, subject, msgBuilder.toString());
			}
			catch (EmailException e)
			{
				LOG.error(e.getMessage(),e);
			}
			FileIOUtilities.cleanDir(errorDirec);
		}
		else
		{
			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			final String subject = "[Success] Products Loading Notification";
			msgBuilder.append("No of records processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of records Skipped     : ").append(skipCount).append("<br/>");
			msgBuilder.append("No of records failed              : ").append(errorCount).append("<br />");
			try
			{
				EmailUtils.getInstance().sendEmail(null, sendTo, subject, msgBuilder.toString());
			}
			catch (EmailException e)
			{
			  LOG.error(e.getMessage(),e);
				e.printStackTrace();
			}
		}
			FileIOUtilities.cleanDir(errorDirec);
		
	}

	/**
	 * Send price notification.
	 *
	 * @param errorProducts the error products
	 * @throws Exception the exception
	 */
	public static void sendPriceNotification(List<ErrorBean> errorProducts,List<SkipBean> skipCounts, String errorDirec,
																int successCount, int errorCount,int skipCount )
	{
		String sendTo = null;
		sendTo = Config.getString("mail.notification.sendtoemail", StringUtils.EMPTY);
		String fileName=null;
		
			if (CollectionUtils.isNotEmpty(errorProducts))
		    {
			for (ErrorBean errorBean : errorProducts)
			{
				fileName = "PriceFile";
				String productId=errorBean.getStoreId();
				String fname=errorBean.getFileName();
				String record = "File Name :::"+fname+" "+"\n"+"Sku ID : "+productId+"\n"+"Reason : "+errorBean.getMessage()+"\n";
		    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
			}
			
			 for(SkipBean skipBean:skipCounts){
				fileName = "PriceFile";
				String importFileName=skipBean.getFileName();
				String productId=skipBean.getStoreId();
		   	String record = "File Name ::: "+importFileName+"  "+"\n"+"Sku ID "+productId+"\n"+"Reason : "+skipBean.getMessage()+"\n";
		    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
			}
			 
			final String subject = "[Failure] Prices Loading Notification";
			String attachmentPath = null;
			if (fileName != null)
			{
				attachmentPath = FileIOUtilities.getErrorFilePath(errorDirec, fileName);
			}

			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			msgBuilder.append("No of records Processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of Price Row records Skipped      : ").append(skipCount).append("<br />");
			msgBuilder.append("No of records failed                 : ").append(errorCount).append("<br />");
			try
			{
				EmailUtils.getInstance().sendEmail(attachmentPath, sendTo, subject, msgBuilder.toString());
			}
			catch (EmailException e)
			{
				LOG.error(e.getMessage(),e);
			}
			FileIOUtilities.cleanDir(errorDirec);
		}
		else
		{
			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			final String subject = "[Success] Prices Loading Notification";
			msgBuilder.append("No of records processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of records Skipped              : ").append(skipCount).append("<br />");
			msgBuilder.append("No of records failed              : ").append(errorCount).append("<br />");
			try
			{
				EmailUtils.getInstance().sendEmail(null, sendTo, subject, msgBuilder.toString());
			}
			catch (EmailException e)
			{
				LOG.error(e.getMessage(),e);
			}
		}
			FileIOUtilities.cleanDir(errorDirec);
		
	}
	
	/**
	 * Send notification.
	 *
	 * @param errorPOS the error POS
	 * @param errorCount 
	 * @param successCount 
	 * @param errorDirec 
	 * @throws EmailException the email exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void sendPOSNotification(List<ErrorBean> errorPOS,List<SkipBean> skipCounts,String errorDirec, int successCount, 
											int errorCount,int skipCount) throws EmailException, IOException
	{
		String sendTo = null;
		sendTo = Config.getString("mail.notification.sendtoemail", StringUtils.EMPTY);
		String fileName=null;
		
		if (CollectionUtils.isNotEmpty(errorPOS)) 
		{
			
			for (ErrorBean errorBean : errorPOS)
			{
				fileName = "POSFile";
				String importedFileName=errorBean.getFileName();
				String storeId=errorBean.getStoreId();
				String record = "File Name :::"+importedFileName+" "+"\n"+"Store ID : "+storeId+"\n"+" Reason : "+errorBean.getMessage()+"\n";
		    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
			}
			
			for(SkipBean skipBean:skipCounts){
				fileName = "POSFile";
				String storeId=skipBean.getStoreId();
				String record = "File Name :::"+"\n"+"Store ID is "+storeId+"\n"+" Reason : "+skipBean.getMessage()+"\n";
		    	FileIOUtilities.processErrorRecord(errorDirec, record, fileName);
			}
			
			final String subject = "[Failure] Point Of Service Notification";
			String attachmentPath = null;
			if (fileName != null)
			{
				attachmentPath = FileIOUtilities.getErrorFilePath(errorDirec, fileName);
			}
	
			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			msgBuilder.append("No of records Processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of records Skipped                : ").append(skipCount).append("<br />");
			msgBuilder.append("No of records failed                 : ").append(errorCount).append("<br />");
			EmailUtils.getInstance().sendEmail(attachmentPath, sendTo, subject, msgBuilder.toString());
			FileIOUtilities.cleanDir(errorDirec);
		}
		else
		{
			final StringBuilder msgBuilder = new StringBuilder();
			msgBuilder.append("<html>");
			msgBuilder.append("<p>").append(" Status ").append("<br/>");
			msgBuilder.append("--------------------------------------------------------------------------------<br/><br/>");
			final String subject = "[Success] Point Of Service Notification";
			msgBuilder.append("No of records processed successfully : ").append(successCount).append("<br/>");
			msgBuilder.append("No of records Skipped                : ").append(skipCount).append("<br />");
			msgBuilder.append("No of records failed                 : ").append(errorCount).append("<br />");
			EmailUtils.getInstance().sendEmail(null, sendTo, subject, msgBuilder.toString());
		}
			FileIOUtilities.cleanDir(errorDirec);
	}



}
