package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dao2.DirecteurERepository;
import com.coding.entity.directeurE;

@Service
public class DirecteurEService {
	 @Autowired
	 DirecteurERepository directeurerepository;
	 
	 //creation dun directeur d"etude
	 public directeurE creatDirecteurE(directeurE e) {
		 return directeurerepository.save(e);
	 }
	 //  recuperation de la liste des direteurs detude
	 
	 public  List<directeurE> getAllDirecteurs(){
		 
		 
		return directeurerepository.findAll();
		 
	 }
   // recuperation dun seul directeurs detude
	 
	 public directeurE getDirecteurById(Long idDirecteur) {
		 directeurE de=directeurerepository.findById(idDirecteur).orElse(null);
		 return de;
	 }
	// modification dun directeur d'etude 
	 public directeurE updateDirecteurE(Long idOld,directeurE newD) {
		 directeurE Dold=directeurerepository.findById(idOld).orElse(null);
		 
		 Dold.setEmail(newD.getEmail());
		 Dold.setAge(newD.getAge());
		 Dold.setImg(newD.getImg());
		 Dold.setNom(newD.getNom());
		 Dold.setTelephone(newD.getTelephone());
		 Dold.setUsername(newD.getUsername());
		 Dold.setPassword(newD.getPassword());
		 Dold.setPrenom(newD.getPrenom());
		 Dold.setSexe(newD.getSexe());
		 return directeurerepository.save(Dold);
	 }
	 // suppression dun directeur d'etude
	 public directeurE deletedDirecteurE(Long idDE) {
		 directeurE de=directeurerepository.findById(idDE).orElse(null);
		 if(de!=null) {
			 directeurerepository.delete(de);
		 }
		 return de;
	 }
}
