package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User u=(User)target;
		if(!Pattern.matches("[A-Za-z]{4,10}",u.getUserName())) {
			errors.rejectValue("userName",null,"please enter 4-10 chars only");
		}
		if(!Pattern.matches("[a-zA-Z]*[\\\\@][a-z]{2,10}[\\\\.][a-z]{2,3}",u.getUserEmail())) {
			errors.rejectValue("userEmail",null,"please enter 4-20 chars only");
		}
		if(!Pattern.matches("[A-Z][a-z0-9]{5,25}[\\@#$%^&!._][0-9]+",u.getUserPwd())) {
			
			errors.rejectValue("userPwd",null,"please enter atleast one number, one lower case, one upper case, special symbol,6-20 chars only");
		}
		if(u.getRoles()==null || u.getRoles().isEmpty()){
			errors.rejectValue("roles",null,"please select atleast one");
			
			
		}
		
		
	}
	

}
