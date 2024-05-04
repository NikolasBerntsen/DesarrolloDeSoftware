package Aplicacion.Controladores;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;

import java.util.ArrayList;
import java.util.List;

public class ControladorUniversidad {
    private static ControladorUniversidad instancia = null;

    private ControladorUniversidad() {}

    public static ControladorUniversidad getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUniversidad();
        }
        return instancia;
    }

    private List<Facultad> facultades = new ArrayList<Facultad>();

    public void borrarCatedra(Carrera carrera, String nombre) {
        for (Facultad facultad : facultades) {
            for (Carrera car : facultad.getCarreras()) {
                if (car.equals(carrera)) {
                    car.borrarCatedra(nombre);
                    return;
                }
            }
        }
    }

    public void borrarMateria(Carrera carrera, String nombre) {
        for (Carrera car : getCarreras()) {
            if (car.equals(carrera)) {
                car.borrarMateria(nombre);
                return;
            }
        }
    }


    public void crearCatedra(Materia materia, int ID) {
        Catedra catedra = new Catedra();
        catedra.setID(ID);
        materia.agregarCatedra(catedra);
    }


    public void crearMateria(Carrera carrera, String nombre, int cargaHoraria,int ID) {
        Materia materia = new Materia();
        carrera.agregarMateria(materia);
        materia.setNombre(nombre);
        materia.setCargaHoraria(cargaHoraria);
        materia.setID(ID);

    }

    public List<Carrera> getCarreras(String nombre) {
        List<Carrera> carreras = new ArrayList<>();
        for (Facultad facultad : facultades) {
            for (Carrera carrera : facultad.getCarreras()) {
                if (carrera.getNombre().equals(nombre)) {
                    carreras.add(carrera);
                }
            }
        }
        return carreras;
    }

    public void borrarCarrera(String nombre) {
        for (Facultad facultad : facultades) {
            for (Carrera carrera : facultad.getCarreras()) {
                if (carrera.getNombre().equals(nombre)) {
                    facultad.borrarCarrera(carrera);
                    return;
                }
            }
        }
    }

    public void crearCarrera(String nombre, String nombreFacultad) {
        for (Facultad facultad : facultades) {
            if (facultad.getNombre().equals(nombreFacultad)) {
                Carrera carrera = new Carrera(nombre);
                facultad.agregarCarrera(carrera);
                return;
            }
        }
    }
    public void borrarFacultad(String nombre) {
        Facultad facultadToRemove = null;
        for (Facultad facultad : facultades) {
            if (facultad.getNombre().equals(nombre)) {
                facultadToRemove = facultad;
                break;
            }
        }
        if (facultadToRemove != null) {
            facultades.remove(facultadToRemove);
        }
    }

    public List<Facultad> getFacultades(){
        return facultades;
    }

    public Facultad fromCarreraGetFacultad(Carrera carrera) {
        for (Facultad facu : facultades) {
            if (facu.getCarreras().contains(carrera)) {
                return facu;
            }
        }
        return null;
    }

            public void crearFacultad(String nombre){
        Facultad facultad = new Facultad(nombre);
        facultades.add(facultad);
    }
    public void resetFacultades(){
        facultades = new ArrayList<Facultad>();
    }
}
