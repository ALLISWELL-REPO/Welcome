package org.o2.register.svc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o2.register.svc.beans.ErrorBean;
import org.o2.register.svc.builder.RegisterServletReqBuilder;
import org.o2.register.svc.client.beans.RegisterSvcWebReq;
import org.o2.register.svc.client.beans.RegisterSvcWebRes;
import org.o2.register.svc.client.impl.RegisterServiceClientImpl;
import org.o2.register.svc.exception.ApplicationExceptions;

//@WebServlet("/register")
public class RegisterServlet  extends HttpServlet {

	String page="result.jsp";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RegisterSvcWebRes wbRes = null;
		try {
		//prepare request for serviceclient
		RegisterServletReqBuilder servletReqBuilder=new RegisterServletReqBuilder();
		RegisterSvcWebReq webReq=servletReqBuilder.buildWebReq(req);
		//call client by passing webReq
		RegisterServiceClientImpl client=new RegisterServiceClientImpl();
		/*RegisterSvcWebRes wbRes;*/
		
			wbRes = client.enrollment(webReq);
		} catch (ApplicationExceptions e) {
			 page="error.jsp";
			ErrorBean errorBean=new ErrorBean();
			
			errorBean.setRespCode(e.getRespCode());
			errorBean.setRespmsg(e.getRespMsg());
			wbRes.setRespCode(errorBean.getRespCode());
			wbRes.setRespMsg(errorBean.getRespmsg());
			//e.printStackTrace();
		}
		
	 req.setAttribute("wbRes",wbRes);	 
	 req.getRequestDispatcher("page").forward(req, resp);
	 
	}
}
