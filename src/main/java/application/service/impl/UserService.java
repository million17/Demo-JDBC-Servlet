package application.service.impl;

import javax.inject.Inject;

import application.dao.IUserDAO;
import application.model.User;
import application.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDao;

	@Override
	public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
