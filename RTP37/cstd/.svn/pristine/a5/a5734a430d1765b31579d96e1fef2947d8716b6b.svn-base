package org.o2.registersvc.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public interface RegisterSvcProcess {

	RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq req) throws BussinessException, SystemException, UnknownException, SQLException, FileNotFoundException, IOException;
}
