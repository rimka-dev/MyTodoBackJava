package com.mytodo.mytodo.bll;

import java.util.List;

import com.mytodo.mytodo.bo.ListOfTodo;
import com.mytodo.mytodo.bo.Todo;

public interface TodoManager {

	public void addTodo(Todo maTodo) throws TodoException;

	public List<Todo> getAllTodo();

	public void addListe(ListOfTodo todo1) throws TodoException;

	public Todo updateTodo(Todo maTodo2);

	public Todo deleteItemOfTodo(ListOfTodo todo6);

	public List<Todo> deleteTodo(Todo maTodo);

	public Todo getTodoById(Integer id);

	public ListOfTodo getItemById(Integer id);

	
}
