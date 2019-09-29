
package com.citybank.statementdtls.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StatementDetailsService", targetNamespace = "http://www.citybank.com/StatementDtls/service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.citybank.statementdtls.schema.req.ObjectFactory.class,
    com.citybank.statementdtls.schema.res.ObjectFactory.class
})
public interface StatementDetailsService {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.citybank.statementdtls.schema.res.StatementDtlsRespType
     */
    @WebMethod(action = "http://www.example.org/StatementDetailsService/NewOperation")
    @WebResult(name = "StatementDtlsResp", targetNamespace = "http://www.citybank.com/StatementDtls/Schema/Res", partName = "parameters")
    @Action(input = "http://www.example.org/StatementDetailsService/NewOperation", output = "http://www.citybank.com/StatementDtls/service/StatementDetailsService/getTransactionsResponse")
    public StatementDtlsRespType getTransactions(
        @WebParam(name = "StatementDtlsReq", targetNamespace = "http://www.citybank.com/StatementDtls/Schema/Req", partName = "parameters")
        StatementDtlsReqType parameters);

}
