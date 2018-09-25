package co.edu.uptc.sw2.entidades;

import java.util.ArrayList;

public class Materia {

    private int id;
    private String nombre;
    private int creditos;
    private Profesor profesor;
    private ArrayList<Horario> horario;
    private Carrera carrera;
    
    public Materia(int id, String nombre, int creditos, ArrayList<Horario> horario, Profesor profesor, Carrera carrera) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.profesor = profesor;
        this.horario = horario;
        this.id = id;
        this.carrera = carrera;
    }

    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Horario> getHorario() {
        return horario;
    }

    public void setHorario(ArrayList<Horario> horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
