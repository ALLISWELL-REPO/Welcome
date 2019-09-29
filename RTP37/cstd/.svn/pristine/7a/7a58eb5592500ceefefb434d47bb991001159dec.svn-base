package com.citybank.statementdtls.process.builder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionsDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.process.valuebeans.DiffrenceBtYear;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionsProcess;

@Component
public class StatementDtlsProcessResBuilder {

	public StatementDtlsProcessVbRes resProcessBuilder(StatementDtlsDAORes daoRes, StatementDtlsProcessVbReq vbreq)
			throws BusinessException {
		// TODO Auto-generated method stub
		StatementDtlsProcessVbRes vbRes = new StatementDtlsProcessVbRes();
		vbRes.setRespCode(daoRes.getRespCode());
		vbRes.setRespMsg(daoRes.getRespMsg());
		String category = vbreq.getTypeOfCate();
		if (category == null || "".equals(category.trim())) {
			category = "ALL";
			System.out.println("category " + category);
		}
		System.out.println("category " + category);

		// get dao trans list

		List<TransactionsDAO> daoTransList = daoRes.getTransDAO();
		List<TransactionsProcess> transProcessList = new ArrayList<TransactionsProcess>();
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat simpDate = new SimpleDateFormat("dd-MM-yyy");
		if (vbreq.getStartDate() == null || "".equals(vbreq.getStartDate().trim()) || vbreq.getEndDate() == null
				|| "".equals(vbreq.getEndDate().trim())) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -60);
			startDate = calendar.getTime();
			endDate = Calendar.getInstance().getTime();
		} else {
			String stringStartDate = vbreq.getStartDate();
			String stringEndDate = vbreq.getEndDate();
			try {
				startDate = simpDate.parse(stringStartDate);
				endDate = simpDate.parse(stringEndDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		long days = DiffrenceBtYear.diffrenceYear(startDate, endDate);
		System.out.println(days);
		if (days <= 0) {
			throw new BusinessException("Date002", "Provide valid Date");
		}
		if (days <= 365) {
			for (TransactionsDAO transDao : daoTransList) {
				TransactionsProcess process = new TransactionsProcess();
				String transStringDate = transDao.getDate();

				try {
					Date transDate = simpDate.parse(transStringDate);
					if (startDate.getTime() <= transDate.getTime() && transDate.getTime() <= endDate.getTime()) {
						TransactionsProcess transProcess = new TransactionsProcess();
						
						if(transDao.getStatus().equalsIgnoreCase(category)){
							System.out.println("success");
							transProcess=getTransactionProcess(transDao);
							transProcessList.add(transProcess);
						}
					}
					vbRes.setTransProcess(transProcessList);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("provide only 12 month transaction");
			throw new BusinessException("Date001", "provide 12 months transactions");
		}
		return vbRes;
	}

		// iterate the transaction from dao and set to process
		public static TransactionsProcess getTransactionProcess(TransactionsDAO daoTrans){
			
		//for (TransactionsDAO daoTrans : daoTransList) {
			TransactionsProcess transProcess = new TransactionsProcess();
			transProcess.setId(daoTrans.getId());
			transProcess.setDate(daoTrans.getDate());
			transProcess.setName(daoTrans.getName());
			
			transProcess.setDesc(daoTrans.getDesc());
			transProcess.setMerchantname(daoTrans.getMerchantname());
			transProcess.setAmount(daoTrans.getAmount());
			transProcess.setStatus(daoTrans.getStatus());
			transProcess.setRemarks(daoTrans.getRemarks());

			return transProcess;

		}
	
	}


