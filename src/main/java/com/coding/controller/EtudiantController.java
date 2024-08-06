package com.coding.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.entity.etudiant;
import com.coding.service.EtudiantService;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "http://localhost:3000")
public class EtudiantController {

	@Autowired
	EtudiantService etudiantService;
	
	//api de creation dun etudiant
	// Exemple dans votre Controller ou API
	@PostMapping("/addStudent")
	public ResponseEntity<etudiant> createEtudiant(@RequestBody etudiant etudiant, @RequestParam Long filliereId) {
	    etudiant newEtudiant = etudiantService.createEtudiant(etudiant, filliereId);
	    return ResponseEntity.ok().body(newEtudiant);
	}

	
	//api recuperation de la liste des etudiants 
	@GetMapping("/listStudents")
	public ResponseEntity<List<etudiant>> getAllStudents() {
	    List <etudiant> newEtudiantList = etudiantService.getAllListStudent();
	    return ResponseEntity.ok().body(newEtudiantList);
	}
	
	
	//api recuperation d'un seul etudiant
	@GetMapping("/{idStudent}")
	public ResponseEntity<etudiant> getAllStudents(@PathVariable("idStudent") Long id) {
		if (id ==null) {
            return ResponseEntity.badRequest().build(); // Retourner une réponse BadRequest si l'ID est null
        }
	    etudiant newEtudiant = etudiantService.getStudent(id);
	    
	    if ( newEtudiant == null) {
            return ResponseEntity.notFound().build();
        }
	    return ResponseEntity.ok().body(newEtudiant);
	}
	
	
	//suppression dun etudiant  return objet supprimer
	@DeleteMapping("/{idStudent}")
	public ResponseEntity<etudiant> deletStudent( @PathVariable("idStudent")Long id){
		
		etudiant deletedEtudiant=etudiantService.deleteStudent(id);
		if (id == null) {
            return ResponseEntity.badRequest().build(); // Retourner une réponse BadRequest si l'ID est null
        }
		if(deletedEtudiant==null) {
			return ResponseEntity.notFound().build();
			
		}
		 return ResponseEntity.ok().body(deletedEtudiant);
	}
	
	// nbre total des etudiant
	@GetMapping("/totalEtudiant")
	public  ResponseEntity<Long> getNbreTotalEtudiant() {
		long count = etudiantService.nbreTotalEtudiant();
        return ResponseEntity.ok(count);
	}
	
	
	
	  // API de mise à jour d'un étudiant
    @PutMapping("/updateStudent/{idstudent}")
    public ResponseEntity<etudiant> updateEtudiant(@PathVariable("idstudent") Long id, @RequestBody etudiant updatedEtudiant, @RequestParam("filliereId") Long filliereId) {
        try {
            etudiant etudiant = etudiantService.updateEtudiant(id, updatedEtudiant, filliereId);
            return ResponseEntity.ok().body(etudiant);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Si l'étudiant ou la filière n'est pas trouvé
        }
    }
	
	
	
	//Api recuperation de la liste des etudiants  par filliere
	
    @GetMapping("/listStudentsByfilliere/{idfilliere}")
	public ResponseEntity<List<etudiant>> getAllStudentsByFilliere(@PathVariable("idfilliere") Long id) {
	    List <etudiant> newEtudiantListByFilliere = etudiantService.getAllStudentsByFilliere(id);
	    return ResponseEntity.ok().body(newEtudiantListByFilliere);
	}
	

}
