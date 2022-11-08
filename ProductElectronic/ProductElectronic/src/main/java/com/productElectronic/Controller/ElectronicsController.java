package com.productElectronic.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.productElectronic.Entity.Electronics;
import com.productElectronic.Repository.ProductRepository;

@RestController
@RequestMapping("/electronics")
public class ElectronicsController {
	
	@Autowired
	private ProductRepository eleRepo;
	
	//Crud Swagger
	
			@GetMapping("/")
			public List<Electronics> getAll(){
				List<Electronics> list=((JpaRepository<Electronics, Long>) eleRepo).findAll();
				return list;	
			}
			
			@GetMapping("/{id}")
			public Electronics get(@PathVariable Long id) {
				
				List<Electronics> list=eleRepo.findAll();
				int n=list.size();
				for(int i=0;i<n;i++) {
					Electronics ele=list.get(i);
					if(ele.getProductId()==id) {
						return ele;
					}
				}
				Electronics ele=new Electronics(0L,null,0L,0);
				
				return ele;
			}
			
			
			@PostMapping("/add")
			public String add(@RequestBody Electronics ele) {
				
			Long id=((CrudRepository<Electronics, Long>) eleRepo).save(ele).getProductId();
			System.out.println("............................."+ele);
			return "added "+id;
			}

			
			 @PutMapping("/update")
			 public String update(@RequestBody Electronics ord) {
				
			 Long id=((CrudRepository<Electronics, Long>) eleRepo).save(ord).getSellerId();
			 return "updated "+id;
			}
			 
			 @DeleteMapping("/delete/{id}")
			 public String Delete(@PathVariable Long id) {
				 
				 ((CrudRepository<Electronics, Long>) eleRepo).deleteById(id);
				 return "deleted  "+id;
			 }
			 
			 //add 
			 @GetMapping("/add/{sId}/{name}/{price}")
				public Electronics addpro(@PathVariable Long sId,@PathVariable String name,@PathVariable int price ) {
					
				Electronics ele=new Electronics();
				ele.setSellerId(sId);
				ele.setProductname(name);
				ele.setPrice(price);
				eleRepo.save(ele);
				System.out.println("............................."+ele);
				return ele;
				
				}
			 

}
