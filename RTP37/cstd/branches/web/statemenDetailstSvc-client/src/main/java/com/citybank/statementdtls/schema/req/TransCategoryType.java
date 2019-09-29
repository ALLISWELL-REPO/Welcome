
package com.citybank.statementdtls.schema.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransCategoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransCategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataRange" type="{http://www.citybank.com/StatementDtls/schema/Req}DataRangeType"/>
 *         &lt;element name="typeofcategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransCategoryType", propOrder = {
    "dataRange",
    "typeofcategory"
})
public class TransCategoryType {

    @XmlElement(name = "DataRange", required = true)
    protected DataRangeType dataRange;
    @XmlElement(required = true)
    protected String typeofcategory;

    /**
     * Gets the value of the dataRange property.
     * 
     * @return
     *     possible object is
     *     {@link DataRangeType }
     *     
     */
    public DataRangeType getDataRange() {
        return dataRange;
    }

    /**
     * Sets the value of the dataRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRangeType }
     *     
     */
    public void setDataRange(DataRangeType value) {
        this.dataRange = value;
    }

    /**
     * Gets the value of the typeofcategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeofcategory() {
        return typeofcategory;
    }

    /**
     * Sets the value of the typeofcategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeofcategory(String value) {
        this.typeofcategory = value;
    }

}
