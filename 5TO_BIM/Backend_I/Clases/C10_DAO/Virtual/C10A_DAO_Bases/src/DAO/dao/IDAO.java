package DAO.dao;

import java.util.List;

public interface IDAO<T> {

	public T guardar(T t);
	public void eliminarPorId(Integer id);
	public T buscarPorId(Integer id);
	public List<T> buscarTodos();
}