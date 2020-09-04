package fr.fleury.services;

import fr.fleury.entity.Departement;

public interface IDepartementService {
	
	public int addDepartement(Departement dIn);
	
	public int delDepartement(int dId);
	
	public int modDepartement(Departement dIn);

}
