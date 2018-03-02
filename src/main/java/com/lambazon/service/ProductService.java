package com.lambazon.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lambazon.domain.Product;
import com.lambazon.repository.ProductRepository;

@Service
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	public List<Product> products() {
		return productRepository.products();
	}

	public Product product(Long id) {
		return productRepository.product(id);
	}
}
