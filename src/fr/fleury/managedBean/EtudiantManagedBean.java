package fr.fleury.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.fleury.entity.Etudiant;
import fr.fleury.services.EtudiantServiceImpl;
import fr.fleury.services.IEtudiantService;

@ManagedBean(name = "eMB")
@RequestScoped
public class EtudiantManagedBean implements Serializable{
	
	//Attributs
	
	private Etudiant etudiant;
	
	//Traduction de l'association UML en JAVA
	
	IEtudiantService eService = new EtudiantServiceImpl();

	
	//Constructeur
	
	public EtudiantManagedBean() {
		this.etudiant = new Etudiant();
	}


	//Getter et setters
	
	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	//Méthodes
	
	
	
	

}
