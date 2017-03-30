package com.bruxelas.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruxelas.entities.Version;
import com.bruxelas.services.VersionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class DashRestController {

	private static final Logger logger = LoggerFactory.getLogger(DashRestController.class);
	
	@Autowired
	private VersionService versionService;
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> get(){
		logger.info( "get()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			String welcome =  "Welcome Bruxelas Project 1.0.20170327";
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(welcome);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/version", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getActualVersion(){
		logger.info( "getActualVersion()..." );
		ResponseEntity<String> responseEntity = null;
		try {
			Version version =  this.versionService.findActualVersion();
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(version);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/version/{build}/{commit}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> incrementVersion(@PathVariable("build") String build, @PathVariable("commit") String commit){
		logger.info( "getActualVersion("+build+", "+commit+")..." );
		ResponseEntity<String> responseEntity = null;
		try {
			Version version = new Version(null, build, commit);
			version =  this.versionService.save(version);
			HttpHeaders responseHeaders = new HttpHeaders();
			String usuariosJson = new ObjectMapper().writeValueAsString(version);
			responseEntity = new ResponseEntity<String>(usuariosJson, responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return responseEntity;
	}
	
}
