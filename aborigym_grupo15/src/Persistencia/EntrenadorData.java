package Persistencia;

import Modelo.Conexion;
import Modelo.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EntrenadorData {

    private Connection con = null;

    public EntrenadorData() {
        this.con = Conexion.getConexion();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSERT INTO entrenador
    public void guardarEntrenador(Entrenador e) {
        String sql = "INSERT INTO entrenadores (dni, nombre, apellido, especialidad, estado) VALUES (?,?,?,?,?)"; // 1
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 2, reemplazamos los datos ? por el valor correspondiente del objeto entrenador
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getEspecialidad());
            ps.setBoolean(5, e.isEstado());

            ps.executeUpdate(); // 3

            ResultSet rs = ps.getGeneratedKeys(); // id generado por la bdd
            if (rs.next()) {
                e.setIdEntrenador(rs.getInt(1)); // se lo asignamos al objeto entrenador
                System.out.println("Entrenador guardado con exito. ID: " + e.getIdEntrenador());
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al guardar el entrenador: " + ex.getMessage());
        }
    }

}
