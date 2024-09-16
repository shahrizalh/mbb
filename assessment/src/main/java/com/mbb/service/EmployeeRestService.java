package com.mbb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class EmployeeRestService {

	private RestClient restClient;
	
	public EmployeeRestService() {
		restClient = RestClient.builder()
                .baseUrl("http://localhost:8000")
                .build();
	}
	
	public String getEmployeeSalary(int id) {
		
		return restClient.post()
                .uri("/salary/{id}", id)
                .retrieve()
                .body(String.class);
	}
}
