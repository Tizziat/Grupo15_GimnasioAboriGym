package Persistencia;

import Modelo.Asistencia;
import Modelo.ClaseGym;
import Modelo.Conexion;
import Modelo.Pase;
import Modelo.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaData {

    private Connection con = null;
    private SocioData socioData;
    private ClaseGymData claseGymData;
    private PaseData paseData;

    public AsistenciaData() {
        this.con = Conexion.getConexion();
        this.socioData = new SocioData();
        this.claseGymData = new ClaseGymData();
        this.paseData = new PaseData();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSERT INTO asistencia (Registra la entrada con validaciones de socio y pase)
    public void registrarAsistencia(Asistencia asistencia) {
        // El socio debe estar activo
        if (!asistencia.getSocio().isEstado()) {
            JOptionPane.showMessageDialog(null, "El socio se encuentra inactivo.");
            return; // detiene la ejecucion si el socio esta dado de baja
        }

        // El socio debe contar con un pase vigente con clases disponibles
        Pase paseActivo = paseData.obtenerPaseActivoPorSocio(asistencia.getSocio().getIdSocio());
        if (paseActivo == null || paseActivo.getCantidadEntradas() <= 0) {
            JOptionPane.showMessageDialog(null, "El socio no posee un pase activo o no le quedan clases disponibles.");
            return; // detiene la ejecucion si no tiene pase o cupo
        }

        String sql = "INSERT INTO asistencia (ID_Socio, ID_Clase, Fecha_Asistencia) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, asistencia.getSocio().getIdSocio());
            ps.setInt(2, asistencia.getClaseGym().getIdClase());
            ps.setDate(3, Date.valueOf(asistencia.getFechaAsistencia()));

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                asistencia.setIdAsistencia(rs.getInt(1)); // Se lo asignamos al objeto asistencia
                JOptionPane.showMessageDialog(null, "Asistencia registrada con exito. ID: " + asistencia.getIdAsistencia());
                
                // Descontamos un pase disponible del socio
                paseData.descontarEntrada(paseActivo.getIdPase());
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al registrar la asistencia: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // UPDATE asistencia (Modifica un registro existente)
    public void modificarAsistencia(Asistencia asistencia) {
        String sql = "UPDATE asistencia SET ID_Socio = ?, ID_Clase = ?, Fecha_Asistencia = ? WHERE ID_Asistencia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, asistencia.getSocio().getIdSocio());
            ps.setInt(2, asistencia.getClaseGym().getIdClase());
            ps.setDate(3, Date.valueOf(asistencia.getFechaAsistencia()));
            ps.setInt(4, asistencia.getIdAsistencia()); // Condicion WHERE

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Asistencia actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro de asistencia para actualizar.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al modificar asistencia: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DELETE FROM asistencia (Eliminacion fisica del registro)
    public void eliminarAsistencia(int idAsistencia) {
        String sql = "DELETE FROM asistencia WHERE ID_Asistencia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAsistencia);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Registro de asistencia eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la asistencia especificada.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al eliminar asistencia: " + ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT asistencia por ID (Busca una asistencia especifica)
    public Asistencia buscarAsistenciaPorId(int idAsistencia) {
        String sql = "SELECT * FROM asistencia WHERE ID_Asistencia = ?";
        Asistencia asistencia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAsistencia);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                asistencia = instanciarAsistenciaDesdeResultSet(rs);
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al buscar la asistencia: " + ex.getMessage());
        }
        return asistencia;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT ALL: Devuelve todas las asistencias registradas ordenadas cronologicamente
    public List<Asistencia> listarAsistencias() {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencia ORDER BY Fecha_Asistencia DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(instanciarAsistenciaDesdeResultSet(rs)); // Recorremos fila por fila y agregamos a la lista
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al listar las asistencias: " + ex.getMessage());
        }
        return lista;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT por socio: Filtra las asistencias que pertenecen a un socio en particular
    public List<Asistencia> listarPorSocio(int idSocio) {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencia WHERE ID_Socio = ? ORDER BY Fecha_Asistencia DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(instanciarAsistenciaDesdeResultSet(rs));
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al listar asistencias por socio: " + ex.getMessage());
        }
        return lista;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT por Clase: Filtra todas las asistencias registradas a una clase especifica
    public List<Asistencia> listarPorClase(int idClase) {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencia WHERE ID_Clase = ? ORDER BY Fecha_Asistencia DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(instanciarAsistenciaDesdeResultSet(rs));
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al listar asistencias por clase: " + ex.getMessage());
        }
        return lista;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // metodo auxiliar: mapea una fila del ResultSet a un objeto Asistencia
    private Asistencia instanciarAsistenciaDesdeResultSet(ResultSet rs) throws SQLException {
        Asistencia asistencia = new Asistencia();
        asistencia.setIdAsistencia(rs.getInt("ID_Asistencia"));

        //recuperamos las entidades completas relacionadas usando sus respectivas clases 
        Socio s = socioData.buscarSocioPorId(rs.getInt("ID_Socio"));
        ClaseGym c = claseGymData.buscarClasePorId(rs.getInt("ID_Clase"));

        asistencia.setSocio(s);
        asistencia.setClaseGym(c);
        asistencia.setFechaAsistencia(rs.getDate("Fecha_Asistencia").toLocalDate());

        return asistencia;
    }
}