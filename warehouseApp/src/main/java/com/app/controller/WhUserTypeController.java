
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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtil util;
	@Autowired
	private WhUserTypeValidator validator;
	
	@RequestMapping("/show")
	public String showPage(ModelMap map) {

		map.addAttribute("whUserType",new WhUserType());
		return "WhUserTypeRegister";

	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType, Errors errors,ModelMap map) {
		validator.validate(whUserType, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveWhUserType(whUserType);
			String messege="whUserType '"+id+"' saved successfully";
			map.addAttribute("utd",messege);
			map.addAttribute("whUserType",new WhUserType());
			
		}else {
			map.addAttribute("utd","please check errors");
		}
		return "WhUserTypeRegister";

	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<WhUserType> obj=service.getAllWhUserTypes();
		map.addAttribute("list",obj);
		return "WhUserTypeData";

	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id")Integer uid,ModelMap map) {
		service.deleteWhUserType(uid);
		map.addAttribute("list",service.getAllWhUserTypes());
		map.addAttribute("msg",uid+"deleted sucessfully");
		return "WhUserTypeData";


	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer uid,ModelMap map) {
		WhUserType ob=service.getWhUserTypeById(uid);
		map.addAttribute("whUserType",ob);

		return "WhUserTypeEdit";

	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute WhUserType whUserType,ModelMap map) {
		service.updateWhUserType(whUserType);
		List<WhUserType>list=service.getAllWhUserTypes();
		map.addAttribute("list",list);

		return "WhUserTypeData";

	}
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		if(id==0) {
			m.addObject("list",service.getAllWhUserTypes());
		}
		else {
			m.addObject("list",Collections.singletonList(service.getWhUserTypeById(id)));
		}

		return m;

	}
	@RequestMapping("/pdf")
	public ModelAndView doPdfExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if(id==0) {
			m.addObject("list",service.getAllWhUserTypes());
		}
		else {
			m.addObject("list",Collections.singletonList(service.getWhUserTypeById(id)));
		}

		return m;

	}
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]>list=service.getWhUserCountByType();
		System.out.println(path);
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "WhUserReports";
	}
	@RequestMapping("/viewone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		WhUserType wt=service.getWhUserTypeById(id);
		map.addAttribute("wt",wt);
		return "WhUserTypeView";
		
	}
}
