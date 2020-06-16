package au.com.rejectshop.core.commerceservices.storefinder.impl;

import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.data.AddressData;

import de.hybris.platform.storelocator.exception.GeoLocatorException;
import de.hybris.platform.storelocator.exception.GeoServiceWrapperException;
import de.hybris.platform.storelocator.impl.GoogleMapTools;
import de.hybris.platform.util.Config;
import org.apache.log4j.Logger;
import org.springframework.web.client.ResourceAccessException;

/**
 * Created by hkhurana on 16/02/2017.
 */
public class RejectShopGoogleMapTools extends GoogleMapTools {
    private static final String GOOGLE_API_KEY = "googleApiKey";
    private static final Logger LOG = Logger.getLogger(RejectShopGoogleMapTools.class);

    @Override
    public GPS geocodeAddress(AddressData addressData) throws GeoServiceWrapperException {
        try {

            final String googleApiKey = Config.getString(GOOGLE_API_KEY, null);
            //LOG.info("RejectShopGoogleMapTools ----"+googleApiKey);
            super.setGoogleKey(googleApiKey);
            //LOG.info("addressData="+addressData);
            //LOG.info("getBuilding="+addressData.getBuilding());
            //LOG.info("getCity="+addressData.getCity());
            if(addressData.getCountryCode().equalsIgnoreCase("au")) {
                addressData.setCountryCode("Australia");
            }
            LOG.info("getCountryCode="+addressData.getCountryCode());
            //LOG.info("getName="+addressData.getName());
            //LOG.info("getStreet="+addressData.getStreet());
            //LOG.info("getZip="+addressData.getZip());
            //LOG.info("googleQuery="+super.getGoogleQuery(addressData));
            return super.geocodeAddress(addressData);
        } catch (GeoLocatorException var7) {
            LOG.error("error in RejectShopGoogleMapTools",var7);
            throw new GeoServiceWrapperException(var7);
        } catch (ResourceAccessException var8) {
            LOG.error("error in RejectShopGoogleMapTools",var8);
            throw new GeoServiceWrapperException(var8);
        }

    }

}
