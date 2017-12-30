package com.thymeleaf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thymeleaf.demo.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
		model.addAttribute("products", productService.getAllProducts());
        return "list-product";
    }

}
