//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved
 * 
 * <p>Java class for PriceCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceCommonData">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>UnitPriceCommonData">
 *       &lt;attribute name="ValueTypeCode" use="required" type="{http://www.nrf-arts.org/IXRetail/namespace/}PriceTypeCode" />
 *       &lt;attribute name="TaxIncludedInPriceFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="PriceOverrideFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="QuantityPricingFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceCommonData")
public class PriceCommonData
    extends UnitPriceCommonData
{

    @XmlAttribute(name = "ValueTypeCode", required = true)
    protected String valueTypeCode;
    @XmlAttribute(name = "TaxIncludedInPriceFlag")
    protected Boolean taxIncludedInPriceFlag;
    @XmlAttribute(name = "PriceOverrideFlag")
    protected Boolean priceOverrideFlag;
    @XmlAttribute(name = "QuantityPricingFlag")
    protected Boolean quantityPricingFlag;

    /**
     * Gets the value of the valueTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueTypeCode() {
        return valueTypeCode;
    }

    /**
     * Sets the value of the valueTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueTypeCode(String value) {
        this.valueTypeCode = value;
    }

    /**
     * Gets the value of the taxIncludedInPriceFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTaxIncludedInPriceFlag() {
        if (taxIncludedInPriceFlag == null) {
            return false;
        } else {
            return taxIncludedInPriceFlag;
        }
    }

    /**
     * Sets the value of the taxIncludedInPriceFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxIncludedInPriceFlag(Boolean value) {
        this.taxIncludedInPriceFlag = value;
    }

    /**
     * Gets the value of the priceOverrideFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isPriceOverrideFlag() {
        if (priceOverrideFlag == null) {
            return true;
        } else {
            return priceOverrideFlag;
        }
    }

    /**
     * Sets the value of the priceOverrideFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPriceOverrideFlag(Boolean value) {
        this.priceOverrideFlag = value;
    }

    /**
     * Gets the value of the quantityPricingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isQuantityPricingFlag() {
        if (quantityPricingFlag == null) {
            return false;
        } else {
            return quantityPricingFlag;
        }
    }

    /**
     * Sets the value of the quantityPricingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQuantityPricingFlag(Boolean value) {
        this.quantityPricingFlag = value;
    }

}