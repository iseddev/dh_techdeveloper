package com.banckend1.ReservaTurnos.repository;

import com.banckend1.ReservaTurnos.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoDAO extends JpaRepository<Odontologo, Integer> {
}
