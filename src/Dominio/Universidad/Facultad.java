package Dominio.Universidad;
import Dominio.utils.Fecha;

import java.util.List;
import java.util.ArrayList;

public class Facultad {
    private List<Carrera> carreras;
    private Fecha diaLimiteDeInscripcion;

    public Facultad() {
        carreras = new ArrayList<>();
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    // No necesitamos un setter para la lista, ya que la inicializamos en el constructor

    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }
}
