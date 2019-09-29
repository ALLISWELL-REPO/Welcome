package com.st.spring.mvc.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { WeekdayValidator.class })
public @interface ValidWeekday {

	String message() default "{invalid.weekday}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}







