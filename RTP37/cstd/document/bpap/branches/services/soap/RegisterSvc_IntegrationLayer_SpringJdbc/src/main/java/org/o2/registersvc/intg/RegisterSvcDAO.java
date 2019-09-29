package org.o2.registersvc.intg;

import java.sql.SQLException;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public interface RegisterSvcDAO {
RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq) throws BussinessException, SystemException, UnknownException, SQLException;
}
