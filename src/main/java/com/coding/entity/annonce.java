package com.coding.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAn;
    private String titre;
    private String description;
    private String image;
    private Date dateEvent;
  /*  @ManyToOne

    directeurG directeurG;
     public directeurG getDirecteurG() {
		return directeurG;
	}

	public void setDirecteurG(directeurG directeurG) {
		this.directeurG = directeurG;
	}
    */
    public annonce() {
    }

    

    public annonce(Long idAn, String titre, String description, String image, Date dateEvent) {
		super();
		this.idAn = idAn;
		this.titre = titre;
		this.description = description;
		this.image = image;
		this.dateEvent = dateEvent;
	}



	public Long getIdAn() {
        return idAn;
    }

   

	public void setIdAn(Long idAn) {
		this.idAn = idAn;
	}

	

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }
}
