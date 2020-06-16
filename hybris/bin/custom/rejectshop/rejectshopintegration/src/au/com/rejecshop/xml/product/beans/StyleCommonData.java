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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StyleCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StyleCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Style" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="StyleColorPalette" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="StyleDesignDetail" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="CareAndUseCode" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleCommonData", propOrder = {
    "style",
    "styleColorPalette",
    "styleDesignDetail",
    "careAndUseCode"
})
@XmlSeeAlso({
    au.com.rejecshop.xml.product.beans.SupplierInformationType.StyleCode.class,
    StyleCodeType.class
})
public class StyleCommonData {

    @XmlElement(name = "Style", required = true)
    protected String style;
    @XmlElement(name = "StyleColorPalette")
    protected List<String> styleColorPalette;
    @XmlElement(name = "StyleDesignDetail")
    protected List<String> styleDesignDetail;
    @XmlElement(name = "CareAndUseCode")
    protected List<String> careAndUseCode;

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Gets the value of the styleColorPalette property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleColorPalette property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleColorPalette().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStyleColorPalette() {
        if (styleColorPalette == null) {
            styleColorPalette = new ArrayList<String>();
        }
        return this.styleColorPalette;
    }

    /**
     * Gets the value of the styleDesignDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleDesignDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleDesignDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStyleDesignDetail() {
        if (styleDesignDetail == null) {
            styleDesignDetail = new ArrayList<String>();
        }
        return this.styleDesignDetail;
    }

    /**
     * Gets the value of the careAndUseCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the careAndUseCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCareAndUseCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCareAndUseCode() {
        if (careAndUseCode == null) {
            careAndUseCode = new ArrayList<String>();
        }
        return this.careAndUseCode;
    }

}
