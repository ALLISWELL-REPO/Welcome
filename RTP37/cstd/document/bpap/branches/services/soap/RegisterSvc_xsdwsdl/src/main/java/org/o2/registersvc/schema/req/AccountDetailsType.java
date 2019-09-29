
package org.o2.registersvc.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountDetailsType", propOrder = {
    "accNumber",
    "mobNumber"
})
public class AccountDetailsType {

    @XmlElement(required = true)
    protected String accNumber;
    protected long mobNumber;

    /**
     * Gets the value of the accNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * Sets the value of the accNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNumber(String value) {
        this.accNumber = value;
    }

    /**
     * Gets the value of the mobNumber property.
     * 
     */
    public long getMobNumber() {
        return mobNumber;
    }

    /**
     * Sets the value of the mobNumber property.
     * 
     */
    public void setMobNumber(long value) {
        this.mobNumber = value;
    }

}
