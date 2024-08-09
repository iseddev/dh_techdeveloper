package dao;

import java.util.List;

public interface Idao<T> {

  // Insertar registro => CREATE
  T insertarRegistro(T t);
  // Consultar todos => READ
  List<T> consultarTodos();
  // Consultar por Id => READ
  T consultarPorId(Integer id);
  // Actualizar un registro => UPDATE
  T actalizarRegistro(T t);
  // Eliminar un registro => DELETE
  void eliminarPorId(Integer id);
}