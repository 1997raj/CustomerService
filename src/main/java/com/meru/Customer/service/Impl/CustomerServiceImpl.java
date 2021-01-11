package com.meru.Customer.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meru.Customer.exception.CustomerNotFoundException;
import com.meru.Customer.exception.InvalidRequestException;
import com.meru.Customer.external.model.OrderRequest;
import com.meru.Customer.messaging.QueueOperation;
import com.meru.Customer.model.Customer;
import com.meru.Customer.repository.CustomerRepository;
import com.meru.Customer.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private QueueOperation queueOperation;

	@Override
	public List<Customer> getAllCustomers() {
		return this.repository.findAll();
	}

	@Override
	public Customer getCustomer(long id) {
		Optional<Customer> customer = this.repository.findById(id);
		if(customer.isPresent())
		{
			return customer.get();
		}
		else
		{
			throw new CustomerNotFoundException("No customer found with ID : "+id);
		}
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer newCustomer = this.repository.save(customer);
		this.queueOperation.createEmptyCartForCustomerId(newCustomer.getCustomerID());
		return newCustomer;
	}

	@Override
	public Customer updateCustomer(long id, Customer updatedCustomer) {
		if(updatedCustomer.getCustomerID() != id)
		{
			throw new InvalidRequestException("CustomerID mismatch in URI and body");
		}
		Optional<Customer> customer = this.repository.findById(id);
		if(customer.isPresent())
		{
			return this.repository.save(updatedCustomer);
		}
		else
		{
			throw new CustomerNotFoundException("No customer found with ID : "+id);
		}
	}

	@Override
	public void deleteCustomer(long id) {
		Optional<Customer> customer = this.repository.findById(id);
		if(customer.isPresent())
		{
			this.queueOperation.deleteCartForCustomerId(id);
			this.repository.deleteById(id);
		}
		else
		{
			throw new CustomerNotFoundException("No customer found with ID : "+id);
		}
		
	}

	@Override
	public String addCustomerToOrderRequest(String jsonOrderRequest) {
		ObjectMapper om = new ObjectMapper();
		String customerAddedOrder = null;
		try {
			OrderRequest orderRequest = om.readValue(jsonOrderRequest, OrderRequest.class);
			long customerID = orderRequest.getCustomerID();
			Customer customer = this.getCustomer(customerID);
			orderRequest.setCustomer(customer);
			System.out.println(customer.getCustomerName());
			customerAddedOrder = om.writeValueAsString(orderRequest);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return customerAddedOrder;
	}
	

}
