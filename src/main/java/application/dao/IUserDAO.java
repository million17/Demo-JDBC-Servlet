package application.dao;

import application.model.User;

public interface IUserDAO {
	User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
