package fr.fleury.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecteur {
	
	//Les paramètres de connexion à la BD
	public static final String url = "jdbc:mysql://localhost:3306/projet_gestion_lycee_jdbc";
	public static final String user = "root";
	public static final String password = "root";
	public static final String driver = "com.mysql.jdbc.Driver";
	
	//L'objet connexion 
	private static Connection cx = null;

	public static Connection getCx() {
		return cx;
	}
	
	public static void ouvrirConnexion() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		cx = DriverManager.getConnection(url, user, password);
	}

}
