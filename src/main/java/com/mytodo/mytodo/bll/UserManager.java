package com.mytodo.mytodo.bll;

import java.util.List;

import com.mytodo.mytodo.bo.AppRoles;
import com.mytodo.mytodo.bo.AppUser;

public interface UserManager {

	public AppUser addNewUser(AppUser user1);
	public AppRoles addNewRole(AppRoles role);
	public void addRoleToUser(String username,String roleName);
	public AppUser getUserByUsername(String username);
	public List<AppUser> lisUser();

}
