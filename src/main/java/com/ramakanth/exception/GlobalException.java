package com.ramakanth.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=Exception.class)
	public String globalExceptionhalding(Model model, Exception e) {
		String error=e.getMessage();
		System.out.println("error message: "+error);
		model.addAttribute("error", error);
		return "error";
	}

}
