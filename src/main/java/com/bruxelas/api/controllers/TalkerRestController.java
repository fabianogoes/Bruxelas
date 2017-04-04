package com.bruxelas.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruxelas.entities.Talker;
import com.bruxelas.services.TalkerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/talker")
public class TalkerRestController {

	private static final Logger logger = LoggerFactory.getLogger(TalkerRestController.class);
	
	@Autowired
	private TalkerService talkerService;
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> get(){
		logger.info( "get()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			List<Talker> talkers = this.talkerService.findAll();
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(talkers);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/{id}" ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> get(@PathVariable("id") long id){
		logger.info( "get("+id+")..." );
		ResponseEntity<String> responseEntity = null;
		try {
			Talker talker = this.talkerService.findOne(id);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(talker);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
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
	
	@RequestMapping(value="/delete/{id}" ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		logger.info( "delete("+id+")..." );
		ResponseEntity<String> responseEntity = null;
		try {
			this.talkerService.delete(id);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString("Delete["+id+"] OK");
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}	
	
	@RequestMapping(value="/nationalities", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getNationalities(){
		logger.info( "getNationalities()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			List<String> countries = Arrays.asList("Brazilian", "American");
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(countries);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/countries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getCountries(){
		logger.info( "getCountries()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			List<String> countries = Arrays.asList("Brazil", "United States");
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(countries);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/languages", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getLanguages(){
		logger.info( "getLanguages()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			List<String> countries = Arrays.asList("Portuguese", "English");
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(countries);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	
}
