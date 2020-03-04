package application.service;

import java.util.List;

import application.model.New;
import application.paging.Pageble;

public interface INewService {
	List<New> findByCategoryId(Long categoryId);

	New findOne(Long id);

	New save(New news);

	New update(New updateNew);

	void delete(long[] ids);

	List<New> findAll(Pageble pageble);

	int getTotalItem();

}
