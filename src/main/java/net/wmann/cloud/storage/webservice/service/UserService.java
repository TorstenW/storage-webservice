package net.wmann.cloud.storage.webservice.service;

import java.util.Optional;

import net.wmann.cloud.storage.webservice.domain.UserEntity;

public interface UserService {
	
	Optional<UserEntity> getUserByEmail(String email);

}
