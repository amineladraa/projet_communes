package fr.gtm.communes.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CommuneDaoTest {
	private String driver ="com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/communes-france";
	private String user ="root";
	private String pswd ="";

	@Test
	public void testCommuneDao() throws ClassNotFoundException{
		
		CommunesDao dao = new CommunesDao (driver, url, user, pswd);
		assertNotNull(dao);
	}
	@Test (expected = ClassNotFoundException.class)
	public void testCommuneDaoException() throws ClassNotFoundException {
		CommunesDao dao = new CommunesDao ("foo", url, user, pswd);
		assertNull(dao);
	}
	
	@Test
	public void testfindCommunesByCodepostal() throws ClassNotFoundException, SQLException{
		CommunesDao dao = new CommunesDao (driver, url, user, pswd);
		assertTrue(dao.findCommunesByCodePostal("999").size()==0);
		assertTrue(dao.findCommunesByCodePostal("358").size()>0);
		
	}
	
	@Test
	public void testfindCommunesByDepartement() throws ClassNotFoundException, SQLException {
		CommunesDao dao = new CommunesDao (driver, url, user, pswd);
		assertTrue(dao.findCommunesByDepartement("foo").size()==0);
		assertTrue(dao.findCommunesByDepartement("yveline").size()>0);
		
		
	}
}
