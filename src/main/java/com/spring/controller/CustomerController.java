package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customers = customerService.getCustomers();
		theModel.addAttribute("customers", customers);
		return "list-customers";
		
	}
	
	@GetMapping("/showAddCustomerForm")
	public String addCustomerForm(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	};
	
	@GetMapping("/showUpdateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") int id, Model theModel) {
		Customer customer = customerService.getCustomer(id);
		theModel.addAttribute("customer",customer);
		return "update-customer";
	}
}
