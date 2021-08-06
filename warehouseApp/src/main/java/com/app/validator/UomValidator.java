package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
@Component
public class UomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom u =(Uom)target;
		if(StringUtils.isEmpty(u.getuType())) {
			errors.rejectValue("uType",null,"please choose one type");
		}
		if(!Pattern.matches("[A-Za-z0-9]{4,10}",u.getuModel())) {
			errors.rejectValue("uModel",null,"plaese enter 4-10 chars only ");
			
		}
		if(StringUtils.isEmpty(u.getuDes()) ||u.getuDes().length()>10) {
			errors.rejectValue("uDes",null,"please enter 10 chars only");
		}
	}

}
