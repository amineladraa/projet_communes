package fr.gtm.communes.dao;

import java.sql.SQLException;
import java.util.List;

import fr.gtm.communes.entities.Commune;

public class MainCommune {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// le nom de la classe du driver
		String driver ="com.mysql.cj.jdbc.Driver";
		//URL vers la base de données
		String url = "jdbc:mysql://localhost:3306/communes-france";
		// utilisateur
		String user ="root";
		//mdp
		String pswd ="";
		
		CommunesDao dao = new CommunesDao (driver,url,user,pswd);
		//List<Commune> communes = dao.findCommunesByCodePostal("972");
		List<Commune> communes = dao.findCommunesByDepartement("yveline");
		for (Commune c : communes) {
			System.out.println(c);
		}

	}

}
