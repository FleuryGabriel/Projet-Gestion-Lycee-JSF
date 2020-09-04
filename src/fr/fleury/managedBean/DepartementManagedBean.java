package fr.fleury.managedBean;

import java.io.Serializable;

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

	//UML vers JAVA
	
	private IDepartementService dService = new DepartementServiceImpl();
	
	//Constructeur
	public DepartementManagedBean() {
		this.departement=new Departement();
	}


	//Getter et setter
	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	

}
