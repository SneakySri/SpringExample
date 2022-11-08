package com.amazonSeller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonSeller.Entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>{

}
