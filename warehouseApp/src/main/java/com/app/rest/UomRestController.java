package com.app.rest;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomService service;
	//1.getting all data from db
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<Uom> list=service.getAllUoms();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<Uom>>(list,HttpStatus.OK);

		}else {
			resp=new ResponseEntity<String>("no data found",HttpStatus.OK);
		}
		return resp;

	}
	//2.inserting data
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody Uom uom){
		ResponseEntity<String> resp=null;
		try {
			Integer uid=service.saveUom(uom);
			String body="saved with id:"+uid;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);

		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;


	}
	//3.deleting one row 
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer uid){
		ResponseEntity<?> resp=null;
		try {
			service.deleteUom(uid);
			resp=new ResponseEntity<String>(uid+"deleted successfully",HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(uid+"no exites in db",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	//4.fetching one row
	@GetMapping("getOne/{uid}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer uid){
		ResponseEntity<?> resp=null;
		try {
			Uom u=service.getUomById(uid);
			if(u!=null) {
				resp=new ResponseEntity<Uom>(u,HttpStatus.OK);
			}else
			{
				resp=new ResponseEntity<String>(uid+"not found in DB",HttpStatus.BAD_REQUEST);
				
			}
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("unable to process the request",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;
		
	}
	//5.upddate data
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody Uom uom,Integer uid){
		ResponseEntity<String> resp=null;
		try {
			service.updateUom(uom);
			resp=new ResponseEntity<String>(uid+"updated successfully",HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
		
	}

}
