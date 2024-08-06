package com.coding.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class directeurG  extends User{
	public directeurG() {}
	@OneToMany
	List<annonce> annonces;

	public List<annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(List<annonce> annonces) {
		this.annonces = annonces;
	}

}
