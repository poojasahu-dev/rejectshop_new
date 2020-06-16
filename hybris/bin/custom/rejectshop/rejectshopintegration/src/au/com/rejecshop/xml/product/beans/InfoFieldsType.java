//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.24 at 03:00:24 PM IST 
//


package au.com.rejecshop.xml.product.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * TRS Extension / Nicholas Busy / 2008-08-08
 *                         MOP Fields / Nathan Van Zyl / 2017-11-17
 * 
 * <p>Java class for InfoFieldsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InfoFieldsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DistributionProfile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Grade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PresentationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcurementRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchandiseInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ABCIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplyingSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArticleClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchandiseStyle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArticleStrategy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerOffer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoFieldsType", propOrder = {
    "distributionProfile",
    "grade",
    "presentationLevel",
    "procurementRule",
    "merchandiseInstructions",
    "groupCode",
    "abcIndicator",
    "supplyingSite",
    "articleClass",
    "merchandiseStyle",
    "articleStrategy",
    "customerOffer",
    "any"
})
public class InfoFieldsType {

    @XmlElement(name = "DistributionProfile")
    protected String distributionProfile;
    @XmlElement(name = "Grade")
    protected String grade;
    @XmlElement(name = "PresentationLevel")
    protected String presentationLevel;
    @XmlElement(name = "ProcurementRule")
    protected String procurementRule;
    @XmlElement(name = "MerchandiseInstructions")
    protected String merchandiseInstructions;
    @XmlElement(name = "GroupCode")
    protected String groupCode;
    @XmlElement(name = "ABCIndicator")
    protected String abcIndicator;
    @XmlElement(name = "SupplyingSite")
    protected String supplyingSite;
    @XmlElement(name = "ArticleClass")
    protected String articleClass;
    @XmlElement(name = "MerchandiseStyle")
    protected String merchandiseStyle;
    @XmlElement(name = "ArticleStrategy")
    protected String articleStrategy;
    @XmlElement(name = "CustomerOffer")
    protected String customerOffer;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the distributionProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributionProfile() {
        return distributionProfile;
    }

    /**
     * Sets the value of the distributionProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributionProfile(String value) {
        this.distributionProfile = value;
    }

    /**
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrade(String value) {
        this.grade = value;
    }

    /**
     * Gets the value of the presentationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentationLevel() {
        return presentationLevel;
    }

    /**
     * Sets the value of the presentationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentationLevel(String value) {
        this.presentationLevel = value;
    }

    /**
     * Gets the value of the procurementRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcurementRule() {
        return procurementRule;
    }

    /**
     * Sets the value of the procurementRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcurementRule(String value) {
        this.procurementRule = value;
    }

    /**
     * Gets the value of the merchandiseInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchandiseInstructions() {
        return merchandiseInstructions;
    }

    /**
     * Sets the value of the merchandiseInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchandiseInstructions(String value) {
        this.merchandiseInstructions = value;
    }

    /**
     * Gets the value of the groupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the value of the groupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
    }

    /**
     * Gets the value of the abcIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getABCIndicator() {
        return abcIndicator;
    }

    /**
     * Sets the value of the abcIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setABCIndicator(String value) {
        this.abcIndicator = value;
    }

    /**
     * Gets the value of the supplyingSite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplyingSite() {
        return supplyingSite;
    }

    /**
     * Sets the value of the supplyingSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplyingSite(String value) {
        this.supplyingSite = value;
    }

    /**
     * Gets the value of the articleClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleClass() {
        return articleClass;
    }

    /**
     * Sets the value of the articleClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleClass(String value) {
        this.articleClass = value;
    }

    /**
     * Gets the value of the merchandiseStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchandiseStyle() {
        return merchandiseStyle;
    }

    /**
     * Sets the value of the merchandiseStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchandiseStyle(String value) {
        this.merchandiseStyle = value;
    }

    /**
     * Gets the value of the articleStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleStrategy() {
        return articleStrategy;
    }

    /**
     * Sets the value of the articleStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleStrategy(String value) {
        this.articleStrategy = value;
    }

    /**
     * Gets the value of the customerOffer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerOffer() {
        return customerOffer;
    }

    /**
     * Sets the value of the customerOffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerOffer(String value) {
        this.customerOffer = value;
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
     * {@link Object }
     * {@link Element }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}