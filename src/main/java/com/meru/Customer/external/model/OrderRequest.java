package com.meru.Customer.external.model;

import java.io.Serializable;
import java.util.List;

import com.meru.Customer.model.Customer;

public class OrderRequest implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long customerID;
	
	private Customer customer;
	
	private Cart cart;
	
	private List<Product> products;
	
	private List<Inventory> inventories;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
}
