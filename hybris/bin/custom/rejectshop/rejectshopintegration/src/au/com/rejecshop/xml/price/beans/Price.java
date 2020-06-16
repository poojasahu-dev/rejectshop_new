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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.nrf-arts.org/IXRetail/namespace/}PriceType">
 *       &lt;attribute name="MajorVersion" type="{http://www.w3.org/2001/XMLSchema}integer" default="2" />
 *       &lt;attribute name="MinorVersion" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" />
 *       &lt;attribute name="FixVersion" type="{http://www.w3.org/2001/XMLSchema}integer" default="1" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Price")
public class Price
    extends PriceType
{

    @XmlAttribute(name = "MajorVersion")
    protected BigInteger majorVersion;
    @XmlAttribute(name = "MinorVersion")
    protected BigInteger minorVersion;
    @XmlAttribute(name = "FixVersion")
    protected BigInteger fixVersion;

    /**
     * Gets the value of the majorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMajorVersion() {
        if (majorVersion == null) {
            return new BigInteger("2");
        } else {
            return majorVersion;
        }
    }

    /**
     * Sets the value of the majorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMajorVersion(BigInteger value) {
        this.majorVersion = value;
    }

    /**
     * Gets the value of the minorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinorVersion() {
        if (minorVersion == null) {
            return new BigInteger("0");
        } else {
            return minorVersion;
        }
    }

    /**
     * Sets the value of the minorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinorVersion(BigInteger value) {
        this.minorVersion = value;
    }

    /**
     * Gets the value of the fixVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFixVersion() {
        if (fixVersion == null) {
            return new BigInteger("1");
        } else {
            return fixVersion;
        }
    }

    /**
     * Sets the value of the fixVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFixVersion(BigInteger value) {
        this.fixVersion = value;
    }

}
