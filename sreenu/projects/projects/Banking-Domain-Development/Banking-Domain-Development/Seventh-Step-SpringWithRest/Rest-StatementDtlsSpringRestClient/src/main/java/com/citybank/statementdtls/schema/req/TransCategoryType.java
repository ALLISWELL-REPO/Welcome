
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
 *         &lt;element name="DateRange" type="{http://www.citybank.com/StatementDtls/Schema/Req}DateRangeType"/>
 *         &lt;element name="typeOfCategory" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dateRange",
    "typeOfCategory"
})
public class TransCategoryType {

    @XmlElement(name = "DateRange", required = true)
    protected DateRangeType dateRange;
    @XmlElement(required = true)
    protected String typeOfCategory;

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setDateRange(DateRangeType value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the typeOfCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfCategory() {
        return typeOfCategory;
    }

    /**
     * Sets the value of the typeOfCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfCategory(String value) {
        this.typeOfCategory = value;
    }

}
