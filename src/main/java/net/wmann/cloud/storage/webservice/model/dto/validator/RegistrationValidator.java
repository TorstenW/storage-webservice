package net.wmann.cloud.storage.webservice.model.dto.validator;

import net.wmann.cloud.storage.webservice.model.dto.RegistrationDto;

import org.apache.commons.lang3.Validate;

public class RegistrationValidator {
	
	public static boolean validate(RegistrationDto registration) throws Exception {
		Validate.notNull(registration, "RegistrationDto must not be null");
		Validate.notBlank(registration.getEmail(), "Email must not be empty");
		Validate.notBlank(registration.getName(), "Name must not be empty");
		Validate.notBlank(registration.getPassword(), "Password must not be empty");
		
		Validate.matchesPattern(registration.getEmail(), "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", 
				"Invalid email address {}.", registration.getEmail());
		// TODO check password length
		return true;
	}

}
