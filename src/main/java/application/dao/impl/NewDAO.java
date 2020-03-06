package application.dao.impl;

import java.util.List;

import application.dao.INewDAO;
import application.mapper.NewMapper;
import application.model.New;
import application.paging.Pageble;

public class NewDAO extends AbstractDAO<New> implements INewDAO {

	@Override
	public List<New> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(New news) {
		String sql = "insert into news " + "(title , thumbnail , categoryid , "
				+ "short_desc , content , created_date , " + "modified_date , created_by , modified_by)"
				+ " values ( ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		return insert(sql, news.getTitle(), news.getThumbnail(), news.getCategoryId(), news.getShortDesc(),
				news.getContent(), news.getCreatedDate(), news.getModifiedDate(), news.getCreatedBy(),
				news.getModifiedBy());
	}

	@Override
	public New findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<New> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(New updateNew) {
//		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ? ,");
//		sql.append("short_desc = ? , content = ? , categoryid = ? , ");
//		sql.append("created_date = ? , created_by = ?, modified_date = ?, modified_by = ? WHERE id = ?");
		String sql = "UPDATE news SET title = ? , thumbnail = ? , categoryid = ? , short_desc = ? , content = ? "
				+ ", created_date = ? , modified_date = ? , created_by = ? , modified_by = ? " + " WHERE id = ? ";
		update(sql, updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getCategoryId(), updateNew.getShortDesc(),
				updateNew.getContent(), updateNew.getCreatedDate(), updateNew.getModifiedDate(),
				updateNew.getCreatedBy(), updateNew.getModifiedBy(), updateNew.getId());

	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ? ";
		update(sql, id);
	}

	@Override
	public List<New> findAll(Pageble pageble) {
//		String sql = "SELECT * FROM news";
		StringBuilder sql = new StringBuilder("SELECT * FROM news ");
		if (pageble.getSorter() != null) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + " , " + pageble.getLimit());
		}
		return query(sql.toString(), new NewMapper());

	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) from news ";
		return count(sql);
	}

}
