package com.examen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;



@Entity(name="utilisateur")
@Table(name="utilisateur")
public class Utilisateur {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    
   
    @NotNull(message="Veuillez saisir un login !")
    @Column(name = "login", nullable = false, length=255)
	private String login;
    
    @NotNull(message="Veuillez saisir un nom !")
    @Column(name = "nom", nullable = false, length=255)
	private String nom;
	
  
    @NotNull(message="Veuillez saisir un prenom !")
    @Column(name = "prenom", nullable = false, length=255)
	private String prenom;
	
    @NotNull(message="Veuillez saisir un mot de passe !")
    @Column(name = "password", nullable = false, length=255)
	private String password;
	/**
	 * @param id
	 * @param login
	 * @param nom
	 * @param prenom
	 * @param password
	 */
	public Utilisateur(int id, String login, String nom, String prenom, String password) {
		super();
		this.id = id;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
	
	public Utilisateur(String login, String nom, String prenom, String password) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}
	
	public Utilisateur() {
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
