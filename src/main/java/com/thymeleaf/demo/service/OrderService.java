package com.thymeleaf.demo.service;

import java.util.List;

import com.thymeleaf.demo.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrders();
	
	Order insertOrder(Order order);
	
	Order updateOrder(Order order);

	Order getOrder(Long id);

}
