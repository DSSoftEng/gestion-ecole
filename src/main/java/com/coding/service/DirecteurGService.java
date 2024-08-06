package com.coding.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dao2.DirecteurGRepository;
import com.coding.entity.directeurG;

@Service
public class DirecteurGService {
	 @Autowired
	 DirecteurGRepository directeurgrepository;
	 
	// creation dun directeur general
	 public directeurG createDirecteur(directeurG directeurg) {
	      
	        return directeurgrepository.save(directeurg);
	    }
	 
	//modification dun directeur d'etude
	 
	 public directeurG updateDirecteur(Long idOld,directeurG newD) {
		 directeurG olD=directeurgrepository.findById(idOld).orElse(null);
		 if(olD!=null) {
			 olD.setUsername(newD.getUsername());
		        olD.setImg(newD.getImg());
		        olD.setPassword(newD.getPassword());
		        olD.setNom(newD.getNom());
		        olD.setPrenom(newD.getPrenom());
		        olD.setAge(newD.getAge());
		        olD.setEmail(newD.getEmail());
		        olD.setTelephone(newD.getTelephone());
		        olD.setSexe(newD.getSexe());
		 }
		 return directeurgrepository.save(olD);
	 }
	 // suppression dun directeur genrale
	 
	 public directeurG deletedDirecteur(Long idTodelete) {
		directeurG deleted=directeurgrepository.findById(idTodelete).orElse(null);
		if(deleted!=null) {
			directeurgrepository.delete(deleted);
		}
		return deleted;
	 }
	 //la recuperation du directeur genrale par id
	 
	 public directeurG getDGByid(Long idD) {
		 return directeurgrepository.findById(idD).orElse(null);
	 }
	 
	 //unique directeur general
	 public directeurG findUniqueDirecteurG() {
	        // Assuming there's only one directeurG in the database
	        Optional<directeurG> directeurG = directeurgrepository.findAll().stream().findFirst();
	        return directeurG.orElse(null);
	    }
}
