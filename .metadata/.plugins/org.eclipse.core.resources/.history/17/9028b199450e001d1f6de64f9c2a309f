package by.htp.ex.dao;

import by.htp.ex.dao.impl.SQLUserDao;

public final class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();

	private final UserDao userDao = new SQLUserDao();
	
	
	private DaoProvider() {
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public static DaoProvider getInstance() {
		return instance;
	}
}
