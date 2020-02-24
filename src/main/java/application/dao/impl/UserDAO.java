package application.dao.impl;

import java.util.List;

import application.dao.IUserDAO;
import application.mapper.UserMapper;
import application.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Override
	public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
		sql.append("INNER JOIN role AS r ON r.id = u.roleid ");
		sql.append(" WHERE id = ? and password = ? and status = ? ");
		List<User> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
