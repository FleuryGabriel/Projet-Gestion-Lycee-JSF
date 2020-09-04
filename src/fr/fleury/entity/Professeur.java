package fr.fleury.entity;

import java.sql.Date;

public class Professeur {
	
	//Attributs
	private int id;
	private String nom;
	private String prenom;
	private Date date_aff;
	
	private Matiere matiere;
	private Departement departement;
	
	
	//Constructeurs
	
	public Professeur() {
		super();
	}
	public Professeur(String nom, String prenom, Date date_aff) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_aff = date_aff;
	}
	public Professeur(int id, String nom, String prenom, Date date_aff) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_aff = date_aff;
	}
	
	//Getter et setters
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_aff() {
		return date_aff;
	}
	public void setDate_aff(Date date_aff) {
		this.date_aff = date_aff;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	@Override
	public String toString() {
		
		if(departement.getNom()!=null && matiere.getNom()!=null) {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_aff=" + date_aff + ", matiere="
				+ matiere + ", departement=" + departement.getNom() + "]";
		}else {
			return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_aff=" + date_aff + "]";
		}
	}
	

	
	
	
}
