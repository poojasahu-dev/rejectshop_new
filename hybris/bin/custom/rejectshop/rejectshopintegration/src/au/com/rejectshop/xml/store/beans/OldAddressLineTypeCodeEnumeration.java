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
 * <p>Java class for OldAddressLineTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OldAddressLineTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Street"/>
 *     &lt;enumeration value="RuralRoute"/>
 *     &lt;enumeration value="POBox"/>
 *     &lt;enumeration value="Unit"/>
 *     &lt;enumeration value="Apartment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OldAddressLineTypeCodeEnumeration")
@XmlEnum
public enum OldAddressLineTypeCodeEnumeration {

    @XmlEnumValue("Street")
    STREET("Street"),
    @XmlEnumValue("RuralRoute")
    RURAL_ROUTE("RuralRoute"),
    @XmlEnumValue("POBox")
    PO_BOX("POBox"),
    @XmlEnumValue("Unit")
    UNIT("Unit"),
    @XmlEnumValue("Apartment")
    APARTMENT("Apartment");
    private final String value;

    OldAddressLineTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OldAddressLineTypeCodeEnumeration fromValue(String v) {
        for (OldAddressLineTypeCodeEnumeration c: OldAddressLineTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
