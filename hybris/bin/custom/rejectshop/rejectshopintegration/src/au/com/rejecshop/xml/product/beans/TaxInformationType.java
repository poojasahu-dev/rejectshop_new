//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * from EAN.UCC
 * 
 * <p>Java class for TaxInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxInformationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TaxCommonData">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="TaxExemptCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxInformationType", propOrder = {
    "taxExemptCode"
})
public class TaxInformationType
    extends TaxCommonData
{

    @XmlElement(name = "TaxExemptCode")
    protected String taxExemptCode;

    /**
     * Gets the value of the taxExemptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxExemptCode() {
        return taxExemptCode;
    }

    /**
     * Sets the value of the taxExemptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxExemptCode(String value) {
        this.taxExemptCode = value;
    }

}
