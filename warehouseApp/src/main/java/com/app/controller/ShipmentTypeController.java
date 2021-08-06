package com.app.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.util.ShipmentTypeUtil;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;


@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;
	@Autowired
	private ShipmentTypeValidator validator;

	@RequestMapping("/register")
	public String showPage(ModelMap map) {
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Errors errors,ModelMap map) {
		//call validator
		validator.validate(shipmentType, errors);
		if(!errors.hasErrors()) {
			//if no errors
			Integer id=service.saveShipmentType(shipmentType);
			String messege="Shipment '"+id+"' saved Sucessfully";
			map.addAttribute("std",messege);
			//clear form backing object
			map.addAttribute("shipmentType",new ShipmentType());

		}
		else {
			//error exist
			map.addAttribute("message","please check errors");

		}
		return "ShipmentTypeRegister";

	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<ShipmentType>obj=service.getAllShipmentTypes();
		map.addAttribute("list",obj);
		return "ShipmentTypeData";

	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id")Integer sid,ModelMap map) {
		service.deleteShipmentType(sid);
		map.addAttribute("list",service.getAllShipmentTypes());
		map.addAttribute("msg",sid+ " deleted sucessfully");
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer sid,ModelMap map) {
		ShipmentType ob=service.getShipmentTypeById(sid);
		map.addAttribute("shipmentType",ob);
		return "ShipmentTypeEdit";

	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		service.updateShipmentType(shipmentType);
		List<ShipmentType>list=service.getAllShipmentTypes();
		map.addAttribute("list",list);
		return "ShipmentTypeData";

	}
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		if(id==0) {
			m.addObject("list",service.getAllShipmentTypes());
		}else {
			m.addObject("list",Collections.singletonList(service.getShipmentTypeById(id)));
		}

		return m;

	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(id==0) {
			m.addObject("list",service.getAllShipmentTypes());
		}else {
			ShipmentType s=service.getShipmentTypeById(id);
			m.addObject("list",Collections.singletonList(s));
		}

		return m;

	}
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getShipmentCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "ShipmentTypeReports";
	}
	@RequestMapping("/viewone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		ShipmentType st=service.getShipmentTypeById(id);
		map.addAttribute("st",st);
		return "ShipmentTypeView";
	}




}

