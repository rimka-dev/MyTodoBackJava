package com.mytodo.mytodo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytodo.mytodo.bll.TodoException;
import com.mytodo.mytodo.bll.TodoManager;
import com.mytodo.mytodo.bo.ListOfTodo;
import com.mytodo.mytodo.bo.Todo;

@CrossOrigin("http://localhost:4200")
//@CrossOrigin
@RestController
@RequestMapping("/ws")
public class CrudTodo {
	@Autowired
	TodoManager manager;
	@GetMapping("/mytodos")
	public List<Todo> getAllTodos(){
		return manager.getAllTodo();
	}
	
	@GetMapping("/mytodos/{id}")
	public Todo getTodoById(@PathVariable("id") Integer id) {
		return manager.getTodoById(id);
	}
	
	@PostMapping("/mytodos")
	public Todo addNewTodo(@RequestBody Todo todo) throws TodoException {
		todo.clearListeOfTodo();
			manager.addTodo(todo);
		
		return todo;
	}
	
	@PostMapping("/mytodos/additem/{id}")
	public ListOfTodo addItemsTodo(@PathVariable("id") Integer id,@RequestBody ListOfTodo item) throws TodoException {
		Todo todo = manager.getTodoById(id);
		todo.addListeOfTodo(item);
		item.setTodo(todo);
		manager.updateTodo(todo);
		manager.addListe(item);
		return manager.getItemById(item.getIdListe());
		//return manager.getTodoById(id);
		//return manager.getAllTodo();
	}
	
	@PutMapping("/mytodos")
	public Todo modifayTodo(@RequestBody Todo putTodo ) {
		manager.updateTodo(putTodo);
		return putTodo;
	}
	
	@DeleteMapping("/mytodos/deletitem/{id}")
	public Todo deleteItem(@PathVariable("id") Integer id) {
		ListOfTodo item = manager.getItemById(id);
		return manager.deleteItemOfTodo(item);
	}
	
	@DeleteMapping("/mytodos/deletodo/{id}")
	public List<Todo> deleteTodo(@PathVariable("id") Integer id) {
		Todo t = manager.getTodoById(id);
		return manager.deleteTodo(t);
	}
	
	

}
