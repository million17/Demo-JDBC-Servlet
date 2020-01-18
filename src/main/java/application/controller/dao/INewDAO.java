package application.controller.dao;

import java.util.List;

import application.model.New;

public interface INewDAO extends GenericDAO {
	List<New> findByCategoryId(Long categoryId);
}
