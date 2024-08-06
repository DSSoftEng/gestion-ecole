package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.dao2.IRoleDao;
import com.coding.dao2.IUserDao;
import com.coding.entity.Role;
import com.coding.entity.User;
import com.coding.entity.annonce;
import com.coding.entity.directeurG;



@Service
public class UserService implements IuserService {
	
	@Autowired
	IUserDao userDao;
	
	public User chercherparUsername(String username)
	{
		return userDao.findByUsername(username);
	}
	
	@Autowired
	 private PasswordEncoder passEncoder;
	@Autowired
	IRoleDao iroleDao;
	
	//ajouter un utilisateur 
	public User addNewUser(User user) {
		String pw=user.getPassword();
		user.setPassword(passEncoder.encode(pw));
		return userDao.save(user);
	}
	
	//ajouter un role 
	public Role addNewRole(Role role) {
		return iroleDao.save(role);
	}
	
	//ajouter un role a un utilisateur
	public void addRoleToUser(String username, String roleName) {
		User user=userDao.findByUsername(username);
		Role role=iroleDao.findByName(roleName);
		//user.getRoles().add(role);
		if (user != null && role != null) {
            user.getRoles().add(role);
            userDao.save(user);
        }
	}
 // recuperation de laliste des utilisateur 
	 public List<User> getAllUser(){
    	 List<User>listeAn=userDao.findAll();
		return listeAn;
    }
	 
	

	// Mettre à jour un utilisateur 
	
		public User updateUser(Long idOld, User newD) {
			User olD = userDao.findById(idOld).orElse(null);
			if (olD != null) {
				olD.setUsername(newD.getUsername());
				olD.setImg(newD.getImg());
				olD.setPassword(passEncoder.encode(newD.getPassword())); // Encoder le mot de passe avant de le définir
				olD.setNom(newD.getNom());
				olD.setPrenom(newD.getPrenom());
				olD.setAge(newD.getAge());
				olD.setEmail(newD.getEmail());
				olD.setTelephone(newD.getTelephone());
				olD.setSexe(newD.getSexe());
				return userDao.save(olD); // Enregistrer les modifications
			}
			return null;
		}
    
}
