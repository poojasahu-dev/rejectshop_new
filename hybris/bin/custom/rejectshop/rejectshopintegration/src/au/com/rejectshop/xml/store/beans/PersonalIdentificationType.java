//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonalIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonalIdentificationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}PersonalIdentificationOldCommonData">
 *       &lt;attribute name="UpdateType" type="{http://www.nrf-arts.org/IXRetail/namespace/}UpdateTypeEnumeration" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonalIdentificationType")
public class PersonalIdentificationType
    extends PersonalIdentificationOldCommonData
{

    @XmlAttribute(name = "UpdateType")
    protected UpdateTypeEnumeration updateType;

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateTypeEnumeration }
     *     
     */
    public UpdateTypeEnumeration getUpdateType() {
        return updateType;
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateTypeEnumeration }
     *     
     */
    public void setUpdateType(UpdateTypeEnumeration value) {
        this.updateType = value;
    }

}
