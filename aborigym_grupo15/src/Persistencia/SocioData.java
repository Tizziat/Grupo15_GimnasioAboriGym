package Persistencia;

import Modelo.Conexion;
import Modelo.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SocioData {
    
    private Connection con = null;

    public SocioData() {
        // conexion a la base de datos
        this.con = Conexion.getConexion();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSERT INTO socio
    public void guardarSocio (Socio s){
        String sql = "INSERT INTO socios (dni, nombre, apellido, edad, correo, telefono, estado) VALUES (?,?,?,?,?,?,?)";//1
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//2
            ps.setString(1, s.getDni());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getApellido());
            ps.setInt(4, s.getEdad());
            ps.setString(5, s.getCorreo());
            ps.setString(6, s.getTelefono());
            ps.setBoolean(7, s.isEstado());
            
            ps.executeUpdate();//3
            
            ResultSet rs = ps.getGeneratedKeys();// id generado por la bdd
            if (rs.next()) {
                s.setIdSocio(rs.getInt(1)); // se lo asignamos al objeto socio
                System.out.println("Socio guardado con exito. ID: " + s.getIdSocio());
            }
            ps.close();
        } catch (SQLException ex) {
            System.err.println("Error al guardar el socio: " + ex.getMessage());
        }
    }
    
    public Socio buscarSocio (String dni){
        String sql = "SELECT * FROM socios WHERE dni = ?";
        Socio socio = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);//2
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();//3
            
            if (rs.next()) {
                socio = new Socio();
                socio.setIdSocio(rs.getInt("id_socio"));
                socio.setDni(rs.getString("dni"));
                socio.setNombre(rs.getString("nombre"));
                socio.setApellido(rs.getString("apellido"));
                socio.setEdad(rs.getInt("edad"));
                socio.setCorreo(rs.getString("correo"));
                socio.setTelefono(rs.getString("telefono"));
                socio.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar socio: " + ex.getMessage());
        }
        return socio;
    }   
     public void altaLogica(int id) {
        String sql = "UPDATE socios SET estado = 1 WHERE id_socio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Se dio de alta el socio con ID: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
     public void bajaLogica(int id) {
        String sql = "UPDATE socios SET estado = 0 WHERE id_socio = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Se dio de baja el socio con ID: " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
     public void borrarSocio(int id) {
        String sql = "DELETE FROM socios WHERE id_socio= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Socio eliminado físicamente de la base de datos.");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al borrar el Socio: " + ex.getMessage());
        }
    }
}



    



    
    

