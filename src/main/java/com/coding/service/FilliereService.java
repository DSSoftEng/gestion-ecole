package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dao2.FilliereRepository;
import com.coding.entity.filliere;


@Service
public class FilliereService {

	@Autowired
    private FilliereRepository filliereRepository;
	
	// recuperer la liste des fillieres
	 public List<filliere> getAllFillieres() {
	        return filliereRepository.findAll();
	    }

	 
	 //recuperer une seule filliere par id
	    public filliere getFilliereById(Long id) {
	        return filliereRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Filliere not found with id " + id));
	    }
  // le nbre total des fillieres
	    public long nbreTotalFilliere() {
	    	return filliereRepository.count();
	    }
	    
	    
}
