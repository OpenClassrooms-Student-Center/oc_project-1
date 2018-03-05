package com.lambazon.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lambazon.API;
import com.lambazon.domain.Product;

@Repository
public class ProductRepository {
	
	private static Map<Long, Product> products = new HashMap<>();
	
	private static void generateData() {
		long id=0;
		products.put(++id, API.createProduct(id, 10, 92.50, "Echo Dot", "(2nd Generation) - Black"));
		products.put(++id, API.createProduct(id, 20, 9.99, "Anker 3ft / 0.9m Nylon Braided", "Tangle-Free Micro USB Cable"));
		products.put(++id, API.createProduct(id, 30, 69.99, "JVC HAFX8R Headphone", "Riptidz, In-Ear"));
		products.put(++id, API.createProduct(id, 40, 32.50, "VTech CS6114 DECT 6.0", "Cordless Phone"));
		products.put(++id, API.createProduct(id, 50, 895.00, "NOKIA OEM BL-5J", "Cell Phone "));
	}
	
	public List<Product> products() {
		
		if (products.isEmpty()) {
			generateData();
		}
		
		return products.values()
				.stream()
				.sorted(Comparator.comparing(Product::getName))
				.collect(Collectors.toList());
	}
	
	public Product product(Long id) {
		return products.get(id);
	}

}
