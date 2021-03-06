//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KitType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}KitCommonData">
 *       &lt;sequence>
 *         &lt;element name="Members" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ItemID" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>ItemIDCommonData">
 *                           &lt;attribute name="CostInclusiveFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                           &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" default="1" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Kit" type="{http://www.nrf-arts.org/IXRetail/namespace/}KitType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KitType", propOrder = {
    "members"
})
public class KitType
    extends KitCommonData
{

    @XmlElement(name = "Members")
    protected KitType.Members members;

    /**
     * Gets the value of the members property.
     * 
     * @return
     *     possible object is
     *     {@link KitType.Members }
     *     
     */
    public KitType.Members getMembers() {
        return members;
    }

    /**
     * Sets the value of the members property.
     * 
     * @param value
     *     allowed object is
     *     {@link KitType.Members }
     *     
     */
    public void setMembers(KitType.Members value) {
        this.members = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ItemID" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>ItemIDCommonData">
     *                 &lt;attribute name="CostInclusiveFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
     *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" default="1" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Kit" type="{http://www.nrf-arts.org/IXRetail/namespace/}KitType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "itemID",
        "kit"
    })
    public static class Members {

        @XmlElement(name = "ItemID", required = true)
        protected List<KitType.Members.ItemID> itemID;
        @XmlElement(name = "Kit")
        protected KitType kit;

        /**
         * Gets the value of the itemID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the itemID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItemID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KitType.Members.ItemID }
         * 
         * 
         */
        public List<KitType.Members.ItemID> getItemID() {
            if (itemID == null) {
                itemID = new ArrayList<KitType.Members.ItemID>();
            }
            return this.itemID;
        }

        /**
         * Gets the value of the kit property.
         * 
         * @return
         *     possible object is
         *     {@link KitType }
         *     
         */
        public KitType getKit() {
            return kit;
        }

        /**
         * Sets the value of the kit property.
         * 
         * @param value
         *     allowed object is
         *     {@link KitType }
         *     
         */
        public void setKit(KitType value) {
            this.kit = value;
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
         *       &lt;attribute name="CostInclusiveFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
         *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}decimal" default="1" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ItemID
            extends ItemIDCommonData
        {

            @XmlAttribute(name = "CostInclusiveFlag")
            protected Boolean costInclusiveFlag;
            @XmlAttribute(name = "Quantity")
            protected BigDecimal quantity;

            /**
             * Gets the value of the costInclusiveFlag property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public boolean isCostInclusiveFlag() {
                if (costInclusiveFlag == null) {
                    return true;
                } else {
                    return costInclusiveFlag;
                }
            }

            /**
             * Sets the value of the costInclusiveFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setCostInclusiveFlag(Boolean value) {
                this.costInclusiveFlag = value;
            }

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

        }

    }

}
