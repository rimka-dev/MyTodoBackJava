package com.mytodo.mytodo.bo;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity

public class AppUser {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // carche le mdp comme JsonIgnore
	private String password;
	@ManyToMany(fetch = FetchType.EAGER) //EAGER = les roles vont etre charger avec user, LAZY = les roles ne sont pas charger avec user sauf si on a besoin de les récuperer
	private Collection<AppRoles> appRoles = new HashSet<>();
	
	
	public AppUser() {
		// TODO Auto-generated constructor stub
	}
	
	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void addRoleForUser(AppRoles role) {
		this.appRoles.add(role);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRoles> getAppRoles() {
		return appRoles;
	}
	public void setAppRoles(Collection<AppRoles> appRoles) {
		this.appRoles = appRoles;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", appRoles=" + appRoles
				+ "]";
	}
	
	
	
	
}
