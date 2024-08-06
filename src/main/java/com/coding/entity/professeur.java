package com.coding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class professeur extends User {
	
	public professeur() {}
 @ManyToOne
  private filliere filliere;

 public filliere getFilliere() {
     return filliere;
 }

 public void setFilliere(filliere filliere) {
     this.filliere = filliere;
 }
}
