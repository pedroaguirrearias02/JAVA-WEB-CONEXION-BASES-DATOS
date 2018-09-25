package co.edu.uptc.sw2.entidades;

public class Facultad {

    private String nombre;
    private int id;
    
    public Facultad(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public Facultad() {
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
