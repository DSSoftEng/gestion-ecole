package com.coding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dao2.EtudiantRepository;
import com.coding.dao2.FilliereRepository;
import com.coding.entity.etudiant;
import com.coding.entity.filliere;

@Service
public class EtudiantService {
	   @Autowired
	    private EtudiantRepository etudiantRepository;
	  
	   @Autowired
	    private FilliereRepository filliereRepository; // Ajoutez le repository de filliere

	    @Autowired
	    private FilliereService filliereService;
	   
	   //creation etudiant avec l'affectation de sa filliere
	    public etudiant createEtudiant(etudiant etudiant, Long filliereId) {
	        // Recherche de la filliere par son ID
	        filliere filliere = filliereRepository.findById(filliereId)
	            .orElseThrow(() -> new IllegalArgumentException("Filliere non trouvée pour l'ID: " + filliereId));

	        // Définir la filliere pour l'étudiant
	        etudiant.setFilliere(filliere);

	        // Enregistrer l'étudiant avec la filliere associée
	        return etudiantRepository.save(etudiant);
	    }
	    // le nbre total des etudiant
	    
	    public long nbreTotalEtudiant() {
	    	return etudiantRepository.count();
	    }
	    
	    
	    
	    
	    //recuperation de la liste des etudiants
	    
	    public List<etudiant> getAllListStudent(){
	    	List<etudiant> newListStudents=etudiantRepository.findAll();
			return newListStudents;
	    			
	    }
	    
	  
	 // Récupérer un étudiant par ID
	    public etudiant getStudent(Long studentId) {
	        if (studentId == null) {
	            throw new IllegalArgumentException("ID de l'étudiant ne doit pas être null");
	        }
	        return etudiantRepository.findById(studentId).orElse(null);
	    }
	   
	   //suppression dun etudiant recherche element puis supprimer element
	    
	    public etudiant deleteStudent(Long studentId) {
	    	 etudiant e=etudiantRepository.findById(studentId).orElse(null);
	    	 
	    	 if(e!=null) {
	    		 etudiantRepository.delete(e);
	    	 }
	    	 return e;
	    }
	    
	    
	 // Méthode de mise à jour d'un étudiant
	    public etudiant updateEtudiant(Long id, etudiant updatedEtudiant, Long filliereId) {
	        Optional<etudiant> optionalEtudiant = etudiantRepository.findById(id);
	        if (optionalEtudiant.isPresent()) {
	            etudiant etudiant = optionalEtudiant.get();

	            // Récupérer et associer la filière
	            filliere filliere = filliereService.getFilliereById(filliereId);
	            etudiant.setFilliere(filliere);

	            // Mettez à jour les autres champs de l'étudiant ici
	            etudiant.setAge(updatedEtudiant.getAge());
	            etudiant.setEmail(updatedEtudiant.getEmail());
	            etudiant.setImg(updatedEtudiant.getImg());
	            etudiant.setNom(updatedEtudiant.getNom());
	            etudiant.setPassword(updatedEtudiant.getPassword());
	            etudiant.setPrenom(updatedEtudiant.getPrenom());
	            etudiant.setSexe(updatedEtudiant.getSexe());
	            etudiant.setTelephone(updatedEtudiant.getTelephone());
	            etudiant.setUsername(updatedEtudiant.getUsername());

	            return etudiantRepository.save(etudiant);
	        } else {
	            throw new IllegalArgumentException("Student not found with id " + id);
	        }
	    }
	    
	    
	    //recuperation de la liste des etudiants  par filliere
	    public List<etudiant> getAllStudentsByFilliere(Long filliereId){
	    	List<etudiant> StudentsByFlliere=etudiantRepository.findByFilliere_IdFil(filliereId);
	    	return StudentsByFlliere;
	    }
		

	}
	
	  

