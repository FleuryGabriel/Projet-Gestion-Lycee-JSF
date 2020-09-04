package fr.fleury.entity;

import java.util.List;

public class Matiere {
	
	//Attribut
	
	private int id;
	private String nom;
	

	//Constructeurs
	public Matiere() {
		super();
	}

	public Matiere(String nom) {
		super();
		this.nom = nom;
	}

	public Matiere(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Matiere(int id) {
		super();
		this.id = id;
	}

	
	//Getters et setters
	
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


	//toString
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
