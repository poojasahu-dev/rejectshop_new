//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ResponseCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestID" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="ResponseTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="ResponseDescription" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>DescriptionCommonData">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BusinessError" maxOccurs="unbounded" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}BusinessErrorCommonData">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ResponseCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}ResponseTypeCode" default="OK" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCommonData", propOrder = {
    "requestID",
    "responseTimestamp",
    "responseDescription",
    "businessError"
})
public class ResponseCommonData {

    @XmlElement(name = "RequestID", required = true)
    protected String requestID;
    @XmlElement(name = "ResponseTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar responseTimestamp;
    @XmlElement(name = "ResponseDescription")
    protected ResponseCommonData.ResponseDescription responseDescription;
    @XmlElement(name = "BusinessError")
    protected List<ResponseCommonData.BusinessError> businessError;
    @XmlAttribute(name = "ResponseCode")
    protected String responseCode;

    /**
     * Gets the value of the requestID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the responseTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseTimestamp() {
        return responseTimestamp;
    }

    /**
     * Sets the value of the responseTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseTimestamp(XMLGregorianCalendar value) {
        this.responseTimestamp = value;
    }

    /**
     * Gets the value of the responseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCommonData.ResponseDescription }
     *     
     */
    public ResponseCommonData.ResponseDescription getResponseDescription() {
        return responseDescription;
    }

    /**
     * Sets the value of the responseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCommonData.ResponseDescription }
     *     
     */
    public void setResponseDescription(ResponseCommonData.ResponseDescription value) {
        this.responseDescription = value;
    }

    /**
     * Gets the value of the businessError property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessError property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseCommonData.BusinessError }
     * 
     * 
     */
    public List<ResponseCommonData.BusinessError> getBusinessError() {
        if (businessError == null) {
            businessError = new ArrayList<ResponseCommonData.BusinessError>();
        }
        return this.businessError;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        if (responseCode == null) {
            return "OK";
        } else {
            return responseCode;
        }
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}BusinessErrorCommonData">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BusinessError
        extends BusinessErrorCommonData
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>DescriptionCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ResponseDescription
        extends DescriptionCommonData
    {


    }

}