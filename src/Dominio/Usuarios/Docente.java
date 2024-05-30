package Dominio.Usuarios;
import Aplicacion.Controladores.ControladorInformes;
import Dominio.Universidad.Catedra;
import Dominio.utils.HorarioDocente;
import Dominio.utils.Turno;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario {
    private List<Catedra> horarioSemanal; // catedras donde esta anotado

    private HorarioDocente disponibilidad = new HorarioDocente();

    private HorarioDocente preferencia = new HorarioDocente();

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
        Turno turno = catedra.getTurno();
        disponibilidad.deshabilitarHorario(catedra.getDia(), turno.getTurno());
    }
    public void quitarCatedra(Catedra catedra) {
        horarioSemanal.remove(catedra);
        Turno turno = catedra.getTurno();
        disponibilidad.habilitarHorario(catedra.getDia(), turno.getTurno());
    }

    public List<Catedra> getHorarioSemanal() {
        return horarioSemanal;
    }

    public void addPreferencia(String dia,String turno){
        preferencia.habilitarHorario(dia,turno);
    }
    public void removePreferencia(String dia,String turno){
        preferencia.deshabilitarHorario(dia,turno);
    }

    public boolean estaDisponible(String dia,String turno){
        return disponibilidad.getdisponibilidad(dia, turno);
    }

}
