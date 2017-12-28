package com.thymeleaf.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="line_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private Integer quantity;
	
	private Integer amount;
    
    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name="state", column=@Column(name="province")),
    	        @AttributeOverride(name="zip", column=@Column(name="postal_code"))
    })
    private Address shippingAddress;

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

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", product=" + product + ", quantity=" + quantity + ", amount=" + amount
				+ ", shippingAddress=" + shippingAddress + "]";
	}

}
