package com.example.demo.exceptionhandler;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class DataExceptionHander {

    @ExceptionHandler(value=DataAccessException.class)
	public String exceptionHandle(Model model) {
		String msg="somthing went wrong";
		model.addAttribute("errmsg",msg);
		return "error";
	}
	
}
