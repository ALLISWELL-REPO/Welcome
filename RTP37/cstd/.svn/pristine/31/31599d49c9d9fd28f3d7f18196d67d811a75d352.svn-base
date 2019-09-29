package org.o2.registersvc.intg;

import java.sql.SQLException;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

public interface RegisterSvcDAO {
	RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws BussinessException, SystemException, UnknownException, SQLException, org.o2.registersvc.intg.util.SystemException, org.o2.registersvc.intg.util.UnknownException;
}
