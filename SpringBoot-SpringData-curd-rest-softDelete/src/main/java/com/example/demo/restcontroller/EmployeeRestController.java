package com.example.demo.restcontroller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.Employee_DetailsRepositary;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private Employee_DetailsRepositary stdrepos;
	
	@GetMapping(value="/emprest",produces={"application/json","application/xml"})
	public Employee empController(@RequestParam("id")int id) {
		Optional<EmployeeEntity> findById = stdrepos.findById(id);
		
		Employee employee = new Employee();
		EmployeeEntity entity= findById.get();
		BeanUtils.copyProperties(entity, employee);
		return employee;
		
	}

}
