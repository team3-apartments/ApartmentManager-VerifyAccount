package com.qa.apartmentManager.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class VerifyAccountRest {

	@GetMapping("${path.verifyPassword}")
	public String verifyPassword(@PathVariable ("password")String password) {
		return checkPassword(password);
	}
	
	private String checkPassword(String pass) {
		File file = new File("src\\main\\resources\\secrets.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String found;
			while((found = br.readLine()) != null) {
				if(found.equals(pass)) {
					return "{\"message\": \"Login success\"}";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{\"message\": \"Incorrect password\"}";
	}
}
