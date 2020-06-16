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
 * <p>Java class for PriceModificationMethodTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PriceModificationMethodTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="PriceOverride"/>
 *     &lt;enumeration value="PriceRule"/>
 *     &lt;enumeration value="Promotion"/>
 *     &lt;enumeration value="SeniorCitizen"/>
 *     &lt;enumeration value="Coupon"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PriceModificationMethodTypeCodeEnumeration")
@XmlEnum
public enum PriceModificationMethodTypeCodeEnumeration {

    @XmlEnumValue("PriceOverride")
    PRICE_OVERRIDE("PriceOverride"),
    @XmlEnumValue("PriceRule")
    PRICE_RULE("PriceRule"),
    @XmlEnumValue("Promotion")
    PROMOTION("Promotion"),
    @XmlEnumValue("SeniorCitizen")
    SENIOR_CITIZEN("SeniorCitizen"),
    @XmlEnumValue("Coupon")
    COUPON("Coupon");
    private final String value;

    PriceModificationMethodTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PriceModificationMethodTypeCodeEnumeration fromValue(String v) {
        for (PriceModificationMethodTypeCodeEnumeration c: PriceModificationMethodTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
