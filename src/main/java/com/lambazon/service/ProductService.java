package com.lambazon.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lambazon.Application;
import com.lambazon.domain.Product;
import com.lambazon.repository.ProductRepository;

@Service
public class ProductService {
	
	@Inject
	private ProductRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public List<Product> products() {
		List<Product> target = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(target::add);
		log.info("returning " + target.size() + " Products from datastore");
		return target;
	}

	public Product product(Long id) {
		return repository.findById(id).get();
	}
}
