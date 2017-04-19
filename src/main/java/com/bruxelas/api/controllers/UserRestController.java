package com.bruxelas.api.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruxelas.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@RequestMapping(value="/getsession")
	public ResponseEntity<String> getSession(HttpSession session) {
		try {
			User user = (User) session.getAttribute("userLogged");
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
