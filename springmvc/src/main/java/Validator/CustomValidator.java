package Validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Entity.Customer;

@Component
public class CustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname");
		ValidationUtils.rejectIfEmpty(errors, "email", "email");

		Customer customer = (Customer) target;

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		
		if(customer.getEmail()!=null)
		if (!(pattern.matcher(customer.getEmail()).matches())) {
			errors.rejectValue("email", "invalid");
		}

	}

}
