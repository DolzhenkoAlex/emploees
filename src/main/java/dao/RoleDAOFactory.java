package dao;

import config.ConfigDb;

public class RoleDAOFactory {
	
	@SuppressWarnings("deprecation")
	public static RoleDAO getRoleDAO() {
		try {
			Class<?> dao = Class.forName(ConfigDb.getProperty("dao.class"));
			return (RoleDAO) dao.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
