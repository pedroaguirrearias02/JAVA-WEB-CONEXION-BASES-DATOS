/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MunicipioDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MunicipioDAO {

    @PersistenceContext
    private EntityManager em;

    public List<MunicipioDTO> getMunicipios() {
        String query = "Select e from MunicipioDTO e";
        return em.createQuery(query).getResultList();
    }

    public MunicipioDTO guardarMunicipio(MunicipioDTO municipio) {
        em.persist(municipio);
        return municipio;
    }

    public void eliminarMunicipio(MunicipioDTO municipioDTO) {
        em.remove(em.find(MunicipioDTO.class, municipioDTO.getId()));
    }

    public MunicipioDTO editarMunicipio(MunicipioDTO municipioDTO) throws NamingException, NotSupportedException, SystemException {
        //em.getTransaction().begin();
        em.merge(municipioDTO);
//        MunicipioDTO municipioDTO1 = em.find(MunicipioDTO.class, municipioDTO.getId());
//        municipioDTO1.setNombre(municipioDTO.getNombre());
        em.getTransaction().commit();
        em.close();
        return municipioDTO;
    }
}
