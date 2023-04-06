package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConnectionProperty {
	
	public static final String CONFIG_NAME = "config.properties";
	public static final Properties GLOBAL_COFIG = new Properties();
	
	public ConnectionProperty() throws FileNotFoundException, IOException {
		GLOBAL_COFIG.load(new FileReader(CONFIG_NAME));
	}

	// Получить значение параметра из конфигурации по имени свойства
	public static String getProperty(String property) {
		return GLOBAL_COFIG.getProperty(property);
	}
	
	public String[] GetConProperties() {
		String url = ConnectionProperty.getProperty("db.url");
		String login = ConnectionProperty.getProperty("db.login");
		String password = ConnectionProperty.getProperty("db.password");
		String driver = ConnectionProperty.getProperty("db.driver.class");
		return new String[] {driver, url, login, password} ;
	}
}
