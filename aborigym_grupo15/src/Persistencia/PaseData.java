
package Persistencia;


import Modelo.Conexion;
import java.sql.Connection;
import Modelo.Pase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class PaseData {

    private  Connection con ;
 
    public PaseData() {
        con = Conexion.getConexion();
    }
    public void guardarPase(Pase pase) {
    String sql = "INSERT INTO pases "
            + "(id_socio, cantidad_entradas, fecha_inicio, fecha_fin, costo, estado) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps =
            con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setInt(1, pase.getSocio().getIdSocio());
        ps.setInt(2, pase.getCantidadEntradas());
        ps.setDate(3, java.sql.Date.valueOf(pase.getFechaInicio()));
        ps.setDate(4, java.sql.Date.valueOf(pase.getFechaFin()));
        ps.setBigDecimal(5, pase.getCosto());
        ps.setBoolean(6, pase.isEstado());

        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                pase.setIdPase(rs.getInt(1));
                System.out.println("Pase guardado con éxito. ID: " + pase.getIdPase());
            }
        }

    } catch (SQLException ex) {
        System.err.println("Error al guardar el pase: " + ex.getMessage());
    }
}
}