package com.thymeleaf.demo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer_order")
public class Order {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
    
    @Embedded
    @AttributeOverrides({
    	@AttributeOverride(name="state", column=@Column(name="province")),
    	        @AttributeOverride(name="zip", column=@Column(name="postal_code"))
    })
    private Address shippingAddress;
	
	@OneToMany
	@JoinTable(name="order_lines", joinColumns=@JoinColumn(name="order_id"), inverseJoinColumns=@JoinColumn(name="line_id"))	
	private List<OrderLine> orderLines;

	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

}
