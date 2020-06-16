/**
 *
 */
package au.com.rejectshop.facades.product.converters.populators;

import de.hybris.platform.commercefacades.user.converters.populator.AddressPopulator;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.core.model.user.AddressModel;


/**
 * @author venkatapavani.t
 *
 */
public class RejectshopAddressPopulator extends AddressPopulator
{
	@Override
	public void populate(final AddressModel source, final AddressData target)
	{
		if (target != null)
		{
			target.setState(source.getState());

			super.populate(source, target);
		}

	}
}
