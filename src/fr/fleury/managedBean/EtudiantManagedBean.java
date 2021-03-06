package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.fleury.entity.Etudiant;
import fr.fleury.services.EtudiantServiceImpl;
import fr.fleury.services.IEtudiantService;

@ManagedBean(name = "eMB")
@RequestScoped
public class EtudiantManagedBean implements Serializable{
	
	//Attributs
	
	private Etudiant etudiant;
	private List<Etudiant> etudiants;
	private boolean affichageEt = false;
	
	//Traduction de l'association UML en JAVA
	
	IEtudiantService eService = new EtudiantServiceImpl();

	
	//Constructeur
	
	public EtudiantManagedBean() {
		this.etudiant = new Etudiant();
		this.etudiants = eService.getAllEtudiant();
	}


	//Getter et setters
	
	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public boolean isAffichageEt() {
		return affichageEt;
	}


	public void setAffichageEt(boolean affichageEt) {
		this.affichageEt = affichageEt;
	}

	//M�thodes



	public String rechRef() {
		Etudiant eOut = eService.getEtudiantById(etudiant.getId());
		
		if(eOut.getNom()!=null) {
			this.etudiant=eOut;
			this.affichageEt=true;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Identifiant inconnu"));
		}
		
		return "recherche";
	}
	
	public String suprEt() {
		int verif = eService.delEtudiant(this.etudiant.getId());
		
		if(verif==1) {
			this.etudiants=eService.getAllEtudiant();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur de suppression"));
			this.etudiants=eService.getAllEtudiant();
		}
		
		return "accueil";
	}
	
	public String ajouter() {
		int verif = eService.addEtudiant(this.etudiant);
		
		if(verif==1) {
			this.etudiants=eService.getAllEtudiant();
			return "accueil";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur lors de l'ajout"));
			return "ajout";
		}
	}
	
	public String modifier() {
		int verif = eService.modEtudiant(etudiant);
		
		if(verif==1) {
			this.etudiants=eService.getAllEtudiant();
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
