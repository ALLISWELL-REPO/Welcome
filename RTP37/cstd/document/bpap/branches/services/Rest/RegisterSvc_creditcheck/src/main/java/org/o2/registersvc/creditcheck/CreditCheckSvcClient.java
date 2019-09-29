package org.o2.registersvc.creditcheck;

import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.springframework.stereotype.Component;


public interface CreditCheckSvcClient {
	public CreditCheckResponse getCreditScore(CreditCheckRequest req);

}
