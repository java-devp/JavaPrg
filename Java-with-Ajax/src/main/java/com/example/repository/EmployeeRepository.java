package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

	@Query(value="from EmployeeEntity where ename=:ename and salary=:salary")
	public EmployeeEntity getNameAndSalary(String ename,float salary);
	
	@Query(value="select e from EmployeeEntity e where e.ename=:ename")
	public EmployeeEntity getData(String ename);
	
}
