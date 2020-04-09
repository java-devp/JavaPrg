package com.example.service;

import java.util.List;

import com.example.model.EmployeeModel;

public interface EmployeeService{
	
	public void InsertData(EmployeeModel model) throws Exception;
	public List<EmployeeModel> viewData();
	


}
