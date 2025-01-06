package com.educandoweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.entities.User;
import com.educandoweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {

    User u1 = new User(null, "Billy Brown", "billy@gmail.com", "77777777", "12345");
    User u2 = new User(null, "Snowbird Brown", "snowbird@gmail.com", "88888888", "12345");
 
    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
