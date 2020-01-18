package application.controller.dao;

import java.util.List;

import application.model.Category;
import application.model.New;

public interface ICategoryDAO extends GenericDAO {
	List<Category> findAll();
	
}
