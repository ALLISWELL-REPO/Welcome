
package com.citybank.cards.statement.resp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Trasaction" type="{http://www.citybank.com/StatementDtls|Schema/Resp}TrasactionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransDetailsType", propOrder = {
    "trasaction"
})
public class TransDetailsType {

    @XmlElement(name = "Trasaction")
    protected List<TrasactionType> trasaction;

    /**
     * Gets the value of the trasaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trasaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrasaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrasactionType }
     * 
     * 
     */
    public List<TrasactionType> getTrasaction() {
        if (trasaction == null) {
            trasaction = new ArrayList<TrasactionType>();
        }
        return this.trasaction;
    }

}
