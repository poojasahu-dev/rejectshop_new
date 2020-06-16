//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.05 at 06:07:27 PM IST 
//


package au.com.rejectshop.xml.store.beans;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Approved - Name Common Data  
 * 
 * <p>Java class for NameCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NameCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Salutation" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Name" maxOccurs="unbounded" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="Location" type="{http://www.nrf-arts.org/IXRetail/namespace/}LocationTypeCode" />
 *                 &lt;attribute name="TypeCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}NameTypeCode" />
 *                 &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Suffix" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="SortingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="MailingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="OfficialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameCommonData", propOrder = {
    "salutation",
    "name",
    "suffix",
    "fullName",
    "sortingName",
    "mailingName",
    "officialName"
})
@XmlSeeAlso({
    au.com.rejectshop.xml.store.beans.PersonalIdentificationCommonData.Name.class,
    au.com.rejectshop.xml.store.beans.WorkerCommonData.Name.class,
    au.com.rejectshop.xml.store.beans.ContactCommonData.Name.class,
    au.com.rejectshop.xml.store.beans.CustomerCommonData.Name.class
})
public class NameCommonData {

    @XmlElement(name = "Salutation")
    protected NameCommonData.Salutation salutation;
    @XmlElement(name = "Name")
    protected List<NameCommonData.Name> name;
    @XmlElement(name = "Suffix")
    protected NameCommonData.Suffix suffix;
    @XmlElement(name = "FullName", required = true)
    protected String fullName;
    @XmlElement(name = "SortingName")
    protected String sortingName;
    @XmlElement(name = "MailingName")
    protected String mailingName;
    @XmlElement(name = "OfficialName")
    protected String officialName;

    /**
     * Gets the value of the salutation property.
     * 
     * @return
     *     possible object is
     *     {@link NameCommonData.Salutation }
     *     
     */
    public NameCommonData.Salutation getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameCommonData.Salutation }
     *     
     */
    public void setSalutation(NameCommonData.Salutation value) {
        this.salutation = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameCommonData.Name }
     * 
     * 
     */
    public List<NameCommonData.Name> getName() {
        if (name == null) {
            name = new ArrayList<NameCommonData.Name>();
        }
        return this.name;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link NameCommonData.Suffix }
     *     
     */
    public NameCommonData.Suffix getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameCommonData.Suffix }
     *     
     */
    public void setSuffix(NameCommonData.Suffix value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the sortingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortingName() {
        return sortingName;
    }

    /**
     * Sets the value of the sortingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortingName(String value) {
        this.sortingName = value;
    }

    /**
     * Gets the value of the mailingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailingName() {
        return mailingName;
    }

    /**
     * Sets the value of the mailingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailingName(String value) {
        this.mailingName = value;
    }

    /**
     * Gets the value of the officialName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialName() {
        return officialName;
    }

    /**
     * Sets the value of the officialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialName(String value) {
        this.officialName = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="Location" type="{http://www.nrf-arts.org/IXRetail/namespace/}LocationTypeCode" />
     *       &lt;attribute name="TypeCode" type="{http://www.nrf-arts.org/IXRetail/namespace/}NameTypeCode" />
     *       &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Name {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "Location")
        protected String location;
        @XmlAttribute(name = "TypeCode")
        protected String typeCode;
        @XmlAttribute(name = "RelativeOrder")
        protected BigInteger relativeOrder;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Gets the value of the typeCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeCode() {
            return typeCode;
        }

        /**
         * Sets the value of the typeCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeCode(String value) {
            this.typeCode = value;
        }

        /**
         * Gets the value of the relativeOrder property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getRelativeOrder() {
            return relativeOrder;
        }

        /**
         * Sets the value of the relativeOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setRelativeOrder(BigInteger value) {
            this.relativeOrder = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Salutation {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "RelativeOrder")
        protected BigInteger relativeOrder;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the relativeOrder property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getRelativeOrder() {
            return relativeOrder;
        }

        /**
         * Sets the value of the relativeOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setRelativeOrder(BigInteger value) {
            this.relativeOrder = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="RelativeOrder" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Suffix {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "RelativeOrder")
        protected BigInteger relativeOrder;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the relativeOrder property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getRelativeOrder() {
            return relativeOrder;
        }

        /**
         * Sets the value of the relativeOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setRelativeOrder(BigInteger value) {
            this.relativeOrder = value;
        }

    }

}
