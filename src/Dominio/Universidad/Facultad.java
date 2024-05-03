package Dominio.Universidad;
import Dominio.utils.Fecha;

import java.util.List;
import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private List<Carrera> carreras;
    private Fecha diaLimiteDeInscripcion;

    public Facultad() {
        carreras = new ArrayList<>();
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public List<Materia> getMaterias(Carrera carrera) {
        return carrera.getMaterias();
    }

    public List<Catedra> getCatedras(Carrera carrera,Materia materia){
        return carrera.getCatedras(materia);
    }

    // No necesitamos un setter para la lista, ya que la inicializamos en el constructor

    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    public Fecha getDiaLimiteDeInscripcion() {
        return diaLimiteDeInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDialimiteInscripcion(Fecha fecha) {
        this.diaLimiteDeInscripcion = fecha;
    }
}
