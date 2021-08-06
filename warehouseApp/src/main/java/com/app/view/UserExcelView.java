package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsxView{

	@Override
	@SuppressWarnings("unchecked")
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=users.xlsx");
		List<User> list=(List<User>)model.get("list");
		Sheet sheet=workbook.createSheet("users");
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<User> list) {
		int rowId=1;
		for(User u:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(u.getUserId().toString());
			r.createCell(1).setCellValue(u.getUserName());
			r.createCell(2).setCellValue(u.getUserEmail());
			r.createCell(3).setCellValue(u.getUserPwd());
			r.createCell(4).setCellValue(u.getRoles().toString());
		}
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("PASSWORD");
		row.createCell(4).setCellValue("ROLES");
	}

}
