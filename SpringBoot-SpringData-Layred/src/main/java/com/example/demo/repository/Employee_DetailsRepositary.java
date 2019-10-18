package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeEntity;

public interface Employee_DetailsRepositary extends JpaRepository<EmployeeEntity,Serializable> {

	@Query(value="Select email from EmployeeEntity")
	public List<String> findByEmila();
	
	@Query(value="Select ename from EmployeeEntity where empno=:empno")
	public List<String> findByid(int empno);
}
