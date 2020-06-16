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
 * <p>Java class for InventoryCountStatusCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InventoryCountStatusCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Scheduled"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Resumed"/>
 *     &lt;enumeration value="CompletedButNotEntered"/>
 *     &lt;enumeration value="CompletedAndEntered"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InventoryCountStatusCodeEnumeration")
@XmlEnum
public enum InventoryCountStatusCodeEnumeration {

    @XmlEnumValue("Scheduled")
    SCHEDULED("Scheduled"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("Resumed")
    RESUMED("Resumed"),
    @XmlEnumValue("CompletedButNotEntered")
    COMPLETED_BUT_NOT_ENTERED("CompletedButNotEntered"),
    @XmlEnumValue("CompletedAndEntered")
    COMPLETED_AND_ENTERED("CompletedAndEntered");
    private final String value;

    InventoryCountStatusCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InventoryCountStatusCodeEnumeration fromValue(String v) {
        for (InventoryCountStatusCodeEnumeration c: InventoryCountStatusCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}