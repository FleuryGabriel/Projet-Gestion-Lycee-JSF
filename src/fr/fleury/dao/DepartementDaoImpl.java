package fr.fleury.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.fleury.entity.Departement;
import fr.fleury.util.Connecteur;

public class DepartementDaoImpl implements IDepartementDao {
	
	//Attributs de la couche
	private PreparedStatement ps = null;

	@Override
	public int addDepartement(Departement dIn) {

		//Ouvrir la connexion
		
		try {
			Connecteur.ouvrirConnexion();
			
			//Construire la requête
			
			String request = "INSERT INTO departement (id, nom) VALUES (?, ?);";
			ps = Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, dIn.getId());
			ps.setString(2, dIn.getNom());
			
			//Exécuter la requête
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if (ps!=null) {
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
	public int delDepartement(int dId) {

		//Ouvrir la connexion
		
		try {
			Connecteur.ouvrirConnexion();
			
			//Créer la requête
			
			String request = "DELETE FROM departement WHERE id=?;";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setInt(1, dId);
			
			//Exécuter la requête
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
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
	public int modDepartement(Departement dIn) {

		try {
			Connecteur.ouvrirConnexion();
			
			String request = "UPDATE departement SET nom=? WHERE id=?;";
			ps=Connecteur.getCx().prepareStatement(request);
			ps.setString(1, dIn.getNom());
			ps.setInt(2, dIn.getId());
			
			int result = ps.executeUpdate();
			
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
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
	public List<Departement> getAllDepartement() {
		
		try {
			Connecteur.ouvrirConnexion();
			
			String request = "SELECT * FROM departement;";
			ps=Connecteur.getCx().prepareStatement(request);
			
			ResultSet rs = ps.executeQuery();
			
			List<Departement> dpts = new ArrayList<Departement>();
			
			while(rs.next()) {
				
				Departement dOut= new Departement();
				
				dOut.setId(rs.getInt("id"));
				dOut.setNom(rs.getString("nom"));
				
				dpts.add(dOut);
			}
			
			return dpts;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
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
