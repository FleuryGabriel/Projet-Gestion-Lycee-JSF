package fr.fleury.services;

import fr.fleury.dao.IProfesseurDao;
import fr.fleury.dao.ProfesseurDaoImpl;
import fr.fleury.entity.Departement;
import fr.fleury.entity.Matiere;
import fr.fleury.entity.Professeur;

public class ProfesseurServiceImpl implements IProfesseurService{
	
	IProfesseurDao pDao = new ProfesseurDaoImpl();

	@Override
	public int addProfesseur(Professeur pIn) {
		return pDao.addProfesseur(pIn);
	}

	@Override
	public int delProfesseur(int pId) {
		return pDao.delProfesseur(pId);
	}

	@Override
	public int modProfesseur(Professeur pIn) {
		return pDao.modProfesseur(pIn);
	}

	@Override
	public int affecterDeptProfesseur(Professeur pIn, Departement dIn) {
		return pDao.affecterDeptProfesseur(pIn, dIn);
	}

	@Override
	public int affecterMatProfesseur(Professeur pIn, Matiere mIn) {
		return pDao.affecterMatProfesseur(pIn, mIn);
	}

}
