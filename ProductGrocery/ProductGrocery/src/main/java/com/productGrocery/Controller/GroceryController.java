package com.productGrocery.Controller;

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

import com.productGrocery.Entity.Grocery;
import com.productGrocery.Repository.GroceryRepository;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	
	@Autowired
	private GroceryRepository groRepo;
	
	@GetMapping("/")
	public List<Grocery> getAll(){
		List<Grocery> list=((JpaRepository<Grocery, Long>) groRepo).findAll();
		return list;	
	}
	
	@GetMapping("/{id}")
	public Grocery get(@PathVariable Long id) {
		
		List<Grocery> list=groRepo.findAll();
		int n=list.size();
		for(int i=0;i<n;i++) {
			Grocery gro=list.get(i);
			Long l=gro.getProductId();
			if(l==id) {
				return gro;
			}
		}
		Grocery gro=new Grocery(0L,null,0L,0);
		
		return gro;
	}
	
	
	@PostMapping("/add")
	public String add(@RequestBody Grocery gro) {
		
	Long id=((CrudRepository<Grocery, Long>) groRepo).save(gro).getProductId();
	return "added "+id;
	}

	
	 @PutMapping("/update")
	 public String update(@RequestBody Grocery gro) {
		
	 Long id=groRepo.save(gro).getProductId();
	 return "updated "+id;
	}
	 
	 @DeleteMapping("/delete/{id}")
	 public String Delete(@PathVariable Long id) {
		 
		 groRepo.deleteById(id);
		 return "deleted  "+id;
	 }
	 
	//add 
		 @GetMapping("/add/{sId}/{name}/{price}")
			public Grocery addpro(@PathVariable Long sId,@PathVariable String name,@PathVariable int price ) {
				
			 Grocery ele=new Grocery();
			ele.setSellerId(sId);
			ele.setProductname(name);
			ele.setPrice(price);
			groRepo.save(ele);
			System.out.println("............................."+ele);
			return ele;
			
			}


}
