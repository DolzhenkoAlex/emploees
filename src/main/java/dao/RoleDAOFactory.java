package dao;

import config.GlobalConfig;

public class RoleDAOFactory {
	
	@SuppressWarnings("deprecation")
	public static RoleDAO getRoleDAO() {
		try {
			Class<?> dao = Class.forName(GlobalConfig.getProperty("dao.class"));
			return (RoleDAO) dao.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
