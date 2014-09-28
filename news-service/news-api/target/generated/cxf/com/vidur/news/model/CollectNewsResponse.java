
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
 *         &lt;element name="collectNewsResponseType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "collectNewsResponseType"
})
@XmlRootElement(name = "collectNewsResponse")
public class CollectNewsResponse {

    @XmlElement(required = true)
    protected String collectNewsResponseType;

    /**
     * Gets the value of the collectNewsResponseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectNewsResponseType() {
        return collectNewsResponseType;
    }

    /**
     * Sets the value of the collectNewsResponseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectNewsResponseType(String value) {
        this.collectNewsResponseType = value;
    }

}
