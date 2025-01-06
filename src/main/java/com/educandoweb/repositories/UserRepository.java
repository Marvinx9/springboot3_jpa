package com.educandoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
