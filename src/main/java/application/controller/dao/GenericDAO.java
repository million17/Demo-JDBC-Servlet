package application.controller.dao;

import java.sql.Connection;
import java.util.List;

import application.controller.mapper.RowMapper;

public interface GenericDAO<T> {
	Connection getConnection();
	
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
 