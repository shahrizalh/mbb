package com.mbb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbb.dto.StaffDto;
import com.mbb.entity.Staff;
import com.mbb.repo.EmployeeRepository;
import com.mbb.repo.PaginationRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private PaginationRepository pageRepo;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<Staff> findAll(){
		
		return employeeRepo.findAll();
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Optional<Staff> findById(int id) {	
		return employeeRepo.findById(id);
	}
	
	@org.springframework.transaction.annotation.Transactional
	public Staff saveEmployee(Staff employee) {
		
		return employeeRepo.save(employee);
	}
	
	/**
	 * alternatively, we can use builder pattern approach
	 * @param dto
	 * @return
	 */
	public Staff mapToEntity(StaffDto dto) {
		
		Staff s = new Staff();
		s.setName(dto.getName());
		s.setDepartment(dto.getDepartment());
		s.setJobGrade(dto.getJobGrade());
		
		return s;
	}
	
	/**
	 * alternatively, we can use builder pattern approach
	 * @param dto
	 * @return
	 */
	public StaffDto mapToDto(Staff staff) {
		
		StaffDto d = new StaffDto();
		d.setId(staff.getId());
		d.setName(staff.getName());
		d.setDepartment(staff.getDepartment());
		d.setJobGrade(staff.getJobGrade());
		
		return d;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Page<Staff> findAllPagination(Pageable pageable){
		
		return pageRepo.findAll(pageable);
	}
}
