package fr.fleury.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.fleury.entity.Departement;
import fr.fleury.entity.Etudiant;
import fr.fleury.util.Connecteur;

public class EtudiantDaoImpl implements IEtudiantDao {

	private PreparedStatement ps = null;

	@Override
	public int addEtudiant(Etudiant eIn) {

		try {
			Connecteur.ouvrirConnexion();

			String request = "INSERT INTO etudiant (id, nom, prenom) VALUES (?, ?, ?);";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, eIn.getId());
			ps.setString(2, eIn.getNom());
			ps.setString(3, eIn.getPrenom());

			int result = ps.executeUpdate();

			return result;

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

		return 0;
	}

	@Override
	public int delEtudiant(int eId) {

		try {
			Connecteur.ouvrirConnexion();

			String request = "DELETE FROM etudiant WHERE id=?;";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, eId);

			int verif = ps.executeUpdate();

			return verif;

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

		return 0;
	}

	@Override
	public int modEtudiant(Etudiant eIn) {

		try {
			Connecteur.ouvrirConnexion();

			String request = "UPDATE etudiant SET nom=?, prenom=? WHERE id=?;";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setString(1, eIn.getNom());
			ps.setString(2, eIn.getPrenom());
			ps.setInt(3, eIn.getId());

			int verif = ps.executeUpdate();

			return verif;

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

		return 0;
	}

	@Override
	public int affecterdeptEtudiant(Etudiant eIn, Departement dIn) {

		try {
			Connecteur.ouvrirConnexion();

			String request = "UPDATE etudiant SET id_dept=? WHERE id=?;";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, dIn.getId());
			ps.setInt(2, eIn.getId());

			int verif = ps.executeUpdate();

			return verif;

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

		return 0;
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "SELECT * FROM etudiant;";
			ps=Connecteur.getCx().prepareStatement(request);
			
			ResultSet rs = ps.executeQuery();
			
			List<Etudiant> etudiants = new ArrayList<Etudiant>();
			
			while(rs.next()) {
				Etudiant eOut = new Etudiant();
				
				eOut.setId(rs.getInt("id"));
				eOut.setNom(rs.getString("nom"));
				eOut.setPrenom(rs.getString("prenom"));
				eOut.setDepartement(new Departement(rs.getInt("id_dept")));
				
				etudiants.add(eOut);
			}
			
			return etudiants;
			
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

}
