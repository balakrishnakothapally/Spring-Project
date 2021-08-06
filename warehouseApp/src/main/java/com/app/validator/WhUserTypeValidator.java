package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		WhUserType wt=(WhUserType)target;
		
		if(StringUtils.isEmpty(wt.getUserType())) {
			errors.rejectValue("userType",null,"please select one type");
		}
		if(!Pattern.matches("[A-Z0-9]{2,6}",wt.getUserCode())) {
			errors.rejectValue("userCode",null,"please enter 2-6 chars");
		}
		if(StringUtils.isEmpty(wt.getUserFor())) {
			errors.rejectValue("userFor",null,"please select one");
		}
		if(!Pattern.matches("[a-zA-Z]*[\\@][a-z]{2,10}[\\.][a-z]{2,3}",wt.getUserGmail())) {
//			[A-Za-z]{6}[\\.][A-Za-z]{2,3}
			errors.rejectValue("userGmail",null,"please enter correctly");
		}
		if(!Pattern.matches("[0-9]{2,10}",wt.getUserContact())) {
			errors.rejectValue("userContact",null,"please enter max 10 only");
		
			
		}
		if(StringUtils.isEmpty(wt.getUserIdType())) {
			errors.rejectValue("userIdType",null,"please select one id");
		}
		if(!Pattern.matches("[0-9]{2,10}",wt.getUserIdNumber())) {
			errors.rejectValue("userIdNumber",null, "please enter 10 digits number");
			
		}
		
	}

}
