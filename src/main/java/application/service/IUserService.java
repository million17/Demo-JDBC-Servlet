package application.service;

import application.model.User;

public interface IUserService {
	User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
