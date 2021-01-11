package com.meru.Customer.service;

import java.util.List;

import com.meru.Customer.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomer(long id);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(long id, Customer updatedCustomer);

	public void deleteCustomer(long id);

	public String addCustomerToOrderRequest(String jsonOrderRequest);

}
