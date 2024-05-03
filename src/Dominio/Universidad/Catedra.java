package Dominio.Universidad;


import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Catedra {
    private int id;
    private String aula;
    private int capacidad;
    private String turno;
    private String dia;
    private List<Docente> docentes;
    private List<Estudiante> alumnosInscriptos;

    private Materia materia;

    public Catedra() {
        docentes = new ArrayList<>();
        alumnosInscriptos = new ArrayList<Estudiante>();
    }

    public Catedra(int id, String aula, String dia, String turno){
        this.id = id;
        this.aula = aula;
        this.dia = dia;
        this.turno = turno;
        docentes = new ArrayList<>();
        alumnosInscriptos = new ArrayList<Estudiante>();
    }

    public void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public void agregarAlumno(Estudiante Estudiante) {
        alumnosInscriptos.add(Estudiante);
    }

    public Materia getMateria() {
        return materia;
    }

    public int getCargaHoraria() {
        return materia.getCargaHoraria();
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString(){
        return "\n id:"+id+"\n aula:"+aula+"\n turno:"+turno+"\n dia:"+dia+Integer.valueOf(alumnosInscriptos.size());
    }
}
