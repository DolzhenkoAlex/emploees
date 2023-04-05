package dao;

import java.io.FileReader;
import java.util.Properties;

public class ConnectionProperty {
	
	private Properties pr = new Properties();;
	
	
	public String[] GetConProperties() {
		
		try {
			// Загружаем данные из файла  /config.properties
			pr.load(new FileReader("config.properties"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		String url = pr.getProperty("db.url");
		String login = pr.getProperty("db.login");
		String password = pr.getProperty("db.password");
		String driver = pr.getProperty("db.driver.class");
		return new String[] {driver, url, login, password} ;
	}
}
