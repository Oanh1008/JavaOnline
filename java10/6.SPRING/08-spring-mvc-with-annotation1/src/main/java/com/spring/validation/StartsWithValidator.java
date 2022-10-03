package com.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ConstraintValidator<Annotation, T> Annotation: Annotation need to add
 * validation T : Type of Value want to validate
 */
public class StartsWithValidator implements ConstraintValidator<StartsWith, String> {

	private String  prefix;
	@Override
		public void initialize(StartsWith startsWith) {
			// TODO Auto-generated method stub
			prefix= startsWith.prefix();
		}
	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if(input ==null) {
			return false;
		}
		return input.startsWith(prefix);
	}

}
