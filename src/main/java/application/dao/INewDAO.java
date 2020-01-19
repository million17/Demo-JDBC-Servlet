package application.dao;

import java.util.List;

import application.model.New;

public interface INewDAO extends GenericDAO<New> {
	List<New> findByCategoryId(Long categoryId);
	Long save(New news);
}
