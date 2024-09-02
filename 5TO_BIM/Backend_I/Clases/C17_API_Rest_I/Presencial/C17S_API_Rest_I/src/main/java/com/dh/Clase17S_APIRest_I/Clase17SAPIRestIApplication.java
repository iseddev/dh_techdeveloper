package com.dh.Clase17S_APIRest_I;

import com.dh.Clase17S_APIRest_I.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase17SAPIRestIApplication {

	public static void main(String[] args) {
		BD.createTable();
		SpringApplication.run(Clase17SAPIRestIApplication.class, args);
	}

}
