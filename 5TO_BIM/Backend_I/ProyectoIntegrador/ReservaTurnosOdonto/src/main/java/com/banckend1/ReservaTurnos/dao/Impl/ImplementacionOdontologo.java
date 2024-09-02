package com.banckend1.ReservaTurnos.dao.Impl;

import com.banckend1.ReservaTurnos.dao.BD;
import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionOdontologo implements IDAO<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionOdontologo.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {
            LOGGER.info("Estamos guardando un odontologo");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS (" +
                            "NOMBRE, APELLIDO, MATRICULA) VALUES " +
                            "(?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.execute();

            //guardé el odontologo y se generó el id

            ResultSet rs = preparedStatement.getGeneratedKeys();


            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                System.out.println("Se guardó el odontologo con nombre " +
                        odontologo.getNombre());
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
        LOGGER.info("Guardamos el odontologo con nombre " + odontologo.getNombre());
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> odontologoList = new ArrayList<>();

        try {
            connection = BD.getConnection();

            Statement buscarTodos = connection.createStatement(
            );

            ResultSet rs = buscarTodos.executeQuery("SELECT * FROM ODONTOLOGOS");

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));

                odontologoList.add(odontologo);
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

        return odontologoList;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS WHERE ID=?"
            );
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNombre(rs.getString(2));
                odontologo.setApellido(rs.getString(3));
                odontologo.setMatricula(rs.getString(4));
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

        return odontologo;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("Se eliminó el odontologo");
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
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;

        try {
            LOGGER.info("Estamos actualizando un odontologo");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE ODONTOLOGOS SET NOMBRE = ?, APELLIDO= ?, " +
                        "MATRICULA = ? WHERE ID=?");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.setInt(4, odontologo.getId());

            //Se actualizó el odontologo
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                System.out.println("Se actualizó el odontólogo:");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("Apellido: " + rs.getString(3));
                System.out.println("Matricula: " + rs.getString(4));

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
        LOGGER.info("Actualizamos el odontologo con id " + odontologo.getId());
        return odontologo;
    }
}
