/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MunicipioDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public MunicipioDTO editarMunicipio(MunicipioDTO municipioDTO){
        em.merge(municipioDTO);
//        eliminarMunicipio(municipioDTO);
//        em.persist(municipioDTO);
//        UserTransaction transaction = (UserTransaction) em.getTransaction();//(UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
//        transaction.begin();
//        MunicipioDTO employee = em.find(MunicipioDTO.class, municipioDTO.getId());
//        employee.setNombre(municipioDTO.getNombre());
//        String query = "update MunicipioDTO set nombre='"+municipioDTO.getNombre()+"' where id="+municipioDTO.getId();
//        em.createQuery(query).executeUpdate();
//        em.createQuery(query).executeUpdate();
//        em.getTransaction().commit();
//        em.merge(employee);
//        transaction.commit();
//        em.getTransaction().commit();
        return municipioDTO;
    }
}
