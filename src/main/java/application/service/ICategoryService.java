package application.service;

import java.util.List;

import application.model.Category;

public interface ICategoryService {
	List<Category> findAll();
	Category save(Category category);
	Category update(Category update);
	void delete (Long categoryId);
	Category findOne(Long categoryId);
}
