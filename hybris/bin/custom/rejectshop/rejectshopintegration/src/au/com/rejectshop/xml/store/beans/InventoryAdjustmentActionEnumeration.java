//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InventoryAdjustmentActionEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InventoryAdjustmentActionEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Add"/>
 *     &lt;enumeration value="Subtract"/>
 *     &lt;enumeration value="Set"/>
 *     &lt;enumeration value="InformationOnly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InventoryAdjustmentActionEnumeration")
@XmlEnum
public enum InventoryAdjustmentActionEnumeration {

    @XmlEnumValue("Add")
    ADD("Add"),
    @XmlEnumValue("Subtract")
    SUBTRACT("Subtract"),
    @XmlEnumValue("Set")
    SET("Set"),
    @XmlEnumValue("InformationOnly")
    INFORMATION_ONLY("InformationOnly");
    private final String value;

    InventoryAdjustmentActionEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InventoryAdjustmentActionEnumeration fromValue(String v) {
        for (InventoryAdjustmentActionEnumeration c: InventoryAdjustmentActionEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
