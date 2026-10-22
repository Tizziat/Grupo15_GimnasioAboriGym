/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tizzi
 */
public class Entrenador {
    private int idEntrenador;
    private int dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;

    public Entrenador() {
    }

    public Entrenador(int idEntrenador, int dni, String nombre, String apellido, String especialidad, boolean estado) {
        this.idEntrenador = idEntrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
