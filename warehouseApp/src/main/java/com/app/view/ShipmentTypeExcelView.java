package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=shipments.xls");
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");
		Sheet sheet=workbook.createSheet("shipments");
		setHead(sheet);
		setBody(sheet,list);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("NOTE");

	}

	private void setBody(Sheet sheet,List<ShipmentType>list) {
		int rowId=1;
		for(ShipmentType s:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(s.getShipmentId());
			r.createCell(1).setCellValue(s.getShipmentMode());
			r.createCell(2).setCellValue(s.getShipmentCode());
			r.createCell(3).setCellValue(s.getEnableShipment());
			r.createCell(4).setCellValue(s.getShipmentGrade());
			r.createCell(5).setCellValue(s.getNote());

		}
	}

}
