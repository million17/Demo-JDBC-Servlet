package application.service.impl;

import java.sql.Timestamp;
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
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		news.setCreatedBy("");
		news.setModifiedBy("");
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Long newId = newDAO.save(news);

		return newDAO.findOne(newId);
	}

	@Override
	public New update(New updateNew) {
		New oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDAO.delete(id);
		}

	}

}
