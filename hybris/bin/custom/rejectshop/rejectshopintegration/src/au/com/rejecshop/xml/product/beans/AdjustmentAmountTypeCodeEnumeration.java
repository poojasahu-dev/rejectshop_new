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
 * <p>Java class for AdjustmentAmountTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdjustmentAmountTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="EvenExchange"/>
 *     &lt;enumeration value="IncreaseAmount"/>
 *     &lt;enumeration value="DecreaseAmount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdjustmentAmountTypeCodeEnumeration")
@XmlEnum
public enum AdjustmentAmountTypeCodeEnumeration {

    @XmlEnumValue("EvenExchange")
    EVEN_EXCHANGE("EvenExchange"),
    @XmlEnumValue("IncreaseAmount")
    INCREASE_AMOUNT("IncreaseAmount"),
    @XmlEnumValue("DecreaseAmount")
    DECREASE_AMOUNT("DecreaseAmount");
    private final String value;

    AdjustmentAmountTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdjustmentAmountTypeCodeEnumeration fromValue(String v) {
        for (AdjustmentAmountTypeCodeEnumeration c: AdjustmentAmountTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
