package application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Role;
import application.model.User;

public class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet resultSet) {
		User users = new User();
		try {
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("username"));
			users.setPassword(resultSet.getString("password"));
			users.setFullName(resultSet.getString("fullname"));
			users.setStatus(resultSet.getInt("status"));
			users.setRoleId(resultSet.getLong("roleid"));
			users.setCreatedDate(resultSet.getTimestamp("created_date"));
			users.setModifiedDate(resultSet.getTimestamp("modified_date"));
			users.setCreatedBy(resultSet.getString("created_by"));
			users.setModifiedBy(resultSet.getString("modified_by"));
			try {
				Role role = new Role();
				role.setName(resultSet.getString("name"));
				role.setCode(resultSet.getString("code"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			if (resultSet.getTimestamp("modified_date") != null) {
				users.setCreatedDate(resultSet.getTimestamp("modified_date"));
			}
			if (resultSet.getTimestamp("modified_by") != null) {
				users.setModifiedBy(resultSet.getString("modified_by"));
			}
			return users;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
}
