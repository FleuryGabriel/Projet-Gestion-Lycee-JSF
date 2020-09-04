package fr.fleury.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.fleury.entity.Matiere;
import fr.fleury.services.IMatiereService;
import fr.fleury.services.MatiereServiceImpl;

@ManagedBean(name = "mMB")
@RequestScoped
public class MatiereManagedBean implements Serializable{
	
	//Attributs
	
	private Matiere matiere;
	
	//UML vers Java
	
	private IMatiereService mService = new MatiereServiceImpl();

	//Constructeur
	public MatiereManagedBean() {
		this.matiere=new Matiere();
	}

	//Getter et setter
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	
	

}
