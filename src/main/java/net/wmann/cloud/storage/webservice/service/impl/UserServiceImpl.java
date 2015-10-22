package net.wmann.cloud.storage.webservice.service.impl;

import java.util.HashSet;
import java.util.Set;

import net.wmann.cloud.storage.webservice.domain.UserEntity;
import net.wmann.cloud.storage.webservice.domain.converter.UserConverter;
import net.wmann.cloud.storage.webservice.exception.DuplicateEmailException;
import net.wmann.cloud.storage.webservice.model.Role;
import net.wmann.cloud.storage.webservice.model.dto.RegistrationDto;
import net.wmann.cloud.storage.webservice.model.dto.UserDto;
import net.wmann.cloud.storage.webservice.model.dto.validator.RegistrationValidator;
import net.wmann.cloud.storage.webservice.repository.UserRepository;
import net.wmann.cloud.storage.webservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto getAuthenticatedUser() {
		UserEntity result = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    result = userRepository.findOneByEmail(authentication.getName()).get();
		    if(result != null && result.isSuspended()){
		    	result = null;
		    } else {
		    	log.debug("Found for name: {} user: {}", authentication.getName(), result);
		    }
		}
		return result == null ? null : UserConverter.convertUserEntity(result);
	}
	
	@Override
	public UserDto registerUser(RegistrationDto registration) throws IllegalArgumentException, DuplicateEmailException {
		try {
			RegistrationValidator.validate(registration);
		} catch (Exception e) {
			log.info("Invalid registration {}", e.toString());
			throw new IllegalArgumentException();
		}
		if(userRepository.findOneByEmail(registration.getEmail()).isPresent()) {
			log.info("Email already exists: {}", registration.getEmail());
			throw new DuplicateEmailException();
		}
		Set<Role> defaultRoles = new HashSet<>();
		defaultRoles.add(Role.USER);
		UserEntity newUser = new UserEntity();
		newUser.setName(registration.getName());
		newUser.setEmail(registration.getEmail());
		newUser.setPasswordHash(new BCryptPasswordEncoder().encode(registration.getPassword()));
		newUser.setRoles(defaultRoles);
		UserEntity storedUser = userRepository.save(newUser);
		return UserConverter.convertUserEntity(storedUser);
	}

}
