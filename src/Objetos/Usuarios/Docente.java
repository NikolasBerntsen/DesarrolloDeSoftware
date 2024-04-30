package Objetos.Usuarios;
import Objetos.Universidad.Catedra;

import java.util.List;

public class Docente extends Usuario {
    private List<Catedra> horarioSemanal;

    // Constructor, getters y setters

    public void crearInforme() {
        // Implementación del método
    }

    public List<Catedra> getHorarioSemanal() {
        return horarioSemanal;
    }//messi
}
