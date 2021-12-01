package com.thiago.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.todo.domain.Todo;
import com.thiago.todo.repositories.TodoRepository;
import com.thiago.todo.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo findById(Long id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Tarefa não econtrada. Id: " + id));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();
		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repository.findAllClose();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = repository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Todo update(Long id, Todo obj) {
		Todo newObj = findById(id);
		newObj.setTitulo(obj.getTitulo());
		newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFinalizado(obj.isFinalizado());
		return repository.save(newObj);
	}

}
