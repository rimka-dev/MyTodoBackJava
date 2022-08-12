package com.mytodo.mytodo.dal;

import org.springframework.data.repository.CrudRepository;

import com.mytodo.mytodo.bo.ListOfTodo;

public interface ListeDAO extends CrudRepository<ListOfTodo, Integer>{

}
