package net.wmann.cloud.storage.webservice.domain.converter;

import net.wmann.cloud.storage.webservice.domain.UserEntity;
import net.wmann.cloud.storage.webservice.model.dto.UserDto;

public class UserConverter {
	
	public static UserDto convertUserEntity(UserEntity entity) {
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setRoles(entity.getRoles());
		return dto;
	}

}
