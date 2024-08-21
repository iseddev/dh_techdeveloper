package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	T insert(T t);													// CREATE
	List<T> selectAll();										// READ
	T update(T t) throws SQLException;			// UPDATE
	void deleteById(Integer id);						// DELETE
}