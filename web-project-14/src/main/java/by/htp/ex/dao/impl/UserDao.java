package by.htp.ex.dao.impl;

import java.sql.SQLException;
import java.util.Random;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IUserDao;

public class UserDao implements IUserDao{

	@Override
	public String signIn(String login, String password) throws DaoException {
		
		Random rand = new Random();
		int value = rand.nextInt(1000);
		
//		if(value % 3 == 0) {
//			try {
//			   throw new SQLException("stub exception");
//			}catch(SQLException e) {
//				throw new DaoException(e);
//			}
//		}else if (value % 2 == 0) {
//			return true;
//		}else {
//			return false;
//		}
	return "d";	
	}
	
	
	public String getRole(String login, String password) {
		return "user";
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException  {
		// TODO Auto-generated method stub
		return false;
	}

}
