
package org.o2.registersvc.service;

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
@WebServiceClient(name = "EnrollmentService", targetNamespace = "http://www.o2.org/RegisterSvc/Service", wsdlLocation = "file:/D:/RTP3602/RegisterSvc_xsdwsdl/src/main/resources/RegisterService.wsdl")
public class EnrollmentService
    extends Service
{

    private final static URL ENROLLMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException ENROLLMENTSERVICE_EXCEPTION;
    private final static QName ENROLLMENTSERVICE_QNAME = new QName("http://www.o2.org/RegisterSvc/Service", "EnrollmentService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/RTP3602/RegisterSvc_xsdwsdl/src/main/resources/RegisterService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ENROLLMENTSERVICE_WSDL_LOCATION = url;
        ENROLLMENTSERVICE_EXCEPTION = e;
    }

    public EnrollmentService() {
        super(__getWsdlLocation(), ENROLLMENTSERVICE_QNAME);
    }

    public EnrollmentService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ENROLLMENTSERVICE_QNAME, features);
    }

    public EnrollmentService(URL wsdlLocation) {
        super(wsdlLocation, ENROLLMENTSERVICE_QNAME);
    }

    public EnrollmentService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ENROLLMENTSERVICE_QNAME, features);
    }

    public EnrollmentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EnrollmentService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RegisterService
     */
    @WebEndpoint(name = "RegisterServicePort")
    public RegisterService getRegisterServicePort() {
        return super.getPort(new QName("http://www.o2.org/RegisterSvc/Service", "RegisterServicePort"), RegisterService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RegisterService
     */
    @WebEndpoint(name = "RegisterServicePort")
    public RegisterService getRegisterServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.o2.org/RegisterSvc/Service", "RegisterServicePort"), RegisterService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ENROLLMENTSERVICE_EXCEPTION!= null) {
            throw ENROLLMENTSERVICE_EXCEPTION;
        }
        return ENROLLMENTSERVICE_WSDL_LOCATION;
    }

}
