package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.Date;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {


	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		response.addHeader("Content-Disposition","attachment;filename=shipments.pdf");
		List<Uom> list=(List<Uom>)model.get("list");
		Paragraph p=new Paragraph();
		document.add(p);
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");
		for(Uom u:list) {
			t.addCell(u.getuId().toString());
			t.addCell(u.getuType());
			t.addCell(u.getuModel());
			t.addCell(u.getuDes());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}

	
	

}
