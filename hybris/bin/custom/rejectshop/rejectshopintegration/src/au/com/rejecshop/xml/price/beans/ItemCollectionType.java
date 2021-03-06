//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemCollectionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.nrf-arts.org/IXRetail/namespace/}DescriptionCommonDataExtension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LongDescription" type="{http://www.nrf-arts.org/IXRetail/namespace/}LongDescriptionCommonDataExtension" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;choice>
 *             &lt;element name="ItemID" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemIDCommonDataExtension"/>
 *             &lt;element name="ItemCollection" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemCollectionType"/>
 *           &lt;/choice>
 *           &lt;element name="Quantity" type="{http://www.nrf-arts.org/IXRetail/namespace/}QuantityCommonDataExtension" minOccurs="0"/>
 *           &lt;element name="ItemQualification" type="{http://www.nrf-arts.org/IXRetail/namespace/}QualificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="Operator" type="{http://www.nrf-arts.org/IXRetail/namespace/}LogicalOperatorType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemCollectionType", propOrder = {
    "itemCollectionID",
    "description",
    "longDescription",
    "itemIDOrItemCollectionAndQuantity"
})
public class ItemCollectionType {

    @XmlElement(name = "ItemCollectionID")
    protected String itemCollectionID;
    @XmlElement(name = "Description")
    protected List<DescriptionCommonDataExtension> description;
    @XmlElement(name = "LongDescription")
    protected List<LongDescriptionCommonDataExtension> longDescription;
    @XmlElements({
        @XmlElement(name = "Quantity", type = QuantityCommonDataExtension.class),
        @XmlElement(name = "ItemID", type = ItemIDCommonDataExtension.class),
        @XmlElement(name = "ItemCollection", type = ItemCollectionType.class),
        @XmlElement(name = "ItemQualification", type = QualificationType.class)
    })
    protected List<Object> itemIDOrItemCollectionAndQuantity;
    @XmlAttribute(name = "Operator")
    protected String operator;

    /**
     * Gets the value of the itemCollectionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCollectionID() {
        return itemCollectionID;
    }

    /**
     * Sets the value of the itemCollectionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCollectionID(String value) {
        this.itemCollectionID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionCommonDataExtension }
     * 
     * 
     */
    public List<DescriptionCommonDataExtension> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionCommonDataExtension>();
        }
        return this.description;
    }

    /**
     * Gets the value of the longDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the longDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLongDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LongDescriptionCommonDataExtension }
     * 
     * 
     */
    public List<LongDescriptionCommonDataExtension> getLongDescription() {
        if (longDescription == null) {
            longDescription = new ArrayList<LongDescriptionCommonDataExtension>();
        }
        return this.longDescription;
    }

    /**
     * Gets the value of the itemIDOrItemCollectionAndQuantity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemIDOrItemCollectionAndQuantity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemIDOrItemCollectionAndQuantity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantityCommonDataExtension }
     * {@link ItemIDCommonDataExtension }
     * {@link ItemCollectionType }
     * {@link QualificationType }
     * 
     * 
     */
    public List<Object> getItemIDOrItemCollectionAndQuantity() {
        if (itemIDOrItemCollectionAndQuantity == null) {
            itemIDOrItemCollectionAndQuantity = new ArrayList<Object>();
        }
        return this.itemIDOrItemCollectionAndQuantity;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

}
