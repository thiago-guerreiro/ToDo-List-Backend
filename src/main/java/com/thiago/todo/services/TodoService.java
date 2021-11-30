package com.thiago.todo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.todo.domain.Todo;
import com.thiago.todo.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public Todo findById(Long id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElse(null);
	}

}
