package com.mytodo.mytodo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytodo.mytodo.bll.UserManager;
import com.mytodo.mytodo.bo.AppUser;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/ws")
public class AccountRestController {
	@Autowired
	private UserManager manageruser;
		@GetMapping("/users")
	public List<AppUser> allUser(){
		return manageruser.lisUser();
	}

}
