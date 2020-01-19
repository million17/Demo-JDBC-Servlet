package application.dao.impl;

import java.util.List;

import application.dao.INewDAO;
import application.mapper.NewMapper;
import application.model.New;

public class NewDAO extends AbstractDAO<New> implements INewDAO {

	@Override
	public List<New> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(New news) {
		String sql = "insert into news (title,content, categoryid) values (?,?,?)";

		return insert(sql, news.getTitle(), news.getContent(), news.getCategoryId());
	}

}
