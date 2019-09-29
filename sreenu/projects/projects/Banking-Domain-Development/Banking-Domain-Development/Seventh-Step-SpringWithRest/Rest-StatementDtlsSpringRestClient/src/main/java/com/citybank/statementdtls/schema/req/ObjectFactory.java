
package com.citybank.statementdtls.schema.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.citybank.statementdtls.schema.req package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _StatementDtlsReq_QNAME = new QName("http://www.citybank.com/StatementDtls/Schema/Req", "StatementDtlsReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.citybank.statementdtls.schema.req
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatementDtlsReqType }
     * 
     */
    public StatementDtlsReqType createStatementDtlsReqType() {
        return new StatementDtlsReqType();
    }

    /**
     * Create an instance of {@link TransCategoryType }
     * 
     */
    public TransCategoryType createTransCategoryType() {
        return new TransCategoryType();
    }

    /**
     * Create an instance of {@link ServiceDetailsType }
     * 
     */
    public ServiceDetailsType createServiceDetailsType() {
        return new ServiceDetailsType();
    }

    /**
     * Create an instance of {@link CustomerDetailsType }
     * 
     */
    public CustomerDetailsType createCustomerDetailsType() {
        return new CustomerDetailsType();
    }

    /**
     * Create an instance of {@link DateRangeType }
     * 
     */
    public DateRangeType createDateRangeType() {
        return new DateRangeType();
    }

    /**
     * Create an instance of {@link ClientDetailsType }
     * 
     */
    public ClientDetailsType createClientDetailsType() {
        return new ClientDetailsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatementDtlsReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citybank.com/StatementDtls/Schema/Req", name = "StatementDtlsReq")
    public JAXBElement<StatementDtlsReqType> createStatementDtlsReq(StatementDtlsReqType value) {
        return new JAXBElement<StatementDtlsReqType>(_StatementDtlsReq_QNAME, StatementDtlsReqType.class, null, value);
    }

}
