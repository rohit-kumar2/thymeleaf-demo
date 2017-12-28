package com.thymeleaf.demo.entity;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private boolean inStock;
	
	@ElementCollection
	@CollectionTable(name="product_comments")
	@MapKeyJoinColumn(name="customer_id")
	@Column(name="comment")
	private Map<Customer, String> customeComments;

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Map<Customer, String> getCustomeComments() {
		return customeComments;
	}

	public void setCustomeComments(Map<Customer, String> customeComments) {
		this.customeComments = customeComments;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", inStock=" + inStock
				+ ", customeComments=" + customeComments + "]";
	}
	

}
