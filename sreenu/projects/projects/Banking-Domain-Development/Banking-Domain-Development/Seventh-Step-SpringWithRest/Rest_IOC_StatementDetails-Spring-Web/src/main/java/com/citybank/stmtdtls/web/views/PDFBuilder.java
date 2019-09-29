package com.citybank.stmtdtls.web.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.citybank.stmtdtlssvc.client.beans.TransactionClient;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFBuilder extends AbstrctITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("entered into pef builder");

		List<TransactionClient> listOfTrans = new ArrayList<TransactionClient>();

		listOfTrans = (List<TransactionClient>) model.get(listOfTrans);

		System.out.println("pdf builder list size" + listOfTrans.size());

		doc.add(new Paragraph("welcome to citybank"));

		if (listOfTrans.size() == 0) {

			doc.add(new Paragraph("No transactions found"));

		}

		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f,
				3.0f });
		table.setSpacingBefore(10);

		// define font for table header row

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(BaseColor.WHITE);

		// define table header cell

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		if (listOfTrans.size() > 0) {

			cell.setPhrase(new Phrase("id", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("DATE", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("description", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("merchantname", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("amount", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("status", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("remarks", font));
			table.addCell(cell);

			for (TransactionClient client : listOfTrans) {

				table.addCell(client.getTransid());
				table.addCell(client.getDate());

				table.addCell(client.getName());

				table.addCell(client.getDesc());

				table.addCell(client.getMerchantname());

				table.addCell(client.getAmount());

				table.addCell(client.getStatus());

				table.addCell(client.getRemarks());

			}

		}

		doc.add(table);

		System.out.println("exit from pdf builder ");

	}

}
