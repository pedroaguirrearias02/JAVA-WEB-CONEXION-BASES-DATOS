package co.edu.uptc.sw2.entidades;

public class Municipio {

    private String nombre;
    private int id;

    public Municipio() {
    }

    public Municipio(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
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
