package net.wmann.cloud.storage.webservice.controller;

import net.wmann.cloud.storage.webservice.annotation.TraceExecution;
import net.wmann.cloud.storage.webservice.exception.DuplicateEmailException;
import net.wmann.cloud.storage.webservice.model.dto.RegistrationDto;
import net.wmann.cloud.storage.webservice.model.dto.UserDto;
import net.wmann.cloud.storage.webservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@TraceExecution
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUsers() {
        return new ResponseEntity<>(userService.getAuthenticatedUser(), HttpStatus.OK);
    }
	
	@TraceExecution
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDto> registerUser(@RequestBody RegistrationDto registration) 
			throws IllegalArgumentException, DuplicateEmailException {
        return new ResponseEntity<>(userService.registerUser(registration), HttpStatus.OK);
    }

}
