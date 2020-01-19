package application.dao;

import java.sql.Connection;
import java.util.List;

import application.mapper.RowMapper;

public interface GenericDAO<T> {
	Connection getConnection();

	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

	void update(String sql, Object... parameters);

	Long insert(String sql, Object... parameters);
}
