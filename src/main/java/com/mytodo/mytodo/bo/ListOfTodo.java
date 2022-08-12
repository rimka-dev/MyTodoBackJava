package com.mytodo.mytodo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ListOfTodo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idListe;
	
	private String tache;
	
	@ManyToOne
	@JsonIgnore
	private Todo todo;
	
	public ListOfTodo() {
		// TODO Auto-generated constructor stub
	}

	public ListOfTodo(String tache, Todo todo) {
		super();
		this.tache = tache;
		this.todo = todo;
	}

	public String getTache() {
		return tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}
	

	public Integer getIdListe() {
		return idListe;
	}

	@Override
	public String toString() {
		return "ListOfTodo [tache=" + tache + "]";
	}
	
	

}
