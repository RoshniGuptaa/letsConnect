package com.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
public class HomeController {
	@GetMapping("/")
     public ResponseEntity<String> HomeController(){
         return new ResponseEntity<String>("Welcome to our letsConnect api using spring boot",HttpStatus.OK);
	}
}
