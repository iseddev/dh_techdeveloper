package odontologo.dao;

import java.util.List;

public interface IDao <T>{
    // Crear
    T insertarRegistro(T t);

    // Consultar
    List<T> listarTodos();
}
