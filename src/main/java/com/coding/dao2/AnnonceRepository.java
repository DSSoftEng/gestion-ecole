package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.annonce;


@Repository
public interface AnnonceRepository extends JpaRepository<annonce,Long> {

}
