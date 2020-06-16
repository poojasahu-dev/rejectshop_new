//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GroupType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TradeItemGroupIdentificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeItemGroupIdentificationDescription" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>DescriptionCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LinkItem" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>ItemIDCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Category" type="{http://www.nrf-arts.org/IXRetail/namespace/}ItemCategoryTypeCode" />
 *       &lt;attribute name="TypeCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}GroupTypeCodeEnumeration" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupType", propOrder = {
    "groupID",
    "groupType",
    "tradeItemGroupIdentificationCode",
    "tradeItemGroupIdentificationDescription",
    "linkItem",
    "productRange"
})
public class GroupType {

    @XmlElement(name = "GroupID", required = true)
    protected String groupID;
    @XmlElement(name = "GroupType", required = true)
    protected String groupType;
    @XmlElement(name = "TradeItemGroupIdentificationCode")
    protected String tradeItemGroupIdentificationCode;
    @XmlElement(name = "TradeItemGroupIdentificationDescription")
    protected GroupType.TradeItemGroupIdentificationDescription tradeItemGroupIdentificationDescription;
    @XmlElement(name = "LinkItem")
    protected List<GroupType.LinkItem> linkItem;
    @XmlElement(name = "ProductRange")
    protected String productRange;
    @XmlAttribute(name = "Category")
    protected String category;
    @XmlAttribute(name = "TypeCode")
    protected GroupTypeCodeEnumeration typeCode;

    /**
     * Gets the value of the groupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * Sets the value of the groupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupID(String value) {
        this.groupID = value;
    }

    /**
     * Gets the value of the groupType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * Sets the value of the groupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupType(String value) {
        this.groupType = value;
    }

    /**
     * Gets the value of the tradeItemGroupIdentificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeItemGroupIdentificationCode() {
        return tradeItemGroupIdentificationCode;
    }

    /**
     * Sets the value of the tradeItemGroupIdentificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeItemGroupIdentificationCode(String value) {
        this.tradeItemGroupIdentificationCode = value;
    }

    /**
     * Gets the value of the tradeItemGroupIdentificationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link GroupType.TradeItemGroupIdentificationDescription }
     *     
     */
    public GroupType.TradeItemGroupIdentificationDescription getTradeItemGroupIdentificationDescription() {
        return tradeItemGroupIdentificationDescription;
    }

    /**
     * Sets the value of the tradeItemGroupIdentificationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupType.TradeItemGroupIdentificationDescription }
     *     
     */
    public void setTradeItemGroupIdentificationDescription(GroupType.TradeItemGroupIdentificationDescription value) {
        this.tradeItemGroupIdentificationDescription = value;
    }

    /**
     * Gets the value of the linkItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupType.LinkItem }
     * 
     * 
     */
    public List<GroupType.LinkItem> getLinkItem() {
        if (linkItem == null) {
            linkItem = new ArrayList<GroupType.LinkItem>();
        }
        return this.linkItem;
    }

    /**
     * Gets the value of the productRange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductRange() {
        return productRange;
    }

    /**
     * Sets the value of the productRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductRange(String value) {
        this.productRange = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link GroupTypeCodeEnumeration }
     *     
     */
    public GroupTypeCodeEnumeration getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupTypeCodeEnumeration }
     *     
     */
    public void setTypeCode(GroupTypeCodeEnumeration value) {
        this.typeCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>ItemIDCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LinkItem
        extends ItemIDCommonData
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
    public static class TradeItemGroupIdentificationDescription
        extends DescriptionCommonData
    {


    }

}