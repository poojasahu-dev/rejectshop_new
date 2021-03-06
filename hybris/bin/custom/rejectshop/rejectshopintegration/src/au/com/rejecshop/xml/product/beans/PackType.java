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


/**
 * <p>Java class for PackType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitNumberCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="PackVolume">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PackWeight">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PackMeasurements" type="{http://www.nrf-arts.org/IXRetail/namespace/}MeasurementsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PackMethod" type="{http://www.nrf-arts.org/IXRetail/namespace/}PackMethodCodes" default="Flat" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackType", propOrder = {
    "unitNumberCount",
    "packVolume",
    "packWeight",
    "packMeasurements"
})
public class PackType {

    @XmlElement(name = "UnitNumberCount", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger unitNumberCount;
    @XmlElement(name = "PackVolume", required = true)
    protected PackType.PackVolume packVolume;
    @XmlElement(name = "PackWeight", required = true)
    protected PackType.PackWeight packWeight;
    @XmlElement(name = "PackMeasurements")
    protected MeasurementsType packMeasurements;
    @XmlAttribute(name = "PackMethod")
    protected String packMethod;

    /**
     * Gets the value of the unitNumberCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnitNumberCount() {
        return unitNumberCount;
    }

    /**
     * Sets the value of the unitNumberCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnitNumberCount(BigInteger value) {
        this.unitNumberCount = value;
    }

    /**
     * Gets the value of the packVolume property.
     * 
     * @return
     *     possible object is
     *     {@link PackType.PackVolume }
     *     
     */
    public PackType.PackVolume getPackVolume() {
        return packVolume;
    }

    /**
     * Sets the value of the packVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackType.PackVolume }
     *     
     */
    public void setPackVolume(PackType.PackVolume value) {
        this.packVolume = value;
    }

    /**
     * Gets the value of the packWeight property.
     * 
     * @return
     *     possible object is
     *     {@link PackType.PackWeight }
     *     
     */
    public PackType.PackWeight getPackWeight() {
        return packWeight;
    }

    /**
     * Sets the value of the packWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackType.PackWeight }
     *     
     */
    public void setPackWeight(PackType.PackWeight value) {
        this.packWeight = value;
    }

    /**
     * Gets the value of the packMeasurements property.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementsType }
     *     
     */
    public MeasurementsType getPackMeasurements() {
        return packMeasurements;
    }

    /**
     * Sets the value of the packMeasurements property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementsType }
     *     
     */
    public void setPackMeasurements(MeasurementsType value) {
        this.packMeasurements = value;
    }

    /**
     * Gets the value of the packMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackMethod() {
        if (packMethod == null) {
            return "Flat";
        } else {
            return packMethod;
        }
    }

    /**
     * Sets the value of the packMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackMethod(String value) {
        this.packMethod = value;
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
    public static class PackVolume
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
    public static class PackWeight
        extends MeasurementCommonData
    {


    }

}
