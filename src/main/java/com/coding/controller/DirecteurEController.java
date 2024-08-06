package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.entity.directeurE;
import com.coding.service.DirecteurEService;


@Controller
@RequestMapping("/api/directeurE")
public class DirecteurEController {
	
	@Autowired
	DirecteurEService directeurservice;
	// api pour la creation d'un directeur d'etude
	@PostMapping("/addDirecteurE")
	public ResponseEntity<directeurE> creatDirectorEtude( @RequestBody directeurE directeurE){
		directeurE d=directeurservice.creatDirecteurE(directeurE);
		return ResponseEntity.ok().body(d);
	}
	
	//api recuperation de la liste des directeurs detudes
	@GetMapping("/listDirecteurs")
	public ResponseEntity<List<directeurE>> getAllDirecteurs(){
		
		return ResponseEntity.ok().body(directeurservice.getAllDirecteurs());
	}
	
	//api recuperation dun seul directeur d'etude 
	@GetMapping("/{idDirecteur}")
	public  ResponseEntity<directeurE>  getDirecteur(@PathVariable("idDirecteur") Long idDirecteur){
		directeurE de=directeurservice.getDirecteurById(idDirecteur);
		return ResponseEntity.ok().body(de);
	}
	// api modification dun directeur d'etude 

    @PutMapping("/updateStudent/{idDirecteur}")
	public ResponseEntity<directeurE> updateDirecteurE(@PathVariable("idDirecteur") Long idOld,@RequestBody directeurE newD){
		directeurE de=directeurservice.updateDirecteurE(idOld, newD);
		return ResponseEntity.ok().body(de);
	
	}
	//api de suppression dun seul directeur d'etude
	@DeleteMapping("/{idDirecteur}")
	public ResponseEntity<directeurE>  deletedDE(@PathVariable("idDirecteur")Long idDE){
		directeurE de=directeurservice.deletedDirecteurE(idDE);
		return  ResponseEntity.ok().body(de);
	}
}
