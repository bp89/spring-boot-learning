package com.craigecomputing.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.craigecomputing.domains.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User save(User user);
	
	User getById(String id);
	
}