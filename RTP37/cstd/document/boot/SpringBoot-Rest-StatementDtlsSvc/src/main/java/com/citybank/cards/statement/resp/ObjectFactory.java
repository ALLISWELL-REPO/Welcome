
package com.citybank.cards.statement.resp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.citybank.statementdtls_schema.resp package. 
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

    private final static QName _StatementDtlsRes_QNAME = new QName("http://www.citybank.com/StatementDtls|Schema/Resp", "StatementDtlsRes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.citybank.statementdtls_schema.resp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatementDtlsResType }
     * 
     */
    public StatementDtlsResType createStatementDtlsResType() {
        return new StatementDtlsResType();
    }

    /**
     * Create an instance of {@link StatusBlockType }
     * 
     */
    public StatusBlockType createStatusBlockType() {
        return new StatusBlockType();
    }

    /**
     * Create an instance of {@link TrasactionType }
     * 
     */
    public TrasactionType createTrasactionType() {
        return new TrasactionType();
    }

    /**
     * Create an instance of {@link TransDetailsType }
     * 
     */
    public TransDetailsType createTransDetailsType() {
        return new TransDetailsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatementDtlsResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citybank.com/StatementDtls|Schema/Resp", name = "StatementDtlsRes")
    public JAXBElement<StatementDtlsResType> createStatementDtlsRes(StatementDtlsResType value) {
        return new JAXBElement<StatementDtlsResType>(_StatementDtlsRes_QNAME, StatementDtlsResType.class, null, value);
    }

}
