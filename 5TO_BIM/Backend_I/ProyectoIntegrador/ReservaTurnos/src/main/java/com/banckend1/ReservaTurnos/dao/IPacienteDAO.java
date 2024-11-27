package com.banckend1.ReservaTurnos.dao;

import com.banckend1.ReservaTurnos.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteDAO extends JpaRepository<Paciente, Integer> {
}
