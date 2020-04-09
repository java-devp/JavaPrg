package com.example.controller;


/*
 * This class is responsible for handling Exception or
 *  (Global Exception Handler)
 */
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(value=NullPointerException.class)
	public String nullPointer(Model model) {
		model.addAttribute("message","Something went wrong");
		return"error";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String DataAccess(Model model) {
		model.addAttribute("message","Something went wrong");
		return"error";
	}
	
	

}
