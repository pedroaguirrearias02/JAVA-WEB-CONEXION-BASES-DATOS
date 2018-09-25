package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Facultad;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioFacultad")
public class ServicioFacultad {

    @GET
    public ArrayList<Facultad> getFacultad() {
        return Almacenamiento.getInstance().getListFacultads();
    }

   @POST
    public Facultad guardarFacultad(Facultad facultad) {
        for (int i = 0; i < Almacenamiento.getInstance().getListFacultads().size(); i++) {
            if (Almacenamiento.getInstance().getListFacultads().get(i).getId() == (facultad.getId())) {
                Almacenamiento.getInstance().getListFacultads().get(i).setNombre(facultad.getNombre());
                return facultad;
            }
        }
        facultad.setId(Almacenamiento.getInstance().getListFacultads().size() + 1);
        Almacenamiento.getInstance().getListFacultads().add(facultad);
        return facultad;
    }
    
    @DELETE
    @Path("/{name}")
    public void deleteFacultad(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListFacultads().size(); i++) {
            if (Almacenamiento.getInstance().getListFacultads().get(i).getNombre().equals(name)) {
                Almacenamiento.getInstance().getListFacultads().remove(i);
            }
        }
    }
}
