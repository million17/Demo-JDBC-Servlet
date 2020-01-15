package application.controller.service.impl;

import java.util.List;

import javax.inject.Inject;

import application.controller.dao.ICategoryDAO;
import application.controller.service.ICategoryService;
import application.model.Category;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

}
