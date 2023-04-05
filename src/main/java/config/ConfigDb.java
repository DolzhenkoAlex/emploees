package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigDb {

	public static final String CONFIG_NAME = "config.properties";
	public static final Properties GLOBAL_COFIG = new Properties();
/*
	// Сделать начальную загрузку параметров из файла по умолчанию
	public static void initConfigDb() throws IOException {
		File f = new File("config.properties");
		System.out.println(f.getAbsolutePath());
		initConfigDb(null);
	}

	// Сделать загрузку данных из конфигурационного файла, имя которого передано в
	// виде параметра
	// Если имя null или пустое - берем файл по умолчанию.
	public static void initConfigDb(String name) throws IOException {
		if (name != null && !name.trim().isEmpty()) {
			File f = new File("config.properties");
			System.out.println(f.getAbsolutePath());
			GLOBAL_COFIG.load(new FileReader(name));
		} else {
			File f = new File("config.properties");
			System.out.println(f.getAbsolutePath());
			GLOBAL_COFIG.load(new FileReader(CONFIG_NAME));
		}
	}
*/
	
	public ConfigDb() throws FileNotFoundException, IOException  {
		GLOBAL_COFIG.load(new FileReader(CONFIG_NAME));
	}
	
	
	// Получить значение параметра из глобальной конфигурации по имени
	public static String getProperty(String property) {
		return GLOBAL_COFIG.getProperty(property);
	}
	
}
