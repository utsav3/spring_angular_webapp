package com.webapp.spring_angular_webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webapp.spring_angular_webapp.models.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String>{

	
}
