package com.craigecomputing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craigecomputing.domains.User;
import com.craigecomputing.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		return ResponseEntity.ok(userRepository.getById(id));
	}

	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}
}