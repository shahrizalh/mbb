package com.mbb.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.dto.StaffDto;
import com.mbb.entity.Staff;
import com.mbb.service.EmployeeRestService;
import com.mbb.service.EmployeeService;
import com.mbb.utils.AppConstants;

@RestController
@RequestMapping("/customer")
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRestService empRestService;
	
	@GetMapping("/detail")
	public ResponseEntity<String> testCustomer() {
		
		logger.info("LOGGER : Test print");
		
		return ResponseEntity.ok("Welcome to my page");
	}
	
	@PostMapping("/save")
	public ResponseEntity<Staff> saveNewEmployee(@RequestBody StaffDto employee) {
		
		logger.info("Save a new employee");
		logger.info("REQUEST : "+employee.toString());
		Staff s = employeeService.mapToEntity(employee);
		
		logger.info("RESPONSE : "+ s.toString());
		return ResponseEntity.ok(employeeService.saveEmployee(s));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Staff>> getAllEmployee(){
		logger.info("REQUEST : Get all employee");
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	@GetMapping("/all/pagination")
	public ResponseEntity<List<StaffDto>> getAllEmployeePagination(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir){
		
		logger.info("Pagination search...START");
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Staff> pageList = employeeService.findAllPagination(pageable);
		
		List<Staff> staffList = pageList.getContent();
		
		List<StaffDto> dtoList = staffList.stream().map(s -> employeeService.mapToDto(s)).collect(Collectors.toList());
		
		logger.info("Pagination search...ENDS");
		
		return ResponseEntity.ok(dtoList);
	
	}
	
	@PostMapping("/employee/salary")
	public ResponseEntity<String> getEmployeeSalary(@RequestParam(required = true) int employeeId){
		logger.info("Get Employee Salary by Id : "+ employeeId);

		String response = empRestService.getEmployeeSalary(employeeId);
		
		logger.info("RESPONSE : "+ response.toString());
		
		return ResponseEntity.ok(response);
	}
}
