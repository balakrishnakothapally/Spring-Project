package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView{

	
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=users.pdf");
		List<User> list=(List<User>)model.get("list");
		Paragraph p=new Paragraph("welcome to App");
		document.add(p);
		PdfPTable t=new PdfPTable(5);
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("EMAIL");
		t.addCell("PASSWORD");
		t.addCell("ROLES");
		
		for(User u:list) {
			t.addCell(u.getUserId().toString());
			t.addCell(u.getUserName());
			t.addCell(u.getUserEmail());
			t.addCell(u.getUserPwd());
			t.addCell(u.getRoles().toString());
		}
		
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}
	
	
	

}
