/**
 *
 */
package au.com.rejectshop.facades.promotion.price.impl;

import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade;


/**
 * @author saisravan.k
 * 
 */
public class DefaultPromotionDataPriceFacade implements PromotionDataPriceFacade
{
	/**
	 * 
	 */
	private static final String _9999 = "9999";

	@Resource
	private CommonI18NService commonI18NService;

	private static final Logger LOG = Logger.getLogger(DefaultPromotionDataPriceFacade.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.com.rejectshop.facades.promotion.price.PromotionDataPriceFacade#setPricePromotionData(de.hybris.platform.
	 * commercefacades.product.data.ProductData, de.hybris.platform.core.model.product.ProductModel)
	 */

	public void setPricePromotionData(final ProductData productData, final ProductModel productModel)
	{
		final PriceData priceDataProduct = new PriceData();
		final List<PriceRowModel> priceRows = (List<PriceRowModel>) productModel.getEurope1Prices();
		final Date todayDataTime = new Date();
		final SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy");
		PriceRowModel basePrice = null;
		final List<PriceRowModel> futurePrices = new ArrayList<PriceRowModel>();
		if (priceRows.size() > 1)
		{
			for (final PriceRowModel priceRow : priceRows)
			{
				final Date endTime = priceRow.getEndTime();
				if (_9999.equalsIgnoreCase(simpledateFormat.format(endTime)))
				{
					basePrice = priceRow;
				}
				else
				{
					futurePrices.add(priceRow);
				}
			}
			for (final PriceRowModel futurePrice : futurePrices)
			{
				final Date startDate = futurePrice.getStartTime();
				final Date endDate = futurePrice.getEndTime();
				if (null != startDate && null != endDate)
				{
					if ((todayDataTime.compareTo(startDate) >= 0) && (endDate.compareTo(todayDataTime) >= 0))
					{
						if (Double.compare(futurePrice.getPrice().doubleValue(), basePrice.getPrice().doubleValue()) < 0)
						{
							if (null != productData.getPrice())
							{
								productData.getPrice().setValue(BigDecimal.valueOf((futurePrice.getPrice().doubleValue())));
								productData.getPrice().setFormattedValue(
										commonI18NService.getCurrentCurrency().getSymbol()
												+ " "
												+ BigDecimal.valueOf((futurePrice.getPrice().doubleValue()))
														.setScale(2, RoundingMode.HALF_EVEN).toString());
							}
							else
							{
								priceDataProduct.setValue(BigDecimal.valueOf((futurePrice.getPrice().doubleValue())));
								priceDataProduct.setFormattedValue(commonI18NService.getCurrentCurrency().getSymbol()
										+ " "
										+ BigDecimal.valueOf((futurePrice.getPrice().doubleValue())).setScale(2, RoundingMode.HALF_EVEN)
												.toString());
								productData.setPrice(priceDataProduct);
							}

						}
					}
				}
				else
				{
					LOG.info("Start date or end date of a price row can not be null");
				}
			}
		}


	}

}
