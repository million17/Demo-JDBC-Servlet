package application.service.impl;

import java.util.List;

import javax.inject.Inject;

import application.dao.ICategoryDAO;
import application.model.Category;
import application.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

}
