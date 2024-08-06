package com.coding.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String username;
	private String password;

    private String img;
	private long age;
	private String email;
    private String telephone;
    private String sexe;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		    name = "user_role",
		    joinColumns = @JoinColumn(name = "user_id"),
		    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
   public User() {}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public long getAge() {
	return age;
}
public void setAge(long age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
public User(Long id, String nom, String prenom, String username, String password, String img, long age, String email,
		String telephone, String sexe, List<Role> roles) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.username = username;
	this.password = password;
	this.img = img;
	this.age = age;
	this.email = email;
	this.telephone = telephone;
	this.sexe = sexe;
	this.roles = roles;
}
	
	

}
