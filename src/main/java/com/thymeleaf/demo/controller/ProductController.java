package com.thymeleaf.demo.controller;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thymeleaf.demo.entity.Product;
import com.thymeleaf.demo.entity.XEditableForm;
import com.thymeleaf.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String showAllProducts(Model model) {
		model.addAttribute("product", new Product());
		return "add-product";
	}
	
	@PostMapping
	public String createProduct(@Valid Product product) {
		productService.insertProduct(product);
		return "redirect:/";
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping
	@RequestMapping("/{id}")
	public <T,V> String updateProduct(@PathVariable Long id, @Valid XEditableForm<T> form) throws NoSuchFieldException, 
									   SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Product product = productService.getProduct(id);
		V value = null;
		Field fieldToUpdate = product.getClass().getDeclaredField(form.getName());
		fieldToUpdate.setAccessible(true);
		if(BigDecimal.class.equals(fieldToUpdate.getType())) {
			value = (V) new BigDecimal(form.getValue().toString());
		} else
			value = (V) form.getValue();
		
		fieldToUpdate.set(product, fieldToUpdate.getType().cast(value));
		productService.updateProduct(product);
		return "redirect:/";
	}

}
