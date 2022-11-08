package com.amazonCustomer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonCustomer.Entity.Customer;
import com.amazonCustomer.Repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cusRepo;

	public Customer authenticate(String name, String pass) {
		// TODO Auto-generated method stub
		List<Customer> list=cusRepo.findAll();
		
		Customer cus=list.stream().filter(c->c.getCusName().equals(name)&&c.getCusPass().equals(pass)).findAny().orElse(null);
		
		return cus;
	}
}
