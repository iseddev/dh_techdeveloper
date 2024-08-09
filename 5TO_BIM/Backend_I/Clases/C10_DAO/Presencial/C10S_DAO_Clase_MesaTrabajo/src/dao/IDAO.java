package dao;

public interface IDAO<T> {

  // Esta interfaz es donde determinaremos la "lógica de negocio", es decir, donde definiremos los procesos a ejecutar sobre nuestra base de datos y que deberan ser implemnetados con su propia lógica en

  // De forma general, aquíe es donde se definen las implementaciones CRUD:
  // C => CREATE
  // R => READ
  // U => UPDATE
  // D => DELETE

  // CREATE
  T guardarRegistro(T t);

  // Mesa de trabajo
  // READ
  T buscarPorId(Integer id);
}
