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

	@Override
	public Category findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ? ";
		List<Category> categorys = query(sql, new CategoryMapper(), id);
		return categorys.isEmpty() ? null : categorys.get(0);
	}

	@Override
	public Long save(Category categorys) {

		String sql = "INSERT INTO category " + " (name , code , created_date "
				+ ", modified_date , created_by , modified_by )" 
				+ " values ( ? , ? , ? , ? , ? , ? )";
		return insert(sql,			 
				categorys.getName(),
				categorys.getCode(),
				categorys.getCreatedDate(),
				categorys.getModifiedDate(),
				categorys.getCreatedBy(),
				categorys.getModifiedBy());
	}

	@Override
	public void update(Category categorys) {
		String sql = "UPDATE category SET name = ? , code = ? , created_date = ?"
				+ " , modified_date = ? , created_by = ? , modified_by = ? " + "WHERE id = ?";
		update(sql, new CategoryMapper(), categorys.getName(), categorys.getCode(), categorys.getCreatedDate(),
				categorys.getModifiedDate(), categorys.getCreatedBy(), categorys.getModifiedBy());

	}

	@Override
	public void delete(Long categoryId) {
		String sql = "DELETE FROM category WHERE id = ? ";
		update(sql, categoryId);

	}

	@Override
	public Category findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ? ";
		List<Category> categorys = query(sql, new CategoryMapper(), code);
		return categorys.isEmpty() ? null : categorys.get(0);
	}


}
