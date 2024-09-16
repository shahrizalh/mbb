package com.mbb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbb.entity.Staff;

public interface EmployeeRepository extends JpaRepository<Staff, Integer> {

}
