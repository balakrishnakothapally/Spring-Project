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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;
	@Autowired
	private UomValidator validator;
	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("uom",new Uom());

		return "UomRegister";

	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom,Errors errors ,ModelMap map) {
		validator.validate(uom, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveUom(uom);
			String messege="uom '"+id+"' saved successfully";
			map.addAttribute("utd",messege);
			map.addAttribute("uom",new Uom());
			
		}else {
			map.addAttribute("utd","please check errors");
		}
		

		return "UomRegister";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Uom>obj=service.getAllUoms();
		map.addAttribute("list",obj);

		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id")Integer uid,ModelMap map) {
		service.deleteUom(uid);
		map.addAttribute("list",service.getAllUoms());
		map.addAttribute("msg",uid+" deleted sucessfully");

		return "UomData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer uid,ModelMap map) {
		Uom ob=service.getUomById(uid);
		map.addAttribute("uom",ob);
		return "UomEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Uom uom,ModelMap map) {
		service.updateUom(uom);
		List<Uom>list=service.getAllUoms();
		map.addAttribute("list",list);
		return "UomData";

	}
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		if(id==0) {
			m.addObject("list",service.getAllUoms());
		}else {
			m.addObject("list",Collections.singletonList(service.getUomById(id)));
		}


		return m;

	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==0) {
			m.addObject("list",service.getAllUoms());
		}else {
			Uom u=service.getUomById(id);
			m.addObject("list",Collections.singletonList(u));
		}
		return m;
	}

	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]>list=service.getUomCountByType();
		System.out.println(path);
		util.generatePie(path, list);
		util.genarateBar(path, list);

		return "UomReports";
	}
	@RequestMapping("/viewone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		Uom ut=service.getUomById(id);
		map.addAttribute("st",ut);
		return "UomView";
		
	}

}
