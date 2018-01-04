package com.thymeleaf.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class OrderLine {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="line_id")
	private Long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="product_id")
	private Product product;
	
	private Integer quantity;
	
	private Integer amount;
	
	@Transient
	private String isOrdered;

	public OrderLine() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(String isOrdered) {
		this.isOrdered = isOrdered;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", product=" + product + ", quantity=" + quantity + ", amount=" + amount
				+ ", isOrdered=" + isOrdered + "]";
	}

}
