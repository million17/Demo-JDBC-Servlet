package application.controller.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.controller.dao.INewDAO;
import application.model.New;

public class NewDAO extends AbstractDAO implements INewDAO {

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
	public List<New> findByCategoryId(Long categoryId) {
		List<New> results = new ArrayList<>();
		String sql = "select * from news where categoryid = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setLong(1, categoryId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					New news = new New();
					news.setId(resultSet.getLong("id"));
					news.setTitle(resultSet.getString("title"));
					results.add(news);
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
