package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.directeurE;

@Repository
public interface DirecteurERepository extends JpaRepository<directeurE,Long> {

}
