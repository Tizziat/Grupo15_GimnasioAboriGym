package Persistencia;

import Modelo.ClaseGym;
import Modelo.Conexion;
import Modelo.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClaseGymData {

    private Connection con = null;

    public ClaseGymData() {
        this.con = Conexion.getConexion(); // Conectamos a la bdd
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSERT INTO clases (Guarda una nueva clase con las 2 validaciones obligatorias)
    public void guardarClase(ClaseGym clase) {
        // Validacion de Especialidad
        if (!clase.getEntrenador().getEspecialidad().equalsIgnoreCase(clase.getNombre())) {
            JOptionPane.showMessageDialog(null, "La especialidad del entrenador no coincide con la disciplina de la clase.");
            return; // detiene la ejecucion si no coinciden la especialidad y la disciplina
        }

        // Validacion de Horario
        if (entrenadorTieneHorarioOcupado(clase.getEntrenador().getIdEntrenador(), clase.getHorario())) {
            JOptionPane.showMessageDialog(null, "El entrenador ya posee una clase asignada en ese horario.");
            return; // detiene la ejecucion si se superponen los horarios
        }

        clase.setEstado(true); // Alta logica

        String sql = "INSERT INTO clases (Disciplina, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador()); // (fk) 
            ps.setTime(3, Time.valueOf(clase.getHorario())); 
            ps.setInt(4, clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());

            ps.executeUpdate(); 

            ResultSet rs = ps.getGeneratedKeys(); // Obtenemos el ID autogenerado por la bdd
            if (rs.next()) {
                clase.setIdClase(rs.getInt(1)); // Se lo asignamos al objeto clase
                JOptionPane.showMessageDialog(null, "Clase guardada con exito. ID: " + clase.getIdClase());
            }
            ps.close(); // Cerramos el PreparedStatement
        } catch (SQLException ex) {
            System.err.println("Error al guardar la clase: " + ex.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // METODO AUXILIAR: Verifica si el entrenador ya dicta otra clase activa en ese horario
    private boolean entrenadorTieneHorarioOcupado(int idEntrenador, LocalTime horario) {
        String sql = "SELECT COUNT(*) FROM clases WHERE ID_Entrenador = ? AND Horario = ? AND Estado = TRUE";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEntrenador);
            ps.setTime(2, Time.valueOf(horario));
            
            ResultSet rs = ps.executeQuery(); 
            if (rs.next()) {
                int cantidad = rs.getInt(1);
                ps.close();
                return cantidad > 0; // Si devuelve mas de 0 significa que ya tiene clase a esa hora!!!
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al verificar horario del entrenador: " + ex.getMessage());
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT por ID: Busca una clase activa por su clave primaria
    public ClaseGym buscarClasePorId(int id) {
        ClaseGym clase = null;
        String sql = "SELECT c.*, e.Nombre, e.Apellido, e.Especialidad "
                   + "FROM clases c "
                   + "JOIN entrenadores e ON c.ID_Entrenador = e.ID_Entrenador "
                   + "WHERE c.ID_Clase = ? AND c.Estado = TRUE";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clase = instanciarClaseDesdeResultSet(rs); 
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al buscar la clase: " + ex.getMessage());
        }
        return clase;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT ALL (JOIN): Devuelve todas las clases disponibles con los datos de su entrenador
    public List<ClaseGym> listarClasesDisponibles() {
        List<ClaseGym> lista = new ArrayList<>();
        String sql = "SELECT c.*, e.Nombre, e.Apellido, e.Especialidad "
                   + "FROM clases c "
                   + "JOIN entrenadores e ON c.ID_Entrenador = e.ID_Entrenador "
                   + "WHERE c.Estado = TRUE";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) { // 1 Recorremos fila por fila 
                lista.add(instanciarClaseDesdeResultSet(rs)); // 2
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al listar las clases: " + ex.getMessage());
        }
        return lista;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // SELECT por coincidencia exacta de disciplina
    public List<ClaseGym> buscarPorDisciplina(String disciplina) {
        List<ClaseGym> lista = new ArrayList<>();
        String sql = "SELECT c.*, e.Nombre, e.Apellido, e.Especialidad "
                   + "FROM clases c "
                   + "JOIN entrenadores e ON c.ID_Entrenador = e.ID_Entrenador "
                   + "WHERE c.Disciplina = ? AND c.Estado = TRUE";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, disciplina);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(instanciarClaseDesdeResultSet(rs));
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al buscar por disciplina: " + ex.getMessage());
        }
        return lista;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // UPDATE: Modifica los datos de una clase existente en la bdd
    public void modificarClase(ClaseGym clase) {
        String sql = "UPDATE clases SET Disciplina = ?, ID_Entrenador = ?, Horario = ?, Capacidad = ? WHERE ID_Clase = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getIdEntrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4, clase.getCapacidad());
            ps.setInt(5, clase.getIdClase());

            int exito = ps.executeUpdate(); 
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Clase modificada con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al modificar la clase: " + ex.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // BAJA LOGICA: Desactiva la clase cambiando su estado a FALSE sin eliminarla fisicamente
    public void darDeBajaClase(int idClase) {
        String sql = "UPDATE clases SET Estado = FALSE WHERE ID_Clase = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Clase dada de baja exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al dar de baja la clase: " + ex.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // METODO AUXILIAR: Transforma una fila del ResultSet a un objeto ClaseGym con su Entrenador cargado
    private ClaseGym instanciarClaseDesdeResultSet(ResultSet rs) throws SQLException {
        ClaseGym clase = new ClaseGym();
        clase.setIdClase(rs.getInt("ID_Clase"));
        clase.setNombre(rs.getString("Disciplina"));
        clase.setHorario(rs.getTime("Horario").toLocalTime());
        clase.setCapacidad(rs.getInt("Capacidad"));
        clase.setEstado(rs.getBoolean("Estado"));

        // Creamos y asignamos el objeto Entrenador dentro de la Clase 
        Entrenador e = new Entrenador();
        e.setIdEntrenador(rs.getInt("ID_Entrenador"));
        e.setNombre(rs.getString("Nombre"));
        e.setApellido(rs.getString("Apellido"));
        e.setEspecialidad(rs.getString("Especialidad"));

        clase.setEntrenador(e);
        return clase;
    }
}