package com.paypal.hybris.converters;

import de.hybris.platform.converters.impl.AbstractPopulatingConverter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.ebay.utils.PaypalStringUtils;
import com.paypal.hybris.constants.PaypalConstants;
import com.paypal.hybris.data.AbstractResultData;
import com.paypal.hybris.data.ResultErrorData;
import com.paypal.hybris.data.SeverityCode;

import urn.ebay.apis.eBLBaseComponents.AbstractResponseType;
import urn.ebay.apis.eBLBaseComponents.ErrorType;


public abstract class AbstractResultConverter<SOURCE extends AbstractResponseType, TARGET extends AbstractResultData>
		extends AbstractPopulatingConverter<SOURCE, TARGET>
{

	/**
	 * Populate the target instance from the source instance. Calls a list of injected populators to populate the
	 * instance.
	 *
	 * @param response
	 *           the source item
	 * @param resultData
	 */
	@Override
	public void populate(final SOURCE response, final TARGET resultData)
	{
		resultData.setBuild(response.getBuild());
		resultData.setVersion(response.getVersion());
		resultData.setCorrelationId(response.getCorrelationID());
		resultData.setDateTime(PaypalStringUtils.getCalendarFromResponse(response.getTimestamp()));
		resultData.setErrors(new ArrayList<ResultErrorData>());
		resultData.setAck(response.getAck().getValue());

		final List<ResultErrorData> errorsData = resultData.getErrors();
		final List<String> errorMessagesList = new ArrayList<>();
		resultData.setErrorMessagesList(errorMessagesList);
		final List<ErrorType> errors = response.getErrors();
		if (CollectionUtils.isNotEmpty(errors))
		{
			for (final ErrorType error : errors)
			{
				final ResultErrorData errorData = new ResultErrorData();
				errorData.setErrorCode(error.getErrorCode());
				errorData.setShortMessage(error.getShortMessage());
				errorData.setLongMessage(error.getLongMessage());

				final StringBuilder errorMessageBuilder = new StringBuilder();
				errorMessageBuilder.append(error.getErrorCode()).append(PaypalConstants.ERROR_MESSAGE_CODE_SEPARATOR);
				errorMessageBuilder.append(error.getShortMessage()).append(PaypalConstants.ERROR_MESSAGE_SHORT_MESSAGE_SEPARATOR);
				errorMessageBuilder.append(error.getLongMessage());
				errorMessagesList.add(errorMessageBuilder.toString());

				final String severityCodeValue = error.getSeverityCode().getValue().toUpperCase();
				errorData.setSeverityCode(SeverityCode.valueOf(severityCodeValue));

				errorsData.add(errorData);
			}
		}

		super.populate(response, resultData);
	}
}
