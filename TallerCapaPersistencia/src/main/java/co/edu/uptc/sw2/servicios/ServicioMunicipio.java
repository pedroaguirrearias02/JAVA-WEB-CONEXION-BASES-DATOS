package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.entidades.Municipio;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMunicipio")
public class ServicioMunicipio {

    @GET
    public ArrayList<Municipio> getMunicipio() {
        return Almacenamiento.getInstance().getListMunicipios();
    }

    @POST
    public Municipio guardarMunicipio(Municipio municipio) {
        for (int i = 0; i < Almacenamiento.getInstance().getListMunicipios().size(); i++) {
            if (Almacenamiento.getInstance().getListMunicipios().get(i).getId() == (municipio.getId())) {
                Almacenamiento.getInstance().getListMunicipios().get(i).setNombre(municipio.getNombre());
                return municipio;
            }
        }
        municipio.setId(Almacenamiento.getInstance().getListMunicipios().size() + 1);
        Almacenamiento.getInstance().getListMunicipios().add(municipio);
        return municipio;
    }

    @DELETE
    @Path("/{name}")
    public void deleteMunicipio(@PathParam("name") String name) {
        for (int i = 0; i < Almacenamiento.getInstance().getListMunicipios().size(); i++) {
            if (Almacenamiento.getInstance().getListMunicipios().get(i).getNombre().equals(name)) {
                Almacenamiento.getInstance().getListMunicipios().remove(i);
            }
        }
    }
}
