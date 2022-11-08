package com.amazonCustomer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amazonCustomer.Entity.Customer;
import com.amazonCustomer.Repository.CustomerRepo;
import com.amazonCustomer.Service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepo cusRepo;
	
	@Autowired
	private CustomerService cusSer;
	
	//Crud Swagger
	
	@GetMapping("/")
	public List<Customer> getAll(){
		List<Customer> list=((JpaRepository<Customer, Long>) cusRepo).findAll();
		return list;	
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable Long id) {
		
		List<Customer> list=((JpaRepository<Customer, Long>) cusRepo).findAll();
		Customer cus =list.stream().filter(c->c.getCusId().equals(id)).findAny().orElse(null);
		return cus;
	}
	
	
	@PostMapping("/add")
	public String add(@RequestBody Customer cus) {
		
	Long id=((CrudRepository<Customer, Long>) cusRepo).save(cus).getCusId();
	return "added "+id;
	}

	
	 @PutMapping("/update")
	 public String update(@RequestBody Customer cus) {
		
	 Long id=((CrudRepository<Customer, Long>) cusRepo).save(cus).getCusId();
	 return "updated "+id;
	}
	 
	 @DeleteMapping("/delete/{id}")
	 public String Delete(@PathVariable Long id) {
		 
		 ((CrudRepository<Customer, Long>) cusRepo).deleteById(id);
		 return "deleted  "+id;
	 }
	
	 //real
	 @RequestMapping("/login")
	 public ModelAndView index() {
		 return new ModelAndView("index");
	 }
	
	 @RequestMapping("/check")
	 public Customer check(@RequestParam("name") String name,@RequestParam("pass") String pass) {
		 
		 
		 System.out.println(name+pass);
		 Customer cus=cusSer.authenticate(name,pass);
		 
		 return  cus; 
	 }
	 
	 @RequestMapping("/authenciate/{name}/{pass}")
	 public Customer authen(@PathVariable String name,@PathVariable String pass) {
		 
		 System.out.println("at cus.......... before rest");

		 System.out.println(name+pass);
		 Customer cus=cusSer.authenticate(name,pass);
		 System.out.println("at cus.......... after rest");

		 return  cus; 
	 }
	 
	 
	 
	 @RequestMapping("/signup")
	 public ModelAndView signup() {
		 
		 return new ModelAndView("signup"); 
	 }
	 
	 @RequestMapping("/add/{name}/{pass}/{address}/{ph}")
	 public Customer save(@PathVariable String name,@PathVariable String pass,@PathVariable String address,@PathVariable String ph) {
		 
		 Customer cus=new Customer(0L,name,pass,address,ph);
		 System.out.println(cus);
		 cusRepo.save(cus);
		 return cus;
	 }
	 
}
