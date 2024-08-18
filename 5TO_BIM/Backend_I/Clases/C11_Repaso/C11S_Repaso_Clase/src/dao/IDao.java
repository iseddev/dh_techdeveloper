package dao;

import java.util.List;

public interface IDao<T> {

  // Insertar registro => CREATE
  T insertRegistro(T t);
  // Consultar todos => READ
  List<T> selectTodos();
  // Consultar por Id => READ
  T selectPorId(Integer id);
  // Actualizar un registro => UPDATE
  T updateRegistro(T t);
  // Eliminar un registro => DELETE
  void deletePorId(Integer id);
}