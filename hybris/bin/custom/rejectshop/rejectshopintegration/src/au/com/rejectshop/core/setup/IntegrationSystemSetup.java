/**
 * 
 */
package au.com.rejectshop.core.setup;

import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupParameter;

import java.util.List;

import au.com.rejectshop.core.constants.RejectshopCoreConstants;


/**
 * This class provides hooks into the system's initialization and update processes.
 * 
 * @see "https://wiki.hybris.com/display/release4/Hooks+for+Initialization+and+Update+Process"
 */

@SystemSetup(extension = RejectshopCoreConstants.EXTENSIONNAME)
public class IntegrationSystemSetup extends AbstractSystemSetup
{

	/* (non-Javadoc)
	 * @see de.hybris.platform.commerceservices.setup.AbstractSystemSetup#getInitializationOptions()
	 */
	@Override
	public List<SystemSetupParameter> getInitializationOptions()
	{
		// YTODO Auto-generated method stub
		return null;
	}

}
