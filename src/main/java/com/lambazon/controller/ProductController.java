package com.lambazon.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambazon.service.ProductService;


@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GetMapping("/products")
	public String products	(Model model) {
		model.addAttribute("prods", productService.products());
		return "products";
	}
	
	@GetMapping("/products/{id}/details")
	public String product	(@PathVariable Long id, Model model) {
		model.addAttribute("prod", productService.product(id));
		return "product";
	}
}
