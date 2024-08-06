package com.coding.dao2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.professeur;

@Repository
public interface ProfessseurRepository extends JpaRepository<professeur ,Long> {
	List<professeur> findByFilliere_IdFil(Long idFilliere);
	long count();
}
