package application.dao;

import java.util.List;

import application.model.Category;
import application.model.New;

public interface ICategoryDAO extends GenericDAO<Category> {
	List<Category> findAll();
	
}
