/**
 *
 */
package com.paypal.hybris.commands.strategy;

import java.math.BigDecimal;


public interface CaptureStrategy
{
	public boolean allowCapture(BigDecimal totalAmount);
}
