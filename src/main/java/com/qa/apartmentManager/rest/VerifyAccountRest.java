package com.qa.apartmentManager.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class VerifyAccountRest {

	@Value("${data.secretPassword}")
	private String secretPassword;
	
	@GetMapping("${path.verifyPassword}")
	public String verifyPassword(@PathVariable ("password")String password) {
		return checkPassword(password);
	}
	
	private String checkPassword(String pass) {
		if (pass.equals(secretPassword)) {
			return "{\"message\": \"Login success\"}";
		}
		
		return "{\"message\": \"Incorrect password\"}";
	}
}
