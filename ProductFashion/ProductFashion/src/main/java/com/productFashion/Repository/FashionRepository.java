package com.productFashion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productFashion.Entity.Fashion;

public interface FashionRepository extends JpaRepository<Fashion,Long> {

}
