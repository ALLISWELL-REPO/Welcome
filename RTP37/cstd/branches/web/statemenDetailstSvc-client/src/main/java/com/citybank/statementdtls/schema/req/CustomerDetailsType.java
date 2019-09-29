
package com.citybank.statementdtls.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardnum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cvvnum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameoncard" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerDetailsType", propOrder = {
    "cardnum",
    "cvvnum",
    "expdate",
    "nameoncard"
})
public class CustomerDetailsType {

    @XmlElement(required = true)
    protected String cardnum;
    protected int cvvnum;
    @XmlElement(required = true)
    protected String expdate;
    @XmlElement(required = true)
    protected String nameoncard;

    /**
     * Gets the value of the cardnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardnum() {
        return cardnum;
    }

    /**
     * Sets the value of the cardnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardnum(String value) {
        this.cardnum = value;
    }

    /**
     * Gets the value of the cvvnum property.
     * 
     */
    public int getCvvnum() {
        return cvvnum;
    }

    /**
     * Sets the value of the cvvnum property.
     * 
     */
    public void setCvvnum(int value) {
        this.cvvnum = value;
    }

    /**
     * Gets the value of the expdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpdate() {
        return expdate;
    }

    /**
     * Sets the value of the expdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpdate(String value) {
        this.expdate = value;
    }

    /**
     * Gets the value of the nameoncard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameoncard() {
        return nameoncard;
    }

    /**
     * Sets the value of the nameoncard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameoncard(String value) {
        this.nameoncard = value;
    }

}
