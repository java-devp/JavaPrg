package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.EmployeeEntity;

public interface Employee_DetailsRepositary extends JpaRepository<EmployeeEntity,Serializable> {

	@Query(value="Select email from EmployeeEntity")
	public List<String> findByEmila();
	
	@Query(value="Select ename from EmployeeEntity where empno=:empno")
	public List<String> findByid(int empno);
	
	@Query(value="UPDATE EmployeeEntity e SET e.active = false  WHERE e.empno = :empno")
	@Modifying
	@Transactional
	public void deleteByid(int empno);
	
	@Query(value="Select e from EmployeeEntity e where e.active = true")
	public Page<EmployeeEntity> findbyactive(PageRequest pagerqst);
}
