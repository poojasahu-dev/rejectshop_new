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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PreparedItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PreparedItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FoodItemHoldingTime" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="CookingMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IngredientMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NutritionalMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DegreeOfOriginalWort" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FatPercentageInDryMatter" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PercentageOfAlcoholByVolume" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ItemGeneticallyModifiedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="ItemIrradiatedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="IngredientIrradiatedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="RawMaterialirradiatedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreparedItemType", propOrder = {
    "foodItemHoldingTime",
    "cookingMessage",
    "ingredientMessage",
    "nutritionalMessage",
    "degreeOfOriginalWort",
    "fatPercentageInDryMatter",
    "percentageOfAlcoholByVolume"
})
public class PreparedItemType {

    @XmlElement(name = "FoodItemHoldingTime")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar foodItemHoldingTime;
    @XmlElement(name = "CookingMessage")
    protected List<String> cookingMessage;
    @XmlElement(name = "IngredientMessage")
    protected List<String> ingredientMessage;
    @XmlElement(name = "NutritionalMessage")
    protected List<String> nutritionalMessage;
    @XmlElement(name = "DegreeOfOriginalWort")
    protected BigDecimal degreeOfOriginalWort;
    @XmlElement(name = "FatPercentageInDryMatter")
    protected BigDecimal fatPercentageInDryMatter;
    @XmlElement(name = "PercentageOfAlcoholByVolume")
    protected BigDecimal percentageOfAlcoholByVolume;
    @XmlAttribute(name = "ItemGeneticallyModifiedFlag")
    protected Boolean itemGeneticallyModifiedFlag;
    @XmlAttribute(name = "ItemIrradiatedFlag")
    protected Boolean itemIrradiatedFlag;
    @XmlAttribute(name = "IngredientIrradiatedFlag")
    protected Boolean ingredientIrradiatedFlag;
    @XmlAttribute(name = "RawMaterialirradiatedFlag")
    protected Boolean rawMaterialirradiatedFlag;

    /**
     * Gets the value of the foodItemHoldingTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFoodItemHoldingTime() {
        return foodItemHoldingTime;
    }

    /**
     * Sets the value of the foodItemHoldingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFoodItemHoldingTime(XMLGregorianCalendar value) {
        this.foodItemHoldingTime = value;
    }

    /**
     * Gets the value of the cookingMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cookingMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCookingMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCookingMessage() {
        if (cookingMessage == null) {
            cookingMessage = new ArrayList<String>();
        }
        return this.cookingMessage;
    }

    /**
     * Gets the value of the ingredientMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ingredientMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIngredientMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIngredientMessage() {
        if (ingredientMessage == null) {
            ingredientMessage = new ArrayList<String>();
        }
        return this.ingredientMessage;
    }

    /**
     * Gets the value of the nutritionalMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nutritionalMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNutritionalMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNutritionalMessage() {
        if (nutritionalMessage == null) {
            nutritionalMessage = new ArrayList<String>();
        }
        return this.nutritionalMessage;
    }

    /**
     * Gets the value of the degreeOfOriginalWort property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDegreeOfOriginalWort() {
        return degreeOfOriginalWort;
    }

    /**
     * Sets the value of the degreeOfOriginalWort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDegreeOfOriginalWort(BigDecimal value) {
        this.degreeOfOriginalWort = value;
    }

    /**
     * Gets the value of the fatPercentageInDryMatter property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFatPercentageInDryMatter() {
        return fatPercentageInDryMatter;
    }

    /**
     * Sets the value of the fatPercentageInDryMatter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFatPercentageInDryMatter(BigDecimal value) {
        this.fatPercentageInDryMatter = value;
    }

    /**
     * Gets the value of the percentageOfAlcoholByVolume property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentageOfAlcoholByVolume() {
        return percentageOfAlcoholByVolume;
    }

    /**
     * Sets the value of the percentageOfAlcoholByVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentageOfAlcoholByVolume(BigDecimal value) {
        this.percentageOfAlcoholByVolume = value;
    }

    /**
     * Gets the value of the itemGeneticallyModifiedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isItemGeneticallyModifiedFlag() {
        if (itemGeneticallyModifiedFlag == null) {
            return false;
        } else {
            return itemGeneticallyModifiedFlag;
        }
    }

    /**
     * Sets the value of the itemGeneticallyModifiedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setItemGeneticallyModifiedFlag(Boolean value) {
        this.itemGeneticallyModifiedFlag = value;
    }

    /**
     * Gets the value of the itemIrradiatedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isItemIrradiatedFlag() {
        if (itemIrradiatedFlag == null) {
            return false;
        } else {
            return itemIrradiatedFlag;
        }
    }

    /**
     * Sets the value of the itemIrradiatedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setItemIrradiatedFlag(Boolean value) {
        this.itemIrradiatedFlag = value;
    }

    /**
     * Gets the value of the ingredientIrradiatedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIngredientIrradiatedFlag() {
        if (ingredientIrradiatedFlag == null) {
            return false;
        } else {
            return ingredientIrradiatedFlag;
        }
    }

    /**
     * Sets the value of the ingredientIrradiatedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIngredientIrradiatedFlag(Boolean value) {
        this.ingredientIrradiatedFlag = value;
    }

    /**
     * Gets the value of the rawMaterialirradiatedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRawMaterialirradiatedFlag() {
        if (rawMaterialirradiatedFlag == null) {
            return false;
        } else {
            return rawMaterialirradiatedFlag;
        }
    }

    /**
     * Sets the value of the rawMaterialirradiatedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRawMaterialirradiatedFlag(Boolean value) {
        this.rawMaterialirradiatedFlag = value;
    }

}
