package com.mytodo.mytodo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class AppRoles {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String roleName;
	public AppRoles() {
		// TODO Auto-generated constructor stub
	}	
	
	public AppRoles(String roleName) {
		super();
		this.roleName = roleName;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AppRoles [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
	

}
