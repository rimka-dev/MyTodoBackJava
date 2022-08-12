package com.mytodo.mytodo.bll;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytodo.mytodo.bo.ListOfTodo;
import com.mytodo.mytodo.bo.Todo;
import com.mytodo.mytodo.dal.ListeDAO;
import com.mytodo.mytodo.dal.TodoListeDAO;


@Service
public class TodoManagerImpl implements TodoManager {
	@Autowired
	TodoListeDAO todoDao;
	@Autowired
	ListeDAO listeDao;

	@Override
	public void addTodo(Todo maTodo) throws TodoException {
		for(Todo t: todoDao.findAll()) {
			if(t.getNameTodo().equalsIgnoreCase(maTodo.getNameTodo())) {
				throw new TodoException(t.getNameTodo() + " exisite déja! ");
			}
		}
		todoDao.save(maTodo);
		
	}

	@Override
	public List<Todo> getAllTodo() {
		
		return (List<Todo>) todoDao.findAll();
	}

	@Override
	@Transactional
	public void addListe(ListOfTodo todo1) throws TodoException  {
		
		for(ListOfTodo l: listeDao.findAll()) {
			if(l.getTache().equalsIgnoreCase(todo1.getTache()) && l.getTodo().equals(todo1.getTodo())) {
				throw new TodoException(todo1.getTache() + " exisite déja ");
			}
		}
		listeDao.save(todo1);
	}

	@Override
	@Transactional
	public Todo updateTodo(Todo maTodo2) {
		todoDao.save(maTodo2);
		Integer id = maTodo2.getIdTodo();
		
		return todoDao.findById(id).get();
	}

	@Override
	@Transactional
	public Todo deleteItemOfTodo(ListOfTodo todo6) {
		Todo t = todo6.getTodo();
		t.deleteItemList(todo6);
		Integer id = t.getIdTodo();
		
		listeDao.delete(todo6);
		todoDao.save(t);
		
		return todoDao.findById(id).get();
	}

	@Override
	@Transactional
	public List<Todo> deleteTodo(Todo maTodo) {
		for(ListOfTodo l : maTodo.getListeOfTodo()) {
			listeDao.delete(l);
			}
		todoDao.delete(maTodo);
		return (List<Todo>) todoDao.findAll();
	}

	@Override
	public Todo getTodoById(Integer id) {
		
		return todoDao.findById(id).get();
	}

	@Override
	public ListOfTodo getItemById(Integer id) {
		
		return listeDao.findById(id).get();
	}

	

	
}
