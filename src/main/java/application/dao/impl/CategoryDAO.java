package application.dao.impl;

import java.util.List;

import application.dao.ICategoryDAO;
import application.mapper.CategoryMapper;
import application.model.Category;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {
	@Override
	public List<Category> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
