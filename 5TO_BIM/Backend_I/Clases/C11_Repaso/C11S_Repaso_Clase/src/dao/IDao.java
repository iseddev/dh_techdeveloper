package dao;

import java.util.List;

public interface IDao<T> {

  // ● Administración de datos de los pacientes: listar, agregar, modificar y eliminar pacientes.

  // ===== Listar =====
  T selectPorId(Integer id);
  List<T> selectTodos();

  // ===== Agregar =====
  T insertRegistro(T t);

  // ===== Modificar =====
  T updateRegistro(T t);

  // ===== Eliminar =====
  void deletePorId(Integer id);
}