package com.main.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.Model.Orders;
import com.main.Model.Product;

@Service
public class MainService {
	
	public int total = 0;


	@Autowired
	private RestTemplate resttemplate;
	

	List list=new ArrayList();
	
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		
		
	    
		int i=1;
		int n=list.size();
		if(n<7) {
		try {
			
		while(true) {	
			
			  System.out.println("before rest"+list);
			Product pro=this.resttemplate.getForObject("http://electronics/electronics/"+i,Product.class);
			  System.out.println(pro.getProductname());
			if(pro.getProductname().equals(null)) {
				break;
			}
			i++;
			list.add(pro);
     	  }   
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
 	    System.out.println(list);
 	   
 	    try {
 	    while(true) {	
			
			  System.out.println("before rest"+list);
			Product pro=this.resttemplate.getForObject("http://fashion/fashion/"+i,Product.class);
			  System.out.println(pro.getProductname());
			if(pro.getProductname().equals(null)) {
				break;
			}
			i++;
			list.add(pro);
     	  }   
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
 	    System.out.println(list);
 	    
 	    try {
 	    	while(true) {	
		
 	    		System.out.println("before rest"+list);
 	    		Product pro=this.resttemplate.getForObject("http://grocery/grocery/"+i,Product.class);
 	    		System.out.println(pro.getProductname());
 	    		if(pro.getProductname().equals(null)) {
 	    			break;
 	    		}
 	    		i++;
 	    		list.add(pro);
 	    	}   
 	    }
 	    catch(Exception e) {
 	    	System.out.println(e);
 	    }
		}
 	    System.out.println(list);
		
		return list;
	}


	public List<Product> getCart(Long cusId,String type) {
		// TODO Auto-generated method stub
		
		int i=1;
		total=0;
		List<Orders> ordlst=new ArrayList();
		List<Product> cart=new ArrayList();


		System.out.println("............at ser getcart"+list);
		try {
 	    while(true)
 	    {	
 	    		Orders ord =new Orders(); 
 	    		System.out.println("before rest"+list);
 	    		
 	    			ord=this.resttemplate.getForObject("http://orders/order/"+i,Orders.class);
 	    			System.out.println(ord);
 	    			if(ord.getStatus().equals(null)) {
 	    				break;	
 	 	    		}
 	    			else if(ord.getStatus().equals("cart")||ord.getStatus().equals("order")) {
 	    				
 	    	    		ordlst.add(ord);
 	 	    			
 	    			}
 	    			i=i+1;
 	    		System.out.println(".............."+i);  
 	    		
 	    		
     	   
 	     }
 	    }catch(Exception e) {
 			System.out.println(e);
 	    }
 	     System.out.println(ordlst);
 	     System.out.println(list);
 	    
 	     int n=list.size();
 	     int k=ordlst.size();
 	     for(int j=0;j<n;j++) {
	    	Product p=(Product) list.get(j);
 	    	System.out.println("inside n....."+j+" "+n);
 	    	for(int l=0;l<k;l++){
 	    			System.out.println("inside k....."+l+" "+k);
 	    			Orders o=ordlst.get(l);
 	    			System.out.println("inside loop "+o.getCusId()+"  "+cusId+"///"+o.getStatus()+"///  "+p.getProductId()+" "+ o.getProductId()+"");
 	    		
 	    			if(type.equals("cart")) {
 	    				if(o.getCusId()==cusId && o.getStatus().equals("cart")&&o.getProductId()==p.getProductId()) {
 	    					System.out.println("..........add cart "+p);
 	    					cart.add(p);
 	    					total=total+p.getPrice();
 	    					break;
 	    				}
 	    			}
 	    			else if(o.getCusId()==cusId && o.getStatus().equals("order")&&o.getProductId()==p.getProductId()) {
 	    					System.out.println("..........add order "+p);
 	 	    				cart.add(p);
 	 	    				total=total+p.getPrice();

 	 	    				break;
 	    			}
 	    			else if(k==l) {
 	    				break;
 	    			}
 	    		
 	    		
 	    		}
 	     }
 	     System.out.println(cart);
		
 	     return cart;
			}
	
	
	

	
	}
