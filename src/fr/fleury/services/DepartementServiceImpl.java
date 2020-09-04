package fr.fleury.services;

import fr.fleury.dao.DepartementDaoImpl;
import fr.fleury.dao.IDepartementDao;
import fr.fleury.entity.Departement;

public class DepartementServiceImpl implements IDepartementService{
	
	IDepartementDao dDao = new DepartementDaoImpl();

	@Override
	public int addDepartement(Departement dIn) {
		return dDao.addDepartement(dIn);
	}

	@Override
	public int delDepartement(int dId) {
		return dDao.delDepartement(dId);
	}

	@Override
	public int modDepartement(Departement dIn) {
		return dDao.modDepartement(dIn);
	}
	
	

}
