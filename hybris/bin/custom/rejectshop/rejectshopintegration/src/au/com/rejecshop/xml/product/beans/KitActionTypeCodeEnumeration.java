//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KitActionTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KitActionTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="IsPartOf"/>
 *     &lt;enumeration value="AddsTo"/>
 *     &lt;enumeration value="IsRemovedFrom"/>
 *     &lt;enumeration value="Void"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KitActionTypeCodeEnumeration")
@XmlEnum
public enum KitActionTypeCodeEnumeration {

    @XmlEnumValue("IsPartOf")
    IS_PART_OF("IsPartOf"),
    @XmlEnumValue("AddsTo")
    ADDS_TO("AddsTo"),
    @XmlEnumValue("IsRemovedFrom")
    IS_REMOVED_FROM("IsRemovedFrom"),
    @XmlEnumValue("Void")
    VOID("Void");
    private final String value;

    KitActionTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KitActionTypeCodeEnumeration fromValue(String v) {
        for (KitActionTypeCodeEnumeration c: KitActionTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
