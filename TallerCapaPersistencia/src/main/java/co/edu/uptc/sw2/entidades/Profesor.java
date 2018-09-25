package co.edu.uptc.sw2.entidades;

public class Profesor {

    private int id;
    private String nombres;
    private String apellidos;
    private String documento;

    public Profesor() {
    }

    public Profesor(int id, String nombres, String apellidos, String documento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
