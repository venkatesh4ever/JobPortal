
package com.vidur.news.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="saveNewsRequestType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "saveNewsRequestType"
})
@XmlRootElement(name = "saveNews")
public class SaveNews {

    @XmlElement(required = true)
    protected String saveNewsRequestType;

    /**
     * Gets the value of the saveNewsRequestType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaveNewsRequestType() {
        return saveNewsRequestType;
    }

    /**
     * Sets the value of the saveNewsRequestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaveNewsRequestType(String value) {
        this.saveNewsRequestType = value;
    }

}
