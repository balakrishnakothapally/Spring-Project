package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;


public class UomExcelView extends AbstractXlsxView{

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=shipments.xls");
		List<Uom> list=(List<Uom>)model.get("list");
		Sheet sheet=workbook.createSheet("uoms");
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<Uom> list) {
		int rowId=1;
		for(Uom u:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(u.getuId());
			r.createCell(1).setCellValue(u.getuType());
			r.createCell(2).setCellValue(u.getuModel());
			r.createCell(3).setCellValue(u.getuDes());
		}		
		
	}

	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("NOTE");
		
	}

	
	}


