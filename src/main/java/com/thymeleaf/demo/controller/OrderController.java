package com.thymeleaf.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thymeleaf.demo.entity.Order;
import com.thymeleaf.demo.entity.OrderLine;
import com.thymeleaf.demo.entity.Product;
import com.thymeleaf.demo.service.CustomerService;
import com.thymeleaf.demo.service.OrderService;
import com.thymeleaf.demo.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	@RequestMapping("/create")
	public String showAddOrders(Model model) {
		Order order = new Order();
		List<Product> productList = productService.getAllProducts();
		order.setCustomer(customerService.getAllCustomers().get(0));
		model.addAttribute("products", productList);
		model.addAttribute("order", order);
		return "create-order";
	}
	
	@GetMapping
	@RequestMapping("/list")
	public String showAllOrders(Model model) {
		model.addAttribute("cust", customerService.getAllCustomers().get(0));
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("orders", orderService.getAllOrders());
        return "list-order";
	}
	
	@PostMapping
	public String createOrder(@Valid Order order) {
		List<OrderLine> orderItems = new ArrayList<>();
		for(OrderLine line : order.getOrderLines()) {
			if(line.getIsOrdered() != null && line.getIsOrdered().equals("Y")) {
				line.setProduct(productService.getProduct(line.getProduct().getId()));
				line.setAmount(line.getQuantity() * line.getProduct().getPrice().intValue());
				orderItems.add(line);
			}
		}
		order.setOrderLines(orderItems);
		order.setOrderDate(new Date());
		orderService.insertOrder(order);
		return "redirect:/order/list";
	}

}
