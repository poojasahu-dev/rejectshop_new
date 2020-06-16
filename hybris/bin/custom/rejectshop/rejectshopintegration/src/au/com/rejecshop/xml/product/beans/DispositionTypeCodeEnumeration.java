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
 * <p>Java class for DispositionTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DispositionTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="ReturnToSupplier"/>
 *     &lt;enumeration value="Destroyed"/>
 *     &lt;enumeration value="RetainUntilNextPromotion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DispositionTypeCodeEnumeration")
@XmlEnum
public enum DispositionTypeCodeEnumeration {

    @XmlEnumValue("ReturnToSupplier")
    RETURN_TO_SUPPLIER("ReturnToSupplier"),
    @XmlEnumValue("Destroyed")
    DESTROYED("Destroyed"),
    @XmlEnumValue("RetainUntilNextPromotion")
    RETAIN_UNTIL_NEXT_PROMOTION("RetainUntilNextPromotion");
    private final String value;

    DispositionTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DispositionTypeCodeEnumeration fromValue(String v) {
        for (DispositionTypeCodeEnumeration c: DispositionTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
