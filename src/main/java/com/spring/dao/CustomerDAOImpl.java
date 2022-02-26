package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery("from Customer order by lastName",Customer.class).getResultList();
		return customers;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}
	
}
