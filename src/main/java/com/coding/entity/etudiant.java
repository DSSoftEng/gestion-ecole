package com.coding.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class etudiant extends User {
    
    @ManyToOne
    private filliere filliere;

    public etudiant() {}

    public filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(filliere filliere) {
        this.filliere = filliere;
    }
}
