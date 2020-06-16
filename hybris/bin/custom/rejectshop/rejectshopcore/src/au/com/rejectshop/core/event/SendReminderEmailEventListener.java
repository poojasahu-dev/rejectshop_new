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

import au.com.rejectshop.core.model.process.SendReminderProcessModel;


/**
 * @author saisravan.k
 *
 */
public class SendReminderEmailEventListener extends AbstractEventListener<SendReminderEmailEvent>
{
	@Autowired
	private ModelService modelService;
	@SuppressWarnings("unused")
	private BusinessProcessService businessProcessService;

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
	 * @return the businessProcessService
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

	/** The Constant process. */
	private static final String process = "sendReminderEmailProcess";

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event
	 * .events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final SendReminderEmailEvent event)
	{
		final SendReminderProcessModel businessProcessModel = (SendReminderProcessModel) getBusinessProcessService().createProcess(
				process + System.currentTimeMillis() + "_" + UUID.randomUUID(), process);

		businessProcessModel.setSite(event.getSite());
		businessProcessModel.setEmail(event.getEmail());
		businessProcessModel.setDayofReminder(event.getDayofReminder());
		businessProcessModel.setTime(event.getTime());
		businessProcessModel.setName(event.getName());
		businessProcessModel.setProductUrl(event.getProductUrl());
		businessProcessModel.setProductName(event.getProductName());
		businessProcessModel.setProductCode(event.getProductCode());
		businessProcessModel.setProductImageUrl(event.getProductImageUrl());
		businessProcessModel.setProductPrice(event.getProductPrice());
		getModelService().save(businessProcessModel);
		getBusinessProcessService().startProcess(businessProcessModel);

	}// YTODO Auto-generated method stub

}
