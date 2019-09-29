
package com.citybank.statementdtls.schema.res;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.citybank.statementdtls.schema.res package. 
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

    private final static QName _StatementDtlsResp_QNAME = new QName("http://www.citybank.com/StatementDtls/Schema/Res", "StatementDtlsResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.citybank.statementdtls.schema.res
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatementDtlsRespType }
     * 
     */
    public StatementDtlsRespType createStatementDtlsRespType() {
        return new StatementDtlsRespType();
    }

    /**
     * Create an instance of {@link TransactionType }
     * 
     */
    public TransactionType createTransactionType() {
        return new TransactionType();
    }

    /**
     * Create an instance of {@link StatusBlockType }
     * 
     */
    public StatusBlockType createStatusBlockType() {
        return new StatusBlockType();
    }

    /**
     * Create an instance of {@link TransactionDetailsType }
     * 
     */
    public TransactionDetailsType createTransactionDetailsType() {
        return new TransactionDetailsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatementDtlsRespType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citybank.com/StatementDtls/Schema/Res", name = "StatementDtlsResp")
    public JAXBElement<StatementDtlsRespType> createStatementDtlsResp(StatementDtlsRespType value) {
        return new JAXBElement<StatementDtlsRespType>(_StatementDtlsResp_QNAME, StatementDtlsRespType.class, null, value);
    }

}
