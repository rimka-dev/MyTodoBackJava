package com.mytodo.mytodo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytodo.mytodo.bll.UserManager;
import com.mytodo.mytodo.bo.AppRoles;
import com.mytodo.mytodo.bo.AppUser;
import com.mytodo.mytodo.bo.RoleUserForm;

import lombok.Data;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/ws")
public class AccountRestController {
	@Autowired
	private UserManager manageruser;
		@GetMapping("/users")
	public List<AppUser> allUser(){
		return manageruser.lisUser();
	}
	
		@PostMapping("/users")
	public AppUser saveUser(@RequestBody AppUser newUser) {
		return manageruser.addNewUser(newUser);
	}
		
		@PostMapping("/role")
		public AppRoles saveRole(@RequestBody AppRoles role) {
			return manageruser.addNewRole(role);
		}
		
		
		@PostMapping("/addRoleToUser")
		public void addRoleToUser(@RequestBody RoleUserForm roleuserform) {
			 manageruser.addRoleToUser(roleuserform.getUsername(), roleuserform.getRoleName());
		}
		
		/*@Data
		class RoleUserForm{
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
			
			
			
		}*/
		

}
