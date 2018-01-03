package com.thymeleaf.demo.repository;

import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.entity.Customer;
import com.thymeleaf.demo.repository.base.RepositoryBase;

@Repository
public interface CustomerRepository extends RepositoryBase<Customer, Long> {

}
