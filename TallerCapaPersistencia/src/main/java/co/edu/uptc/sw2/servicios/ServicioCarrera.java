package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Carrera;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioCarrera")
public class ServicioCarrera {

    @GET
    public ArrayList<Carrera> getCarrera() {
        return Almacenamiento.getInstance().getListCarreras();
    }

    @POST
    public Carrera guardarCarrera(Carrera carrera) {
        for (int i = 0; i < Almacenamiento.getInstance().getListCarreras().size(); i++) {
            if (Almacenamiento.getInstance().getListCarreras().get(i).getId() == (carrera.getId())) {
                Almacenamiento.getInstance().getListCarreras().get(i).setNombre(carrera.getNombre());
                Almacenamiento.getInstance().getListCarreras().get(i).setFacultad(carrera.getFacultad());
                return carrera;
            }
        }
        carrera.setId(Almacenamiento.getInstance().getListCarreras().size() + 1);
        Almacenamiento.getInstance().getListCarreras().add(carrera);
        return carrera;
    }

    @DELETE
    @Path("/{name}")
    public void deleteCarrera(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListCarreras().size(); i++) {
            if (Almacenamiento.getInstance().getListCarreras().get(i).getNombre().equals(name)) {
                Almacenamiento.getInstance().getListCarreras().remove(i);
            }
        }
    }
}
