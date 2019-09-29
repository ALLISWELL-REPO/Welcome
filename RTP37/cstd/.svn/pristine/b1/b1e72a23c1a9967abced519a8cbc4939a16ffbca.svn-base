package com.citybank.statementdtls.process.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TrasactionDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.process.util.DifferenceBTYear;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;

@Component
public class StatementDtlsProcessResBuiler {

	//private Logger logger = Logger.getLogger(StatementDtlsProcessResBuiler.class);

	public StatementDtlsProcessVbRes buildProcessVbResponse(StatementDtlsDAORes daoRes, StatementDtlsProcessVbReq vbReq)
			throws BusinessException {
		//logger.debug("enter into the process resp builder");
		StatementDtlsProcessVbRes processVbRes = new StatementDtlsProcessVbRes();

		processVbRes.setRespCode(daoRes.getRespCode());
		processVbRes.setRespMsg(daoRes.getRespMsg());
		
		String category = vbReq.getTypeOfCate();
		if (category == null || "".equals(category.trim())) {
			category = "ALL";
			System.out.println("categery " + category);
		}
		//logger.info("categery " + category);

		List<TransactionProcess> processList = new ArrayList<TransactionProcess>();
		List<TrasactionDAO> daoList = daoRes.getTransDAO();
		//logger.info("process list --" + daoList.size());
		// now convert daoList to the ProcessList and add to the response
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (vbReq.getStartDate() == null || "".equals(vbReq.getStartDate().trim()) || vbReq.getEndDate() == null
				|| "".equals(vbReq.getEndDate().trim())) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -60);
			startDate = calendar.getTime();
			endDate = Calendar.getInstance().getTime();
		} else {
			String stringStartDate = vbReq.getStartDate();
			String stringEndDate = vbReq.getEndDate();
			try {
				startDate = sdf.parse(stringStartDate);
				endDate = sdf.parse(stringEndDate);
			} catch (ParseException e) {
				//logger.error("ParseException in PL",e);
			}

		}
		long days = DifferenceBTYear.diferrence(startDate, endDate);
		//logger.info("days in PL :"+days);
		if (days <= 0) {
			throw new BusinessException("Date002", "please provide valid date");
		}
		if (days < 365) {
			for (TrasactionDAO transdao : daoList) {
				TransactionProcess process = new TransactionProcess();
				String transStringDate = transdao.getDate();
				try {
					Date transDate = sdf.parse(transStringDate);
					if (startDate.getTime() <= transDate.getTime() && transDate.getTime() <= endDate.getTime()) {
						TransactionProcess transProcess = new TransactionProcess();

						if (transdao.getStatus().equalsIgnoreCase(category)) {
							//logger.debug("success");
							transProcess = getTransactionProcess(transdao);
							processList.add(transProcess);
						} else if ("ALL".equalsIgnoreCase(category)) {
							transProcess = getTransactionProcess(transdao);
							processList.add(transProcess);
						}
					}
					processVbRes.setTransProcess(processList);

				} catch (ParseException e) {
					//logger.error("ParseException in PL",e);
				}

			}

		} else {
			//logger.debug("we can provide only 12 months trasaction");
			throw new BusinessException("Date001", "we can provide only 12 months trasaction");
		}
		//logger.debug("exit  from the process resp builder");
		return processVbRes;
	}

	public static TransactionProcess getTransactionProcess(TrasactionDAO transDao) {
		TransactionProcess transProcess = new TransactionProcess();
		transProcess.setId(transDao.getId());
		transProcess.setDate(transDao.getDate());
		transProcess.setName(transDao.getName());
		transProcess.setDesc(transDao.getDesc());
		transProcess.setMerchantName(transDao.getMerchantName());
		transProcess.setAmount(transDao.getAmount());
		transProcess.setStatus(transDao.getStatus());
		transProcess.setRemarks(transDao.getRemarks());

		return transProcess;
	}

}
