package application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet resultSet) {
		Category category = new Category();
		try {
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			category.setCreatedDate(resultSet.getTimestamp("created_date"));
			category.setModifiedDate(resultSet.getTimestamp("modified_date"));
			category.setCreatedBy(resultSet.getString("created_by"));
			category.setModifiedBy(resultSet.getString("modified_by"));
			if (resultSet.getTimestamp("modified_date") != null) {
				category.setModifiedDate(resultSet.getTimestamp("modified_date"));
			}
			if (resultSet.getString("modified_by") != null) {
				category.setModifiedBy(resultSet.getString("modified_by"));
			}
			return category;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

}
