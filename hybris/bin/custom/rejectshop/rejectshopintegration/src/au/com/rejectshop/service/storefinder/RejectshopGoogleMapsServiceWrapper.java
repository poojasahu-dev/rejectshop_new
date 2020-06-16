/**
 * 
 */
package au.com.rejectshop.service.storefinder;
import de.hybris.platform.storelocator.GPS;
import de.hybris.platform.storelocator.GeoWebServiceWrapper;
import de.hybris.platform.storelocator.data.AddressData;
import de.hybris.platform.storelocator.data.RouteData;
import de.hybris.platform.storelocator.exception.GeoServiceWrapperException;
import de.hybris.platform.storelocator.impl.GoogleMapTools;
import de.hybris.platform.storelocator.location.Location;
import de.hybris.platform.storelocator.route.DistanceAndRoute;
import de.hybris.platform.storelocator.route.impl.DefaultDistanceAndRoute;
import de.hybris.platform.storelocator.route.impl.DefaultRoute;
import de.hybris.platform.util.Config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class RejectshopGoogleMapsServiceWrapper implements GeoWebServiceWrapper
{

	public static final String GOOGLE_MAPS_URL = "google.maps.url";
	public static final String GOOGLE_GEOCODING_URL = "google.geocoding.url";
	private static final String GOOGLE_API_KEY="googleApiKey";
	private static final String GOOGLE_CLIENT_ID="googleClientId";
	private static final String GOOGLE_PRIVATE_KEY="googlePrivateKey";
	private GoogleMapTools googleMapTools;
	private static final Logger LOG = Logger.getLogger(RejectshopGoogleMapsServiceWrapper.class);

	private GoogleMapTools getMapTools(final String url)
	{
		this.googleMapTools.setBaseUrl(url);
		String googleApiKey=Config.getString( GOOGLE_API_KEY, (String) null);
		String googleClientID=Config.getString( GOOGLE_CLIENT_ID, (String) null);
		String googlePrivateKey=Config.getString( GOOGLE_PRIVATE_KEY, (String) null);
		LOG.info("Get geocode with url--value "+url);
		LOG.info("Google API Key "+GOOGLE_API_KEY + "--Key :"+googleApiKey);
		LOG.info("Google API Key "+GOOGLE_CLIENT_ID + "--Key :"+googleClientID);
		LOG.info("Google API Key "+GOOGLE_PRIVATE_KEY + "--Key :"+googlePrivateKey);
		this.googleMapTools.setGoogleKey(googleApiKey);
		this.googleMapTools.setCliendId(googleClientID);
		this.googleMapTools.setCryptoKey(googlePrivateKey);
		return this.googleMapTools;
	}

	@Override
	public GPS geocodeAddress(final Location address) throws GeoServiceWrapperException
	{
		final GoogleMapTools mapTools = this.getMapTools(Config.getString(GOOGLE_GEOCODING_URL, (String) null));

		return mapTools.geocodeAddress(address);
	}

	@Override
	public GPS geocodeAddress(final AddressData address) throws GeoServiceWrapperException
	{
		final GoogleMapTools mapTools = this.getMapTools(Config.getString(GOOGLE_GEOCODING_URL, (String) null));
		return mapTools.geocodeAddress(address);
	}

	@Override
	public DistanceAndRoute getDistanceAndRoute(final Location start, final Location destination) throws GeoServiceWrapperException
	{
		final GoogleMapTools geocodingModule = this.getMapTools(Config.getString(GOOGLE_MAPS_URL, (String) null));
		final RouteData routeData = geocodingModule.getDistanceAndRoute(start, destination);
		final DefaultRoute route = new DefaultRoute(start.getGPS(), destination, routeData.getCoordinates());
		return new DefaultDistanceAndRoute(routeData.getDistance(), routeData.getEagleFliesDistance(), route);
	}

	@Override
	public String formatAddress(final Location address) throws GeoServiceWrapperException
	{
		return (new GoogleMapTools()).getGoogleQuery(address.getAddressData());
	}

	@Override
	public DistanceAndRoute getDistanceAndRoute(final GPS start, final Location destination) throws GeoServiceWrapperException
	{
		final GoogleMapTools geocodingModule = this.getMapTools(Config.getString(GOOGLE_MAPS_URL, (String) null));
		final RouteData routeData = geocodingModule.getDistanceAndRoute(start, destination.getGPS());
		final DefaultRoute route = new DefaultRoute(start, destination, routeData.getCoordinates());
		return new DefaultDistanceAndRoute(routeData.getDistance(), routeData.getEagleFliesDistance(), route);
	}

	@Required
	public void setGoogleMapTools(final GoogleMapTools googleMapTools)
	{
		this.googleMapTools = googleMapTools;
	}

}
