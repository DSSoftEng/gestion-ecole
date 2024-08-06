package com.coding.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.entity.directeurG;

@Repository
public interface DirecteurGRepository  extends JpaRepository<directeurG,Long>  {

}
