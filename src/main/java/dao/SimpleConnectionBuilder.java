package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.ConfigDb;

// Реализация интерфейса ConnectionBuilder
public class SimpleConnectionBuilder implements ConnectionBuilder{

	public SimpleConnectionBuilder() {
		try {
            Class.forName(ConfigDb.getProperty("db.driver.class"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
		
	}

	@Override
	public Connection getConnection() throws SQLException{
		String url = ConfigDb.getProperty("db.url");
		String login = ConfigDb.getProperty("db.login");
		String password = ConfigDb.getProperty("db.password");
		return DriverManager.getConnection(url, login, password);
	}
	
	public String[] getStrCon() {
		String url = ConfigDb.getProperty("db.url");
		String login = ConfigDb.getProperty("db.login");
		String password = ConfigDb.getProperty("db.password");
		return new String[] {url, login, password} ;
	}

}
