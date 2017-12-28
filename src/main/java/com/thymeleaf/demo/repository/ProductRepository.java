package com.thymeleaf.demo.repository;

import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.entity.Product;
import com.thymeleaf.demo.repository.base.RepositoryBase;

@Repository
public interface ProductRepository extends RepositoryBase<Product, Long> {

}
