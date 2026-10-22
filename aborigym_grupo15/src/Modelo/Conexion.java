package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mariadb://localhost:3306/aborigym_grupo15";
    private static String usuario = "root";
    private static String password = "";
    
    private static Connection conexion = null;

    // constructor privado
    private Conexion() {}

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
            } catch (ClassNotFoundException e) {
                System.err.println("No se puede conectar o cargar el driver de MariaDB: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("No se puede conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}