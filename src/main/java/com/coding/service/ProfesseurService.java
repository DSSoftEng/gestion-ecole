package com.coding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PathVariable;

import com.coding.dao2.FilliereRepository;
import com.coding.dao2.ProfessseurRepository;
import com.coding.entity.filliere;
import com.coding.entity.professeur;

@Service
public class ProfesseurService {
	
	  @Autowired
	  ProfessseurRepository profrepository;
	  @Autowired
	    private FilliereService filliereService;
	  // ajout dun professeur dans la bdd
	  @Autowired
	    private FilliereRepository filliereRepository; 
	  
	  public professeur creatProf (professeur prof,Long filliereId) {
		  

	        // Recherche de la filliere par son ID
	        filliere filliere = filliereRepository.findById(filliereId)
	            .orElseThrow(() -> new IllegalArgumentException("Filliere non trouvée pour l'ID: " + filliereId));
	        
	        prof.setFilliere(filliere);
		   return profrepository.save(prof);
	  }
	  
	  //la liste des profs
	  
	  public  List<professeur> getALLProfs(){
		  
		  return profrepository.findAll();
	  }
	  // totale des prof
	  public long nbreTotalProfesseur() {
	    	return profrepository.count();
	    }
	    
	  
	  //la liste des profs par filliere
	  
	  public List<professeur> getAllProfsByFilliere(Long idFilliere){
		  List<professeur> profsByFil=profrepository.findByFilliere_IdFil(idFilliere);
		return  profsByFil;
		  
		  
	  }
	  //supprimer un profeseur 
	  public professeur deleteProf(Long proftId) {
	    	 professeur p=profrepository.findById(proftId).orElse(null);
	    	 
	    	 if(p!=null) {
	    		 profrepository.delete(p);
	    	 }
	    	 return p;
	    }
	 // modification d'un seul professeur 
	  public professeur updateProf(Long idOldProf,professeur newProf ,Long idFilliere) {
		  professeur prof=profrepository.findById(idOldProf).orElse(null);
		  filliere filliere=filliereRepository.findById(idFilliere).orElse(null);
		  prof.setFilliere(filliere);
		  prof.setNom(newProf.getNom());
		  prof.setAge(newProf.getAge());
		  prof.setEmail(newProf.getEmail());
		  prof.setImg(newProf.getImg());
		  prof.setPrenom(newProf.getPrenom());
		  prof.setPassword(newProf.getPassword());
		  prof.setSexe(newProf.getSexe());
		  prof.setTelephone(newProf.getTelephone());
		  prof.setUsername(newProf.getUsername());
		  return profrepository.save(prof);
	  }
	  
	  //recuperation d'un seul professeur par id
	  
	  public professeur getProfBYId(Long idProf) {
	        try {
	            Optional<professeur> profOptional = profrepository.findById(idProf);
	            if (profOptional.isPresent()) {
	                return profOptional.get();
	            } else {
	                throw new EntityNotFoundException("Professeur not found with ID " + idProf);
	            }
	        } catch (Exception e) {
	            // Log the exception
	            e.printStackTrace();
	            throw new RuntimeException("Error retrieving professeur with ID " + idProf, e);
	        }
	    }

}
