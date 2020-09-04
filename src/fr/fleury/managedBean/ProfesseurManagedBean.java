package fr.fleury.managedBean;

import java.io.Serializable;

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
	
	//UML vers Java
	
	private IProfesseurService pService = new ProfesseurServiceImpl();

	
	//Constructeur
	public ProfesseurManagedBean() {
		this.professeur=new Professeur();
	}

	
	//Getter et setter

	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	
	
	
	

}
