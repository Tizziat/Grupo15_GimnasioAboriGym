package Pruebas;

import Modelo.Asistencia;
import Modelo.ClaseGym;
import Modelo.Entrenador;
import Modelo.Socio;
import Persistencia.AsistenciaData;
import Persistencia.ClaseGymData;
import Persistencia.EntrenadorData;
import Persistencia.SocioData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PruebaAsistencia {

    public static void main(String[] args) {
        AsistenciaData asistenciaData = new AsistenciaData();
        ClaseGymData claseData = new ClaseGymData();

        // Prueba 1 (anterior): listar asistencias
        System.out.println("Cantidad de asistencias: "
                + asistenciaData.listarAsistencias().size());

        // Prueba 2: control de cupo
        // 1. Buscamos una clase de Spinning; si no existe, la creamos con capacidad 1
        List<ClaseGym> clases = claseData.buscarPorDisciplina("Spinning");
        ClaseGym clase;
        if (clases.isEmpty()) {
            Entrenador ana = new EntrenadorData().buscarEntrenador("34567768");
            clase = new ClaseGym("Spinning", ana, LocalTime.of(18, 0), 1, true);
            claseData.guardarClase(clase);
        } else {
            clase = clases.get(0);
        }
        System.out.println("Clase ID " + clase.getIdClase()
                + " - capacidad: " + clase.getCapacidad());

        // 2. Traemos al socio 1 completo (con su estado) desde la base
        Socio socio = new SocioData().buscarSocioPorId(1);
        if (socio == null) {
            System.out.println("No existe el socio con ID 1.");
            return;
        }

        // 3. Intentamos anotarlo dos veces hoy: la segunda tiene que rechazarse
        Asistencia primera = new Asistencia(socio, clase, LocalDate.now());
        asistenciaData.registrarAsistencia(primera);

        Asistencia segunda = new Asistencia(socio, clase, LocalDate.now());
        asistenciaData.registrarAsistencia(segunda);

        System.out.println("Asistencias de hoy en esa clase: "
                + asistenciaData.contarAsistenciasPorClaseYFecha(
                        clase.getIdClase(), LocalDate.now()));
    }
}