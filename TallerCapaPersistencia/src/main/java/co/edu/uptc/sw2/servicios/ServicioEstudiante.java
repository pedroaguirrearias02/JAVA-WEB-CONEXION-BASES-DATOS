package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Estudiante;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioEstudiante")
public class ServicioEstudiante {

    public ServicioEstudiante() {
    }

    @GET
    public ArrayList<Estudiante> consultarEstudiante() {
        return Almacenamiento.getInstance().getListEstudiantes();
    }

    @POST
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < Almacenamiento.getInstance().getListEstudiantes().size(); i++) {
            if (Almacenamiento.getInstance().getListEstudiantes().get(i).getId() == (estudiante.getId())) {
                Almacenamiento.getInstance().getListEstudiantes().get(i).setNombre(estudiante.getNombre());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setApellidos(estudiante.getApellidos());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setCodigo(estudiante.getCodigo());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setDocumento(estudiante.getDocumento());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setFechaNacimiento(estudiante.getFechaNacimiento());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setCarrera(estudiante.getCarrera());
                Almacenamiento.getInstance().getListEstudiantes().get(i).setMunicipio(estudiante.getMunicipio());
                return estudiante;
            }
        }
        estudiante.setId(Almacenamiento.getInstance().getListEstudiantes().size() + 1);
        Almacenamiento.getInstance().getListEstudiantes().add(estudiante);
        return estudiante;
    }

    @DELETE
    @Path("/{name}")
    public void deleteEstudiante(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListEstudiantes().size(); i++) {
            if (Almacenamiento.getInstance().getListEstudiantes().get(i).getNombre().equals(name)) {
                Almacenamiento.getInstance().getListEstudiantes().remove(i);
            }
        }
    }
}
