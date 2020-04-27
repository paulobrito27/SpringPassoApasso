package com.example.SpringPassoAPasso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPassoAPasso.entities.User;

@RestController 
@RequestMapping( value = "/users") 
class UserResource{

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(12l, "paulo", "paulo@mail", "3423-6470", "271080");
		return ResponseEntity.ok().body(user);
	}
}
