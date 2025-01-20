package com.educandoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
