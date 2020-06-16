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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Approved 
 * 
 * <p>Java class for MeasurementCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasurementCommonData">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *       &lt;attribute name="UnitOfMeasure" type="{http://www.nrf-arts.org/IXRetail/namespace/}UnitOfMeasureCodeCommonData" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementCommonData", propOrder = {
    "value"
})
@XmlSeeAlso({
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.Depth.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.Height.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.Width.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.Diameter.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.GrossWeight.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.NetWeight.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.NetContent.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.DrainedWeight.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.PegHorizontal.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.PegVertical.class,
    au.com.rejectshop.xml.store.beans.ItemMeasurementCommonData.TareWeight.class,
    au.com.rejectshop.xml.store.beans.TemperatureCommonData.Maximum.class,
    au.com.rejectshop.xml.store.beans.TemperatureCommonData.Minimum.class,
    au.com.rejectshop.xml.store.beans.OrderInformationType.OrderingLeadTime.class,
    au.com.rejectshop.xml.store.beans.OrderInformationType.OrderSizingFactor.class
})
public class MeasurementCommonData {

    @XmlValue
    protected float value;
    @XmlAttribute(name = "UnitOfMeasure")
    protected String unitOfMeasure;

    /**
     * Gets the value of the value property.
     * 
     */
    public float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasure(String value) {
        this.unitOfMeasure = value;
    }

}