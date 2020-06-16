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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Approved
 * 
 * <p>Java class for MerchandiseHierarchyStructureCommonData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchandiseHierarchyStructureCommonData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="Level" type="{http://www.nrf-arts.org/IXRetail/namespace/}StructureType" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="Group" type="{http://www.nrf-arts.org/IXRetail/namespace/}StructureType" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchandiseHierarchyStructureCommonData", propOrder = {
    "id",
    "name",
    "level",
    "group"
})
public class MerchandiseHierarchyStructureCommonData {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Level")
    protected List<StructureType> level;
    @XmlElement(name = "Group")
    protected List<StructureType> group;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the level property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructureType }
     * 
     * 
     */
    public List<StructureType> getLevel() {
        if (level == null) {
            level = new ArrayList<StructureType>();
        }
        return this.level;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructureType }
     * 
     * 
     */
    public List<StructureType> getGroup() {
        if (group == null) {
            group = new ArrayList<StructureType>();
        }
        return this.group;
    }

}
