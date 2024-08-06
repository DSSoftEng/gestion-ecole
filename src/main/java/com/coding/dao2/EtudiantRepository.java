package com.coding.dao2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<etudiant, Long>{
	List<etudiant> findByFilliere_IdFil(Long idFilliere);
	long count();
}
