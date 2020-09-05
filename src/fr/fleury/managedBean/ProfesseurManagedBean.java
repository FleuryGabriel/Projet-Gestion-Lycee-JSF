package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.fleury.entity.Professeur;
import fr.fleury.services.IProfesseurService;
import fr.fleury.services.ProfesseurServiceImpl;

@ManagedBean(name = "pMB")
@RequestScoped
public class ProfesseurManagedBean implements Serializable{
	
	//Attributs
	
	private Professeur professeur;
	private List<Professeur> professeurs;
	
	//UML vers Java
	
	private IProfesseurService pService = new ProfesseurServiceImpl();

	
	//Constructeur
	public ProfesseurManagedBean() {
		this.professeur=new Professeur();
		this.professeurs=pService.getallProfesseurs();
	}

	
	//Getter et setter

	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public List<Professeur> getProfesseurs() {
		return professeurs;
	}


	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}
	
	
	
	

}
