package com.amazonOrder.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
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
import org.springframework.web.bind.annotation.RestController;

import com.amazonOrder.Entity.Orders;
import com.amazonOrder.Repository.OrderRepository;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository ordRepo;
	
	 List<Orders> cart=new ArrayList();
	 Long cId=0L;
	

	//Crud Swagger
	
		@GetMapping("/")
		public List<Orders> getAll(){
			List<Orders> list=((JpaRepository<Orders, Long>) ordRepo).findAll();
			return list;	
		}
		
		@GetMapping("/{id}")
		public Orders get(@PathVariable Long id) {
			
			List<Orders> list=ordRepo.findAll();
			int n=list.size();
			Orders lastord=list.get(n-1);

			if(id>lastord.getOrderId()) {
				Orders or=new Orders();
				return or;
				}
			 
			for(int i=0;i<n;i++) {
				Orders ord=list.get(i);
				System.out.println("...."+n+" "+i+" "+id+" "+ord.getOrderId());

				if(ord.getOrderId()==id) {
					cart.add(ord);
					System.out.println(ord);
					return ord;
				}
			
		}
			
			
				Orders or=new Orders();
				or.setStatus("active");
				return or;
				
			
			
		}			
		
		
		@PostMapping("/add")
		public String add(@RequestBody Orders ord) {
			
		Long id=((CrudRepository<Orders, Long>) ordRepo).save(ord).getOrderId();
		return "added "+id;
		}

		
		 @PutMapping("/update")
		 public String update(@RequestBody Orders ord) {
			
		 Long id=((CrudRepository<Orders, Long>) ordRepo).save(ord).getSellerId();
		 return "updated "+id;
		}
		 
		 @DeleteMapping("/delete/{id}")
		 public String Delete(@PathVariable Long id) {
			 
			 ((CrudRepository<Orders, Long>) ordRepo).deleteById(id);
			 return "deleted  "+id;
		 }
		 
		 @RequestMapping("/test")
		 public String Test() {
			 return "working......";
		 }
		 //actual work
		
		 
		 @RequestMapping("/ord/{cusId}/{sellerId}/{productId}")
		 public Orders ord(@PathVariable Long cusId,@PathVariable Long sellerId,@PathVariable Long productId) {
			 
			 if(cusId.equals(cId)) {	 
				 cId=cusId;
				 Orders o=new Orders(0L,cusId,sellerId,productId,"cart");
				 ordRepo.save(o);
				 return o;
			 }
			 List<Orders> cart=new ArrayList();
			 cId=cusId;
			 
			 Orders o=new Orders(0L,cusId,sellerId,productId,"cart");
			 ordRepo.save(o);
			 
			 return o;
		 }
		 
		 @RequestMapping("remove/{cusId}/{productId}")
		 public Orders remove(@PathVariable Long cusId,@PathVariable Long productId) {
			List<Orders> list=ordRepo.findAll();
			Orders o=list.stream().filter(or->or.getCusId()==cusId&&or.getProductId()==productId).findAny().orElse(null);
			ordRepo.deleteById(o.getOrderId());
			return o;
		 }
		 
		 @RequestMapping("/pay/{total}")
		 public Orders pay(@PathVariable int total) {
			 
			 int n=cart.size();
			 System.out.println("...."+n);
			 System.out.println("...."+cart);

			 for(int i=0;i<n;i++) {
				 Orders o=cart.get(i);
				 Orders ord=new Orders(o.getOrderId(),o.getCusId(),o.getSellerId(),o.getProductId(),"order");
				 ordRepo.save(ord);
			 }
			 Orders ord=new Orders();			 
			 return ord;
		 }

}
