package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	@RequestMapping("/all")
	public String showDocsPage(ModelMap map) {
		List<Object[]>lts=service.getFileIdAndNames();
		map.addAttribute("list",lts);
		return "Documents";
		
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDocs(@RequestParam CommonsMultipartFile fob) {
		
		if(fob!=null) {
			Document doc =new Document();
			doc.setFileName(fob.getOriginalFilename());
			doc.setFileData(fob.getBytes());
			service.saveDocument(doc);
		}
		return "redirect:all";
		
	}
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam Integer fileId,HttpServletResponse resp) {
		Document doc=service.getDocumentById(fileId);
		resp.addHeader("Content-Disposition","attachment;filename="+doc.getFileName());
		try {
			FileCopyUtils.copy(doc.getFileData(),resp.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
