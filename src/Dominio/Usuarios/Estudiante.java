package Dominio.Usuarios;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Materia;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private Carrera carrera;
    private List<Materia> materiasAprobadas;
    private List<Catedra> catedrasInscriptas;
    private int cargaHoraria;
    public Estudiante(){
        materiasAprobadas = new ArrayList<Materia>();
        catedrasInscriptas = new ArrayList<Catedra>();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public List<Catedra> getCatedrasInscriptas() {
        return catedrasInscriptas;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void inscribirA(Catedra catedra){
        catedrasInscriptas.add(catedra);
    }

    public void bajarDe(Catedra catedra) {
        catedrasInscriptas.remove(catedra);
    }
    public void addAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }
}
