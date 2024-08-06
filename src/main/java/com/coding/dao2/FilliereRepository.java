package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.filliere;



@Repository
public interface FilliereRepository extends JpaRepository<filliere,Long> {
long count();
}
