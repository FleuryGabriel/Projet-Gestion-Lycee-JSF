package fr.fleury.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Matiere;
import fr.fleury.entity.Professeur;
import fr.fleury.util.Connecteur;

public class ProfesseurDaoImpl implements IProfesseurDao{
	
	private PreparedStatement ps = null;
	
	IDepartementDao dDao = new DepartementDaoImpl();
	IMatiereDao mDao = new MatiereDaoImpl();

	@Override
	public int addProfesseur(Professeur pIn) {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "INSERT INTO professeur (id, nom, prenom, date_aff) VALUES (?, ?, ?, ?);";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, pIn.getId());
			ps.setString(2, pIn.getNom());
			ps.setString(3, pIn.getPrenom());
			ps.setDate(4, pIn.getDate_aff());
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int delProfesseur(int pId) {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "DELETE FROM professeur WHERE id=?";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, pId);
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int modProfesseur(Professeur pIn) {

		try {
			Connecteur.ouvrirConnexion();
			
			String request = "UPDATE professeur SET nom=?, prenom=?, date_aff=? WHERE id=?;";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setString(1, pIn.getNom());
			ps.setString(2, pIn.getPrenom());
			ps.setDate(3, pIn.getDate_aff());
			ps.setInt(4, pIn.getId());
			
			int result = ps.executeUpdate();
			
			return result;
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int affecterDeptProfesseur(Professeur pIn, Departement dIn) {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "UPDATE professeur SET id_dep=? WHERE id=?;";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, dIn.getId());
			ps.setInt(2, pIn.getId());
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int affecterMatProfesseur(Professeur pIn, Matiere mIn) {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "UPDATE professeur SET id_matiere=? WHERE id=?;";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, mIn.getId());
			ps.setInt(2, pIn.getId());
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public List<Professeur> getAllProfesseur() {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "SELECT * FROM professeur;";
			ps=Connecteur.getCx().prepareStatement(request);
			
			ResultSet rs = ps.executeQuery();
			List<Professeur> profs = new ArrayList<Professeur>();
			
			while(rs.next()) {
				Professeur pOut = new Professeur();
				
				pOut.setId(rs.getInt("id"));
				pOut.setNom(rs.getString("nom"));
				pOut.setPrenom(rs.getString("prenom"));
				pOut.setDate_aff(rs.getDate("date_aff"));
				pOut.setDepartement(dDao.findDepartementById(rs.getInt("id_dep")));
				pOut.setMatiere(mDao.getMatiereById(rs.getInt("id_matiere")));
				
				profs.add(pOut);
			}
			
			return profs;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {

				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Professeur getProfById(int pId) {
		try {
			Connecteur.ouvrirConnexion();

			String request = "SELECT * FROM professeur WHERE id=?;";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, pId);

			ResultSet rs = ps.executeQuery();
			Professeur pOut = new Professeur();
			rs.next();

			pOut.setId(rs.getInt("id"));
			pOut.setNom(rs.getString("nom"));
			pOut.setNom(rs.getString("prenom"));
			pOut.setDate_aff(rs.getDate("date_aff"));
			pOut.setDepartement(dDao.findDepartementById(rs.getInt("id_dep")));
			pOut.setMatiere(mDao.getMatiereById(rs.getInt("id_matiere")));

			return pOut;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.close();
				}

				if (Connecteur.getCx() != null) {
					Connecteur.getCx().close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
