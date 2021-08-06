package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=users.xlsx");
	
		List<WhUserType> list=(List<WhUserType>)model.get("list");
		Sheet sheet=workbook.createSheet("users");
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<WhUserType> list) {
		
		int rowId=1;
		for(WhUserType u:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(u.getUserId());
			r.createCell(1).setCellValue(u.getUserType());
			r.createCell(2).setCellValue(u.getUserCode());
			r.createCell(3).setCellValue(u.getUserFor());
			r.createCell(4).setCellValue(u.getUserGmail());
			r.createCell(5).setCellValue(u.getUserContact());
			r.createCell(6).setCellValue(u.getUserIdType());
			r.createCell(7).setCellValue(u.getUserIdNumber());
		}
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("FOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("IDTYPE");
		row.createCell(7).setCellValue("NUMBER");
		
	}

}
