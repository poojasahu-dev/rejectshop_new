//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved - 20050228
 * 
 * <p>Java class for BusinessErrorCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessErrorCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="Description" type="{http://www.nrf-arts.org/IXRetail/namespace/}DescriptionCommonData" minOccurs="0" form="qualified"/>
 *         &lt;element name="RelatedErrorID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Severity" type="{http://www.nrf-arts.org/IXRetail/namespace/}SeverityCodeType" default="Information" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessErrorCommonData", propOrder = {
    "errorID",
    "code",
    "description",
    "relatedErrorID"
})
@XmlSeeAlso({
    BusinessErrorCommonDataExtension.class,
    au.com.rejecshop.xml.price.beans.ResponseCommonData.BusinessError.class
})
public class BusinessErrorCommonData {

    @XmlElement(name = "ErrorID")
    protected String errorID;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Description")
    protected DescriptionCommonData description;
    @XmlElement(name = "RelatedErrorID")
    protected List<String> relatedErrorID;
    @XmlAttribute(name = "Severity")
    protected String severity;

    /**
     * Gets the value of the errorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorID() {
        return errorID;
    }

    /**
     * Sets the value of the errorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorID(String value) {
        this.errorID = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionCommonData }
     *     
     */
    public DescriptionCommonData getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionCommonData }
     *     
     */
    public void setDescription(DescriptionCommonData value) {
        this.description = value;
    }

    /**
     * Gets the value of the relatedErrorID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedErrorID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedErrorID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRelatedErrorID() {
        if (relatedErrorID == null) {
            relatedErrorID = new ArrayList<String>();
        }
        return this.relatedErrorID;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        if (severity == null) {
            return "Information";
        } else {
            return severity;
        }
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

}
