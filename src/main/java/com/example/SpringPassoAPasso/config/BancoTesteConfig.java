package com.example.SpringPassoAPasso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.SpringPassoAPasso.entities.Order;
import com.example.SpringPassoAPasso.entities.User;
import com.example.SpringPassoAPasso.entities.enumns.OrderStatus;
import com.example.SpringPassoAPasso.repositories.OrderRepository;
import com.example.SpringPassoAPasso.repositories.UserRepository;

@Configuration 
@Profile("test") //nome test esta configurado no arquivo application.properties 
public class BancoTesteConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, u1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	
}
