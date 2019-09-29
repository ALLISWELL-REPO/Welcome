
package com.citybank.statementdtls.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channelid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reqid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientDetailsType", propOrder = {
    "clientid",
    "channelid",
    "reqid"
})
public class ClientDetailsType {

    @XmlElement(required = true)
    protected String clientid;
    @XmlElement(required = true)
    protected String channelid;
    @XmlElement(required = true)
    protected String reqid;

    /**
     * Gets the value of the clientid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientid() {
        return clientid;
    }

    /**
     * Sets the value of the clientid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientid(String value) {
        this.clientid = value;
    }

    /**
     * Gets the value of the channelid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelid() {
        return channelid;
    }

    /**
     * Sets the value of the channelid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelid(String value) {
        this.channelid = value;
    }

    /**
     * Gets the value of the reqid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqid() {
        return reqid;
    }

    /**
     * Sets the value of the reqid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqid(String value) {
        this.reqid = value;
    }

}
