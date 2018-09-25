package co.edu.uptc.sw2.entidades;

public class Carrera {

    private String nombre;
    private Facultad facultad;
    private int id;

    public Carrera(int id, String nombre, Facultad facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.id = id;
    }

    public Carrera() {
    }
    
    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
