package fr.pizzeria.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDbDao;

public class ConnexionBase {

	private static  final Logger LOG = LoggerFactory.getLogger(PizzaDbDao.class);
	private String url;
	private String username;
	private String password;
	private String driver;


	public ConnexionBase() throws ClassNotFoundException{
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Class.forName(file.getString("jdbc.driver"));
		url = file.getString("jdbc.url");
		username =  file.getString("jdbc.username");
		password = file.getString("jdbc.password");
	}
	
	public Connection connecte(){

		
		try {
			return DriverManager.getConnection(url, username,password);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}

	}
	
	public void close(Connection co){
		try {
			if (co!= null) {
				co.close();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
