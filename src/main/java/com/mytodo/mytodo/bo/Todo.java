package com.mytodo.mytodo.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="MaTodo")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTodo;
	
	private String titleTodo;
	
	@OneToMany(mappedBy = "todo", fetch = FetchType.LAZY)
	private Set <ListOfTodo> listeOfTodo = new HashSet<>();
	
	 public Todo() {
		
	}

	public Todo(String nameTodo) {
		super();
		this.titleTodo = nameTodo;
	}

	public Integer getIdTodo() {
		return idTodo;
	}

	public void setIdTodo(Integer idTodo) {
		this.idTodo = idTodo;
	}

	public String getNameTodo() {
		return titleTodo;
	}

	public void setNameTodo(String nameTodo) {
		this.titleTodo = nameTodo;
	}

	public Set<ListOfTodo> getListeOfTodo() {
		return listeOfTodo;
	}

	public void setListeOfTodo(Set<ListOfTodo> listeOfTodo) {
		this.listeOfTodo = listeOfTodo;
	}
	
	public void addListeOfTodo(ListOfTodo todo) {
		 boolean isEmpty = this.listeOfTodo.isEmpty();
		if(isEmpty) {
			this.listeOfTodo.removeAll(listeOfTodo);
		}
		this.listeOfTodo.add(todo);
		todo.setTodo(this);
	}
	public void clearListeOfTodo() {
		this.listeOfTodo.clear();
		
	}
	
	public void deleteItemList(ListOfTodo todo) {
		this.listeOfTodo.remove(todo);
		
	}

	@Override
	public String toString() {
		return "Todo [idTodo=" + idTodo + ", titleTodo=" + titleTodo + ", listeOfTodo=" + listeOfTodo + "]";
	}

	
	
	
	
	
	 
	
	

}
