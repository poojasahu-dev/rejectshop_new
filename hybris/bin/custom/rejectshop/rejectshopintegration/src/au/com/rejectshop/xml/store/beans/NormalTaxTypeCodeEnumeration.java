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
 * <p>Java class for NormalTaxTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NormalTaxTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Exceptional"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NormalTaxTypeCodeEnumeration")
@XmlEnum
public enum NormalTaxTypeCodeEnumeration {

    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Exceptional")
    EXCEPTIONAL("Exceptional");
    private final String value;

    NormalTaxTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NormalTaxTypeCodeEnumeration fromValue(String v) {
        for (NormalTaxTypeCodeEnumeration c: NormalTaxTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
