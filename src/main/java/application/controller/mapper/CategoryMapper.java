package application.controller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Category;

public class CategoryMapper<T> implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet resultSet) {
		Category category = new Category();
		try {
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
