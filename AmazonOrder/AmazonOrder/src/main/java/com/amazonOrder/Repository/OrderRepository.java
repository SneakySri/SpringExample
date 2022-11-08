package com.amazonOrder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazonOrder.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {

}
