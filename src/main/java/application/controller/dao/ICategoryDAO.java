package application.controller.dao;

import java.util.List;

import application.model.Category;

public interface ICategoryDAO {
	List<Category> findAll();
}
