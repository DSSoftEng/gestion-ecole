package com.coding;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coding.entity.Role;
import com.coding.entity.User;
import com.coding.service.UserService;


@SpringBootApplication
public class GestionPersonneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPersonneApiApplication.class, args);
	}

	/*@Bean
	public PasswordEncoder passEncoder()
	{
		return new BCryptPasswordEncoder();
	}*/
	@Bean
	CommandLineRunner start(UserService accountService) {
		return args->{

			/* accountService.addNewRole(new Role(null,"USER"));
			accountService.addNewRole(new Role(null,"ADMIN"));
			accountService.addNewRole(new Role(null,"CUSTOMER_MANAGER"));
			accountService.addNewRole(new Role(null,"PRODUCT_MANAGER"));
			accountService.addNewRole(new Role(null,"BILLS_MANAGER"));
			
			accountService.addNewUser(new User(null,"Dounya","sebki","user1","1234","",30,"","","",new ArrayList<>()));

			accountService.addNewUser(new User(null,"aya","sabri","admin","567","",30,"","","",new ArrayList<>()));

			accountService.addNewUser(new User(null,"amine","ben","user3","8910","",30,"","","",new ArrayList<>()));

			accountService.addNewUser(new User(null,"fahd","ben","user4","1112","",30,"","","",new ArrayList<>()));
			
			accountService.addRoleToUser("user1","USER");
			accountService.addRoleToUser("admin","USER");
			accountService.addRoleToUser("admin","ADMIN");
			System.out.println("cela marche bien");
			accountService.addRoleToUser("user3","CUSTOMER_MANAGER");
			accountService.addRoleToUser("user4","USER");
			  
				
			//System.out.println("Répertoire temporaire actuel : " + System.getProperty("java.io.tmpdir"));
			
			*/
		};
	
	}


}
