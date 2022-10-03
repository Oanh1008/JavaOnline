package com.spring.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartsWithValidator.class)
public @interface StartsWith {

	// endpoint: @StartsWith(value="XAB",message="must start with")
//	public String value() default "";
	
	public String message() default "";

	String prefix() default "";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
