package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmployeeModel;
import com.example.model.Response;
import com.example.service.EmployeeService;

/*@RestController
public class RestWebController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping( value ="/viewData")
	public Response viewData() {
		List<EmployeeModel> view = service.viewData();
		Response response = new Response("Done", view);
		System.out.println("RestWebController.viewData()");
		System.out.println(view);
		return response;
	}

}*/
