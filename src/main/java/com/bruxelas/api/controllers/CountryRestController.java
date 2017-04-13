package com.bruxelas.api.controllers;

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

import com.bruxelas.entities.Country;
import com.bruxelas.services.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {

	private static final Logger logger = LoggerFactory.getLogger(CountryRestController.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> get(){
		logger.info( "get()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			List<Country> list = this.countryService.findAll();
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(list);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> get(@PathVariable("id") Long id){
		logger.info( "get()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			Country country = this.countryService.findOne(id);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(country);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> post(@RequestBody Country country){
		logger.info( "post("+country+")..." );
		ResponseEntity<String> responseEntity = null;
		try {
			country = this.countryService.save(country);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(country);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}	
	
	@RequestMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		logger.info( "get()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			this.countryService.delete(id);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString("Delete["+id+"] OK");
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}

	
}
