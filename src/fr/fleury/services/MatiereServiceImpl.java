package fr.fleury.services;

import java.util.List;

import fr.fleury.dao.IMatiereDao;
import fr.fleury.dao.MatiereDaoImpl;
import fr.fleury.entity.Matiere;

public class MatiereServiceImpl implements IMatiereService{
	
	IMatiereDao mDao = new MatiereDaoImpl();

	@Override
	public int addMatiere(Matiere mIn) {
		return mDao.addMatiere(mIn);
	}

	@Override
	public int delMatiere(int mId) {
		return mDao.delMatiere(mId);
	}

	@Override
	public int modMatiere(Matiere mIn) {
		return mDao.modMatiere(mIn);
	}

	@Override
	public List<Matiere> getallMatieres() {
		return mDao.getAllMatiere();
	}

	@Override
	public Matiere getMatiereById(int mId) {
		return mDao.getMatiereById(mId);
	}

}
