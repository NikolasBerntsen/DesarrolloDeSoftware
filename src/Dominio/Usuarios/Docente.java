package Dominio.Usuarios;
import Aplicacion.Controladores.ControladorInformes;
import Dominio.Universidad.Catedra;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario {
    private List<Catedra> horarioSemanal; // catedras donde esta anotado

    public Docente(){
        this.horarioSemanal = new ArrayList<>();
    }

    public Docente(String nombre, int legajo, int DNI) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.DNI = DNI;
        this.horarioSemanal = new ArrayList<>();
    }

    public void crearInforme() {
        ControladorInformes.getInstancia().exportarInformeCursada(horarioSemanal);

    }
    public int getCargaHoraria(){
        int cargaHoraria = 0;
        for (Catedra catedra : horarioSemanal){
            cargaHoraria += catedra.getCargaHoraria();
        }
        return cargaHoraria;
    }

    public void agregarCatedra(Catedra catedra) {
        horarioSemanal.add(catedra);
    }
    public void quitarCatedra(Catedra catedra) {
        horarioSemanal.remove(catedra);
    }

    public List<Catedra> getHorarioSemanal() {
        return horarioSemanal;
    }
}
