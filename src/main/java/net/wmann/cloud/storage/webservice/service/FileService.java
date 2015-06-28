package net.wmann.cloud.storage.webservice.service;

import java.util.List;

import net.wmann.cloud.storage.webservice.domain.FileEntity;
import net.wmann.cloud.storage.webservice.domain.UserEntity;

public interface FileService {
	
	List<FileEntity> getFilesByUser(UserEntity user);

}
