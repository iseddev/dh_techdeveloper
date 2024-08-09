package dao;

import org.apache.log4j.Logger;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {

    private static final Logger LOGGER = Logger.getLogger(Data.class);
    private static final String DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE " +
            "ODONTOLOGOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NUMERO_MATRICULA VARCHAR(100) NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL)";

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();
            LOGGER.info("Se estableció la conexion");
            Statement statement = connection.createStatement();

            statement.execute(DROP_CREATE);
            LOGGER.info("Se creó la tabla");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("No se llegó a crear la tabla");
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Databases/examenbckn", "root", "");
    }
}
