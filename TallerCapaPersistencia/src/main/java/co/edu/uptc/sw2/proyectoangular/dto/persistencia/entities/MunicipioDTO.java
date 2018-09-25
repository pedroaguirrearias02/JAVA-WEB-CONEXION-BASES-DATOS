package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MunicipioDTO {

    private String nombre;
    @Id
    private int id;
    
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
