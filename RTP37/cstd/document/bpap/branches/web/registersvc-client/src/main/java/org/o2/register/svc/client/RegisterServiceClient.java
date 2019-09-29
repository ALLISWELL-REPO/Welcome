/*@NHS All rights are reserved.You should not disclose the
 * Information outside otherwise terms and conditions will apply
 * 
 */
package org.o2.register.svc.client;

import org.o2.register.svc.client.beans.RegisterSvcWebReq;
import org.o2.register.svc.client.beans.RegisterSvcWebRes;
import org.o2.register.svc.exception.ApplicationExceptions;

/**
 * @author stech
 * @Date 22-Apr-2018
   @Description : 
 * 
 */
public interface RegisterServiceClient {
	
	RegisterSvcWebRes enrollment(RegisterSvcWebReq req) throws ApplicationExceptions;

}
