
package Persistencia;


import Modelo.Conexion;
import java.sql.Connection;
import Modelo.Pase;
import Modelo.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

    public class PaseData {

    private  Connection con ;
 
    private SocioData socioData;
    
    public PaseData() {
        con = Conexion.getConexion();
        socioData = new SocioData();
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // UPDATE pases (Modifica un pase existente)
    public void modificarPase(Pase pase) {
        String sql = "UPDATE pases SET id_socio = ?, cantidad_entradas = ?, fecha_inicio = ?, fecha_fin = ?, costo = ?, estado = ? "
                   + "WHERE id_pase = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pase.getSocio().getIdSocio());
            ps.setInt(2, pase.getCantidadEntradas());
            ps.setDate(3, Date.valueOf(pase.getFechaInicio()));
            ps.setDate(4, Date.valueOf(pase.getFechaFin()));
            ps.setBigDecimal(5, pase.getCosto());
            ps.setBoolean(6, pase.isEstado());
            ps.setInt(7, pase.getIdPase());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Pase modificado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el pase a modificar.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al modificar el pase: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT pase activo por socio (Verifica que tenga entradas y este en fecha)
    public Pase obtenerPaseActivoPorSocio(int idSocio) {
        String sql = "SELECT * FROM pases WHERE id_socio = ? AND estado = 1 AND cantidad_entradas > 0 AND CURDATE() <= fecha_fin";
        Pase pase = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pase = instanciarPaseDesdeResultSet(rs);
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al obtener pase activo: " + ex.getMessage());
        }
        return pase;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // UPDATE pases (Descuenta 1 entrada tras registrar asistencia)
    public void descontarEntrada(int idPase) {
        String sql = "UPDATE pases SET cantidad_entradas = cantidad_entradas - 1 WHERE id_pase = ? AND cantidad_entradas > 0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPase);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al descontar entrada: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT por ID
    public Pase buscarPasePorId(int idPase) {
        String sql = "SELECT * FROM pases WHERE id_pase = ?";
        Pase pase = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPase);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pase = instanciarPaseDesdeResultSet(rs);
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al buscar pase: " + ex.getMessage());
        }
        return pase;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT ALL: Devuelve todos los pases
    public List<Pase> listarPases() {
        List<Pase> lista = new ArrayList<>();
        String sql = "SELECT * FROM pases";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(instanciarPaseDesdeResultSet(rs));
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al listar pases: " + ex.getMessage());
        }
        return lista;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BAJA LOGICA: Cancela o desactiva un pase
    public void cancelarPase(int idPase) {
        String sql = "UPDATE pases SET estado = 0 WHERE id_pase = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPase);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Pase cancelado con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al cancelar pase: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // METODO AUXILIAR: Mapea ResultSet a objeto Pase
    private Pase instanciarPaseDesdeResultSet(ResultSet rs) throws SQLException {
        Pase pase = new Pase();
        pase.setIdPase(rs.getInt("id_pase"));

        // Ajustar el nombre del método de búsqueda según tu SocioData si es buscarSocio o buscarSocioPorId
        Socio s = socioData.buscarSocioPorId(rs.getInt("id_socio"));
        pase.setSocio(s);

        pase.setCantidadEntradas(rs.getInt("cantidad_entradas"));
        pase.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
        pase.setFechaFin(rs.getDate("fecha_fin").toLocalDate());
        pase.setCosto(rs.getBigDecimal("costo"));
        pase.setEstado(rs.getBoolean("estado"));
        return pase;
    }
}