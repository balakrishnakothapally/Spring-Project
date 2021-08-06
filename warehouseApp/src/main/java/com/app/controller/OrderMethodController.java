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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;
	@Autowired
	private OrderMethodValidator validator;

	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";

	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveOrderMethod(orderMethod);
			String messege="Order'"+id+"'saved Sucessfully";
			map.addAttribute("msg",messege);
			map.addAttribute("orderMethod",new OrderMethod());
			
		}else {
			map.addAttribute("msg","please check for errors");
		}
		return "OrderMethodRegister";

	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<OrderMethod>obj=service.getAllOrderMethodTypes();
		map.addAttribute("list",obj);

		return "OrderMethodData";


	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id")Integer oid,ModelMap map) {
		service.deleteOrderMethod(oid);
		map.addAttribute("list",service.getAllOrderMethodTypes());
		map.addAttribute("msg",oid+"deleted successfully");
		return "OrderMethodData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer oid,ModelMap map) {
		OrderMethod ob=service.getOrderMethodById(oid);
		map.addAttribute("orderMethod",ob);

		return "OrderMethodEdit";

	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute OrderMethod orderMethod,ModelMap map) {

		service.updateOrderMethod(orderMethod);
		List<OrderMethod>list=service.getAllOrderMethodTypes();
		map.addAttribute("list",list);
		return "OrderMethodData";

	}
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		if(id==0) {
			m.addObject("list",service.getAllOrderMethodTypes());

		}else {
			//			OrderMethod order= service.getOrderMethodById(id);
			m.addObject("list",Collections.singletonList(service.getOrderMethodById(id)));
			//			m.addObject("list", Arrays.asList(order).toString());
		}
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		if(id==0) {
			m.addObject("list",service.getAllOrderMethodTypes());

		}else {
			OrderMethod order=service.getOrderMethodById(id);
			m.addObject("list",Collections.singletonList(order));
		}

		m.setView(new OrderMethodPdfView());
		return m;

	}
	@RequestMapping("/charts")
	public String showCharts() {
		String path=context.getRealPath("/");
		List<Object[]> list=service.getOrderMethodCountByMode();
		System.out.println(path);
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "OrderMethodReports";

	}
	@RequestMapping("/viewone")
	public String getOneRow(@RequestParam Integer id,ModelMap map) {
		OrderMethod om=service.getOrderMethodById(id);
		map.addAttribute("om",om);
		return "OrderMethodView";
		
	}
	}
