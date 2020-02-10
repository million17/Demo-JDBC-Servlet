package application.dao;

import java.util.List;

import application.model.New;

public interface INewDAO extends GenericDAO<New> {
	New findOne(Long id);
	List<New> findByCategoryId(Long categoryId);
	Long save(New news);
	void update(New updateNew);
	void delete(long id);
}
