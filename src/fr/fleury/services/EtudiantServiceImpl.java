package fr.fleury.services;

import fr.fleury.dao.EtudiantDaoImpl;
import fr.fleury.dao.IEtudiantDao;
import fr.fleury.entity.Departement;
import fr.fleury.entity.Etudiant;

public class EtudiantServiceImpl implements IEtudiantService{
	
	IEtudiantDao eDao = new EtudiantDaoImpl();
	

	@Override
	public int addEtudiant(Etudiant eIn) {
		return eDao.addEtudiant(eIn);
	}

	@Override
	public int delEtudiant(int eId) {
		return eDao.delEtudiant(eId);
	}

	@Override
	public int modEtudiant(Etudiant eIn) {
		return eDao.modEtudiant(eIn);
	}

	@Override
	public int affDeptEtudiant(Etudiant eIn, Departement dIn) {
		return eDao.affecterdeptEtudiant(eIn, dIn);
	}

}
