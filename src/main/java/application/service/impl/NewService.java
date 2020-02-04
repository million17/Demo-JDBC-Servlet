package application.service.impl;

import java.util.List;

import javax.inject.Inject;

import application.dao.INewDAO;
import application.model.New;
import application.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;

	@Override
	public List<New> findByCategoryId(Long categoryId) {

		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public New save(New news) {
		Long newId = newDAO.save(news);

		return newDAO.findOne(newId);
	}

}
