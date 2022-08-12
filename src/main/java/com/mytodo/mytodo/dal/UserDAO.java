package com.mytodo.mytodo.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytodo.mytodo.bo.AppUser;

public interface UserDAO extends CrudRepository<AppUser, Integer> {
	
	@Query("select u from AppUser u where u.username = :username")
	AppUser findByUsernameLike(@Param("username") String username);


}
