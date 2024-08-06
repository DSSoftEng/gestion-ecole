package com.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.entity.directeurG;
import com.coding.service.DirecteurGService;

@Controller
@RequestMapping("/api/directeurG")
@CrossOrigin(origins = "http://localhost:3000")
public class DirecteurGController {
	@Autowired
	DirecteurGService  directeurgservice;
	
	// api creation dun directeur generale
	@PostMapping("/addDirecteurG")
	public ResponseEntity<directeurG> creatDirecteur(@RequestBody directeurG directeurG){
		directeurG dg=directeurgservice.createDirecteur(directeurG);
		return ResponseEntity.ok().body(dg);
	}
	// api modification dun directeur genrale

    @PutMapping("/updateDireteurG/{idDirecteur}")
	public ResponseEntity<directeurG> updateDirecteurE( @PathVariable("idDirecteur") Long idDG,@RequestBody directeurG dg){
		 directeurG olD=directeurgservice.updateDirecteur(idDG, dg);
		
		return ResponseEntity.ok().body(olD);
	}
	//api suppression dun directeur generale
	@DeleteMapping("/{idDirecteurG}")
	public ResponseEntity<directeurG> deletedDirecteurG(@PathVariable("idDirecteurG")Long idD){
          directeurG todelet=directeurgservice.deletedDirecteur(idD);
		return ResponseEntity.ok().body(todelet);
	}
	
	//api pour la recuperation du directeur genrale par id
	@GetMapping("/{idDirecteurG}")
	public ResponseEntity<directeurG> getDirecteurD(@PathVariable("idDirecteurG")Long idD){
		directeurG de=directeurgservice.getDGByid(idD);
		return ResponseEntity.ok().body(de);
	}
	
	
}
