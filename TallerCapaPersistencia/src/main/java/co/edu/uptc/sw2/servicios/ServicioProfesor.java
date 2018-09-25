package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Profesor;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioProfesor")
public class ServicioProfesor {

    @GET
    public ArrayList<Profesor> getProfesors() {
        return Almacenamiento.getInstance().getListProfesors();
    }

    @POST
    public Profesor guardarProfesor(Profesor profesor) {
        for (int i = 0; i < Almacenamiento.getInstance().getListProfesors().size(); i++) {
            if (Almacenamiento.getInstance().getListProfesors().get(i).getId() == profesor.getId()) {
                Almacenamiento.getInstance().getListProfesors().get(i).setNombres(profesor.getNombres());
                Almacenamiento.getInstance().getListProfesors().get(i).setApellidos(profesor.getApellidos());
                Almacenamiento.getInstance().getListProfesors().get(i).setDocumento(profesor.getDocumento());
                return profesor;
            }
        }
        profesor.setId(Almacenamiento.getInstance().getListProfesors().size() + 1);
        Almacenamiento.getInstance().getListProfesors().add(profesor);
        return profesor;
    }

    @DELETE
    @Path("/{name}")
    public void deleteProfesor(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListProfesors().size(); i++) {
            if (Almacenamiento.getInstance().getListProfesors().get(i).getNombres().equals(name)) {
                Almacenamiento.getInstance().getListProfesors().remove(i);
                break;
            }
        }
    }
}
