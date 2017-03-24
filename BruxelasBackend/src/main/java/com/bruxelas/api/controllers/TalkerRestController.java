package com.bruxelas.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruxelas.entities.Talker;
import com.bruxelas.services.TalkerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/talker")
public class TalkerRestController {

	private static final Logger logger = LoggerFactory.getLogger(TalkerRestController.class);
	
	@Autowired
	private TalkerService talkerService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> post(@RequestBody Talker talker){
		logger.info( "post("+talker+")..." );
		ResponseEntity<String> responseEntity = null;
		try {
			
			talker = this.talkerService.save(talker);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(talker);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
}
