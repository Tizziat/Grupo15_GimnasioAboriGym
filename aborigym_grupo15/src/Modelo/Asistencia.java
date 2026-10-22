package Modelo;

import java.time.LocalDate;

public class Asistencia {

    private int idAsistencia;
    private Socio socio;
    private ClaseGym claseGym;
    private LocalDate fechaAsistencia;

    public Asistencia() {
    }

    // Para crear una asistencia nueva: la base de datos genera el ID.
    public Asistencia(Socio socio, ClaseGym claseGym,
                      LocalDate fechaAsistencia) {
        this.socio = socio;
        this.claseGym = claseGym;
        this.fechaAsistencia = fechaAsistencia;
    }

    // Para representar una asistencia que ya existe en la base de datos.
    public Asistencia(int idAsistencia, Socio socio, ClaseGym claseGym,
                      LocalDate fechaAsistencia) {
        this.idAsistencia = idAsistencia;
        this.socio = socio;
        this.claseGym = claseGym;
        this.fechaAsistencia = fechaAsistencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public ClaseGym getClaseGym() {
        return claseGym;
    }

    public void setClaseGym(ClaseGym claseGym) {
        this.claseGym = claseGym;
    }

    public LocalDate getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(LocalDate fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }
}
