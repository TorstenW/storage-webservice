package net.wmann.cloud.storage.webservice.service;

import net.wmann.cloud.storage.webservice.exception.DuplicateEmailException;
import net.wmann.cloud.storage.webservice.model.dto.RegistrationDto;
import net.wmann.cloud.storage.webservice.model.dto.UserDto;

public interface UserService {
	
	UserDto getAuthenticatedUser();
	
	UserDto registerUser(RegistrationDto registration) throws IllegalArgumentException, DuplicateEmailException;

}
