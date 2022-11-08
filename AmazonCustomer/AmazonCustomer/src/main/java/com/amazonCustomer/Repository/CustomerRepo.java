package com.amazonCustomer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonCustomer.Entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
