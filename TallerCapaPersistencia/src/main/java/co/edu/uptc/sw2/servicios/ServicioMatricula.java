package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Matricula;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMatricula")
public class ServicioMatricula {

    @GET
    public ArrayList<Matricula> getMatricula() {
        return Almacenamiento.getInstance().getListMatriculas();
    }

    @POST
    public Matricula guardarMatricula(Matricula matricula) {
        for (int i = 0; i < Almacenamiento.getInstance().getListCarreras().size(); i++) {
            if (Almacenamiento.getInstance().getListMatriculas().get(i).getId() == (matricula.getId())) {
                Almacenamiento.getInstance().getListMatriculas().get(i).setAnnio(matricula.getAnnio());
                Almacenamiento.getInstance().getListMatriculas().get(i).setSemestre(matricula.getSemestre());
                Almacenamiento.getInstance().getListMatriculas().get(i).setMateria(matricula.getMateria());
                Almacenamiento.getInstance().getListMatriculas().get(i).setEstudiante(matricula.getEstudiante());
                return matricula;
            }
        }
        matricula.setId(Almacenamiento.getInstance().getListMatriculas().size() + 1);
        Almacenamiento.getInstance().getListMatriculas().add(matricula);
        return matricula;
    }

    @DELETE
    @Path("/{id}")
    public void deleteMatricula(@PathParam("name") int id) {
        for (int i = 0; i < Almacenamiento.getInstance().getListMatriculas().size(); i++) {
            if (Almacenamiento.getInstance().getListMatriculas().get(i).getId() == id) {
                Almacenamiento.getInstance().getListMatriculas().remove(i);
            }
        }
    }
}
