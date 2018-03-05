package com.lambazon.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.service.CustomerService;


@Controller
public class CustomerController {
	
	@Inject
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String getAll(Model model) {
		model.addAttribute("custs", customerService.customers());
		return "customers";
	}
	
	@GetMapping("/customers/{id}/details")
	public String getOne (@PathVariable Long id, Model model) {
		model.addAttribute("cust", customerService.customer(id));
		return "customer";
	}
	
}
