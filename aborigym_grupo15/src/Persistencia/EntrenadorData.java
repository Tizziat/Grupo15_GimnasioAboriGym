package Persistencia;

import Modelo.Conexion;
import Modelo.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public ArrayList<Entrenador> listarEntrenadores(){
        ArrayList<Entrenador> lista = new ArrayList<>();
            
        String sql = "SELECT * FROM entrenadores";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Entrenador entrenador = new Entrenador();
                
                entrenador.setIdEntrenador(rs.getInt("id_entrenador"));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad"));
                entrenador.setEstado(rs.getBoolean("estado"));
                
                lista.add(entrenador);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException ex) {
        System.out.println("Error al listar entrenadores: " + ex.getMessage());
        }    
    return lista;
    }
    
    public Entrenador buscarEntrenador (String dni){
        String sql = "SELECT * FROM entrenadores WHERE dni = ?";
        Entrenador entrenador = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);//2
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();//3
            
            if (rs.next()) {
                entrenador = new Entrenador();
                entrenador.setIdEntrenador(rs.getInt("id_entrenador"));
                entrenador.setDni(rs.getString("dni"));
                entrenador.setNombre(rs.getString("nombre"));
                entrenador.setApellido(rs.getString("apellido"));
                entrenador.setEspecialidad(rs.getString("especialidad")); // Esta es la nueva
                entrenador.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar entrenador: " + ex.getMessage());
        }
        return entrenador;
                
    }
    
    public void altaLogica(int id) {
        String sql = "UPDATE entrenadores SET estado = 1 WHERE id_entrenador = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Se dio de alta el entrenador con ID: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void bajaLogica(int id) {
        String sql = "UPDATE entrenadores SET estado = 0 WHERE id_entrenador = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Se dio de baja el entrenador con ID: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void borrarEntrenador(int id) {
        String sql = "DELETE FROM entrenadores WHERE id_entrenador = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Entrenador eliminado físicamente de la base de datos.");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar el entrenador: " + ex.getMessage());
        }
    }
    public void actualizarEntrenador(Entrenador e) {
    String sql = "UPDATE entrenadores SET dni = ?, nombre = ?, apellido = ?, "
        + "especialidad = ?, estado = ? WHERE id_entrenador = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, e.getDni());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellido());
        ps.setString(4, e.getEspecialidad());
        ps.setBoolean(5, e.isEstado());
        ps.setInt(6, e.getIdEntrenador());
        
        int exito = ps.executeUpdate();

        if (exito == 1) {
            System.out.println("Entrenador actualizado correctamente.");
        } else {
            System.out.println("No se encontro el entrenador.");
        }

        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al actualizar entrenador: " + ex.getMessage());
    }
}
}
