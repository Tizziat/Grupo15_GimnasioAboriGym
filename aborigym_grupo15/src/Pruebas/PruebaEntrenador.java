
package Pruebas;

import Modelo.Entrenador;
import Persistencia.EntrenadorData;

public class PruebaEntrenador {

    public static void main(String[] args) {
        EntrenadorData data = new EntrenadorData();
        String dniPrueba = "34567768";

        // se guard solo si  no existe.
        Entrenador encontrado = data.buscarEntrenador(dniPrueba);

        if (encontrado == null) {
            Entrenador nuevo = new Entrenador(
                    dniPrueba, "Ana", "Prueba", "Pilates", true
            );
            data.guardarEntrenador(nuevo);
        }

        // Comprobamos que la búsqueda traiga también la especialidad.
        encontrado = data.buscarEntrenador(dniPrueba);
        
        // Prueba anterior: mostrar el entrenador encontrado.
// if (encontrado != null) {
//     System.out.println("Encontrado: " + encontrado.getNombre()
//             + " - Especialidad: " + encontrado.getEspecialidad());
// }

// Prueba nueva: actualizar la especialidad y volver a buscarla.
        if (encontrado != null) {
            System.out.println("Especialidad antes: " + encontrado.getEspecialidad());

            encontrado.setEspecialidad("Spinning");
            data.actualizarEntrenador(encontrado);

            Entrenador actualizado = data.buscarEntrenador(dniPrueba);
            System.out.println("Especialidad después: "
                    + actualizado.getEspecialidad());
        }

        // Comprobamos que el listado lea la tabla entrenadores.
        for (Entrenador entrenador : data.listarEntrenadores()) {
            System.out.println("Listado: " + entrenador.getNombre()
                    + " " + entrenador.getApellido());
        }
    }
}
