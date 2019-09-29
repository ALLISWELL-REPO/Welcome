package com.citybank.stmtdtlssvc.web.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.citybank.stmtdtlssvc.client.beans.TransactionClient;

public class ExcelBuilder extends AbstractXlsView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("enter into excel builder");
		List<TransactionClient> listOfTrans = new ArrayList<TransactionClient>();
		listOfTrans = (List<TransactionClient>) model.get("listOfTrans");
		System.out.println("Excel list "+listOfTrans.size());
		// create a new Excel sheet
		Sheet sheet = workbook.createSheet("Transaction");
		sheet.setDefaultColumnWidth(30);

		// create a style for header parts
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		// create header row
		Row header = sheet.createRow(0);
		if (listOfTrans.size() > 0) {
			header.createCell(0).setCellValue("id");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("date");
			header.getCell(1).setCellStyle(style);

			header.createCell(2).setCellValue("name");
			header.getCell(2).setCellStyle(style);

			header.createCell(3).setCellValue("description");
			header.getCell(3).setCellStyle(style);

			header.createCell(4).setCellValue("merchantName");
			header.getCell(4).setCellStyle(style);

			header.createCell(5).setCellValue("amount");
			header.getCell(5).setCellStyle(style);

			header.createCell(6).setCellValue("status");
			header.getCell(6).setCellStyle(style);

			header.createCell(7).setCellValue("remarks");
			header.getCell(7).setCellStyle(style);

			// create data rows
			int rowCount = 1;
			
			for(TransactionClient client : listOfTrans){
				Row row=sheet.createRow(rowCount++);
				row.createCell(0).setCellValue(client.getId());
				row.createCell(1).setCellValue(client.getDate());
				row.createCell(2).setCellValue(client.getName());
				row.createCell(3).setCellValue(client.getDesc());
				row.createCell(4).setCellValue(client.getMerchantName());
				row.createCell(5).setCellValue(client.getAmount());
				row.createCell(6).setCellValue(client.getStatus());
				row.createCell(7).setCellValue(client.getRemarks());
			}

		}
		System.out.println("exit from excel builder");
	}
}
