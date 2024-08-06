package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.entity.etudiant;
import com.coding.entity.professeur;
import com.coding.service.ProfesseurService;

import org.springframework.web.bind.annotation.PathVariable;


import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/api/professeurs")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesseurController {

	
	@Autowired
		ProfesseurService professeurservice;
	
	// api pour la creation dun professeur 
	@PostMapping("/addProf")
	public ResponseEntity<professeur> creatProf(@RequestBody  professeur prof,@RequestParam Long idFilliere) {
		professeur newprof=professeurservice.creatProf(prof,  idFilliere);
		return ResponseEntity.ok().body(newprof);
	}
	
	//api recuperation de la liste des professeurs
	@GetMapping("/listProfs")
	public  ResponseEntity<List<professeur>> getALLProfs(){
	 List <professeur>	Listprof=professeurservice.getALLProfs();
		return ResponseEntity.ok().body(Listprof);
	}

	// nbre total des professeurs
    @GetMapping("/totalProfesseur")
    public ResponseEntity<Long> getNbreTotalProfesseur() {
        Long count = professeurservice.nbreTotalProfesseur();
        return ResponseEntity.ok(count);
    }
	
	
	
	
	
	
	//api recuperation de la liste des profs par filliere

    @GetMapping("/listProfsByfilliere/{idfilliere}")
	public ResponseEntity<List<professeur>>  getAllProfsByFilliere(@PathVariable("idfilliere") Long idFilliere){
		 List<professeur> listProfByFil=professeurservice.getAllProfsByFilliere(idFilliere);
		 return ResponseEntity.ok().body(listProfByFil);
	}

    //api pour supprimer un professeur 
    @DeleteMapping("/{idProf}")
	public ResponseEntity<professeur> deletStudent( @PathVariable("idProf")Long id){
		
		professeur deletedProf=professeurservice.deleteProf(id);
		if (id == null) {
            return ResponseEntity.badRequest().build(); // Retourner une réponse BadRequest si l'ID est null
        }
		if(deletedProf==null) {
			return ResponseEntity.notFound().build();
			
		}
		 return ResponseEntity.ok().body(deletedProf);
	}
	
	// API recuperation d'un prof


    @GetMapping("/{idProf}")
    public ResponseEntity<?> getProfById(@PathVariable("idProf") Long idProf) {
        try {
            professeur prof = professeurservice.getProfBYId(idProf);
            return ResponseEntity.ok().body(prof);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    // api de modification d'un professeur
    
	  // API de mise à jour d'un étudiant
    @PutMapping("/updateProf/{idprof}")
    public ResponseEntity<professeur> updateEtudiant(@PathVariable("idprof") Long id, @RequestBody professeur updatedProf, @RequestParam("filliereId") Long filliereId) {
        try {
        	professeur professeur = professeurservice.updateProf(id, updatedProf , filliereId);
            return ResponseEntity.ok().body(professeur);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Si l professeur  ou la filière n'est pas trouvé
        }
    }
	
  

    
}