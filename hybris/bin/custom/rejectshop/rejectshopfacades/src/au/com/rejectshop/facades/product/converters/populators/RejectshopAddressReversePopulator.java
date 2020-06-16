/**
 *
 */
package au.com.rejectshop.facades.product.converters.populators;

import de.hybris.platform.commercefacades.user.converters.populator.AddressReversePopulator;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.core.model.user.AddressModel;


/**
 * @author venkatapavani.t
 *
 */
public class RejectshopAddressReversePopulator extends AddressReversePopulator
{
	/**
	 * Populate.
	 *
	 * @param addressData
	 *           the address data
	 * @param addressModel
	 *           the address model
	 */
	@Override
	public void populate(final AddressData addressData, final AddressModel addressModel)
	{
		addressModel.setState(addressData.getState());

		super.populate(addressData, addressModel);
	}

}
