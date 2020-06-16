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
 * <p>Java class for EquivalentItemActionTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EquivalentItemActionTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Substitute"/>
 *     &lt;enumeration value="SubstitutedFor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EquivalentItemActionTypeEnumeration")
@XmlEnum
public enum EquivalentItemActionTypeEnumeration {

    @XmlEnumValue("Substitute")
    SUBSTITUTE("Substitute"),
    @XmlEnumValue("SubstitutedFor")
    SUBSTITUTED_FOR("SubstitutedFor");
    private final String value;

    EquivalentItemActionTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EquivalentItemActionTypeEnumeration fromValue(String v) {
        for (EquivalentItemActionTypeEnumeration c: EquivalentItemActionTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}