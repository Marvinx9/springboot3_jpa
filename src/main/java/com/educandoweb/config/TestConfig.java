package com.educandoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.entities.Category;
import com.educandoweb.entities.Order;
import com.educandoweb.entities.Product;
import com.educandoweb.entities.User;
import com.educandoweb.enums.OrderStatus;
import com.educandoweb.repositories.CategoryRepository;
import com.educandoweb.repositories.OrderRepository;
import com.educandoweb.repositories.ProductRepository;
import com.educandoweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;
  
  @Override
  public void run(String... args) throws Exception {

    User u1 = new User(null, "Billy Brown", "billy@gmail.com", "77777777", "12345");
    User u2 = new User(null, "Snowbird Brown", "snowbird@gmail.com", "88888888", "12345");
 
    Order o1 = new Order(null, Instant.parse("2025-01-12T19:44:41Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2025-01-01T08:10:00Z"), OrderStatus.WAITNG_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2025-01-10T22:02:10Z"), OrderStatus.WAITNG_PAYMENT, u1);

    Category c1 = new Category( null, "Electronics");
    Category c2 = new Category( null, "Books");
    Category c3 = new Category( null, "Computers");

    Product p1 = new Product(null, "HeadSet", "The best headset of line with active noise cancellation", 65.90, "http://localhost:8080/");
    Product p2 = new Product(null, "Smart Tv", "A form of mass media based on the electronic delivery of moving images and sound from a source to a receiver.", 3450.90, "http://localhost:8080/");
    Product p3 = new Product(null, "MacBook Pro", "Apple MacBook Pro is a macOS laptop with a 13.30-inch display that has a resolution of 2560x1600 pixels", 12399.90, "http://localhost:8080/");
    Product p4 = new Product(null, "Pc Gamer", "Someone who plays games on a personal computer (PC)", 6619.99, "http://localhost:8080/");

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
  }
}
