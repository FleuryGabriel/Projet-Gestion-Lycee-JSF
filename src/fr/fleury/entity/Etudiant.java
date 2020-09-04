package fr.fleury.entity;

public class Etudiant {
	
	//Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private Departement departement;
	
	
	//Constructeurs
	
	public Etudiant() {
		super();
	}

	public Etudiant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Etudiant(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	//toString
	@Override
	public String toString() {
		
		if(departement.getNom() != null) {
			return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", département=" + departement.getNom() + "]";
		}else {
			return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom+ "]";
		}
		
		
	}

	

}
