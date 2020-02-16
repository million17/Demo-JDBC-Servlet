package application.service;

import java.util.List;

import application.model.New;

public interface INewService {
	List<New> findByCategoryId(Long categoryId);
	
	New save(New news);
	New update(New updateNew);
	void delete(long[] ids);
	List<New> findAll(Integer offset,Integer limit);
	int getTotalItem();
}
