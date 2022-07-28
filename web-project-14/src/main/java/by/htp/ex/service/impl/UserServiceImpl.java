package by.htp.ex.service.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDao;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IUserService;
import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.util.validation.ValidationProvider;

public class UserServiceImpl implements IUserService{

	private final IUserDao iUserDao = DaoProvider.getInstance().getIUserDao();
	
	
	
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataVelidation();
	
	@Override
	public String signIn(String login, String password) throws ServiceException {
		
		if(!userDataValidation.checkAUthData(login, password)) {
			throw new ServiceException("login ...... ");
		}
		
		
		try {
			return iUserDao.signIn(login, password);
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean registration(NewUserInfo user) {
		// TODO Auto-generated method stub
		return false;
	}

}
