package co.edu.uptc.sw2.servicios;

import c.edu.uptc.sw2.persistencia.Almacenamiento;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MunicipioDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MunicipioLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//@Stateless
@Path("ServicioMunicipio")
public class ServicioMunicipio {
    
    @EJB
    private MunicipioLogica logica;
    
    @GET
    public List<MunicipioDTO> getMunicipio() {
        return logica.getMunicipios();
    }

    @POST
    public MunicipioDTO guardarMunicipio(MunicipioDTO municipio) {
        for (int i = 0; i < logica.getMunicipios().size(); i++) {
            if (logica.getMunicipios().get(i).getId() == (municipio.getId())) {
                logica.getMunicipios().get(i).setNombre(municipio.getNombre());
                return municipio;
            }
        }
        municipio.setId(logica.getMunicipios().size() + 1);
        logica.guardarMunicipio(municipio);
        return municipio;
    }

    @DELETE
    @Path("/{name}")
    public void deleteMunicipio(@PathParam("name") String name) {
        for (int i = 0; i < logica.getMunicipios().size(); i++) {
            if (logica.getMunicipios().get(i).getNombre().equals(name)) {
                logica.eliminarMunicipio(logica.getMunicipios().get(i));
            }
        }
    }
}
