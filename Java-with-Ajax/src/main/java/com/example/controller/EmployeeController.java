package com.example.controller;
/*
 * This is Controller which is responsible for handle client request
 * @Author Gautam
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.EmployeeModel;
import com.example.model.Response;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {
	
	

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository empRepo;


	@RequestMapping(value="/")
	public String loadData(Model model) {
		EmployeeModel emodel= new EmployeeModel();
		model.addAttribute("emodel",emodel);
		return"submit";
	}
	
	@RequestMapping(value="/insertdata")
	public String insertData( EmployeeModel emodel,Model model) {
		
		try {
		 service.InsertData(emodel);
		model.addAttribute("success","Registration Successfull");
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			model.addAttribute("message","Something Went Wrong");  
			return"error";
		}
		catch(Exception e) {
			e.printStackTrace();
			return"error";
		}
		return "result";
		
	}
	
	
	  @RequestMapping(value="/viewData")
	  @ResponseBody
	  public Response viewData() {
	  List<EmployeeModel> view = service.viewData();
	  Response response = new Response("Done", view);
		System.out.println("RestWebController.viewData()");
		System.out.println(view);
	  return response;
	  }
	 
	
	  
	@RequestMapping(value = "/examples/echo", method = RequestMethod.GET)
    @ResponseBody
    public String makeGetEcho(@RequestParam("text") String text) {
        return text;
    }
	
	
}
