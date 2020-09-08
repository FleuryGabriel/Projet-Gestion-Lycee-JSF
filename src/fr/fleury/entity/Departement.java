package fr.fleury.entity;

import java.util.List;

public class Departement {

	// Attributs

	private int id;
	private String nom;


	// Constructeur

	public Departement() {
		super();
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public Departement(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Departement(int id) {
		super();
		this.id = id;
	}

	// Getters et setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	


	
}
