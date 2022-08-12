package com.mytodo.mytodo.dal;

import org.springframework.data.repository.CrudRepository;

import com.mytodo.mytodo.bo.Todo;

public interface TodoListeDAO extends CrudRepository<Todo, Integer> {

}
