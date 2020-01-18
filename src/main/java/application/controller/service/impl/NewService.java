package application.controller.service.impl;

import java.util.List;

import javax.inject.Inject;

import application.controller.dao.INewDAO;
import application.controller.service.INewService;
import application.model.New;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;

	@Override
	public List<New> findByCategoryId(Long categoryId) {

		return newDAO.findByCategoryId(categoryId);
	}

}
