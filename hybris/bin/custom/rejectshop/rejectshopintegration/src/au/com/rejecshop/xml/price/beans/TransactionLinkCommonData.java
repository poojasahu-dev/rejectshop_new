//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.24 at 01:03:43 PM IST 
//


package au.com.rejecshop.xml.price.beans;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Approved
 * 
 * <p>Java class for TransactionLinkCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionLinkCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="BusinessUnit" form="qualified">
 *             &lt;complexType>
 *               &lt;simpleContent>
 *                 &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>BusinessUnitCommonData">
 *                 &lt;/extension>
 *               &lt;/simpleContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="RetailStoreID" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;/choice>
 *         &lt;element name="WorkstationID" type="{http://www.nrf-arts.org/IXRetail/namespace/}WorkstationIDType" minOccurs="0" form="qualified"/>
 *         &lt;element name="SequenceNumber" type="{http://www.nrf-arts.org/IXRetail/namespace/}SequenceNumberType" form="qualified"/>
 *         &lt;element name="LineItemSequenceNumber" type="{http://www.nrf-arts.org/IXRetail/namespace/}SequenceNumberType" minOccurs="0" form="qualified"/>
 *         &lt;element name="BusinessDayDate" type="{http://www.nrf-arts.org/IXRetail/namespace/}BusinessDayDateType" minOccurs="0" form="qualified"/>
 *         &lt;element name="BeginDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="EndDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ReasonCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}TransactionLinkReasonTypeCode" default="Return" />
 *       &lt;attribute name="EntryMethod" type="{http://www.nrf-arts.org/IXRetail/namespace/}EntryMethodTypeCode" default="Scanned" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionLinkCommonData", propOrder = {
    "businessUnit",
    "retailStoreID",
    "workstationID",
    "sequenceNumber",
    "lineItemSequenceNumber",
    "businessDayDate",
    "beginDateTime",
    "endDateTime"
})
public class TransactionLinkCommonData {

    @XmlElement(name = "BusinessUnit")
    protected TransactionLinkCommonData.BusinessUnit businessUnit;
    @XmlElement(name = "RetailStoreID")
    protected String retailStoreID;
    @XmlElement(name = "WorkstationID")
    protected String workstationID;
    @XmlElement(name = "SequenceNumber", required = true)
    protected BigInteger sequenceNumber;
    @XmlElement(name = "LineItemSequenceNumber")
    protected BigInteger lineItemSequenceNumber;
    @XmlElement(name = "BusinessDayDate")
    protected XMLGregorianCalendar businessDayDate;
    @XmlElement(name = "BeginDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beginDateTime;
    @XmlElement(name = "EndDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDateTime;
    @XmlAttribute(name = "ReasonCode")
    protected String reasonCode;
    @XmlAttribute(name = "EntryMethod")
    protected String entryMethod;

    /**
     * Gets the value of the businessUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLinkCommonData.BusinessUnit }
     *     
     */
    public TransactionLinkCommonData.BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the value of the businessUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLinkCommonData.BusinessUnit }
     *     
     */
    public void setBusinessUnit(TransactionLinkCommonData.BusinessUnit value) {
        this.businessUnit = value;
    }

    /**
     * Gets the value of the retailStoreID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetailStoreID() {
        return retailStoreID;
    }

    /**
     * Sets the value of the retailStoreID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetailStoreID(String value) {
        this.retailStoreID = value;
    }

    /**
     * Gets the value of the workstationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkstationID() {
        return workstationID;
    }

    /**
     * Sets the value of the workstationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkstationID(String value) {
        this.workstationID = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSequenceNumber(BigInteger value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the lineItemSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLineItemSequenceNumber() {
        return lineItemSequenceNumber;
    }

    /**
     * Sets the value of the lineItemSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLineItemSequenceNumber(BigInteger value) {
        this.lineItemSequenceNumber = value;
    }

    /**
     * Gets the value of the businessDayDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBusinessDayDate() {
        return businessDayDate;
    }

    /**
     * Sets the value of the businessDayDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBusinessDayDate(XMLGregorianCalendar value) {
        this.businessDayDate = value;
    }

    /**
     * Gets the value of the beginDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginDateTime() {
        return beginDateTime;
    }

    /**
     * Sets the value of the beginDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginDateTime(XMLGregorianCalendar value) {
        this.beginDateTime = value;
    }

    /**
     * Gets the value of the endDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the value of the endDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDateTime(XMLGregorianCalendar value) {
        this.endDateTime = value;
    }

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        if (reasonCode == null) {
            return "Return";
        } else {
            return reasonCode;
        }
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the entryMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryMethod() {
        if (entryMethod == null) {
            return "Scanned";
        } else {
            return entryMethod;
        }
    }

    /**
     * Sets the value of the entryMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryMethod(String value) {
        this.entryMethod = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.nrf-arts.org/IXRetail/namespace/>BusinessUnitCommonData">
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BusinessUnit
        extends BusinessUnitCommonData
    {


    }

}