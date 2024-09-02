package com.banckend1.ReservaTurnos.dao.Impl;

import com.banckend1.ReservaTurnos.dao.BD;
import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Domicilio;
import com.banckend1.ReservaTurnos.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionPaciente implements IDAO<Paciente> {

    private static final Logger LOGGER = Logger.getLogger(ImplementacionPaciente.class);

    ImplementacionDomicilio implementacionDomicilio = new ImplementacionDomicilio();

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;

        try {
            implementacionDomicilio.guardar(paciente.getDomicilio());

            LOGGER.info("Estamos guardando un paciente");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO PACIENTES (" +
                            "NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES " +
                            "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                paciente.setId(rs.getInt(1));
                System.out.println("Se guardó el paciente con nombre " +
                        paciente.getNombre());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        LOGGER.info("Guardamos el paciente con nombre " + paciente.getNombre());
        return paciente;

    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection = null;

        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PACIENTES"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));

                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domicilio);

                pacienteList.add(paciente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteList;

    }

    @Override
    public Paciente consultarPorId(Integer id) {
        Connection connection = null;

        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PACIENTES WHERE ID=?"
            );

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));

                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domicilio);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;

    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
            preparedStatement.setInt(1, id);
            implementacionDomicilio.eliminarPorId(this.consultarPorId(id).getDomicilio().getId());
            preparedStatement.executeUpdate();
            LOGGER.info("Se eliminó el paciente");
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("No se pudo eliminar porque id no existe");
        } finally {
            try {
                connection.close();
                LOGGER.info("Se cierra la conexion");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            Domicilio domicilio = implementacionDomicilio.actualizar(paciente.getDomicilio());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, " +
                            "DNI=?, FECHA_ALTA=?, DOMICILIO_ID=? WHERE ID=?"
            );

            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());
            preparedStatement.setInt(6, paciente.getId());

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                System.out.println("Se actualizó el paciente:");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Apellido: " + rs.getString(3));
                System.out.println("DNI: " + rs.getString(4));
                System.out.println("FechaAlta: " + rs.getDate(5).toLocalDate());
                System.out.println("Domicilio_id: " + rs.getInt(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
