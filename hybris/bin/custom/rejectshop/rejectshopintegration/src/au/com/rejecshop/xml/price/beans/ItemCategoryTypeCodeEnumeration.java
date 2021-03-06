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
 * <p>Java class for ItemCategoryTypeCodeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemCategoryTypeCodeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Stock"/>
 *     &lt;enumeration value="Service"/>
 *     &lt;enumeration value="Alteration"/>
 *     &lt;enumeration value="Fee"/>
 *     &lt;enumeration value="Deposit"/>
 *     &lt;enumeration value="DepositRefund"/>
 *     &lt;enumeration value="Tare"/>
 *     &lt;enumeration value="ItemCollection"/>
 *     &lt;enumeration value="Warranty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemCategoryTypeCodeEnumeration")
@XmlEnum
public enum ItemCategoryTypeCodeEnumeration {

    @XmlEnumValue("Stock")
    STOCK("Stock"),
    @XmlEnumValue("Service")
    SERVICE("Service"),
    @XmlEnumValue("Alteration")
    ALTERATION("Alteration"),
    @XmlEnumValue("Fee")
    FEE("Fee"),
    @XmlEnumValue("Deposit")
    DEPOSIT("Deposit"),
    @XmlEnumValue("DepositRefund")
    DEPOSIT_REFUND("DepositRefund"),
    @XmlEnumValue("Tare")
    TARE("Tare"),
    @XmlEnumValue("ItemCollection")
    ITEM_COLLECTION("ItemCollection"),
    @XmlEnumValue("Warranty")
    WARRANTY("Warranty");
    private final String value;

    ItemCategoryTypeCodeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ItemCategoryTypeCodeEnumeration fromValue(String v) {
        for (ItemCategoryTypeCodeEnumeration c: ItemCategoryTypeCodeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
