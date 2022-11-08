package com.productFashion.Controller;

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

import com.productFashion.Entity.Fashion;
import com.productFashion.Repository.FashionRepository;

@RestController
@RequestMapping("/fashion")
public class FashionController {
	
	@Autowired
	private FashionRepository fasRepo;
	
	//Crud Swagger
	
	@GetMapping("/")
	public List<Fashion> getAll(){
		List<Fashion> list=((JpaRepository<Fashion, Long>) fasRepo).findAll();
		return list;	
	}
	
	@GetMapping("/{id}")
	public Fashion get(@PathVariable Long id) {
		
		List<Fashion> list=fasRepo.findAll();
		int n=list.size();
		for(int i=0;i<n;i++) {
			Fashion fas=list.get(i);
			Long l=fas.getProductId();
			if(l==id) {
				return fas;
			}
		}
		Fashion fas=new Fashion(0L,null,0L,0);
		
		return fas;
	}
	
	
	@PostMapping("/add")
	public String add(@RequestBody Fashion fas) {
		
	Long id=((CrudRepository<Fashion, Long>) fasRepo).save(fas).getProductId();
	return "added "+id;
	}

	
	 @PutMapping("/update")
	 public String update(@RequestBody Fashion fas) {
		
	 Long id=fasRepo.save(fas).getProductId();
	 return "updated "+id;
	}
	 
	 @DeleteMapping("/delete/{id}")
	 public String Delete(@PathVariable Long id) {
		 
		 fasRepo.deleteById(id);
		 return "deleted  "+id;
	 }
	 
	//add 
	 @GetMapping("/add/{sId}/{name}/{price}")
		public Fashion addpro(@PathVariable Long sId,@PathVariable String name,@PathVariable int price ) {
			
		Fashion ele=new Fashion();
		ele.setSellerId(sId);
		ele.setProductname(name);
		ele.setPrice(price);
		fasRepo.save(ele);
		System.out.println("............................."+ele);
		return ele;
		
		}

}
