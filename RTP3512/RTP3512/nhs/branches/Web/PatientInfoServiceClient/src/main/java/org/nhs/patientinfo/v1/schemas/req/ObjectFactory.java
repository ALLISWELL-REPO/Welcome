
package org.nhs.patientinfo.v1.schemas.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nhs.patientinfo.v1.schemas.req package. 
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

    private final static QName _PatientInfoReq_QNAME = new QName("http://www.nhs.org/PatientInfo/v1/schemas/Req", "PatientInfoReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nhs.patientinfo.v1.schemas.req
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientInfoReqType }
     * 
     */
    public PatientInfoReqType createPatientInfoReqType() {
        return new PatientInfoReqType();
    }

    /**
     * Create an instance of {@link PatientContextType }
     * 
     */
    public PatientContextType createPatientContextType() {
        return new PatientContextType();
    }

    /**
     * Create an instance of {@link PatientDetailsTYpe }
     * 
     */
    public PatientDetailsTYpe createPatientDetailsTYpe() {
        return new PatientDetailsTYpe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfoReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nhs.org/PatientInfo/v1/schemas/Req", name = "PatientInfoReq")
    public JAXBElement<PatientInfoReqType> createPatientInfoReq(PatientInfoReqType value) {
        return new JAXBElement<PatientInfoReqType>(_PatientInfoReq_QNAME, PatientInfoReqType.class, null, value);
    }

}
