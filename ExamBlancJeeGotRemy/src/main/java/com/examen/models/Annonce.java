package com.examen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Entity(name="annonce")
@Table(name="annonce")
public class Annonce {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @Length(max = 255, message="Le poste peut contenir au maximum 255 caractères !")
    @Column(name = "image_link", nullable = true, length=255)
	private String image_link;
	
    @Length(max = 255, message="Le contenu peut contenir au maximum 255 caractères !")
    @NotBlank(message="Veuillez saisir un contenu !")
    @Column(name = "contenu", nullable = false, length=255)
	private String contenu;
	
    @Length(max = 255, message="Le titre peut contenir au maximum 255 caractères !")
    @NotBlank(message="Veuillez saisir un titre !")
    @Column(name = "titre", nullable = false, length=255)
	private String titre;
	
    @ManyToOne(optional=false)
    @JoinColumn(name="utilisateur_id", referencedColumnName = "id")
	private Utilisateur utilisateur;
	
	/**
	 * @param id
	 * @param image_link
	 * @param contenu
	 * @param titre
	 * @param utilisateur
	 */
	public Annonce(int id, String image_link, String contenu, String titre, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.image_link = image_link;
		this.contenu = contenu;
		this.titre = titre;
		this.utilisateur = utilisateur;
	}

	public Annonce(String image_link, String contenu, String titre, Utilisateur utilisateur) {
		super();
		this.image_link = image_link;
		this.contenu = contenu;
		this.titre = titre;
		this.utilisateur = utilisateur;
	}
	
	public Annonce() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
