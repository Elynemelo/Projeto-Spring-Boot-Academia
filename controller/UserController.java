package com.accenture.academiaSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.academiaSpringBoot.model.User;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private List<User> users = new ArrayList<User>();
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		users.add(user);
		return "Usuário inserido na lista com sucesso";
		
	}
		
	@GetMapping("/view")
	public List<User> viewUsers() {		
		return users;
	}
	
	
	@GetMapping("/viewUser/{id}")
	public User viewUser(@PathVariable("id") int id) {		
		User procurado = null;
		for(User user: users) {
			if (user.getId() == id) {
				procurado = user;
			}
		}
		return procurado;
	}
	
	@PutMapping("/update")
	public String updateUser() {
		return "Método UPDATE";
	}
	
	
	@DeleteMapping("/delete")
	public String deleteUser() {
		return "Método DELETE";
	}
	
}