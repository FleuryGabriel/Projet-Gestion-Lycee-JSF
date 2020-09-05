package fr.fleury.services;

import java.util.List;

import fr.fleury.entity.Matiere;

public interface IMatiereService {
	
	public int addMatiere(Matiere mIn);
	
	public int delMatiere(int mId);
	
	public int modMatiere(Matiere mIn);
	
	public List<Matiere> getallMatieres();
	
	public Matiere getMatiereById(int mId);

}
