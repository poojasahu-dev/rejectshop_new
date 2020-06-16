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
 * <p>Java class for GiftCertificateMediaTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GiftCertificateMediaTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="StoredValue"/>
 *     &lt;enumeration value="PreprintedPaper"/>
 *     &lt;enumeration value="BlankPaper"/>
 *     &lt;enumeration value="CarWashToken"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GiftCertificateMediaTypeCodeEnumeration")
@XmlEnum
public enum GiftCertificateMediaTypeCodeEnumeration {

    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),
    @XmlEnumValue("PreprintedPaper")
    PREPRINTED_PAPER("PreprintedPaper"),
    @XmlEnumValue("BlankPaper")
    BLANK_PAPER("BlankPaper"),
    @XmlEnumValue("CarWashToken")
    CAR_WASH_TOKEN("CarWashToken");
    private final String value;

    GiftCertificateMediaTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GiftCertificateMediaTypeCodeEnumeration fromValue(String v) {
        for (GiftCertificateMediaTypeCodeEnumeration c: GiftCertificateMediaTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}