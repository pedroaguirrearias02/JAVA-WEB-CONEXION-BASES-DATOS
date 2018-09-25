package co.edu.uptc.sw2.entidades;

import java.util.Date;


public class Estudiante {

    private String nombre;
    private String apellidos;
    private String codigo;
    private String documento;
    private Date fechaNacimiento;
    private Carrera carrera;
    private Municipio municipio;
    private int id;

    public Estudiante(int id ,String nombre, String apellidos, String codigo, String documento, Date fechaNacimiento, Carrera carrera, Municipio municipio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.municipio = municipio;
        this.id = id;
    }

    public Estudiante() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
