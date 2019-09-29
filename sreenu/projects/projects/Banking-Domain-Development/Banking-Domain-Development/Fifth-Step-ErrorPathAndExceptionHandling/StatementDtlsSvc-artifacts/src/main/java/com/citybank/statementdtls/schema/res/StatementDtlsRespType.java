
package com.citybank.statementdtls.schema.res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatementDtlsRespType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatementDtlsRespType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusBlock" type="{http://www.citybank.com/StatementDtls/Schema/Res}StatusBlockType"/>
 *         &lt;element name="TransactionDetails" type="{http://www.citybank.com/StatementDtls/Schema/Res}TransactionDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatementDtlsRespType", propOrder = {
    "statusBlock",
    "transactionDetails"
})
public class StatementDtlsRespType {

    @XmlElement(name = "StatusBlock", required = true)
    protected StatusBlockType statusBlock;
    @XmlElement(name = "TransactionDetails")
    protected TransactionDetailsType transactionDetails;

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
     * Gets the value of the transactionDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionDetailsType }
     *     
     */
    public TransactionDetailsType getTransactionDetails() {
        return transactionDetails;
    }

    /**
     * Sets the value of the transactionDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDetailsType }
     *     
     */
    public void setTransactionDetails(TransactionDetailsType value) {
        this.transactionDetails = value;
    }

}
