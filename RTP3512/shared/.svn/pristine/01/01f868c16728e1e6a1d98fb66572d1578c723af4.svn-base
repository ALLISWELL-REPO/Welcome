package com.st.spring.mvc.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeekdayValidator 
implements ConstraintValidator<ValidWeekday, String> {

	@Override
	public void initialize(ValidWeekday constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String value, 
			ConstraintValidatorContext context) {
		return Weekday.isValid(value);
	}
	
	
	
	
	
	
	
	

}
