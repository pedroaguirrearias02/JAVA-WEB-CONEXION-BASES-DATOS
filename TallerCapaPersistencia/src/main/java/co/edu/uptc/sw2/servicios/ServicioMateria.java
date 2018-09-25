package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Horario;
import co.edu.uptc.sw2.entidades.Materia;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMateria")
public class ServicioMateria {

    @DELETE
    @Path("/eliminarHorario")
    public void eliminarHorario(Horario horario) {
        Materia materia = null;
        System.out.println("este es el horario eliminado: "+horario);
        for (int i = 0; i < Almacenamiento.getInstance().getListMaterias().size(); i++) {
            for (int j = 0; j < Almacenamiento.getInstance().getListMaterias().get(i).getHorario().size(); j++) {
                if (Almacenamiento.getInstance().getListMaterias().get(i).getHorario().get(j).getId() == horario.getId()) {
                    Almacenamiento.getInstance().getListMaterias().get(i).getHorario().remove(horario);
                    materia = Almacenamiento.getInstance().getListMaterias().get(i);
                    break;
                }
            }
        }
    }

    @GET
    public ArrayList<Materia> getMaterias() {
        return Almacenamiento.getInstance().getListMaterias();
    }

    @POST
    public Materia guardarMateria(Materia materia) {
        for (int i = 0; i < Almacenamiento.getInstance().getListMaterias().size(); i++) {
            if (Almacenamiento.getInstance().getListMaterias().get(i).getId() == (materia.getId())) {
                Almacenamiento.getInstance().getListMaterias().get(i).setNombre(materia.getNombre());
                Almacenamiento.getInstance().getListMaterias().get(i).setCreditos(materia.getCreditos());
                Almacenamiento.getInstance().getListMaterias().get(i).setProfesor(materia.getProfesor());
                Almacenamiento.getInstance().getListMaterias().get(i).setHorario(materia.getHorario());
                Almacenamiento.getInstance().getListMaterias().get(i).setCarrera(materia.getCarrera());
                return materia;
            }
        }
        materia.setId(Almacenamiento.getInstance().getListMaterias().size() + 1);
        Almacenamiento.getInstance().getListMaterias().add(materia);
        return materia;
    }

    @DELETE
    @Path("/{name}")
    public void deleteMateria(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListMaterias().size(); i++) {
            if (Almacenamiento.getInstance().getListMaterias().get(i).getNombre().equals(name)) {
                Almacenamiento.getInstance().getListMaterias().remove(i);
            }
        }
    }

}
