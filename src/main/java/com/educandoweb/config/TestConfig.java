package com.educandoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.entities.Order;
import com.educandoweb.entities.User;
import com.educandoweb.enums.OrderStatus;
import com.educandoweb.repositories.OrderRepository;
import com.educandoweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public void run(String... args) throws Exception {

    User u1 = new User(null, "Billy Brown", "billy@gmail.com", "77777777", "12345");
    User u2 = new User(null, "Snowbird Brown", "snowbird@gmail.com", "88888888", "12345");
 
    Order o1 = new Order(null, Instant.parse("2025-01-12T19:44:41Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2025-01-01T08:10:00Z"), OrderStatus.WAITNG_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2025-01-10T22:02:10Z"), OrderStatus.WAITNG_PAYMENT, u1);

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }
}
