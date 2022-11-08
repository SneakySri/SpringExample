package com.productElectronic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productElectronic.Entity.Electronics;

public interface ProductRepository extends JpaRepository<Electronics,Long>{
	

}
