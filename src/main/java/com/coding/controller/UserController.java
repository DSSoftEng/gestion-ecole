package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.entity.User;
import com.coding.service.UserService;

@Controller

@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userservice;
	
	// api recuperation de la liste des users
		@GetMapping("/listUser")
	   public ResponseEntity<List<User>> getAllAnnonces(){
		   List<User> liste=userservice.getAllUser();
		   return ResponseEntity.ok().body(liste);
	   }
		
  // api recuperation d'un utilisateur a travers username
		
		@GetMapping("/{username}")
		public ResponseEntity<User> getUserByUsername(@PathVariable("username")String username){
			   User user=userservice.chercherparUsername(username);
			   return ResponseEntity.ok().body(user);
		   }
 // api de modification d un utilisateur 
		@PutMapping("/{idUser}")
		public ResponseEntity<User> updateUser(@PathVariable("idUser")Long idUser,@RequestBody  User newUser){
			
			User user=userservice.updateUser(idUser, newUser);
			return ResponseEntity.ok().body(user);
		}

}
