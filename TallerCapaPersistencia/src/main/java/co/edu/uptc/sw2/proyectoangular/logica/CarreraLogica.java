/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.CarreraDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacultadDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.CarreraDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.FacultadDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */

@Stateless
public class CarreraLogica {
    
    @EJB
    private CarreraDAO carreraDAO;
    
    public List<CarreraDTO> getFacultades(){
        return carreraDAO.getCarrera();
    }
    
    public CarreraDTO guardarFacultad(CarreraDTO carreraDTO){
        return carreraDAO.guardarCarrera(carreraDTO);
    }
    
    public void eliminarFacultad(CarreraDTO carreraDTO){
        carreraDAO.eliminarCarrera(carreraDTO);
    }
}
