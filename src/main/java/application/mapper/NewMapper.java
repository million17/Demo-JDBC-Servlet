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
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setShortDesc(resultSet.getString("short_desc"));
			return news;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	
		
	}

}
