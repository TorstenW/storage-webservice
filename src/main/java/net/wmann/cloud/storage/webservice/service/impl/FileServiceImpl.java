package net.wmann.cloud.storage.webservice.service.impl;

import java.util.List;

import net.wmann.cloud.storage.webservice.domain.FileEntity;
import net.wmann.cloud.storage.webservice.domain.UserEntity;
import net.wmann.cloud.storage.webservice.repository.FileRepository;
import net.wmann.cloud.storage.webservice.service.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private FileRepository fileRepository;
	
	@Autowired
	public FileServiceImpl (FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	@Override
	public List<FileEntity> getFilesByUser(UserEntity user) {
		LOG.debug("getFilesByUser: {}", user);
		return fileRepository.findByOwner(user);
	}
	
}
