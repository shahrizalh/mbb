package com.mbb.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class SalaryRestController {
	
	
	@GetMapping("/detail")
	public ResponseEntity<String> testCustomer() {
		
		return ResponseEntity.ok("Welcome to HR page");
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> getEmployeeSalary(@PathVariable int id){
		
		return ResponseEntity.ok("10000");
	}

}
