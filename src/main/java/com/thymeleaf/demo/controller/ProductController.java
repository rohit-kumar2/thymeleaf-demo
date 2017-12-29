package com.thymeleaf.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thymeleaf.demo.entity.Product;
import com.thymeleaf.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	@ResponseBody
	public List<Product> showAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping
	public String createProduct(@Valid Product product) {
		productService.insertProduct(product);
		return "product";
	}
	
	@PutMapping
	@RequestMapping("/{id}")
	@ResponseBody()
	public String updateProduct(@PathVariable Long id, @Valid Product product) {
		Product product1 = productService.updateProduct(product);
		return String.valueOf(product1.getId());
	}

}