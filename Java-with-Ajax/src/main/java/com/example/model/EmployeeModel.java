package com.example.model;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeModel {
	
	private Integer empid;
	private String ename;
	private String addrs;
	private String salary;
	private List<String> city;

}
