package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Horario;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioHorario")
public class ServicioHorario {

    @GET
    public ArrayList<Horario> getHorarios() {
        return Almacenamiento.getInstance().getListHorarios();
    }

    @POST
    public Horario guardarHorario(Horario horario) {
        for (int i = 0; i < Almacenamiento.getInstance().getListHorarios().size(); i++) {
            if (Almacenamiento.getInstance().getListHorarios().get(i).getId() == (horario.getId())) {
                Almacenamiento.getInstance().getListHorarios().get(i).setDia(horario.getDia());
                Almacenamiento.getInstance().getListHorarios().get(i).setHoraInicio(horario.getHoraInicio());
                Almacenamiento.getInstance().getListHorarios().get(i).setHoraFin(horario.getHoraFin());
                return horario;
            }
        }
        horario.setId(Almacenamiento.getInstance().getListHorarios().size() + 1);
        Almacenamiento.getInstance().getListHorarios().add(horario);
        return horario;
    }

    @DELETE
    @Path("/{id}")
    public void deleteHorario(@PathParam("id") int id) {
        for (int i = 0; i < Almacenamiento.getInstance().getListHorarios().size(); i++) {
            if (Almacenamiento.getInstance().getListHorarios().get(i).getId() == id) {
                Almacenamiento.getInstance().getListHorarios().remove(i);
                break;
            }
        }
    }
}
