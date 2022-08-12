package com.mytodo.mytodo.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytodo.mytodo.bo.AppRoles;

public interface RoleDAO extends CrudRepository<AppRoles, Integer> {

	@Query("select u from AppRoles u where u.roleName = :roleName")
	AppRoles findByRoleNameLike(@Param("roleName") String roleName);

}
