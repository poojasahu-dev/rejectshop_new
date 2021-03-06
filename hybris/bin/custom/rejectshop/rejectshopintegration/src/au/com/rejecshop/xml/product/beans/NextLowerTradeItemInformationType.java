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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * from EAN.UCC - Relates to packaging
 * 
 * <p>Java class for NextLowerTradeItemInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NextLowerTradeItemInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalQuantityOfNextLowerTradeItem" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NextLowerTradeItemInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChildTradeItem" type="{http://www.nrf-arts.org/IXRetail/namespace/}ChildOfTradeItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NextLowerTradeItemInformationType", propOrder = {
    "totalQuantityOfNextLowerTradeItem",
    "nextLowerTradeItemInformation",
    "childTradeItem"
})
public class NextLowerTradeItemInformationType {

    @XmlElement(name = "TotalQuantityOfNextLowerTradeItem", required = true)
    protected BigDecimal totalQuantityOfNextLowerTradeItem;
    @XmlElement(name = "NextLowerTradeItemInformation", required = true)
    protected String nextLowerTradeItemInformation;
    @XmlElement(name = "ChildTradeItem", required = true)
    protected List<ChildOfTradeItem> childTradeItem;

    /**
     * Gets the value of the totalQuantityOfNextLowerTradeItem property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalQuantityOfNextLowerTradeItem() {
        return totalQuantityOfNextLowerTradeItem;
    }

    /**
     * Sets the value of the totalQuantityOfNextLowerTradeItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalQuantityOfNextLowerTradeItem(BigDecimal value) {
        this.totalQuantityOfNextLowerTradeItem = value;
    }

    /**
     * Gets the value of the nextLowerTradeItemInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextLowerTradeItemInformation() {
        return nextLowerTradeItemInformation;
    }

    /**
     * Sets the value of the nextLowerTradeItemInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextLowerTradeItemInformation(String value) {
        this.nextLowerTradeItemInformation = value;
    }

    /**
     * Gets the value of the childTradeItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childTradeItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildTradeItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChildOfTradeItem }
     * 
     * 
     */
    public List<ChildOfTradeItem> getChildTradeItem() {
        if (childTradeItem == null) {
            childTradeItem = new ArrayList<ChildOfTradeItem>();
        }
        return this.childTradeItem;
    }

}
