package Dominio.Universidad;

import Dominio.utils.Fecha;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombre;
    private List<Carrera> carreras;
    private Fecha diaLimiteDeInscripcion;

    public Facultad(String nombre) {
        this.nombre=nombre;
        carreras = new ArrayList<>();
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void borrarCarrera(String nombre) {
        for (Carrera carrera : carreras) {
            if (carrera.getNombre().equals(nombre)) {
                carreras.remove(carrera);
                return;
            }
        }
    }

    public List<Materia> getMaterias(Carrera carrera) {
        return carrera.getMaterias();
    }

    public List<Catedra> getCatedras(Carrera carrera, Materia materia) {
        return carrera.getCatedras(materia);
    }

    public void agregarCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    public Fecha getDiaLimiteDeInscripcion() {
        return diaLimiteDeInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDiaLimiteInscripcion(Fecha fecha) {
        this.diaLimiteDeInscripcion = fecha;
    }

    public void crearCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    // Método para agregar materia a una carrera específica
    public void agregarMateriaACarrera(Carrera carrera, Materia materia) {
        carrera.agregarMateria(materia);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
