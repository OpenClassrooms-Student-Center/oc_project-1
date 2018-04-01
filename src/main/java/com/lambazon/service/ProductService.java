package com.lambazon.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lambazon.domain.Product;
import com.lambazon.repository.ProductRepository;

@Service
public class ProductService {
	
	@Inject
	private ProductRepository repository;
	
	public List<Product> products() {
		List<Product> target = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(target::add);
		return target;
	}

	public Product product(Long id) {
		return repository.findById(id).get();
	}
}
