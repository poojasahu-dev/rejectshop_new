//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved
 * 
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
    MonetaryAmountType.class,
    FeeCommonData.class,
    au.com.rejectshop.xml.store.beans.PriceModifierCommonData.Amount.class,
    au.com.rejectshop.xml.store.beans.GiftCertificateCommonData.FaceValue.class,
    au.com.rejectshop.xml.store.beans.OrderInformationExtType.OrderValueMaximum.class,
    au.com.rejectshop.xml.store.beans.OrderInformationExtType.OrderValueMinimum.class,
    UnitPriceCommonData.class,
    au.com.rejectshop.xml.store.beans.TaxCommonData.TaxableAmount.class,
    au.com.rejectshop.xml.store.beans.TaxCommonData.TaxAmount.class,
    au.com.rejectshop.xml.store.beans.TaxExemptCommonData.ExemptTaxableAmount.class,
    au.com.rejectshop.xml.store.beans.TaxExemptCommonData.ExemptTaxAmount.class,
    au.com.rejectshop.xml.store.beans.TaxOverrideCommonData.TaxableAmount.class,
    au.com.rejectshop.xml.store.beans.TaxOverrideCommonData.OriginalTaxAmount.class,
    au.com.rejectshop.xml.store.beans.TaxOverrideCommonData.NewTaxAmount.class
})
public class MonetaryAmountCommonData
    extends AmountCommonData
{


}
