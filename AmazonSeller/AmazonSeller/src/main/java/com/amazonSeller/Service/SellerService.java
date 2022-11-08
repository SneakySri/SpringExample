package com.amazonSeller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazonSeller.Entity.ProcductSel;
import com.amazonSeller.Entity.Product;
import com.amazonSeller.Entity.Seller;
import com.amazonSeller.Repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository selRepo;

	@Autowired
	private RestTemplate resttemplate;

	public Seller getById(Long id) {
		// TODO Auto-generated method stub
		List<Seller> list=selRepo.findAll();
		int n=list.size();
		for(int i=0;i<n;i++) {
			Seller sel=list.get(i);
			if(sel.getSellerId().equals(id)) {
				return sel;
			}
		}
		return null;
	}

	public String addPro(ProcductSel pro) {
		// TODO Auto-generated method stub
		 Product p=new Product(pro.getProductId(),pro.getProductname(),pro.getSellerId(),pro.getPrice());
		 System.out.println(pro);
		 if(pro.getType().equals("electronics")) {
		 
             Product product=this.resttemplate.getForObject("http://electronics/electronics/add/"+p.getSellerId()+"/"+p.getProductname()+"/"+p.getPrice(),Product.class);
			 
			 return "electronics added sucessfully";
		 }
		 
		 else if(pro.getType().equals("fashion")) {
			 
             Product product=this.resttemplate.getForObject("http://fashion/fashion/add/"+p.getSellerId()+"/"+p.getProductname()+"/"+p.getPrice(),Product.class);
			 
			 return "fashion added sucessfully";
		 }
		 
		 
		 else if(pro.getType().equals("grocery")) {
			 
             Product product=this.resttemplate.getForObject("http://grocery/grocery/add/"+p.getSellerId()+"/"+p.getProductname()+"/"+p.getPrice(),Product.class);
			 
			 return "grocery added sucessfully";
		 }
		 
		return null;
	}

	
}
