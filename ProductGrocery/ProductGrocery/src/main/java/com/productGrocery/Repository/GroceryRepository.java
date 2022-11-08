package com.productGrocery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productGrocery.Entity.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery,Long>{

}
