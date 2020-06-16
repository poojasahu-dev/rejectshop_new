/**
 *
 */
package au.com.rejectshop.core.event;

import de.hybris.platform.core.Registry;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import au.com.rejectshop.core.model.process.SendAFriendEmailProcessModel;


/**
 * @author venkatapavani.t
 *
 */
public class SendAFriendEmailEventListener extends AbstractEventListener<SendAFriendEmailEvent>
{
	@Autowired
	private ModelService modelService;
	@SuppressWarnings("unused")
	private BusinessProcessService businessProcessService;
	/** The Constant process. */
	private static final String process = "sendAFriendEmailProcess";

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
	 * Gets the business process service.
	 *
	 * @return the business process service
	 */
	public BusinessProcessService getBusinessProcessService()
	{
		return (BusinessProcessService) Registry.getApplicationContext().getBean("businessProcessService");
	}


	/**
	 * @param businessProcessService
	 *           the businessProcessService to set
	 */
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event
	 * .events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final SendAFriendEmailEvent event)
	{

		final SendAFriendEmailProcessModel businessProcessModel = (SendAFriendEmailProcessModel) getBusinessProcessService()
				.createProcess(process + System.currentTimeMillis() + "_" + UUID.randomUUID(), process);

		System.out.println("event.getYourName() = " + event.getYourName());
		System.out.println("event.getMessage() = " + event.getMessage());

		businessProcessModel.setSite(event.getSite());
		businessProcessModel.setEmail(event.getEmail());
		businessProcessModel.setRecipientEmail(event.getRecipientEmail());
		businessProcessModel.setMessage(event.getMessage());
		businessProcessModel.setName(event.getName());
		businessProcessModel.setProductUrl(event.getProductUrl());
		businessProcessModel.setProductName(event.getProductName());
		businessProcessModel.setProductCode(event.getProductCode());
		businessProcessModel.setProductImageUrl(event.getProductImageUrl());
		businessProcessModel.setProductPrice(event.getProductPrice());
		businessProcessModel.setYourName(event.getYourName());



		getModelService().save(businessProcessModel);
		getBusinessProcessService().startProcess(businessProcessModel);

	}

}
