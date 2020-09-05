package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.fleury.entity.Departement;
import fr.fleury.services.DepartementServiceImpl;
import fr.fleury.services.IDepartementService;

@ManagedBean(name = "dMB")
@RequestScoped
public class DepartementManagedBean implements Serializable{
	
	//Attribut
	
	private Departement departement;
	private List<Departement> departements;

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
	
	

}
