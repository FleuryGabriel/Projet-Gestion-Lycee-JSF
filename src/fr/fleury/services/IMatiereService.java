package fr.fleury.services;

import fr.fleury.entity.Matiere;

public interface IMatiereService {
	
	public int addMatiere(Matiere mIn);
	
	public int delMatiere(int mId);
	
	public int modMatiere(Matiere mIn);

}
