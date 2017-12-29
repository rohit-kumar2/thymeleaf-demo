package com.thymeleaf.demo.service;

import java.util.List;

import com.thymeleaf.demo.entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	Product insertProduct(Product product);
	
	Product updateProduct(Product product);

}
