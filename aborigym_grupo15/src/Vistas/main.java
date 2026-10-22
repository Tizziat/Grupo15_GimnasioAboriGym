package Vistas;

import Modelo.Socio;
import Persistencia.SocioData;


public class main {

    
    public static void main(String[] args) {
       System.out.println("=== TEST POR CONSOLA ===");

        // se declara la variable socioData e instanciamos el objeto (aca se conecta el objeto con la base de datos cuando el constructor llama a Conexion.getConexion)
        SocioData socioData = new SocioData();

        // guardarSocio
        System.out.println("\n------------------------------------------------");
        System.out.println("1. PRUEBA: Guardar socio");
        System.out.println("------------------------------------------------");
        
        // Creamos un socio  (el ID no va por que lo genera la bdd)
        Socio nuevoSocio = new Socio("45982786", "Tiziano", "Tobares", 21, "tizzitobares@gmail.com", "2664754242", true);
        
        // aca se ejecuta el guardado del socio
        socioData.guardarSocio(nuevoSocio);

        // buscarSocio (lo buscamos por el dni)
        System.out.println("\n------------------------------------------------");
        System.out.println("2. PRUEBA: Buscar socio");
        System.out.println("------------------------------------------------");
        
        String dniABuscar = "45982786";
        // aca se ejecuta la busqueda del socio
        Socio socioEncontrado = socioData.buscarSocio(dniABuscar);

        if (socioEncontrado != null) {
            System.out.println("¡Socio encontrado con éxito!");
            System.out.println("ID: " + socioEncontrado.getIdSocio());
            System.out.println("Nombre: " + socioEncontrado.getNombre() + " " + socioEncontrado.getApellido());
        } else {
            System.out.println("No se encontró ningún socio con DNI: " + dniABuscar);
        }

    }
}
    
