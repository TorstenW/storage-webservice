package net.wmann.cloud.storage.webservice.repository;

import java.util.Optional;

import net.wmann.cloud.storage.webservice.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findOneByEmail(String email);

}
