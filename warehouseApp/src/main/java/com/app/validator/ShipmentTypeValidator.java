package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//down cast from Object
		ShipmentType st=(ShipmentType)target;
		//dropdown validation
		if(StringUtils.isEmpty(st.getShipmentMode())) {
			errors.rejectValue("shipmentMode",null,"please choose one mode");
		}
		//text input validation
		if(!Pattern.matches("[A-Z0-9]{4,10}",st.getShipmentCode())) {
			errors.rejectValue("shipmentCode",null, "plase enter 4-10 chars!!");
		}
		//drop down
		if(StringUtils.isEmpty(st.getEnableShipment())) {
			errors.rejectValue("enableShipment",null,"please choose one option");
		}
		//radio buttons
		if(StringUtils.isEmpty(st.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade",null,"please select one grade");
		}
		//text area
		if(StringUtils.isEmpty(st.getNote())|| st.getNote().length()>10) {
			errors.rejectValue("note",null,"please enter note(max 10 chars only)");
			
		}
		
	}

}
