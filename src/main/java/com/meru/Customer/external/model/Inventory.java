package com.meru.Customer.external.model;

import java.io.Serializable;

public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long inventoryID;
	
	private long productID;
	
	private int productInventory;

	public long getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(long inventoryID) {
		this.inventoryID = inventoryID;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public int getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}
	
}
