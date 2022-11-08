package com.amazonSeller.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.client.RestTemplate;

import com.amazonSeller.Entity.ProcductSel;
import com.amazonSeller.Entity.Seller;
import com.amazonSeller.Repository.SellerRepository;
import com.amazonSeller.Service.SellerService;


@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerRepository selRepo;
	
	@Autowired
	private SellerService selSer;
	
	@Autowired
	private RestTemplate resttemplate;
	
	//Crud Swagger
	
		@GetMapping("/")
		public List<Seller> getAll(){
			List<Seller> list=((JpaRepository<Seller, Long>) selRepo).findAll();
			return list;	
		}
		
		@GetMapping("/{id}")
		public Seller get(@PathVariable Long id) {
			
			Seller sel=selSer.getById(id);
			
			return sel;
		}
		
		
		@PostMapping("/add")
		public String add(@RequestBody Seller sel) {
			
		Long id=((CrudRepository<Seller, Long>) selRepo).save(sel).getSellerId();
		return "added "+id;
		}

		
		 @PutMapping("/update")
		 public String update(@RequestBody Seller sel) {
			
		 Long id=((CrudRepository<Seller, Long>) selRepo).save(sel).getSellerId();
		 return "updated "+id;
		}
		 
		 @DeleteMapping("/delete/{id}")
		 public String Delete(@PathVariable Long id) {
			 
			 ((CrudRepository<Seller, Long>) selRepo).deleteById(id);
			 return "deleted  "+id;
		 }
		
		 //signin and signup
		 
		 
		 //data sending to appropriate product
		 @RequestMapping("/addproduct")
		 public String addProduct(@RequestBody ProcductSel pro) {
			 
			 String msg=((SellerService) selSer).addPro(pro);
			 
		 return msg;
		 }

}
