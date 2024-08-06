package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coding.entity.Personne;

public interface PersonneDao extends JpaRepository<Personne, Integer> {

	
	/*public Personne findByNomAndPrenom(String nom);
	
	@Query("select p from Personne p where p.nom=:n")
	public Personne chercherParNom(@Param("n") String nom);*/
	
	
	
}
