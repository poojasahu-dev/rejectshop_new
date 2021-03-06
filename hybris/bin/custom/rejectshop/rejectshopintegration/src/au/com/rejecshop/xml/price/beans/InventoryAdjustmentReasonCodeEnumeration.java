//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InventoryAdjustmentReasonCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InventoryAdjustmentReasonCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Donate"/>
 *     &lt;enumeration value="Destroy"/>
 *     &lt;enumeration value="Liquidate"/>
 *     &lt;enumeration value="Salvage"/>
 *     &lt;enumeration value="Shrink"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InventoryAdjustmentReasonCodeEnumeration")
@XmlEnum
public enum InventoryAdjustmentReasonCodeEnumeration {

    @XmlEnumValue("Donate")
    DONATE("Donate"),
    @XmlEnumValue("Destroy")
    DESTROY("Destroy"),
    @XmlEnumValue("Liquidate")
    LIQUIDATE("Liquidate"),
    @XmlEnumValue("Salvage")
    SALVAGE("Salvage"),
    @XmlEnumValue("Shrink")
    SHRINK("Shrink");
    private final String value;

    InventoryAdjustmentReasonCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InventoryAdjustmentReasonCodeEnumeration fromValue(String v) {
        for (InventoryAdjustmentReasonCodeEnumeration c: InventoryAdjustmentReasonCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
