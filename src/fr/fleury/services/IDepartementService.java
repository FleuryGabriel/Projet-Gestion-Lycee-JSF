package fr.fleury.services;

import java.util.List;

import fr.fleury.entity.Departement;

public interface IDepartementService {
	
	public int addDepartement(Departement dIn);
	
	public int delDepartement(int dId);
	
	public int modDepartement(Departement dIn);
	
	public List<Departement> getallDepartements();
	
	public Departement getDepartementById(int dId);

}
