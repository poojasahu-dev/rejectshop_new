//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved 20050228 from EAN.UCC
 * 
 * <p>Java class for TemperatureInformationCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemperatureInformationCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeliveryToDistributionCenter" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DeliveryToMarket" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="StorageHandling" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemperatureInformationCommonData", propOrder = {
    "deliveryToDistributionCenter",
    "deliveryToMarket",
    "storageHandling"
})
public class TemperatureInformationCommonData {

    @XmlElement(name = "DeliveryToDistributionCenter")
    protected TemperatureInformationCommonData.DeliveryToDistributionCenter deliveryToDistributionCenter;
    @XmlElement(name = "DeliveryToMarket")
    protected TemperatureInformationCommonData.DeliveryToMarket deliveryToMarket;
    @XmlElement(name = "StorageHandling")
    protected TemperatureInformationCommonData.StorageHandling storageHandling;

    /**
     * Gets the value of the deliveryToDistributionCenter property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureInformationCommonData.DeliveryToDistributionCenter }
     *     
     */
    public TemperatureInformationCommonData.DeliveryToDistributionCenter getDeliveryToDistributionCenter() {
        return deliveryToDistributionCenter;
    }

    /**
     * Sets the value of the deliveryToDistributionCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureInformationCommonData.DeliveryToDistributionCenter }
     *     
     */
    public void setDeliveryToDistributionCenter(TemperatureInformationCommonData.DeliveryToDistributionCenter value) {
        this.deliveryToDistributionCenter = value;
    }

    /**
     * Gets the value of the deliveryToMarket property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureInformationCommonData.DeliveryToMarket }
     *     
     */
    public TemperatureInformationCommonData.DeliveryToMarket getDeliveryToMarket() {
        return deliveryToMarket;
    }

    /**
     * Sets the value of the deliveryToMarket property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureInformationCommonData.DeliveryToMarket }
     *     
     */
    public void setDeliveryToMarket(TemperatureInformationCommonData.DeliveryToMarket value) {
        this.deliveryToMarket = value;
    }

    /**
     * Gets the value of the storageHandling property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureInformationCommonData.StorageHandling }
     *     
     */
    public TemperatureInformationCommonData.StorageHandling getStorageHandling() {
        return storageHandling;
    }

    /**
     * Sets the value of the storageHandling property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureInformationCommonData.StorageHandling }
     *     
     */
    public void setStorageHandling(TemperatureInformationCommonData.StorageHandling value) {
        this.storageHandling = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DeliveryToDistributionCenter
        extends TemperatureCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DeliveryToMarket
        extends TemperatureCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}TemperatureCommonData">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class StorageHandling
        extends TemperatureCommonData
    {


    }

}