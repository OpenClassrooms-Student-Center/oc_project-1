package com.lambazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ControllerAdvice

public class LambazonExceptionHandlerController {

	public static final String DEFAULT_ERROR_VIEW = "exception";

	@ExceptionHandler(value = { Exception.class, RuntimeException.class, Error.class })
	public ModelAndView defaultErrorHandler(Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("clue", e.getMessage());
		return mav;
	}
	
	@GetMapping("/error")
	public ModelAndView defaultErrorMapping(Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("clue", e.getMessage());
		return mav;
	}
}
