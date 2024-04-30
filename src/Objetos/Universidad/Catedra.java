package Objetos.Universidad;

import Objetos.Usuarios.Alumno;
import Objetos.Usuarios.Docente;

import java.util.ArrayList;
import java.util.List;

public class Catedra {
    private int id;
    private String aula;
    private int capacidad;
    private String turno;
    private String dia;
    private List<Docente> docentes;
    private List<Alumno> alumnosInscriptos;
    private Materia materia;

    public Catedra() {
        docentes = new ArrayList<>();
        alumnosInscriptos = new ArrayList<>();
    }

    // No necesitamos setters para las listas, ya que las inicializamos en el constructor

    public void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnosInscriptos.add(alumno);
    }
}
