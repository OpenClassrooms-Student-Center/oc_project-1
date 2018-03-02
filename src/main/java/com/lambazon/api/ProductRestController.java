package com.lambazon.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lambazon.domain.Product;
import com.lambazon.service.ProductService;


@RestController
public class ProductRestController {
	
	@Inject
	private ProductService productService;

	@GetMapping("/api/products")
	public List<Product> productsAsJson (Model model) {
		return productService.products();
	}

	@GetMapping("/api/products/{id}/details")
	public Product product	(@PathVariable Long id, Model model) {
		return productService.product(id);
	}
}
