package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
}
