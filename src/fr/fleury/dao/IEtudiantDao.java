package fr.fleury.dao;

import java.util.List;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Etudiant;

public interface IEtudiantDao {

	public int addEtudiant(Etudiant eIn);
	
	public int delEtudiant(int eId);
	
	public int modEtudiant(Etudiant eIn);
	
	public int affecterdeptEtudiant(Etudiant eIn, Departement dIn);
	
	public List<Etudiant> getAllEtudiant();
	
	public Etudiant getEtudiantById(int eId);
	
}
