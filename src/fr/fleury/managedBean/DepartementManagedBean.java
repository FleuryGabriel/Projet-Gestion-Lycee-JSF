package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Etudiant;
import fr.fleury.services.DepartementServiceImpl;
import fr.fleury.services.IDepartementService;

@ManagedBean(name = "dMB")
@RequestScoped
public class DepartementManagedBean implements Serializable{
	
	//Attribut
	
	private Departement departement;
	private List<Departement> departements;
	private boolean affichage;

	//UML vers JAVA
	
	private IDepartementService dService = new DepartementServiceImpl();
	
	//Constructeur
	public DepartementManagedBean() {
		this.departement=new Departement();
		this.departements=dService.getallDepartements();
	}


	//Getter et setter
	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public List<Departement> getDepartements() {
		return departements;
	}


	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	public boolean isAffichage() {
		return affichage;
	}


	public void setAffichage(boolean affichage) {
		this.affichage = affichage;
	}

	
	
	//Méthodes


	public String rechercher() {
		Departement dOut = dService.getDepartementById(departement.getId());
		
		if(dOut.getNom()!=null) {
			this.departement=dOut;
			this.affichage=true;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Identifiant inconnu"));
		}
		
		return "recherche";
	}
	
	public String supprimer() {
		int verif = dService.delDepartement(this.departement.getId());
		
		if(verif==1) {
			this.departements=dService.getallDepartements();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de suppression"));
			this.departements=dService.getallDepartements();
		}
		
		return "accueil";
	}
	
	public String ajouter() {
		int verif = dService.addDepartement(this.departement);
		
		if(verif==1) {
			this.departements=dService.getallDepartements();
			return "accueil";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur lors de l'ajout"));
			return "ajout";
		}
	}
	
	public String modifier() {
		int verif = dService.modDepartement(departement);
		
		if(verif==1) {
			this.departements=dService.getallDepartements();
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
