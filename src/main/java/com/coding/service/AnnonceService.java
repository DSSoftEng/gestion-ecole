package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.dao2.AnnonceRepository;
import com.coding.entity.annonce;

@Service
public class AnnonceService {
	@Autowired
	AnnonceRepository annoncerepository;
	@Autowired
	DirecteurGService directeurservice;
	
	 // Creation d'une annonce
    public annonce creatAnnonce(annonce anc) {
        annonce an = annoncerepository.save(anc);
        return an;
    }
    // recuperation de la liste des annonces
    
    public List<annonce> getAllAnnone(){
    	 List<annonce>listeAn=annoncerepository.findAll();
		return listeAn;
    }
    
    public annonce getAnnonceById(Long idAnn) {
    	annonce ann=new annonce();
    	ann=annoncerepository.findById(idAnn).orElse(null);
    	return ann;
    }
    
    //supprimer une annonce
    public annonce deletAnnonce(Long idAnonce) {
    	annonce an=annoncerepository.findById(idAnonce).orElse(null);
    	if(an!=null) {
    		annoncerepository.delete(an);
    	}
    	return an;
    }
    
    // modification d'une annonce
    public annonce updateAnnonce(Long idOld,annonce an) {
    	annonce anj=annoncerepository.findById(idOld).orElse(null);
    	if(anj!=null) {
    		anj.setDateEvent(an.getDateEvent());
    		anj.setDescription(an.getDescription());
    		anj.setTitre(an.getTitre());
    		anj.setImage(an.getImage());
    	}
    	return annoncerepository.save(anj);
    }
}
