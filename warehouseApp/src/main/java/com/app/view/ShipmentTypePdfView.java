package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=shipments.pdf");
		List<ShipmentType>list=(List<ShipmentType>)model.get("list");
		Paragraph p=new Paragraph("welcome to App");
		document.add(p);
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("Mode");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("GRADE");
		t.addCell("NOTE");
		
		for(ShipmentType s:list) {
			t.addCell(s.getShipmentId().toString());
			t.addCell(s.getShipmentMode());
			t.addCell(s.getEnableShipment());
			t.addCell(s.getShipmentGrade());
			t.addCell(s.getNote());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
		
	}

}
