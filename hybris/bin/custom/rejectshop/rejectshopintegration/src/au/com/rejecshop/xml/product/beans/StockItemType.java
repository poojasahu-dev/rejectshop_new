//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for StockItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StockItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerPickup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnitPriceFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SaleUnitLastReceivedBaseCostAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SaleUnitLastReceivedNetCostAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SaleUnitLandedCostAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SaleUnitLastReceivedCostsEstablishedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TypeCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}StockItemTypeCode" default="ShelfItem" />
 *       &lt;attribute name="StockType" type="{http://www.nrf-arts.org/IXRetail/namespace/}StockTypeCode" default="DryStockDiscrete" />
 *       &lt;attribute name="WeightOrUnitCountCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}WeightOrUnitCountCodeType" default="Unit" />
 *       &lt;attribute name="SwellFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="ShrinkFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="InventoryAccountingMethod" type="{http://www.nrf-arts.org/IXRetail/namespace/}InventoryAccountingMethodType" default="CostMethod" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StockItemType", propOrder = {
    "customerPickup",
    "unitPriceFactor",
    "saleUnitLastReceivedBaseCostAmount",
    "saleUnitLastReceivedNetCostAmount",
    "saleUnitLandedCostAmount",
    "saleUnitLastReceivedCostsEstablishedDate"
})
public class StockItemType {

    @XmlElement(name = "CustomerPickup")
    protected String customerPickup;
    @XmlElement(name = "UnitPriceFactor")
    protected BigDecimal unitPriceFactor;
    @XmlElement(name = "SaleUnitLastReceivedBaseCostAmount")
    protected StockItemType.SaleUnitLastReceivedBaseCostAmount saleUnitLastReceivedBaseCostAmount;
    @XmlElement(name = "SaleUnitLastReceivedNetCostAmount")
    protected StockItemType.SaleUnitLastReceivedNetCostAmount saleUnitLastReceivedNetCostAmount;
    @XmlElement(name = "SaleUnitLandedCostAmount")
    protected StockItemType.SaleUnitLandedCostAmount saleUnitLandedCostAmount;
    @XmlElement(name = "SaleUnitLastReceivedCostsEstablishedDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar saleUnitLastReceivedCostsEstablishedDate;
    @XmlAttribute(name = "TypeCode")
    protected String typeCode;
    @XmlAttribute(name = "StockType")
    protected String stockType;
    @XmlAttribute(name = "WeightOrUnitCountCode")
    protected String weightOrUnitCountCode;
    @XmlAttribute(name = "SwellFlag")
    protected Boolean swellFlag;
    @XmlAttribute(name = "ShrinkFlag")
    protected Boolean shrinkFlag;
    @XmlAttribute(name = "InventoryAccountingMethod")
    protected String inventoryAccountingMethod;

    /**
     * Gets the value of the customerPickup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPickup() {
        return customerPickup;
    }

    /**
     * Sets the value of the customerPickup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPickup(String value) {
        this.customerPickup = value;
    }

    /**
     * Gets the value of the unitPriceFactor property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPriceFactor() {
        return unitPriceFactor;
    }

    /**
     * Sets the value of the unitPriceFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPriceFactor(BigDecimal value) {
        this.unitPriceFactor = value;
    }

    /**
     * Gets the value of the saleUnitLastReceivedBaseCostAmount property.
     * 
     * @return
     *     possible object is
     *     {@link StockItemType.SaleUnitLastReceivedBaseCostAmount }
     *     
     */
    public StockItemType.SaleUnitLastReceivedBaseCostAmount getSaleUnitLastReceivedBaseCostAmount() {
        return saleUnitLastReceivedBaseCostAmount;
    }

    /**
     * Sets the value of the saleUnitLastReceivedBaseCostAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockItemType.SaleUnitLastReceivedBaseCostAmount }
     *     
     */
    public void setSaleUnitLastReceivedBaseCostAmount(StockItemType.SaleUnitLastReceivedBaseCostAmount value) {
        this.saleUnitLastReceivedBaseCostAmount = value;
    }

    /**
     * Gets the value of the saleUnitLastReceivedNetCostAmount property.
     * 
     * @return
     *     possible object is
     *     {@link StockItemType.SaleUnitLastReceivedNetCostAmount }
     *     
     */
    public StockItemType.SaleUnitLastReceivedNetCostAmount getSaleUnitLastReceivedNetCostAmount() {
        return saleUnitLastReceivedNetCostAmount;
    }

    /**
     * Sets the value of the saleUnitLastReceivedNetCostAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockItemType.SaleUnitLastReceivedNetCostAmount }
     *     
     */
    public void setSaleUnitLastReceivedNetCostAmount(StockItemType.SaleUnitLastReceivedNetCostAmount value) {
        this.saleUnitLastReceivedNetCostAmount = value;
    }

    /**
     * Gets the value of the saleUnitLandedCostAmount property.
     * 
     * @return
     *     possible object is
     *     {@link StockItemType.SaleUnitLandedCostAmount }
     *     
     */
    public StockItemType.SaleUnitLandedCostAmount getSaleUnitLandedCostAmount() {
        return saleUnitLandedCostAmount;
    }

    /**
     * Sets the value of the saleUnitLandedCostAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link StockItemType.SaleUnitLandedCostAmount }
     *     
     */
    public void setSaleUnitLandedCostAmount(StockItemType.SaleUnitLandedCostAmount value) {
        this.saleUnitLandedCostAmount = value;
    }

    /**
     * Gets the value of the saleUnitLastReceivedCostsEstablishedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSaleUnitLastReceivedCostsEstablishedDate() {
        return saleUnitLastReceivedCostsEstablishedDate;
    }

    /**
     * Sets the value of the saleUnitLastReceivedCostsEstablishedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSaleUnitLastReceivedCostsEstablishedDate(XMLGregorianCalendar value) {
        this.saleUnitLastReceivedCostsEstablishedDate = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        if (typeCode == null) {
            return "ShelfItem";
        } else {
            return typeCode;
        }
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the stockType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockType() {
        if (stockType == null) {
            return "DryStockDiscrete";
        } else {
            return stockType;
        }
    }

    /**
     * Sets the value of the stockType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockType(String value) {
        this.stockType = value;
    }

    /**
     * Gets the value of the weightOrUnitCountCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightOrUnitCountCode() {
        if (weightOrUnitCountCode == null) {
            return "Unit";
        } else {
            return weightOrUnitCountCode;
        }
    }

    /**
     * Sets the value of the weightOrUnitCountCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightOrUnitCountCode(String value) {
        this.weightOrUnitCountCode = value;
    }

    /**
     * Gets the value of the swellFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSwellFlag() {
        if (swellFlag == null) {
            return false;
        } else {
            return swellFlag;
        }
    }

    /**
     * Sets the value of the swellFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSwellFlag(Boolean value) {
        this.swellFlag = value;
    }

    /**
     * Gets the value of the shrinkFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isShrinkFlag() {
        if (shrinkFlag == null) {
            return false;
        } else {
            return shrinkFlag;
        }
    }

    /**
     * Sets the value of the shrinkFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShrinkFlag(Boolean value) {
        this.shrinkFlag = value;
    }

    /**
     * Gets the value of the inventoryAccountingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryAccountingMethod() {
        if (inventoryAccountingMethod == null) {
            return "CostMethod";
        } else {
            return inventoryAccountingMethod;
        }
    }

    /**
     * Sets the value of the inventoryAccountingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryAccountingMethod(String value) {
        this.inventoryAccountingMethod = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SaleUnitLandedCostAmount
        extends AmountCommonData
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
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SaleUnitLastReceivedBaseCostAmount
        extends AmountCommonData
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
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>AmountCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SaleUnitLastReceivedNetCostAmount
        extends AmountCommonData
    {


    }

}
