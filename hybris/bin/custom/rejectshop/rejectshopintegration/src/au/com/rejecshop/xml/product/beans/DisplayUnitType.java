//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DisplayUnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisplayUnitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShelfItemsHeldCapacityCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="SetupDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TakeDownDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TypeCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}DisplayUnitTypeCode" />
 *       &lt;attribute name="DispositionCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}DispositionTypeCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayUnitType", propOrder = {
    "shelfItemsHeldCapacityCount",
    "setupDate",
    "takeDownDate"
})
public class DisplayUnitType {

    @XmlElement(name = "ShelfItemsHeldCapacityCount", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger shelfItemsHeldCapacityCount;
    @XmlElement(name = "SetupDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar setupDate;
    @XmlElement(name = "TakeDownDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar takeDownDate;
    @XmlAttribute(name = "TypeCode")
    protected String typeCode;
    @XmlAttribute(name = "DispositionCode")
    protected String dispositionCode;

    /**
     * Gets the value of the shelfItemsHeldCapacityCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getShelfItemsHeldCapacityCount() {
        return shelfItemsHeldCapacityCount;
    }

    /**
     * Sets the value of the shelfItemsHeldCapacityCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setShelfItemsHeldCapacityCount(BigInteger value) {
        this.shelfItemsHeldCapacityCount = value;
    }

    /**
     * Gets the value of the setupDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSetupDate() {
        return setupDate;
    }

    /**
     * Sets the value of the setupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSetupDate(XMLGregorianCalendar value) {
        this.setupDate = value;
    }

    /**
     * Gets the value of the takeDownDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTakeDownDate() {
        return takeDownDate;
    }

    /**
     * Sets the value of the takeDownDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTakeDownDate(XMLGregorianCalendar value) {
        this.takeDownDate = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the dispositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispositionCode() {
        return dispositionCode;
    }

    /**
     * Sets the value of the dispositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispositionCode(String value) {
        this.dispositionCode = value;
    }

}
