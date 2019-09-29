
package com.citybank.statementdtls.schema.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatementDtlsResType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatementDtlsResType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusBlock" type="{http://www.citybank.com/StatementDtls/schema/Res}StatusBlockType"/>
 *         &lt;element name="TransDetails" type="{http://www.citybank.com/StatementDtls/schema/Res}TransDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatementDtlsResType", propOrder = {
    "statusBlock",
    "transDetails"
})
public class StatementDtlsResType {

    @XmlElement(name = "StatusBlock", required = true)
    protected StatusBlockType statusBlock;
    @XmlElement(name = "TransDetails")
    protected TransDetailsType transDetails;

    /**
     * Gets the value of the statusBlock property.
     * 
     * @return
     *     possible object is
     *     {@link StatusBlockType }
     *     
     */
    public StatusBlockType getStatusBlock() {
        return statusBlock;
    }

    /**
     * Sets the value of the statusBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusBlockType }
     *     
     */
    public void setStatusBlock(StatusBlockType value) {
        this.statusBlock = value;
    }

    /**
     * Gets the value of the transDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TransDetailsType }
     *     
     */
    public TransDetailsType getTransDetails() {
        return transDetails;
    }

    /**
     * Sets the value of the transDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransDetailsType }
     *     
     */
    public void setTransDetails(TransDetailsType value) {
        this.transDetails = value;
    }

}
