package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import co.edu.uptc.sw2.entidades.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarreraDTO {

    private String nombre;
    private FacultadDTO facultad;
    @Id
    private int id;
    
    public FacultadDTO getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadDTO facultad) {
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
