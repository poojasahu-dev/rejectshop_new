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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Conditionally Approved 20050228 - Members (items) are added in the
 *                 complex type that extends this common dataf  LOOK INTO EXTENDING ITEM FOR
 *             THIS
 * 
 * <p>Java class for KitCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KitCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KitID" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemIDCommonData" minOccurs="0" form="qualified"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="Description" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>DescriptionCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Action" type="{http://www.nrf-arts.org/IXRetail/namespace/}KitActionTypeCode" default="IsPartOf" />
 *       &lt;attribute name="ModifiableFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KitCommonData", propOrder = {
    "kitID",
    "name",
    "description"
})
public class KitCommonData {

    @XmlElement(name = "KitID")
    protected ItemIDCommonData kitID;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected KitCommonData.Description description;
    @XmlAttribute(name = "Action")
    protected String action;
    @XmlAttribute(name = "ModifiableFlag")
    protected Boolean modifiableFlag;

    /**
     * Gets the value of the kitID property.
     * 
     * @return
     *     possible object is
     *     {@link ItemIDCommonData }
     *     
     */
    public ItemIDCommonData getKitID() {
        return kitID;
    }

    /**
     * Sets the value of the kitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIDCommonData }
     *     
     */
    public void setKitID(ItemIDCommonData value) {
        this.kitID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link KitCommonData.Description }
     *     
     */
    public KitCommonData.Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link KitCommonData.Description }
     *     
     */
    public void setDescription(KitCommonData.Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        if (action == null) {
            return "IsPartOf";
        } else {
            return action;
        }
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the modifiableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isModifiableFlag() {
        if (modifiableFlag == null) {
            return true;
        } else {
            return modifiableFlag;
        }
    }

    /**
     * Sets the value of the modifiableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setModifiableFlag(Boolean value) {
        this.modifiableFlag = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>DescriptionCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Description
        extends DescriptionCommonData
    {


    }

}