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
 * <p>Java class for WhenTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WhenTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Before"/>
 *     &lt;enumeration value="After"/>
 *     &lt;enumeration value="Between"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WhenTypeEnumeration")
@XmlEnum
public enum WhenTypeEnumeration {

    @XmlEnumValue("Before")
    BEFORE("Before"),
    @XmlEnumValue("After")
    AFTER("After"),
    @XmlEnumValue("Between")
    BETWEEN("Between");
    private final String value;

    WhenTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WhenTypeEnumeration fromValue(String v) {
        for (WhenTypeEnumeration c: WhenTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
