/**
 *
 *By default, all orders were captured automatically using payment’s CapturingCommand. To allow developers to change that behavior we’ve introduced com.paypal.hybris.commands.strategy.CapturingStrategy as it allows to demonstrate both immediate and delayed capturing.
After add-on is installed the default payment strategy is now the following:
1. Express Checkout ends with Authorization of payment
2. Orders with Order Total less than 100 in currency of purchase are captured immediately after checkout is finished.
3. Orders exceeding the threshold of 100 are not captured automatically. They should be captured with cronjob.
 */
package com.paypal.hybris.commands.strategy.impl;


import de.hybris.platform.servicelayer.config.ConfigurationService;

import java.math.BigDecimal;

import com.paypal.hybris.commands.strategy.CaptureStrategy;


public class DefaultCaptureStrategy implements CaptureStrategy
{
	private ConfigurationService configurationService;

    @Override
    public boolean allowCapture(final BigDecimal requestTotalAmount) {
        return true;
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
