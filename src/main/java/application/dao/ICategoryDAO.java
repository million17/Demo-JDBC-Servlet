package application.dao;

import java.util.List;

import application.model.Category;
import application.model.New;

public interface ICategoryDAO extends GenericDAO<Category> {
	List<Category> findAll();

	Long save(Category categorys);

	void update(Category categorys);

	void delete(Long categoryId);

	Category findOne(Long id);

}
