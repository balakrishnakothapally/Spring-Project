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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {
	@Autowired
	private IShipmentTypeService service;
	// 1 fetch all records from DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<ShipmentType> list=service.getAllShipmentTypes();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<ShipmentType>>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("no data found",HttpStatus.OK);
		}

		return resp;

	}
	//2 insert data
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> resp=null;
		try {
			Integer sid=service.saveShipmentType(shipmentType);
			String body="saved with id:"+sid;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);

		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}
	//3 delete shipmentById as path
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer sid){
		ResponseEntity<?> resp=null;
		try {

			service.deleteShipmentType(sid);
			resp=new ResponseEntity<String>(sid+"deleted sucessfully",HttpStatus.OK);

		} catch (Exception e) {
			resp=new ResponseEntity<String>(sid+"unable to delete/not exist",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	//4 'fetching one row data
	@GetMapping("/getOne/{sid}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer sid){
		ResponseEntity<?> resp=null;
		try {
			ShipmentType st=service.getShipmentTypeById(sid);
			if(st!=null) {
				resp=new ResponseEntity<ShipmentType>(st,HttpStatus.OK);

			}else {
				resp=new ResponseEntity<String>(sid+"not found in dB",HttpStatus.OK);
			}


		} catch (Exception e) {
			resp=new ResponseEntity<String>("unable to process Request",HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;
	}
	//5 updating data
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType shipmentType , Integer sid){
		ResponseEntity<String> resp=null;
		try {
				service.updateShipmentType(shipmentType);
				String body="successfully updated with id:"+sid;
				resp=new ResponseEntity<String>(body,HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("unable to update",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
		
	}

}
