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
 * from EAN.UCC
 * 
 * <p>Java class for OrderInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderingLeadTime" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ManufacturingLeadTime" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OrderQuantityMaximum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;totalDigits value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OrderQuantityMinimum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;totalDigits value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OrderQuantityMultiple" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;totalDigits value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OrderFrequencyProfile" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OrderSizingFactor" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OrderAvailabilityDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OrderKitFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderInformationType", propOrder = {
    "orderingLeadTime",
    "manufacturingLeadTime",
    "orderQuantityMaximum",
    "orderQuantityMinimum",
    "orderQuantityMultiple",
    "orderFrequencyProfile",
    "orderSizingFactor",
    "orderAvailabilityDate"
})
public class OrderInformationType {

    @XmlElement(name = "OrderingLeadTime")
    protected OrderInformationType.OrderingLeadTime orderingLeadTime;
    @XmlElement(name = "ManufacturingLeadTime")
    protected OrderInformationType.ManufacturingLeadTime manufacturingLeadTime;
    @XmlElement(name = "OrderQuantityMaximum")
    protected BigInteger orderQuantityMaximum;
    @XmlElement(name = "OrderQuantityMinimum")
    protected BigInteger orderQuantityMinimum;
    @XmlElement(name = "OrderQuantityMultiple")
    protected BigInteger orderQuantityMultiple;
    @XmlElement(name = "OrderFrequencyProfile")
    protected OrderInformationType.OrderFrequencyProfile orderFrequencyProfile;
    @XmlElement(name = "OrderSizingFactor")
    protected OrderInformationType.OrderSizingFactor orderSizingFactor;
    @XmlElement(name = "OrderAvailabilityDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderAvailabilityDate;
    @XmlAttribute(name = "OrderKitFlag")
    protected Boolean orderKitFlag;

    /**
     * Gets the value of the orderingLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInformationType.OrderingLeadTime }
     *     
     */
    public OrderInformationType.OrderingLeadTime getOrderingLeadTime() {
        return orderingLeadTime;
    }

    /**
     * Sets the value of the orderingLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInformationType.OrderingLeadTime }
     *     
     */
    public void setOrderingLeadTime(OrderInformationType.OrderingLeadTime value) {
        this.orderingLeadTime = value;
    }

    /**
     * Gets the value of the manufacturingLeadTime property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInformationType.ManufacturingLeadTime }
     *     
     */
    public OrderInformationType.ManufacturingLeadTime getManufacturingLeadTime() {
        return manufacturingLeadTime;
    }

    /**
     * Sets the value of the manufacturingLeadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInformationType.ManufacturingLeadTime }
     *     
     */
    public void setManufacturingLeadTime(OrderInformationType.ManufacturingLeadTime value) {
        this.manufacturingLeadTime = value;
    }

    /**
     * Gets the value of the orderQuantityMaximum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderQuantityMaximum() {
        return orderQuantityMaximum;
    }

    /**
     * Sets the value of the orderQuantityMaximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderQuantityMaximum(BigInteger value) {
        this.orderQuantityMaximum = value;
    }

    /**
     * Gets the value of the orderQuantityMinimum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderQuantityMinimum() {
        return orderQuantityMinimum;
    }

    /**
     * Sets the value of the orderQuantityMinimum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderQuantityMinimum(BigInteger value) {
        this.orderQuantityMinimum = value;
    }

    /**
     * Gets the value of the orderQuantityMultiple property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderQuantityMultiple() {
        return orderQuantityMultiple;
    }

    /**
     * Sets the value of the orderQuantityMultiple property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderQuantityMultiple(BigInteger value) {
        this.orderQuantityMultiple = value;
    }

    /**
     * Gets the value of the orderFrequencyProfile property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInformationType.OrderFrequencyProfile }
     *     
     */
    public OrderInformationType.OrderFrequencyProfile getOrderFrequencyProfile() {
        return orderFrequencyProfile;
    }

    /**
     * Sets the value of the orderFrequencyProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInformationType.OrderFrequencyProfile }
     *     
     */
    public void setOrderFrequencyProfile(OrderInformationType.OrderFrequencyProfile value) {
        this.orderFrequencyProfile = value;
    }

    /**
     * Gets the value of the orderSizingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInformationType.OrderSizingFactor }
     *     
     */
    public OrderInformationType.OrderSizingFactor getOrderSizingFactor() {
        return orderSizingFactor;
    }

    /**
     * Sets the value of the orderSizingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInformationType.OrderSizingFactor }
     *     
     */
    public void setOrderSizingFactor(OrderInformationType.OrderSizingFactor value) {
        this.orderSizingFactor = value;
    }

    /**
     * Gets the value of the orderAvailabilityDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderAvailabilityDate() {
        return orderAvailabilityDate;
    }

    /**
     * Sets the value of the orderAvailabilityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderAvailabilityDate(XMLGregorianCalendar value) {
        this.orderAvailabilityDate = value;
    }

    /**
     * Gets the value of the orderKitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOrderKitFlag() {
        if (orderKitFlag == null) {
            return false;
        } else {
            return orderKitFlag;
        }
    }

    /**
     * Sets the value of the orderKitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrderKitFlag(Boolean value) {
        this.orderKitFlag = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ManufacturingLeadTime
        extends MeasurementCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OrderFrequencyProfile
        extends MeasurementCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OrderSizingFactor
        extends MeasurementCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OrderingLeadTime
        extends MeasurementCommonData
    {


    }

}
