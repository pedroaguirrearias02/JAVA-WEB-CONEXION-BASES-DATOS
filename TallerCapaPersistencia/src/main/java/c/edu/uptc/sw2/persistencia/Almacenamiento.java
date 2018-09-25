package c.edu.uptc.sw2.persistencia;

import co.edu.uptc.sw2.entidades.Carrera;
import co.edu.uptc.sw2.entidades.Estudiante;
import co.edu.uptc.sw2.entidades.Facultad;
import co.edu.uptc.sw2.entidades.Horario;
import co.edu.uptc.sw2.entidades.Materia;
import co.edu.uptc.sw2.entidades.Matricula;
import co.edu.uptc.sw2.entidades.Municipio;
import co.edu.uptc.sw2.entidades.Profesor;
import java.util.ArrayList;
import java.util.Date;

public class Almacenamiento {

    private static final Almacenamiento INSTANCE = new Almacenamiento();
    private ArrayList<Estudiante> listEstudiantes;
    private ArrayList<Carrera> listCarreras;
    private ArrayList<Facultad> listFacultads;
    private ArrayList<Materia> listMaterias;
    private ArrayList<Matricula> listMatriculas;
    private ArrayList<Municipio> listMunicipios;
    private ArrayList<Profesor> listProfesors;
    private ArrayList<Horario> listHorarios;

    public static Almacenamiento getInstance() {
        return INSTANCE;
    }

    public Almacenamiento() {
        this.listEstudiantes = new ArrayList<>();
        this.listCarreras = new ArrayList<>();
        this.listFacultads = new ArrayList<>();
        this.listMaterias = new ArrayList<>();
        this.listMatriculas = new ArrayList<>();
        this.listMunicipios = new ArrayList<>();
        this.listProfesors = new ArrayList<>();
        this.listHorarios = new ArrayList<>();

        this.listMunicipios.add(new Municipio(1, "Umbita"));
        this.listMunicipios.add(new Municipio(2, "Tunja"));
        this.listMunicipios.add(new Municipio(3, "Duitama"));
//        this.listMunicipios.add(new Municipio("Sogamoso"));

        listFacultads.add(new Facultad(1, "Ingenieria"));
        listFacultads.add(new Facultad(2, "Ciencias"));
        listFacultads.add(new Facultad(3, "Educacion"));
        listFacultads.add(new Facultad(4, "Ciencias Economicas y Administrativas"));

        this.listProfesors.add(new Profesor(1, "Daniela", "Torres", "1234"));
        this.listProfesors.add(new Profesor(2, "Pedro", "Aguirre", "1234"));
        this.listCarreras.add(new Carrera(1, "Ingenieria de Sistemas", listFacultads.get(0)));
        this.listCarreras.add(new Carrera(2, "Fisica", listFacultads.get(1)));

        this.listHorarios.add(new Horario(1, 2, new Date(), new Date()));
        this.listHorarios.add(new Horario(2, 3, new Date(), new Date()));
        this.listMaterias.add(new Materia(1, "Ing Software", 4, listHorarios, listProfesors.get(0), listCarreras.get(0)));

        listEstudiantes.add(new Estudiante(1, "Daniela", "Torres", "2015", "1049", new Date(), listCarreras.get(0), listMunicipios.get(0)));
    }

    public ArrayList<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(ArrayList<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public ArrayList<Carrera> getListCarreras() {
        return listCarreras;
    }

    public void setListCarreras(ArrayList<Carrera> listCarreras) {
        this.listCarreras = listCarreras;
    }

    public ArrayList<Facultad> getListFacultads() {
        return listFacultads;
    }

    public void setListFacultads(ArrayList<Facultad> listFacultads) {
        this.listFacultads = listFacultads;
    }

    public ArrayList<Materia> getListMaterias() {
        return listMaterias;
    }

    public void setListMaterias(ArrayList<Materia> listMaterias) {
        this.listMaterias = listMaterias;
    }

    public ArrayList<Matricula> getListMatriculas() {
        return listMatriculas;
    }

    public void setListMatriculas(ArrayList<Matricula> listMatriculas) {
        this.listMatriculas = listMatriculas;
    }

    public ArrayList<Municipio> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(ArrayList<Municipio> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public ArrayList<Profesor> getListProfesors() {
        return listProfesors;
    }

    public void setListProfesors(ArrayList<Profesor> listProfesors) {
        this.listProfesors = listProfesors;
    }

    public ArrayList<Horario> getListHorarios() {
        return listHorarios;
    }

    public void setListHorarios(ArrayList<Horario> listHorarios) {
        this.listHorarios = listHorarios;
    }
}
