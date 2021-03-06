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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="ItemIdentity" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemIdentityType"/>
 *           &lt;element name="ItemID" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemIDCommonData"/>
 *         &lt;/choice>
 *         &lt;element name="Price" type="{http://www.nrf-arts.org/IXRetail/namespace/}UnitPriceType" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.nrf-arts.org/IXRetail/namespace/}QuantityType"/>
 *         &lt;element name="MerchandiseHierarchy" type="{http://www.nrf-arts.org/IXRetail/namespace/}MerchandiseHierarchyType" minOccurs="0"/>
 *         &lt;element name="Points" type="{http://www.nrf-arts.org/IXRetail/namespace/}PointsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "itemIdentity",
    "itemID",
    "price",
    "quantity",
    "merchandiseHierarchy",
    "points"
})
@XmlSeeAlso({
    au.com.rejectshop.xml.store.beans.SuggestionType.Item.class
})
public class ItemType {

    @XmlElement(name = "ItemIdentity")
    protected ItemIdentityType itemIdentity;
    @XmlElement(name = "ItemID")
    protected ItemIDCommonData itemID;
    @XmlElement(name = "Price")
    protected UnitPriceType price;
    @XmlElement(name = "Quantity", required = true)
    protected QuantityType quantity;
    @XmlElement(name = "MerchandiseHierarchy")
    protected MerchandiseHierarchyType merchandiseHierarchy;
    @XmlElement(name = "Points")
    protected PointsType points;

    /**
     * Gets the value of the itemIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdentityType }
     *     
     */
    public ItemIdentityType getItemIdentity() {
        return itemIdentity;
    }

    /**
     * Sets the value of the itemIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdentityType }
     *     
     */
    public void setItemIdentity(ItemIdentityType value) {
        this.itemIdentity = value;
    }

    /**
     * Gets the value of the itemID property.
     * 
     * @return
     *     possible object is
     *     {@link ItemIDCommonData }
     *     
     */
    public ItemIDCommonData getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIDCommonData }
     *     
     */
    public void setItemID(ItemIDCommonData value) {
        this.itemID = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link UnitPriceType }
     *     
     */
    public UnitPriceType getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitPriceType }
     *     
     */
    public void setPrice(UnitPriceType value) {
        this.price = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the merchandiseHierarchy property.
     * 
     * @return
     *     possible object is
     *     {@link MerchandiseHierarchyType }
     *     
     */
    public MerchandiseHierarchyType getMerchandiseHierarchy() {
        return merchandiseHierarchy;
    }

    /**
     * Sets the value of the merchandiseHierarchy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchandiseHierarchyType }
     *     
     */
    public void setMerchandiseHierarchy(MerchandiseHierarchyType value) {
        this.merchandiseHierarchy = value;
    }

    /**
     * Gets the value of the points property.
     * 
     * @return
     *     possible object is
     *     {@link PointsType }
     *     
     */
    public PointsType getPoints() {
        return points;
    }

    /**
     * Sets the value of the points property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointsType }
     *     
     */
    public void setPoints(PointsType value) {
        this.points = value;
    }

}
