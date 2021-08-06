package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView{

	
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition","attachment;filename=orders.pdf");
	List<OrderMethod>list=(List<OrderMethod>)model.get("list");
	Paragraph p=new Paragraph("welcome to App");
	document.add(p);
	PdfPTable t=new PdfPTable(6);
	t.addCell("ID");
	t.addCell("Mode");
	t.addCell("CODE");
	t.addCell("TYPE");
	t.addCell("ACCEPTS");
	t.addCell("NOTE");
	
	for(OrderMethod o:list) {
		t.addCell(o.getOrderId().toString());
		t.addCell(o.getOrderMode());
		t.addCell(o.getOrderCode());
		t.addCell(o.getExeType());
	t.addCell(o.getOrderAccepts().toString());
		t.addCell(o.getNote());
	}
	document.add(t);
	document.add(new Paragraph(new Date().toString()));
	
	}

}
