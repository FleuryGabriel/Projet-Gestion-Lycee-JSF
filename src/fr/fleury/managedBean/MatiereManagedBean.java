package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Matiere;
import fr.fleury.services.IMatiereService;
import fr.fleury.services.MatiereServiceImpl;

@ManagedBean(name = "mMB")
@RequestScoped
public class MatiereManagedBean implements Serializable{
	
	//Attributs
	
	private Matiere matiere;
	private List<Matiere> matieres;
	private boolean affichage;
	
	//UML vers Java
	
	private IMatiereService mService = new MatiereServiceImpl();

	//Constructeur
	public MatiereManagedBean() {
		this.matiere=new Matiere();
		this.matieres=mService.getallMatieres();

	}

	//Getter et setter
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public boolean isAffichage() {
		return affichage;
	}

	public void setAffichage(boolean affichage) {
		this.affichage = affichage;
	}
	
	//Méthodes
	
	public String rechercher() {
		Matiere mOut = mService.getMatiereById(matiere.getId());
		
		if(mOut.getNom()!=null) {
			this.matiere=mOut;
			this.affichage=true;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Identifiant inconnu"));
		}
		
		return "recherche";
	}
	
	public String supprimer() {
		int verif = mService.delMatiere(this.matiere.getId());
		
		if(verif==1) {
			this.matieres=mService.getallMatieres();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de suppression"));
			this.matieres=mService.getallMatieres();
		}
		
		return "accueil";
	}
	
	public String ajouter() {
		int verif = mService.addMatiere(this.matiere);
		
		if(verif==1) {
			this.matieres=mService.getallMatieres();
			return "accueil";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur lors de l'ajout"));
			return "ajout";
		}
	}
	
	public String modifier() {
		int verif = mService.modMatiere(matiere);
		
		if(verif==1) {
			this.matieres=mService.getallMatieres();
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
