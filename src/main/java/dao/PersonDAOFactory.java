package dao;

import config.GlobalConfig;

public class PersonDAOFactory {

	@SuppressWarnings("deprecation")
	public static PersonsDAO getPersonsDAO() {
		try {
			Class<?> dao = Class.forName(GlobalConfig.getProperty("dao.class"));
			return (PersonsDAO) dao.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
