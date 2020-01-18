package application.controller.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.controller.dao.ICategoryDAO;
import application.model.Category;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {

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
	public List<Category> findAll() {
		List<Category> results = new ArrayList<>();

		// sql
		String sql = "SELECT * FROM category";

		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Category category = new Category();
					category.setId(resultSet.getLong("id"));
					category.setCode(resultSet.getString("code"));
					category.setName(resultSet.getString("name"));
					results.add(category);
				}

				return results;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}

			}
		}
		return null;

	}

}
