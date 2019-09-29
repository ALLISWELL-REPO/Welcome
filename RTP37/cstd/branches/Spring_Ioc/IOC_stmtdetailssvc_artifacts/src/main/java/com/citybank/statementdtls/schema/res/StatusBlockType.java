
package com.citybank.statementdtls.schema.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusBlockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusBlockType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errormsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reapcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="respmsg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusBlockType", propOrder = {
    "errorcode",
    "errormsg",
    "reapcode",
    "respmsg"
})
public class StatusBlockType {

    @XmlElement(required = true)
    protected String errorcode;
    @XmlElement(required = true)
    protected String errormsg;
    @XmlElement(required = true)
    protected String reapcode;
    @XmlElement(required = true)
    protected String respmsg;

    /**
     * Gets the value of the errorcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * Sets the value of the errorcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorcode(String value) {
        this.errorcode = value;
    }

    /**
     * Gets the value of the errormsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrormsg() {
        return errormsg;
    }

    /**
     * Sets the value of the errormsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrormsg(String value) {
        this.errormsg = value;
    }

    /**
     * Gets the value of the reapcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReapcode() {
        return reapcode;
    }

    /**
     * Sets the value of the reapcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReapcode(String value) {
        this.reapcode = value;
    }

    /**
     * Gets the value of the respmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespmsg() {
        return respmsg;
    }

    /**
     * Sets the value of the respmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespmsg(String value) {
        this.respmsg = value;
    }

}
