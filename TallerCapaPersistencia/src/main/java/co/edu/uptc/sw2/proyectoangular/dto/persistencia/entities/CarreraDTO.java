package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import co.edu.uptc.sw2.entidades.*;
import javax.ejb.Stateless;
import javax.persistence.Id;

@Stateless
public class CarreraDTO {

    private String nombre;
    private Facultad facultad;
    @Id
    private int id;

    public CarreraDTO(int id, String nombre, Facultad facultad) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.id = id;
    }

    public CarreraDTO() {
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
