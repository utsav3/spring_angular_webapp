package com.webapp.spring_angular_webapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.spring_angular_webapp.models.Todo;
import com.webapp.spring_angular_webapp.repositories.TodoRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos(){
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC,"createdAt");
		return todoRepository.findAll(sortByCreatedAtDesc);
	}
	
	@GetMapping("/todos/{id}")
	public Todo createTodo(@Valid @RequestBody Todo todo){
		todo.setCompleted(false);
		return todoRepository.save(todo);
	}
	
	/*@PutMapping("/todos/{id}")
	public ResponseEntity<Todo>  getTodoById(@PathVariable("id") String id){
	//	return todoRepository
		
	}*/
}
