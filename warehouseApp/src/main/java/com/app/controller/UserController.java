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

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.UserUtil;
import com.app.validator.UserValidator;
import com.app.view.UserExcelView;
import com.app.view.UserPdfView;

@Controller
@RequestMapping("/sample")
public class UserController {
	@Autowired
	private IUserService service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private UserUtil util;
	@Autowired
	private UserValidator validator;
	@RequestMapping("/show")
	public String showPage(ModelMap map) {
		map.addAttribute("user",new User());

		return "UserRegister";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,Errors errors,ModelMap map) {
		validator.validate(user, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveUser(user);
			String messege="user '"+id+"' saved successfully";
			map.addAttribute("utd",messege);
			map.addAttribute("user",new User());
			
		}
		else {
			map.addAttribute("utd","please check errors");
		}



		return "UserRegister";

	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<User>obj=service.getAllUsers();
		map.addAttribute("list",obj);
		return "UserData";
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id")Integer uid,ModelMap map) {
		service.deleteUser(uid);
		map.addAttribute("list",service.getAllUsers());
		map.addAttribute("msg",uid+"deleted successfully");
		return "UserData";

	}

	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer uid,ModelMap map) {
		User ob=service.getUserById(uid);
		map.addAttribute("user",ob);
		return "UserEdit";

	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute User user,ModelMap map) {
		service.updateUser(user);
		List<User>list=service.getAllUsers();
		map.addAttribute("list",list);
		return "UserData";
	}
	@RequestMapping("/excel")
	public ModelAndView doExportExcel(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UserExcelView());
		if(id==0) {
			m.addObject("list",service.getAllUsers());
		}
		else {
			m.addObject("list",Collections.singletonList(service.getUserById(id)));

		}
		return m;



	}
	@RequestMapping("/pdf")
	public ModelAndView pdfExport(@RequestParam(value="id",required=false,defaultValue="0")Integer id) {
		ModelAndView m=new ModelAndView();
		if(id==0) {
			m.addObject("list",service.getAllUsers());

		}else {
			User u=service.getUserById(id);
			m.addObject("list",Collections.singletonList(u));

		}
		m.setView(new UserPdfView());
		return m;
	}
	 @RequestMapping("/charts")
	 public String showCharts() {
	   String path=context.getRealPath("/");
	   List<Object[]> list=service.getUserCountByRole();
	   System.out.println(path);
	   util.generatePie(path, list);
	   util.generateBar(path,list);
	   return "UserRoleReports";

	

	 }
	 @RequestMapping("/viewone")
	 public String getOneRow(@RequestParam Integer id,ModelMap map) {
		 User u=service.getUserById(id);
		 map.addAttribute("u",u);
		return "UserView";
		 
	 }
}