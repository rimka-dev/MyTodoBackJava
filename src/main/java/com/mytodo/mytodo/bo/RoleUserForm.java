package com.mytodo.mytodo.bo;

import lombok.Data;
// c'est une class util on l'utilise juste pour récuper les données c'est pas une entité enregistrer en bdd
@Data
public class RoleUserForm {
	private String username;
	private String roleName;
	public RoleUserForm() {
		// TODO Auto-generated constructor stub
	}
	public RoleUserForm(String username, String roleName) {
		super();
		this.username = username;
		this.roleName = roleName;
	}
	

}
