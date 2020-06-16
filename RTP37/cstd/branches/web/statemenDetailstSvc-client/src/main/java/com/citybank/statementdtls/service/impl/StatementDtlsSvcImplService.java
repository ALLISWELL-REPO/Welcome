
package com.citybank.statementdtls.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StatementDtlsSvcImplService", targetNamespace = "http://impl.service.statementdtls.citybank.com/", wsdlLocation = "http://localhost:8080/stmtdetailsSvc_war/transDetails?wsdl")
public class StatementDtlsSvcImplService
    extends Service
{

    private final static URL STATEMENTDTLSSVCIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException STATEMENTDTLSSVCIMPLSERVICE_EXCEPTION;
    private final static QName STATEMENTDTLSSVCIMPLSERVICE_QNAME = new QName("http://impl.service.statementdtls.citybank.com/", "StatementDtlsSvcImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/stmtdetailsSvc_war/transDetails?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STATEMENTDTLSSVCIMPLSERVICE_WSDL_LOCATION = url;
        STATEMENTDTLSSVCIMPLSERVICE_EXCEPTION = e;
    }

    public StatementDtlsSvcImplService() {
        super(__getWsdlLocation(), STATEMENTDTLSSVCIMPLSERVICE_QNAME);
    }

    public StatementDtlsSvcImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), STATEMENTDTLSSVCIMPLSERVICE_QNAME, features);
    }

    public StatementDtlsSvcImplService(URL wsdlLocation) {
        super(wsdlLocation, STATEMENTDTLSSVCIMPLSERVICE_QNAME);
    }

    public StatementDtlsSvcImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STATEMENTDTLSSVCIMPLSERVICE_QNAME, features);
    }

    public StatementDtlsSvcImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StatementDtlsSvcImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StatementDetailsSvc
     */
    @WebEndpoint(name = "StatementDtlsSvcImplPort")
    public StatementDetailsSvc getStatementDtlsSvcImplPort() {
        return super.getPort(new QName("http://impl.service.statementdtls.citybank.com/", "StatementDtlsSvcImplPort"), StatementDetailsSvc.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StatementDetailsSvc
     */
    @WebEndpoint(name = "StatementDtlsSvcImplPort")
    public StatementDetailsSvc getStatementDtlsSvcImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.statementdtls.citybank.com/", "StatementDtlsSvcImplPort"), StatementDetailsSvc.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STATEMENTDTLSSVCIMPLSERVICE_EXCEPTION!= null) {
            throw STATEMENTDTLSSVCIMPLSERVICE_EXCEPTION;
        }
        return STATEMENTDTLSSVCIMPLSERVICE_WSDL_LOCATION;
    }

}