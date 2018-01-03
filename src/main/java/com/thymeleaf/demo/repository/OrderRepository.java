package com.thymeleaf.demo.repository;

import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.entity.Order;
import com.thymeleaf.demo.repository.base.RepositoryBase;

@Repository
public interface OrderRepository extends RepositoryBase<Order, Long> {

}
