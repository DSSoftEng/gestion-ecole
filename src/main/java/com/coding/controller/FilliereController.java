package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.entity.filliere;
import com.coding.service.FilliereService;

@RestController
@RequestMapping("/api/filliere")

@CrossOrigin(origins = "http://localhost:3000")
public class FilliereController {
    
    @Autowired
    private FilliereService filliereService;

    // Récupérer la liste des filières
    @GetMapping("/listFilliere")
    public ResponseEntity<List<filliere>> getAllFilliere(){
        List<filliere> liste = filliereService.getAllFillieres();
        return ResponseEntity.ok().body(liste);
    }
    
    
 // nbre total des fillieres
    @GetMapping("/totalFilliere")
    public ResponseEntity<Long> getNbreTotalFilliere() {
        Long count = filliereService.nbreTotalFilliere();
        return ResponseEntity.ok(count);
    }
	
}
