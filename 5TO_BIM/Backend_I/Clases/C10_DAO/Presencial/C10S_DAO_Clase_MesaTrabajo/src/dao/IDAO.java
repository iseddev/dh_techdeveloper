package dao;

public interface IDAO<T> {

  // Esta interfaz contendrá la firma de los métodos de las operaciones CRUD que requiere nuestra lógica del negocio
  // C - Create <=> R - Read <=> U - Update <=> D - Delete

  T insert(T t); // Create

  // #################### Mesa de trabajo ####################
  T selectById(Integer id); // Read
}