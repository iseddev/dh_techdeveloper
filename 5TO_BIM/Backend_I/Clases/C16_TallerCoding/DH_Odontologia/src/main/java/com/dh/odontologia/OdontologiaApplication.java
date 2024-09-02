package com.dh.odontologia;

import com.dh.odontologia.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OdontologiaApplication {

  public static void main(String[] args) {
    BD.createTables();

    SpringApplication.run(OdontologiaApplication.class, args);
  }
}