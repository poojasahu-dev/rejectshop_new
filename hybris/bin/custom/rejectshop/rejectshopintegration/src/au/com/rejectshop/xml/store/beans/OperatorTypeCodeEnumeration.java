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
 * <p>Java class for OperatorTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatorTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Cashier"/>
 *     &lt;enumeration value="Checker"/>
 *     &lt;enumeration value="OrderTaker"/>
 *     &lt;enumeration value="Server"/>
 *     &lt;enumeration value="Expediter"/>
 *     &lt;enumeration value="BarTender"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperatorTypeCodeEnumeration")
@XmlEnum
public enum OperatorTypeCodeEnumeration {

    @XmlEnumValue("Cashier")
    CASHIER("Cashier"),
    @XmlEnumValue("Checker")
    CHECKER("Checker"),
    @XmlEnumValue("OrderTaker")
    ORDER_TAKER("OrderTaker"),
    @XmlEnumValue("Server")
    SERVER("Server"),
    @XmlEnumValue("Expediter")
    EXPEDITER("Expediter"),
    @XmlEnumValue("BarTender")
    BAR_TENDER("BarTender");
    private final String value;

    OperatorTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatorTypeCodeEnumeration fromValue(String v) {
        for (OperatorTypeCodeEnumeration c: OperatorTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}