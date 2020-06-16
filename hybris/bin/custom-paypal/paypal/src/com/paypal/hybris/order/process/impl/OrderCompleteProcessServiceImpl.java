package com.paypal.hybris.order.process.impl;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.orderprocessing.model.OrderProcessModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.order.process.OrderCompleteProcessService;


public class OrderCompleteProcessServiceImpl implements OrderCompleteProcessService
{
	private static final Logger LOG = Logger.getLogger(OrderCompleteProcessServiceImpl.class);

	private ConfigurationService configurationService;
	private BusinessProcessService businessProcessService;
	private ModelService modelService;

	@Override
	public void startOrderCompletionProcess(final OrderModel order)
	{
		final OrderProcessModel currentOrderProcess = getLatestOrderProcess(order);

		final Collection<OrderProcessModel> orderProcesses = order.getOrderProcess();

		if (currentOrderProcess != null)
		{
			businessProcessService.restartProcess(currentOrderProcess, getRestartNode());
		}

	}

	private OrderProcessModel getLatestOrderProcess(final OrderModel order)
	{
		final List<OrderProcessModel> orderProcesses = new ArrayList<OrderProcessModel>();

		if (CollectionUtils.isNotEmpty(order.getOrderProcess()))
		{
			for (final OrderProcessModel orderProcess : order.getOrderProcess())
			{
				if (PaypalConstants.ORDER_PROCESS_NAME.equals(orderProcess.getProcessDefinitionName()))
				{
					orderProcesses.add(orderProcess);
				}
			}
			if (CollectionUtils.isNotEmpty(orderProcesses))
			{
				Collections.sort(orderProcesses, new Comparator<OrderProcessModel>()
				{
					@Override
					public int compare(final OrderProcessModel orderProcess1, final OrderProcessModel orderProcess2)
					{
						return orderProcess1.getCreationtime().compareTo(orderProcess2.getCreationtime());
					}
				});

				return orderProcesses.get(0);
			}

		}

		LOG.error("[ORDER PROCESS ERROR] Can't find any order process for order #" + order.getCode());

		return null;

	}


	private String getRestartNode()
	{
		String restartNode = configurationService.getConfiguration().getString(PaypalConstants.ORDER_PROCESS_RESTART_NODE, PaypalConstants.DEFAULT_ORDER_PROCESS_RESTART_NODE);
		if (StringUtils.isEmpty(restartNode))
		{
			restartNode = PaypalConstants.DEFAULT_ORDER_PROCESS_RESTART_NODE;
		}
		return restartNode;
	}

	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public ConfigurationService getConfigurationService()
	{
		return configurationService;
	}

	public void setConfigurationService(final ConfigurationService configurationService)
	{
		this.configurationService = configurationService;
	}
}
