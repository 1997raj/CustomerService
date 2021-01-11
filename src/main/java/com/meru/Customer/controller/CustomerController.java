package com.meru.Customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.Customer.model.Customer;
import com.meru.Customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return this.service.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable long id)
	{
		return this.service.getCustomer(id);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer newcustomer = this.service.addCustomer(customer);
		return(new ResponseEntity<Customer>(newcustomer,HttpStatus.CREATED));
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody Customer updatedCustomer)
	{
		return this.service.updateCustomer(id,updatedCustomer);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable long id)
	{
		this.service.deleteCustomer(id);
	}
}
