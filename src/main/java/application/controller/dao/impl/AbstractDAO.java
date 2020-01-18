package application.controller.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.controller.dao.GenericDAO;
import application.controller.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/newjdbc1month2020", "root", "bemyself");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error Connect MySql!");
			return null;
		}

	}



	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			
		}
		return null;
	}
}
