package fr.fleury.managedBean;

import java.io.Serializable;
import java.util.List;

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
	private List<Matiere> matieres;
	
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
	
	

}
