package com.main.Controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.main.Model.Customer;
import com.main.Model.Orders;
import com.main.Model.Product;
import com.main.Service.MainService;


@RestController
@RequestMapping("/main")
public class Controller {
	
	@Autowired
	private MainService ser; 
	
	@Autowired
	private RestTemplate resttemplate;
	
	Customer customer=new Customer(1L,"sri","111","chennai","12345");
	
	
	@RequestMapping("/test")
	public String test() {
		return "working.....";
	}
	
	@RequestMapping("/index")
	public ModelAndView landingpage() {
			System.out.println(".......at index");
			
			List<Product> list=ser.getAll();
			
     	    
     	    HashMap<String,List<Product>> model=new HashMap<>();
     	    System.out.println(model);
     	    model.put("list", list);
			
     	    return new ModelAndView("index",model) ;
	
		}
	@RequestMapping("add/{Id}/{sId}")
	public ModelAndView addorder(@PathVariable Long Id,@PathVariable Long sId,ModelMap model)	{
		
		
		Orders ord=this.resttemplate.getForObject("http://orders/order/ord/"+customer.getCusId()+"/"+sId+"/"+Id,Orders.class);
        String msg="added to cart "+ord;
        System.out.println(msg);
       
		model.put("msg", msg);
		return new ModelAndView("msg",model) ; 
        
		}
	
	@RequestMapping("/cart")
	public ModelAndView cart(ModelMap m) {
		if(customer.equals(null)) {
			 m.put("msg","login pls");
				
				return new ModelAndView("index",m);
			
		}
		List<Product> orderlist=ser.getCart(customer.getCusId(),"cart");
		System.out.println(".........AtControll"+orderlist);
		HashMap<String,List<Product>> model=new HashMap<>();
  	    System.out.println(model);
  	    model.put("list", orderlist);
  	    m.put("total",ser.total);
		
		return new ModelAndView("cart",model);
	 }
	
	@RequestMapping("/order")
	public ModelAndView order(ModelMap m) {
		
		List<Product> orderlist=ser.getCart(customer.getCusId(),"order");
		System.out.println(".........AtControll"+orderlist);
		HashMap<String,List<Product>> model=new HashMap<>();
  	    System.out.println(model);
  	    model.put("list", orderlist);
  	    m.put("total",ser.total);

		return new ModelAndView("order",model);
	 }
	

	@RequestMapping("/pay/{total}")
	public ModelAndView pay(@PathVariable int total,ModelMap model)	{
	
		
		Orders ord=this.resttemplate.getForObject("http://orders/order/pay/"+total,Orders.class);
		System.out.println("converted to order"+ord);
		String msg="payment success";
		System.out.println(msg);
		model.put("msg", msg);
		return new ModelAndView("msg",model) ;
		}
	
	@RequestMapping("/remove/{productId}")
	public ModelAndView remove(@PathVariable Long productId,ModelMap model)	{
	
		
		Orders ord=this.resttemplate.getForObject("http://orders/order/remove/"+customer.getCusId()+"/"+productId,Orders.class);
		String msg="removed"+ord;
		System.out.println(msg);
		model.put("msg", msg);
		return new ModelAndView("msg",model) ;
		}
	
//	@RequestMapping("/login")
//	public ModelAndView login(ModelMap m)
//	{
//		customer=this.resttemplate.getForObject("http://customer/customer/login",Customer.class);
//		m.put("cusName",customer.getCusName());
//		return new ModelAndView("index",m);
//	}
	@RequestMapping("/login")
	 public ModelAndView index() {
		 return new ModelAndView("cusindex");
	 }
	
	 @RequestMapping("/check")
	 public Customer check(@RequestParam("name") String name,@RequestParam("pass") String pass) {
		 
		 System.out.println("....................................");
		 System.out.println(name+pass);
		 System.out.println("at main.......... before rest");
		 customer=this.resttemplate.getForObject("http://customer/customer/authenciate/"+name+"/"+pass,Customer.class);
		 System.out.println("at main.......... after rest");

		 return  customer; 
	 }
	 @RequestMapping("/signup")
	 public ModelAndView signup() {
		 
		 return new ModelAndView("signup"); 
	 }
	 @RequestMapping("/add/{name}/{pass}/{address}/{ph}")
	 public Customer save(@PathVariable String name,@PathVariable String pass,@PathVariable String address,@PathVariable String ph) {
		 
		 Customer cus=new Customer(0L,name,pass,address,ph);
		 System.out.println(cus);
		 customer=this.resttemplate.getForObject("http://customer/customer/add/"+name+"/"+pass+"/"+address+"/"+pass,Customer.class);
		 return cus;
	 }
	
	
	}
