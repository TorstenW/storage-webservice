package net.wmann.cloud.storage.webservice.service.impl;

import java.util.Optional;

import net.wmann.cloud.storage.webservice.domain.UserEntity;
import net.wmann.cloud.storage.webservice.repository.UserRepository;
import net.wmann.cloud.storage.webservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Optional<UserEntity> getUserByEmail(String email) {
		LOG.debug("getUserByEmail: {}", email);
		return userRepository.findOneByEmail(email);
	}

}
