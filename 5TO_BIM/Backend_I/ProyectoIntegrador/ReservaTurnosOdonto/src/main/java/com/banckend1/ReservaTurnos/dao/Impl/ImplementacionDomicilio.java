package com.banckend1.ReservaTurnos.dao.Impl;

import com.banckend1.ReservaTurnos.dao.BD;
import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDomicilio implements IDAO<Domicilio> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionDomicilio.class);

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;

        try {

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO DOMICILIOS (" +
                            "CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES " +
                            "(?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
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

        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        Connection connection = null;

        List<Domicilio> domicilioList = new ArrayList<>();
        Domicilio domicilio = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM DOMICILIOS"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5));

                domicilioList.add(domicilio);
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
        return domicilioList;
    }

    @Override
    public Domicilio consultarPorId(Integer id) {
        Connection connection = null;
        Domicilio domicilio = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(
                    "SELECT * FROM DOMICILIOS WHERE ID=?"
            );
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio();
                domicilio.setId(rs.getInt(1));
                domicilio.setCalle(rs.getString(2));
                domicilio.setNumero(rs.getInt(3));
                domicilio.setLocalidad(rs.getString(4));
                domicilio.setProvincia(rs.getString(5));

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

        return domicilio;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("Se eliminó el domicilio");
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
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;

        try {
            LOGGER.info("Estamos actualizando un domicilio");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE DOMICILIOS SET CALLE = ?, NUMERO= ?, " +
                            "LOCALIDAD = ?, PROVINCIA = ? WHERE ID=?");

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            //Se actualizó el domicilio
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                System.out.println("Se actualizó el domicilio");
                System.out.println("Id: " + rs.getInt(1));
                System.out.println("Calle: " + rs.getString(2));
                System.out.println("Numero: " + rs.getInt(3));
                System.out.println("Localidad: " + rs.getString(4));
                System.out.println("Provincia: " + rs.getString(5));
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
        LOGGER.info("Actualizamos el domicilio con id " + domicilio.getId());
        return domicilio;
    }
}
