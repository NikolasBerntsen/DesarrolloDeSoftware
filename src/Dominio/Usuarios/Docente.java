package Dominio.Usuarios;
import Aplicacion.Controladores.ControladorInformes;
import Dominio.Universidad.Catedra;

import java.util.List;

public class Docente extends Usuario {
    private List<Catedra> horarioSemanal;

    // Constructor, getters y setters

    public void crearInforme(List<Catedra> horarioSemanal) {
        ControladorInformes.getInstancia().exportarInformeCursada(horarioSemanal);

    }

    public List<Catedra> getHorarioSemanal() {
        return horarioSemanal;
    }//messi
}
