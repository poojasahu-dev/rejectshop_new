//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved
 * 
 * <p>Java class for UnitPriceCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnitPriceCommonData">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MonetaryAmountCommonData">
 *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" default="1" />
 *       &lt;attribute name="UnitOfMeasureCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}UnitOfMeasureCodeCommonData" default="EA" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitPriceCommonData")
@XmlSeeAlso({
    PriceCommonData.class
})
public class UnitPriceCommonData
    extends MonetaryAmountCommonData
{

    @XmlAttribute(name = "Quantity")
    protected BigDecimal quantity;
    @XmlAttribute(name = "UnitOfMeasureCode")
    protected String unitOfMeasureCode;

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantity() {
        if (quantity == null) {
            return new BigDecimal("1");
        } else {
            return quantity;
        }
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitOfMeasureCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureCode() {
        if (unitOfMeasureCode == null) {
            return "EA";
        } else {
            return unitOfMeasureCode;
        }
    }

    /**
     * Sets the value of the unitOfMeasureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureCode(String value) {
        this.unitOfMeasureCode = value;
    }

}
