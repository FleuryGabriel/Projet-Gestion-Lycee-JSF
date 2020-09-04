package fr.fleury.services;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Matiere;
import fr.fleury.entity.Professeur;

public interface IProfesseurService {

	public int addProfesseur(Professeur pIn);
	
	public int delProfesseur(int pId);
	
	public int modProfesseur(Professeur pIn);
	
	public int affecterDeptProfesseur(Professeur pIn, Departement dIn);
	
	public int affecterMatProfesseur(Professeur pIn, Matiere mIn);
	
}
