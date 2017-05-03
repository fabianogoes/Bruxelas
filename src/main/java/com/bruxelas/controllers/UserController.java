package com.bruxelas.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bruxelas.entities.User;
import com.bruxelas.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		logger.info( "login()..." );
		User user = this.userService.findByEmail("maggierogers@bruxelas.com.br");
		if(user == null) {
			throw new RuntimeException("Usuario default não encontrado no Banco. Execute o script do README");
		}
		session.setAttribute("userLogged", user );
		return "redirect:/";
	}
	
}
