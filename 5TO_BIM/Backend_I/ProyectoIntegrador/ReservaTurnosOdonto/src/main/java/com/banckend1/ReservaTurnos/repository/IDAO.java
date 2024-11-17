package com.banckend1.ReservaTurnos.dao;

import java.util.List;

public interface IDAO<T> {//crud

  T insertRecord(T t);                // Create
  T getRecord(Integer id);        // Read
  List<T> getAllRecords();            // Read
  void updateRecord(T t);                // Update
  void deleteRecord(Integer id);  // Delete

}