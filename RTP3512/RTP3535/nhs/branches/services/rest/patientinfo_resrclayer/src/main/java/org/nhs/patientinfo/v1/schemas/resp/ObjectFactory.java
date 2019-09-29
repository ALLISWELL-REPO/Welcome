
package org.nhs.patientinfo.v1.schemas.resp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nhs.patientinfo.v1.schemas.resp package. 
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

    private final static QName _PatientInfoRes_QNAME = new QName("http://www.nhs.org/PatientInfo/v1/schemas/Resp", "PatientInfoRes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nhs.patientinfo.v1.schemas.resp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientInfoResType }
     * 
     */
    public PatientInfoResType createPatientInfoResType() {
        return new PatientInfoResType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientInfoResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.nhs.org/PatientInfo/v1/schemas/Resp", name = "PatientInfoRes")
    public JAXBElement<PatientInfoResType> createPatientInfoRes(PatientInfoResType value) {
        return new JAXBElement<PatientInfoResType>(_PatientInfoRes_QNAME, PatientInfoResType.class, null, value);
    }

}
