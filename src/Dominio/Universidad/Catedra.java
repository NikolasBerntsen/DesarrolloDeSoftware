package Dominio.Universidad;


import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;
import Dominio.utils.Turno;

import java.util.ArrayList;
import java.util.List;

public class Catedra {
    private int id;
    private int aula;
    private int capacidad;
    private Turno turno;
    private String dia;
    private List<Docente> docentes;
    private List<Estudiante> alumnosInscriptos;
    private Materia materia;

    public Catedra() {
        docentes = new ArrayList<>();
        alumnosInscriptos = new ArrayList<Estudiante>();
    }
    public Catedra(
            int id,
            int aula,
            int capacidad,
            String turno,
            int horaInicio,
            int horaFinal,
            String dia
    ) {
        this.id = id;
        this.aula = aula;
        this.capacidad = capacidad;
        setTurno(turno,horaInicio,horaFinal);
        this.dia = dia;
        docentes = new ArrayList<>();
        alumnosInscriptos = new ArrayList<Estudiante>();
    }

    public Catedra(
            int id,
            int aula,
            String dia,
            String turno,
            int horaInicio,
            int horaFinal
    ){
        this.id = id;
        this.aula = aula;
        this.dia = dia;
        setTurno(turno,horaInicio,horaFinal);
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

    public void setID(int id) {
        this.id = id;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTurno(String turno, int HoraInicio, int HoraFinal) {
        Turno turno1 = new Turno();
        turno1.cargarTurno(turno, HoraInicio, HoraFinal);
        this.turno = turno1;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCantidadInscriptos(){
        return alumnosInscriptos.size();
    }

    @Override
    public String toString(){
        return "\n id:"+id+"\n aula:"+aula+"\n turno:"+turno+"\n dia:"+dia+Integer.valueOf(alumnosInscriptos.size());
    }

    public int getId() {
        return id;
    }
}
