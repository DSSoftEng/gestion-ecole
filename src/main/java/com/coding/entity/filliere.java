package com.coding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class filliere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFil;

    private String nameFilliere;
    public filliere() {
    }
	public Long getIdFil() {
		return idFil;
	}
	public void setIdFil(Long idFil) {
		this.idFil = idFil;
	}
	public String getNameFilliere() {
		return nameFilliere;
	}
	public void setNameFilliere(String nameFilliere) {
		this.nameFilliere = nameFilliere;
	}

}
