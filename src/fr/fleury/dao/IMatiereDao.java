package fr.fleury.dao;

import java.util.List;

import fr.fleury.entity.Matiere;

public interface IMatiereDao {
	
	public int addMatiere(Matiere mIn);
	
	public int delMatiere(int mId);
	
	public int modMatiere(Matiere mIn);
	
	public List<Matiere> getAllMatiere();
	
	public Matiere getMatiereById(int mId);

}
