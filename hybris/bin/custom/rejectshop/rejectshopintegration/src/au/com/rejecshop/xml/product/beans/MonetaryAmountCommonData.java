//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MonetaryAmountCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MonetaryAmountCommonData">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonetaryAmountCommonData")
@XmlSeeAlso({
    au.com.rejecshop.xml.product.beans.ItemType.RestockingFee.class,
    UnitPriceCommonData.class,
    au.com.rejecshop.xml.product.beans.AlternativeItemType.AdjustmentAmount.class,
    au.com.rejecshop.xml.product.beans.TaxCommonData.TaxableAmount.class,
    au.com.rejecshop.xml.product.beans.TaxCommonData.TaxAmount.class
})
public class MonetaryAmountCommonData
    extends AmountCommonData
{


}