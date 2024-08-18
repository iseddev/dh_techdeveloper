package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

	public T insert(T t);									// CREATE
	public List<T> selectAll();						// READ
	public T update(T t) throws SQLException;									// UPDATE
	public void deleteById(Integer id);		// DELETE
}