package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;


public class OrderMethodExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=orders.xlsx");

		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
		Sheet sheet=workbook.createSheet("orders");
		setHead(sheet);
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ACCEPTS");
		row.createCell(5).setCellValue("NOTE");





	}





	private void setBody(Sheet sheet, List<OrderMethod>list) {
		int rowId=1;

		for(OrderMethod s:list) {
			Row r=sheet.createRow(rowId++);
			r.createCell(0).setCellValue(s.getOrderId().toString());
			r.createCell(1).setCellValue(s.getOrderMode());
			r.createCell(2).setCellValue(s.getOrderCode());
			r.createCell(3).setCellValue(s.getExeType());
			r.createCell(4).setCellValue(s.getOrderAccepts().toString());
			r.createCell(5).setCellValue(s.getNote());


		}


	}

}
