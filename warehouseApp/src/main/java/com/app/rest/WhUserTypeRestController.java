package com.app.rest;

import java.util.List;

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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/user")
public class WhUserTypeRestController {
	@Autowired
	private IWhUserTypeService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<WhUserType> list=service.getAllWhUserTypes();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<WhUserType>>(list,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("no data found",HttpStatus.OK);
		}
		return resp;

	}
	//2.inserting data
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody WhUserType whUserType){
		ResponseEntity<String> resp=null;
		try {
			Integer uid=service.saveWhUserType(whUserType);
			String body="saved with id:"+uid;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}
		return resp;

	}
	//3.delete by id in db
	@DeleteMapping("/delete/{wid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer wid){
		ResponseEntity<?> resp=null;

		try {
			service.deleteWhUserType(wid);
			resp=new ResponseEntity<String>(wid+"deleted sucessfully",HttpStatus.OK);


		} catch (Exception e) {
			resp=new ResponseEntity<String>(wid+"not exists in db",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;

	}
	//4.fetching one row 
	@GetMapping("/getone/{wid}")
	public ResponseEntity<?> getOneObj(@PathVariable Integer wid){
		ResponseEntity<?> resp=null;

		try {
			WhUserType wt=service.getWhUserTypeById(wid);
			if(wt!=null) {
				resp=new ResponseEntity<WhUserType>(wt,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>(wid+"not exists in DB",HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			resp=new ResponseEntity<String>("unable to process the requssst",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	//5.update data
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody WhUserType whUserType){
		ResponseEntity<String> resp=null;
		try {
			service.updateWhUserType(whUserType);
			resp=new ResponseEntity<String>("updated suceessfully",HttpStatus.OK);
		} catch (Exception e) {
			resp=new  ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
		
		
	}
}
