package Dominio.Usuarios;

import Dominio.Universidad.Catedra;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario {
    private List<Catedra> horarioSemanal;

    // Constructor
    public Docente(String nombre, int legajo, int DNI) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.DNI = DNI;
        this.horarioSemanal = new ArrayList<>();
    }

    // Método para agregar una catedra al horario semanal del docente
    public void agregarCatedra(Catedra catedra) {
        horarioSemanal.add(catedra);
    }

    // Método para quitar una catedra del horario semanal del docente
    public void quitarCatedra(Catedra catedra) {
        horarioSemanal.remove(catedra);
    }

    // Getter para el horario semanal
    public List<Catedra> getHorarioSemanal() {
        return horarioSemanal;
    }
}
