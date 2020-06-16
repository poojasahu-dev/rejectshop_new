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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for IndividualType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Salutation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.nrf-arts.org/IXRetail/namespace/}NameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SortingName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MailingName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OfficialName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalSummary" type="{http://www.nrf-arts.org/IXRetail/namespace/}PersonalSummaryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SocioEconomicProfile" type="{http://www.nrf-arts.org/IXRetail/namespace/}SocioEconomicProfileType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Credentials" type="{http://www.nrf-arts.org/IXRetail/namespace/}CredentialsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EmploymentInformation" type="{http://www.nrf-arts.org/IXRetail/namespace/}EmploymentInformationType" minOccurs="0"/>
 *         &lt;element name="ContactInformation" type="{http://www.nrf-arts.org/IXRetail/namespace/}ContactInformationType" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="UpdateType" type="{http://www.nrf-arts.org/IXRetail/namespace/}CustomerUpdateType" default="Existing" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualType", propOrder = {
    "salutation",
    "name",
    "suffix",
    "sortingName",
    "mailingName",
    "officialName",
    "nickName",
    "personalSummary",
    "socioEconomicProfile",
    "credentials",
    "employmentInformation",
    "contactInformation",
    "any"
})
public class IndividualType {

    @XmlElement(name = "Salutation")
    protected String salutation;
    @XmlElement(name = "Name")
    protected List<NameType> name;
    @XmlElement(name = "Suffix")
    protected String suffix;
    @XmlElement(name = "SortingName")
    protected List<String> sortingName;
    @XmlElement(name = "MailingName")
    protected List<String> mailingName;
    @XmlElement(name = "OfficialName")
    protected List<String> officialName;
    @XmlElement(name = "NickName")
    protected String nickName;
    @XmlElement(name = "PersonalSummary")
    protected List<PersonalSummaryType> personalSummary;
    @XmlElement(name = "SocioEconomicProfile")
    protected List<SocioEconomicProfileType> socioEconomicProfile;
    @XmlElement(name = "Credentials")
    protected List<CredentialsType> credentials;
    @XmlElement(name = "EmploymentInformation")
    protected EmploymentInformationType employmentInformation;
    @XmlElement(name = "ContactInformation")
    protected ContactInformationType contactInformation;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "UpdateType")
    protected String updateType;

    /**
     * Gets the value of the salutation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalutation(String value) {
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
     * {@link NameType }
     * 
     * 
     */
    public List<NameType> getName() {
        if (name == null) {
            name = new ArrayList<NameType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffix(String value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the sortingName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortingName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortingName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSortingName() {
        if (sortingName == null) {
            sortingName = new ArrayList<String>();
        }
        return this.sortingName;
    }

    /**
     * Gets the value of the mailingName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mailingName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMailingName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMailingName() {
        if (mailingName == null) {
            mailingName = new ArrayList<String>();
        }
        return this.mailingName;
    }

    /**
     * Gets the value of the officialName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the officialName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOfficialName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOfficialName() {
        if (officialName == null) {
            officialName = new ArrayList<String>();
        }
        return this.officialName;
    }

    /**
     * Gets the value of the nickName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the value of the nickName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

    /**
     * Gets the value of the personalSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personalSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonalSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonalSummaryType }
     * 
     * 
     */
    public List<PersonalSummaryType> getPersonalSummary() {
        if (personalSummary == null) {
            personalSummary = new ArrayList<PersonalSummaryType>();
        }
        return this.personalSummary;
    }

    /**
     * Gets the value of the socioEconomicProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the socioEconomicProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSocioEconomicProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SocioEconomicProfileType }
     * 
     * 
     */
    public List<SocioEconomicProfileType> getSocioEconomicProfile() {
        if (socioEconomicProfile == null) {
            socioEconomicProfile = new ArrayList<SocioEconomicProfileType>();
        }
        return this.socioEconomicProfile;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the credentials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCredentials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CredentialsType }
     * 
     * 
     */
    public List<CredentialsType> getCredentials() {
        if (credentials == null) {
            credentials = new ArrayList<CredentialsType>();
        }
        return this.credentials;
    }

    /**
     * Gets the value of the employmentInformation property.
     * 
     * @return
     *     possible object is
     *     {@link EmploymentInformationType }
     *     
     */
    public EmploymentInformationType getEmploymentInformation() {
        return employmentInformation;
    }

    /**
     * Sets the value of the employmentInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmploymentInformationType }
     *     
     */
    public void setEmploymentInformation(EmploymentInformationType value) {
        this.employmentInformation = value;
    }

    /**
     * Gets the value of the contactInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInformationType }
     *     
     */
    public ContactInformationType getContactInformation() {
        return contactInformation;
    }

    /**
     * Sets the value of the contactInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInformationType }
     *     
     */
    public void setContactInformation(ContactInformationType value) {
        this.contactInformation = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateType() {
        if (updateType == null) {
            return "Existing";
        } else {
            return updateType;
        }
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateType(String value) {
        this.updateType = value;
    }

}
