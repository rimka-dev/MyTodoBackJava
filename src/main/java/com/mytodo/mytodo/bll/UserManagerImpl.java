package com.mytodo.mytodo.bll;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytodo.mytodo.bo.AppRoles;
import com.mytodo.mytodo.bo.AppUser;
import com.mytodo.mytodo.dal.RoleDAO;
import com.mytodo.mytodo.dal.UserDAO;
@Service
@Transactional
public class UserManagerImpl implements UserManager{
	@Autowired
	UserDAO userDao;
	@Autowired
	RoleDAO rolesDao;
	
	@Override
	public AppUser addNewUser(AppUser user1) {
		return  userDao.save(user1);
	}

	@Override
	public AppRoles addNewRole(AppRoles role) {
		return rolesDao.save(role);
	}
	
	@Override
	public void addRoleToUser(String username, String roleName) {
		
		AppUser appUser = this.getUserByUsername(username);
		//System.out.println("=== reponse === "+ appUser);
		AppRoles appRole = rolesDao.findByRoleNameLike(roleName);
		appUser.getAppRoles().add(appRole);
		
	}

	@Override
	public AppUser getUserByUsername(String username) {
		
		return userDao.findByUsernameLike(username);
	}

	@Override
	public List<AppUser> lisUser() {
		
		return (List<AppUser>) userDao.findAll();
	}

	
}