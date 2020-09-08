package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Professeur;
import fr.fleury.services.IProfesseurService;
import fr.fleury.services.ProfesseurServiceImpl;

@ManagedBean(name = "pMB")
@RequestScoped
public class ProfesseurManagedBean implements Serializable{
	
	//Attributs
	
	private Professeur professeur;
	private List<Professeur> professeurs;
	private boolean affichage;
	
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


	public boolean isAffichage() {
		return affichage;
	}


	public void setAffichage(boolean affichage) {
		this.affichage = affichage;
	}
	
	//Méthodes
	
	public String rechercher() {
		Professeur pOut = pService.getProfesseurById(professeur.getId());
		
		if(pOut.getNom()!=null) {
			this.professeur=pOut;
			this.affichage=true;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Identifiant inconnu"));
		}
		
		return "recherche";
	}
	
	public String supprimer() {
		int verif = pService.delProfesseur(this.professeur.getId());
		
		if(verif==1) {
			this.professeurs=pService.getallProfesseurs();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de suppression"));
			this.professeurs=pService.getallProfesseurs();
		}
		
		return "accueil";
	}
	
	public String ajouter() {
		int verif = pService.addProfesseur(this.professeur);
		
		if(verif==1) {
			this.professeurs=pService.getallProfesseurs();
			return "accueil";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur lors de l'ajout"));
			return "ajout";
		}
	}
	
	public String modifier() {
		int verif = pService.modProfesseur(professeur);
		
		if(verif==1) {
			this.professeurs=pService.getallProfesseurs();
			return "accueil";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur lors de la modification"));
			return "modif";
		}
	}
	
	public String redirectModif() {
		return "modif";
	}
	
	
	

}
