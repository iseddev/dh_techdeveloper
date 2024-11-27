package com.dh.odontologia.dao;

import java.util.List;

public interface IDao<T> {

  T insertRecord(T t);                  // CREATE
  T getRecordById(Integer id);          // READ
  List<T> getAllRecords();              // READ
  void updateRecord(T t);               // UPDATE
  void deleteRecordById(Integer id);    // DELETE

}