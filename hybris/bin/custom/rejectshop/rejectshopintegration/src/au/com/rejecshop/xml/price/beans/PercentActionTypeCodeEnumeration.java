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
 * <p>Java class for PercentActionTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PercentActionTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Add"/>
 *     &lt;enumeration value="Subtract"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PercentActionTypeCodeEnumeration")
@XmlEnum
public enum PercentActionTypeCodeEnumeration {

    @XmlEnumValue("Add")
    ADD("Add"),
    @XmlEnumValue("Subtract")
    SUBTRACT("Subtract");
    private final String value;

    PercentActionTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PercentActionTypeCodeEnumeration fromValue(String v) {
        for (PercentActionTypeCodeEnumeration c: PercentActionTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}