package com.mytodo.mytodo;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mytodo.mytodo.bll.TodoManager;
import com.mytodo.mytodo.bll.UserManager;
import com.mytodo.mytodo.bo.AppRoles;
import com.mytodo.mytodo.bo.AppUser;
import com.mytodo.mytodo.bo.ListOfTodo;
import com.mytodo.mytodo.bo.Todo;


@SpringBootApplication
public class MytodoApplication implements CommandLineRunner {
	
	@Autowired
	TodoManager todoManager;
	@Autowired
	UserManager userManager;
	
	public static void main(String[] args) {
		SpringApplication.run(MytodoApplication.class, args);
		
	}
	@Override
	@Transactional
	public void run(String... args) throws Exception{
		//============ ma todo 1 course gateau ========
		Todo maTodo = new Todo("Course gateau");
		
		ListOfTodo todo1 = new ListOfTodo("oeufs", maTodo);
		ListOfTodo todo2 = new ListOfTodo("farine", maTodo);
		ListOfTodo todo3 = new ListOfTodo("sucre", maTodo);
		
		maTodo.addListeOfTodo(todo1);
		maTodo.addListeOfTodo(todo2);
		maTodo.addListeOfTodo(todo3);
		
		System.out.println(maTodo);
		//===== Create =============
		todoManager.addTodo(maTodo);
		todoManager.addListe(todo1);
		todoManager.addListe(todo2);
		todoManager.addListe(todo3);
		todoManager.getAllTodo().forEach(System.out::println);
		System.out.println("================================");
		//============ ma todo 2 course gratin========
				Todo maTodo2 = new Todo("Course Gratin");
				
				ListOfTodo todo4 = new ListOfTodo("oeufs", maTodo2);
				ListOfTodo todo5 = new ListOfTodo("Pomme de terre", maTodo2);
				ListOfTodo todo6 = new ListOfTodo("créme fraiche", maTodo2);
				
				maTodo2.addListeOfTodo(todo4);
				maTodo2.addListeOfTodo(todo5);
				maTodo2.addListeOfTodo(todo6);
				
				System.out.println(maTodo2);
				//===== Create Todo and list of todo ====================
				todoManager.addTodo(maTodo2);
				todoManager.addListe(todo4);
				todoManager.addListe(todo5);
				todoManager.addListe(todo6);
				//===== Read ======================
				todoManager.getAllTodo().forEach(System.out::println);
				//===== Read by Id =======
				Integer id = maTodo2.getIdTodo();
				todoManager.getTodoById(id);
				Integer idItem = todo5.getIdListe();
				todoManager.getItemById(idItem);
				//===== Update ====================
				String titleTodo = "Gratin de pomme de terre";
				maTodo2.setNameTodo(titleTodo);
				todoManager.updateTodo(maTodo2);
				System.out.println("===== update todo======");
				System.out.println(todoManager.updateTodo(maTodo2));
				//====== Delete liste of todo ==========
				todoManager.deleteItemOfTodo(todo6);
				System.out.println("==== delete d'un élément de la liste ====");
				System.out.println(todoManager.deleteItemOfTodo(todo6));
				//====== Delete Todo ===============
				todoManager.deleteTodo(maTodo);
				System.out.println("====== delete ma todo=======");
				System.out.println(todoManager.deleteTodo(maTodo));
				
				
				
				
				//============ ma todo 3 course gateau ========
				Todo maTodo3 = new Todo("Quiche aux oignons");
				
				ListOfTodo todo7 = new ListOfTodo("Pate feuilletee", maTodo3);
				ListOfTodo todo8 = new ListOfTodo("oeufs", maTodo3);
				ListOfTodo todo9 = new ListOfTodo("créme fraiche", maTodo3);
				
				maTodo3.addListeOfTodo(todo7);
				maTodo3.addListeOfTodo(todo8);
				maTodo3.addListeOfTodo(todo9);
				
				System.out.println(maTodo3);
				//===== Create =============
				todoManager.addTodo(maTodo3);
				todoManager.addListe(todo7);
				todoManager.addListe(todo8);
				todoManager.addListe(todo9);
				todoManager.getAllTodo().forEach(System.out::println);
				//============ ma todo 4 course gateau ========
				Todo maTodo4 = new Todo("Crêpe au chocolat");
				
				ListOfTodo todo10 = new ListOfTodo("Farine", maTodo4);
				ListOfTodo todo11 = new ListOfTodo("oeufs", maTodo3);
				ListOfTodo todo12 = new ListOfTodo("Lait", maTodo4);
				
				maTodo4.addListeOfTodo(todo10);
				maTodo4.addListeOfTodo(todo11);
				maTodo4.addListeOfTodo(todo12);
				
				System.out.println(maTodo4);
				//===== Create =============
				todoManager.addTodo(maTodo4);
				todoManager.addListe(todo10);
				todoManager.addListe(todo11);
				todoManager.addListe(todo12);
				todoManager.getAllTodo().forEach(System.out::println);
				
				//======= create users and roles =============
				userManager.addNewRole(new AppRoles("USER"));
				userManager.addNewRole(new AppRoles("ADMIN"));
				userManager.addNewRole(new AppRoles("CUSTOMER_MANAGER"));
				
				userManager.addNewUser(new AppUser("user1","1234"));
				userManager.addNewUser(new AppUser("admin","1234"));
				userManager.addNewUser(new AppUser("manager","1234"));
				userManager.addNewUser(new AppUser("adminBis","1234"));
				
				//==== affecter les roles ============
				userManager.addRoleToUser("user1", "USER");
				userManager.addRoleToUser("admin", "ADMIN");
				userManager.addRoleToUser("manager","CUSTOMER_MANAGER");
				userManager.addRoleToUser("adminBis","USER");
				userManager.addRoleToUser("adminBis","ADMIN");
				
				System.out.println("======!!!========");
				System.out.println(userManager.getUserByUsername("user1"));
				
				userManager.lisUser().forEach(System.out::println);
	
	}
	/*
	 il est possible faire les tests de note IHM dans la fonstion runner suivante :
	 
	 @Bean
	 CommandLineRunner start(UserManager manager){
	 	return args -> {
	 		
	 		manager.addNewRole(new AppRoles("USER"));
	 		..... etc nos tests ihm
	 	
	 	}
	 
	 }
	 
	 */
	
	

}
