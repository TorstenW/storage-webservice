package net.wmann.cloud.storage.webservice.repository;

import java.util.List;

import net.wmann.cloud.storage.webservice.domain.FileEntity;
import net.wmann.cloud.storage.webservice.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
	
	List<FileEntity> findByOwner(UserEntity user);

}
