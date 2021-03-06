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
 * <p>Java class for InventoryStatusCodesEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InventoryStatusCodesEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="AvailableOnHand"/>
 *     &lt;enumeration value="AvailableToSell"/>
 *     &lt;enumeration value="OnOrder"/>
 *     &lt;enumeration value="InTransitInBound"/>
 *     &lt;enumeration value="ReservedOnHand"/>
 *     &lt;enumeration value="Sold"/>
 *     &lt;enumeration value="DefectiveOnHand"/>
 *     &lt;enumeration value="ReturnToVendor"/>
 *     &lt;enumeration value="Shrinkage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InventoryStatusCodesEnumeration")
@XmlEnum
public enum InventoryStatusCodesEnumeration {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("AvailableOnHand")
    AVAILABLE_ON_HAND("AvailableOnHand"),
    @XmlEnumValue("AvailableToSell")
    AVAILABLE_TO_SELL("AvailableToSell"),
    @XmlEnumValue("OnOrder")
    ON_ORDER("OnOrder"),
    @XmlEnumValue("InTransitInBound")
    IN_TRANSIT_IN_BOUND("InTransitInBound"),
    @XmlEnumValue("ReservedOnHand")
    RESERVED_ON_HAND("ReservedOnHand"),
    @XmlEnumValue("Sold")
    SOLD("Sold"),
    @XmlEnumValue("DefectiveOnHand")
    DEFECTIVE_ON_HAND("DefectiveOnHand"),
    @XmlEnumValue("ReturnToVendor")
    RETURN_TO_VENDOR("ReturnToVendor"),
    @XmlEnumValue("Shrinkage")
    SHRINKAGE("Shrinkage");
    private final String value;

    InventoryStatusCodesEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InventoryStatusCodesEnumeration fromValue(String v) {
        for (InventoryStatusCodesEnumeration c: InventoryStatusCodesEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
