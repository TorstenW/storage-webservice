package net.wmann.cloud.storage.webservice.controller;

import java.util.List;

import net.wmann.cloud.storage.webservice.domain.FileEntity;
import net.wmann.cloud.storage.webservice.domain.UserEntity;
import net.wmann.cloud.storage.webservice.repository.UserRepository;
import net.wmann.cloud.storage.webservice.service.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private FileService fileService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> getUsers() {
        LOG.debug("Received a get request to '/test'");
        ResponseEntity<List<UserEntity>> result = new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);;
		return result;
    }
	
	@RequestMapping(value = "/testfile", method = RequestMethod.GET)
	public ResponseEntity<List<FileEntity>> getFile() {
        LOG.debug("Received a get request to '/testfile'");  
        ResponseEntity<List<FileEntity>> result = new ResponseEntity<>(fileService.getFilesByUser(userRepository.findAll().get(0)), HttpStatus.OK);;
		return result;
    }

}
