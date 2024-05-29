package Dominio.Usuarios;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Materia;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario {
    private String carrera;
    private List<Materia> materiasAprobadas;
    private List<Catedra> catedrasInscriptas;
    private int cargaHoraria;

    public Estudiante() {
        materiasAprobadas = new ArrayList<>();
        catedrasInscriptas = new ArrayList<>();
    }

    public Estudiante(String nombre, int legajo, int DNI, String carrera){
        this.nombre = nombre;
        this.legajo = legajo;
        this.DNI = DNI;
        this.carrera = carrera;
        materiasAprobadas = new ArrayList<>();
        catedrasInscriptas = new ArrayList<>();
    }

    public String getCarrera() {
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

    public void inscribirA(Catedra catedra) {
        catedrasInscriptas.add(catedra);
        calcularCargaHoraria();
    }

    public void bajarDe(Catedra catedra) {
        catedrasInscriptas.remove(catedra);
        calcularCargaHoraria();
    }

    public void addAprobada(Materia materia) {
        materiasAprobadas.add(materia);
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    private void calcularCargaHoraria() {
        cargaHoraria = 0;
        for (Catedra catedra : catedrasInscriptas) {
            cargaHoraria += catedra.getMateria().getCargaHoraria();
        }
    }
}
