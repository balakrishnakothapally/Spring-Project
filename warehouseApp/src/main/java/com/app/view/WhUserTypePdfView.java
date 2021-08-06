package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		
		response.addHeader("Content-Disposition","attachment;filename=users.pdf");
		List<WhUserType>list=(List<WhUserType>)model.get("list");
		Paragraph p=new Paragraph("welcome to App");
		document.add(p);
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("FOR");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("IDTYPE");
		t.addCell("NUMBER");
		
		for(WhUserType s:list) {
			t.addCell(s.getUserId().toString());
			t.addCell(s.getUserIdType());
			t.addCell(s.getUserCode());
			t.addCell(s.getUserFor());
			t.addCell(s.getUserGmail());
			t.addCell(s.getUserContact().toString());
			t.addCell(s.getUserIdType());
			t.addCell(s.getUserIdNumber().toString());
			
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}

	}

	

	


