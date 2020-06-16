/**
 *
 */
package au.com.rejectshop.facades.component.data;

import de.hybris.platform.commercefacades.product.data.ImageData;

import java.util.List;
import java.util.Map;


/**
 *
 *
 */
public class REJRotatingComponentData
{

	private String linkUrl;
	private String linkUrlText;
	private Map<String, ImageData> imageMap;
	private Integer order;
	private List restrictions;


	/**
	 * @return the restrictions
	 */
	public List getRestrictions()
	{
		return restrictions;
	}

	/**
	 * @param restrictions
	 *           the restrictions to set
	 */
	public void setRestrictions(final List restrictions)
	{
		this.restrictions = restrictions;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder()
	{
		return order;
	}

	/**
	 * @param order
	 *           the order to set
	 */
	public void setOrder(final Integer order)
	{
		this.order = order;
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl()
	{
		return linkUrl;
	}

	/**
	 * @param linkUrl
	 *           the linkUrl to set
	 */
	public void setLinkUrl(final String linkUrl)
	{
		this.linkUrl = linkUrl;
	}

	/**
	 * @return the linkUrlText
	 */
	public String getLinkUrlText()
	{
		return linkUrlText;
	}

	/**
	 * @param linkUrlText
	 *           the linkUrlText to set
	 */
	public void setLinkUrlText(final String linkUrlText)
	{
		this.linkUrlText = linkUrlText;
	}

	/**
	 * @return the imageMap
	 */
	public Map<String, ImageData> getImageMap()
	{
		return imageMap;
	}

	/**
	 * @param imageMap
	 *           the imageMap to set
	 */
	public void setImageMap(final Map<String, ImageData> imageMap)
	{
		this.imageMap = imageMap;
	}


}
