package com.meru.Customer.external.model;

import java.io.Serializable;
import java.util.List;


public class Cart implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long cartID;
	
	private long customerID;
	
	private List<CartItem> shoppingCart;

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public List<CartItem> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<CartItem> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
	