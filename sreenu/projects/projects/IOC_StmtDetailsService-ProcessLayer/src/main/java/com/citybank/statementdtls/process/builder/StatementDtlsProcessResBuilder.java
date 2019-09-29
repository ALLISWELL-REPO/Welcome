package com.citybank.statementdtls.process.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.process.util.DifferenceBTYear;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;

@Component
public class StatementDtlsProcessResBuilder {

	@SuppressWarnings("static-access")
	public StatementDtlsProcessVbRes buildProcessVbResponse(	StatementDtlsDAORes daoRes, StatementDtlsProcessVbReq vbReq)
			throws BusinessException {

		StatementDtlsProcessVbRes processVbRes = new StatementDtlsProcessVbRes();

		processVbRes.setExpncode(daoRes.getExpncode());
		processVbRes.setExpmsg(daoRes.getExpmsg());

		String category = vbReq.getTypeOfCate();

		if (category == null || "".equals(category.trim())) {

			category = "ALL";
			System.out.println("category" + category);

		}
		System.out.println("category" + category);

		List<TransactionProcess> processList = new ArrayList<TransactionProcess>();
		List<TransactionDAO> daoList = daoRes.getTransDAO();

		System.out.println("Process List" + daoList.size());

		Date startDate = null;
		Date endDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (vbReq.getStartdate() == null
				|| "".equals(vbReq.getStartdate().trim())
				|| "".equals(vbReq.getEnddate().trim())) {

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -60);
			startDate = calendar.getTime();
			endDate = calendar.getInstance().getTime();
		} else {

			String stringStartDate = vbReq.getStartdate();
			String stringEndDate = vbReq.getEnddate();

			try {
				startDate = sdf.parse(stringStartDate);
				endDate = sdf.parse(stringEndDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		long days = DifferenceBTYear.difference(startDate, endDate);
		System.out.println(days);

		if (days <= 0) {
			throw new BusinessException("Date002", "please provide valid date");
		}

		if (days < 365) {

			for (TransactionDAO transDao : daoList) {
				TransactionProcess process = new TransactionProcess();

				String transStringDate = transDao.getDate();

				try {

					Date transDate = sdf.parse(transStringDate);

					if (startDate.getTime() <= transDate.getTime()
							&& transDate.getTime() <= endDate.getTime()) {

						TransactionProcess transProcess = new TransactionProcess();

						if (transDao.getStatus().equalsIgnoreCase(category)) {

							System.out.println("success");

							transProcess = getTransactionProcess(transDao);
							processList.add(transProcess);
						} else if ("ALL".equalsIgnoreCase(category)) {
							transProcess = getTransactionProcess(transDao);
							processList.add(transProcess);
						}

					}

					processVbRes.setTransProcess(processList);

				} catch (ParseException e) {
					e.printStackTrace();
				}

			}

		} else {
			System.out.println("upto 12 months transaction only");
			throw new BusinessException("Date001",
					"upto 12 months transaction only");
		}

		return processVbRes;

	}

	private TransactionProcess getTransactionProcess(TransactionDAO transdao) {
		TransactionProcess transProcess = new TransactionProcess();

		transProcess.setTransid(transdao.getTransid());
		transProcess.setDate(transdao.getDate());
		transProcess.setName(transdao.getName());
		transProcess.setDesc(transdao.getDesc());
		transProcess.setMerchantname(transdao.getMerchantname());
		transProcess.setAmount(transdao.getAmount());
		transProcess.setStatus(transdao.getStatus());
		transProcess.setRemarks(transdao.getRemarks());
		return transProcess;
	}

}
