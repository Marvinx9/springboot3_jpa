package com.educandoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  
}
