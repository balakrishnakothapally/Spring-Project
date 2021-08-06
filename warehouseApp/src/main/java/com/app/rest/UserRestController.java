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

import com.app.model.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/rest/users")
public class UserRestController {
	@Autowired
	private IUserService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<User> list=service.getAllUsers();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<User>>(list,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("no data found",HttpStatus.OK);
		}
		return resp ;
		
		
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody User user){
		Integer uid=service.saveUser(user);
		String body="saved with id:"+uid;
		ResponseEntity<String> resp=null;
		try {
			resp=new ResponseEntity<String>(body,HttpStatus.OK );
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return null;
		
	}
	//3.delete data
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer uid){
		ResponseEntity<?> resp=null;
		
		try {
			service.deleteUser(uid);
			resp=new ResponseEntity<String>(uid+"deleted successfully",HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(uid+"not exist in DB",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
		
	}
	//4.fetching one row
	@GetMapping("getone/{uid}")
	public ResponseEntity<?> getOneObj(@PathVariable Integer uid){
		ResponseEntity<?> resp=null;
		try {
			
			User u=service.getUserById(uid);
			if(u!=null) {
				resp=new ResponseEntity<User>(u,HttpStatus.OK);
			}
			else {
				resp=new ResponseEntity<String>(uid+"not found in DB",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("unable to process the Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
		
		
	}
	//5.update data
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody User user,Integer uid){
		ResponseEntity<String> resp=null;
		try {
			service.updateUser(user);
			resp=new ResponseEntity<String>("updated successfully",HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
		
	}
	

}
