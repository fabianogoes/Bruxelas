package com.bruxelas.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DashRestController {

	@RequestMapping
	public String get(){
		return "Welcome Bruxelas Project";
	}
	
}
