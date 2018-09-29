package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MateriaDTO {

    @Id
    private int id;
    private String nombre;
    private int creditos;
    private ProfesorDTO profesor;
    //@OneToMany(mappedBy = "materiaDTO")
    //@OneToMany(mappedBy = "materiaDTO", cascade = CascadeType.PERSIST)
    //@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    //@OneToMany(mappedBy = "materiaDTO", cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy = "materiaDTO",cascade = CascadeType.PERSIST)
    //@OneToMany
    //@OneToMany(mappedBy = "materiaDTO", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @OneToMany
     @OneToMany(orphanRemoval=true, cascade={CascadeType.ALL})
    private List<HorarioDTO> horario;
    private CarreraDTO carrera;
    
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

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public List<HorarioDTO> getHorario() {
        return horario;
    }

    public void setHorario(List<HorarioDTO> horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }
}
