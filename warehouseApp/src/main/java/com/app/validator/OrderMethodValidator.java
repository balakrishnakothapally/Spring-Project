package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod om=(OrderMethod)target;
		if(StringUtils.isEmpty(om.getOrderMode())) {
			errors.rejectValue("orderMode",null,"please choose one mode");
		}
		if(!Pattern.matches("[A-Z0-9]{4,10}",om.getOrderCode())) {
			errors.rejectValue("orderCode",null,"please enter uppercase 4-10 chars only");
			
		}
		if(StringUtils.isEmpty(om.getExeType())) {
			errors.rejectValue("exeType",null, "please choose one");
		}
		if(om.getOrderAccepts()==null || om.getOrderAccepts().isEmpty()) {
			errors.rejectValue("orderAccepts",null,"please select atlest one");
		}
		if(StringUtils.isEmpty(om.getNote()) || om.getNote().trim().length()>30) {
			errors.rejectValue("note",null,"please enter 10 chars only");
		}
		
	}

}
