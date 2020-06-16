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
 * Approved - from EAN.UCC
 * 
 * <p>Java class for ItemMeasurementCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemMeasurementCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Depth" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Height" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Width" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Diameter" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GrossWeight" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NetWeight" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NetContent" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DrainedWeight" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PegHorizontal" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PegVertical" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TareWeight" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>MeasurementCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="NetContentDeclarationIndicatedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemMeasurementCommonData", propOrder = {
    "depth",
    "height",
    "width",
    "diameter",
    "grossWeight",
    "netWeight",
    "netContent",
    "drainedWeight",
    "pegHorizontal",
    "pegVertical",
    "tareWeight"
})
public class ItemMeasurementCommonData {

    @XmlElement(name = "Depth", required = true)
    protected ItemMeasurementCommonData.Depth depth;
    @XmlElement(name = "Height", required = true)
    protected ItemMeasurementCommonData.Height height;
    @XmlElement(name = "Width", required = true)
    protected ItemMeasurementCommonData.Width width;
    @XmlElement(name = "Diameter")
    protected ItemMeasurementCommonData.Diameter diameter;
    @XmlElement(name = "GrossWeight")
    protected ItemMeasurementCommonData.GrossWeight grossWeight;
    @XmlElement(name = "NetWeight")
    protected ItemMeasurementCommonData.NetWeight netWeight;
    @XmlElement(name = "NetContent")
    protected ItemMeasurementCommonData.NetContent netContent;
    @XmlElement(name = "DrainedWeight")
    protected ItemMeasurementCommonData.DrainedWeight drainedWeight;
    @XmlElement(name = "PegHorizontal")
    protected ItemMeasurementCommonData.PegHorizontal pegHorizontal;
    @XmlElement(name = "PegVertical")
    protected ItemMeasurementCommonData.PegVertical pegVertical;
    @XmlElement(name = "TareWeight")
    protected ItemMeasurementCommonData.TareWeight tareWeight;
    @XmlAttribute(name = "NetContentDeclarationIndicatedFlag")
    protected Boolean netContentDeclarationIndicatedFlag;

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.Depth }
     *     
     */
    public ItemMeasurementCommonData.Depth getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.Depth }
     *     
     */
    public void setDepth(ItemMeasurementCommonData.Depth value) {
        this.depth = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.Height }
     *     
     */
    public ItemMeasurementCommonData.Height getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.Height }
     *     
     */
    public void setHeight(ItemMeasurementCommonData.Height value) {
        this.height = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.Width }
     *     
     */
    public ItemMeasurementCommonData.Width getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.Width }
     *     
     */
    public void setWidth(ItemMeasurementCommonData.Width value) {
        this.width = value;
    }

    /**
     * Gets the value of the diameter property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.Diameter }
     *     
     */
    public ItemMeasurementCommonData.Diameter getDiameter() {
        return diameter;
    }

    /**
     * Sets the value of the diameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.Diameter }
     *     
     */
    public void setDiameter(ItemMeasurementCommonData.Diameter value) {
        this.diameter = value;
    }

    /**
     * Gets the value of the grossWeight property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.GrossWeight }
     *     
     */
    public ItemMeasurementCommonData.GrossWeight getGrossWeight() {
        return grossWeight;
    }

    /**
     * Sets the value of the grossWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.GrossWeight }
     *     
     */
    public void setGrossWeight(ItemMeasurementCommonData.GrossWeight value) {
        this.grossWeight = value;
    }

    /**
     * Gets the value of the netWeight property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.NetWeight }
     *     
     */
    public ItemMeasurementCommonData.NetWeight getNetWeight() {
        return netWeight;
    }

    /**
     * Sets the value of the netWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.NetWeight }
     *     
     */
    public void setNetWeight(ItemMeasurementCommonData.NetWeight value) {
        this.netWeight = value;
    }

    /**
     * Gets the value of the netContent property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.NetContent }
     *     
     */
    public ItemMeasurementCommonData.NetContent getNetContent() {
        return netContent;
    }

    /**
     * Sets the value of the netContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.NetContent }
     *     
     */
    public void setNetContent(ItemMeasurementCommonData.NetContent value) {
        this.netContent = value;
    }

    /**
     * Gets the value of the drainedWeight property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.DrainedWeight }
     *     
     */
    public ItemMeasurementCommonData.DrainedWeight getDrainedWeight() {
        return drainedWeight;
    }

    /**
     * Sets the value of the drainedWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.DrainedWeight }
     *     
     */
    public void setDrainedWeight(ItemMeasurementCommonData.DrainedWeight value) {
        this.drainedWeight = value;
    }

    /**
     * Gets the value of the pegHorizontal property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.PegHorizontal }
     *     
     */
    public ItemMeasurementCommonData.PegHorizontal getPegHorizontal() {
        return pegHorizontal;
    }

    /**
     * Sets the value of the pegHorizontal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.PegHorizontal }
     *     
     */
    public void setPegHorizontal(ItemMeasurementCommonData.PegHorizontal value) {
        this.pegHorizontal = value;
    }

    /**
     * Gets the value of the pegVertical property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.PegVertical }
     *     
     */
    public ItemMeasurementCommonData.PegVertical getPegVertical() {
        return pegVertical;
    }

    /**
     * Sets the value of the pegVertical property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.PegVertical }
     *     
     */
    public void setPegVertical(ItemMeasurementCommonData.PegVertical value) {
        this.pegVertical = value;
    }

    /**
     * Gets the value of the tareWeight property.
     * 
     * @return
     *     possible object is
     *     {@link ItemMeasurementCommonData.TareWeight }
     *     
     */
    public ItemMeasurementCommonData.TareWeight getTareWeight() {
        return tareWeight;
    }

    /**
     * Sets the value of the tareWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemMeasurementCommonData.TareWeight }
     *     
     */
    public void setTareWeight(ItemMeasurementCommonData.TareWeight value) {
        this.tareWeight = value;
    }

    /**
     * Gets the value of the netContentDeclarationIndicatedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNetContentDeclarationIndicatedFlag() {
        if (netContentDeclarationIndicatedFlag == null) {
            return false;
        } else {
            return netContentDeclarationIndicatedFlag;
        }
    }

    /**
     * Sets the value of the netContentDeclarationIndicatedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetContentDeclarationIndicatedFlag(Boolean value) {
        this.netContentDeclarationIndicatedFlag = value;
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
    public static class Depth
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
    public static class Diameter
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
    public static class DrainedWeight
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
    public static class GrossWeight
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
    public static class Height
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
    public static class NetContent
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
    public static class NetWeight
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
    public static class PegHorizontal
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
    public static class PegVertical
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
    public static class TareWeight
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
    public static class Width
        extends MeasurementCommonData
    {


    }

}
