package application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.New;

public class NewMapper implements RowMapper<New> {

	@Override
	public New mapRow(ResultSet resultSet) {
		New news = new New();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setShortDesc(resultSet.getString("short_desc"));
			news.setCreatedDate(resultSet.getTimestamp("created_date"));
			news.setCreatedBy(resultSet.getString("created_by"));
			if (resultSet.getTimestamp("modified_date") != null) {
				news.setCreatedDate(resultSet.getTimestamp("modified_date"));
			}
			if (resultSet.getTimestamp("modified_by") != null) {
				news.setModifiedBy(resultSet.getString("modified_by"));
			}
			return news;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

}
