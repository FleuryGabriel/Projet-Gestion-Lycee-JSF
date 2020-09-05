package fr.fleury.dao;

import java.util.List;

import fr.fleury.entity.Departement;

public interface IDepartementDao {

	public int addDepartement(Departement dIn);
	
	public int delDepartement(int dId);
	
	public int modDepartement(Departement dIn);
	
	public List<Departement> getAllDepartement();
	
	public Departement findDepartementById(int dId);
	
	
	
}
