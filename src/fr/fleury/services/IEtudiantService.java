package fr.fleury.services;

import java.util.List;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Etudiant;

public interface IEtudiantService {
	
	public int addEtudiant(Etudiant eIn);
	
	public int delEtudiant(int eId);
	
	public int modEtudiant(Etudiant eIn);
	
	public int affDeptEtudiant(Etudiant eIn, Departement dIn);
	
	public List<Etudiant> getAllEtudiant();
	
	public Etudiant getEtudiantById(int eId);

}
