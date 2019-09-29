
package org.o2.registersvc.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegisterService", targetNamespace = "http://www.o2.org/RegisterSvc/Service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    org.o2.registersvc.schema.req.ObjectFactory.class,
    org.o2.registersvc.schema.res.ObjectFactory.class
})
public interface RegisterService {


    /**
     * 
     * @param parameters
     * @return 
     *     returns org.o2.registersvc.schema.res.RegisterServiceResType
     */
    @WebMethod
    @WebResult(name = "RegisterServiceRes", targetNamespace = "http://www.o2.org/RegisterSvc/Schema/Res", partName = "parameters")
    public RegisterServiceResType enrollment(
        @WebParam(name = "RegisterServiceReq", targetNamespace = "http://www.o2.org/RegisterSvc/Schema/Req", partName = "parameters")
        RegisterServiceReqType parameters);

}
