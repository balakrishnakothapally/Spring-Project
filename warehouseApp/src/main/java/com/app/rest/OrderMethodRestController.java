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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {
	@Autowired
	private IOrderMethodService service;
	//1.fetching all data from db
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<OrderMethod> list=service.getAllOrderMethodTypes();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<OrderMethod>>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("no data found",HttpStatus.OK);
		}
		return resp;

	}
	//2.inserting data
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> resp=null;
		try {
			Integer oid=service.saveOrderMethod(orderMethod);
			String body="saved with id:"+oid;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}
	//3.delete data
	@DeleteMapping("/delete/{oid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer oid){
		ResponseEntity<?> resp=null;
		try {
			service.deleteOrderMethod(oid);
			resp=new ResponseEntity<String>(oid+"deleted successfully",HttpStatus.OK);

		} catch (Exception e) {
			resp=new ResponseEntity<String>(oid+"unable to delete",HttpStatus.BAD_REQUEST);
			// TODO: handle exception
		}
		return resp;
	}
	//4.fetching one row
	@GetMapping("/getOne/{oid}")
	public ResponseEntity<?> getOneObj(@PathVariable Integer oid){
		ResponseEntity<?> resp=null;
		try {
			OrderMethod om=service.getOrderMethodById(oid);
			if(om!=null) {
				resp=new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>(oid+"not found in DB",HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("not exist",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();

		}
		return resp;

	}
	//5.updating data
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody OrderMethod orderMethod, Integer omid){

		ResponseEntity<String> resp=null;
		try {
			service.updateOrderMethod(orderMethod);
			String body="updated with id:"+omid;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);

		} catch (Exception e) {
			resp=new ResponseEntity<String>("not existed ",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;

	}

}
