package Aplicacion.Controladores;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;
import Dominio.utils.Fecha;

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

    public void borrarCatedra(int id) {
        for (Facultad facu: facultades) {
            for (Carrera carrera : facu.getCarreras()){
                for (Materia materia : carrera.getMaterias()){
                    for (Catedra catedra : materia.getCatedras()){
                        if (catedra.getId() == id){
                            materia.borrarCatedra(id);
                            return;
                        }
                    }
                }
            }
        }
        return;
    }

    public void borrarMateria(String nombreCarrera, int idMateria) {
        Carrera carrera = buscarCarrera(nombreCarrera);
        carrera.borrarMateria(idMateria);
    }

    public void borrarCarrera(String nombre) {
        for (Facultad facu: facultades) {
            for (Carrera carrera : facu.getCarreras()){
                if (carrera.getNombre().equals(nombre)){
                    facu.borrarCarrera(carrera);
                    return;
                }
            }
        }
        return;
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

    public void crearCatedra(
            int idMateria,
            int idCatedra,
            int aula,
            int capacidad,
            String turno,
            int horaInicio,
            int horaFinal,
            String dia
    ) {
        Materia materia = buscarMateria(idMateria);
        Catedra catedra = new Catedra(
                idCatedra,
                aula,
                capacidad,
                turno,
                horaInicio,
                horaFinal,
                dia
        );
        catedra.setMateria(materia);
        materia.agregarCatedra(catedra);
    }

    public void crearMateria(
            String nombrecarrera,
            String nombre,
            int cargaHoraria,
            int ID
    ) {
        Carrera carrera = buscarCarrera(nombrecarrera);
        Materia materia = new Materia();
        materia.setNombre(nombre);
        materia.setCargaHoraria(cargaHoraria);
        materia.setID(ID);
        carrera.agregarMateria(materia);

    }

    public void crearCarrera(
            String nombreFacultad,
            String nombreCarrera,
            int cargaHorariaMaxima
    ) {
        Facultad facultad = buscarFaculta(nombreFacultad);
        Carrera carrera = new Carrera(
                nombreCarrera,
                cargaHorariaMaxima
        );
        facultad.agregarCarrera(carrera);
    }

    public void crearFacultad(String nombre, Fecha diaLimiteDeInscripcion){
        facultades.add(new Facultad(nombre, diaLimiteDeInscripcion));
    }

    public void ModificarCatedra(
            int id,
            int aula,
            int capacidad,
            String dia
    ) {
        Catedra catedra = buscarCatedra(id);
        catedra.setAula(aula);
        catedra.setCapacidad(capacidad);
        catedra.setDia(dia);
    }

    public Catedra buscarCatedra(int id) {
        for (Facultad facu: facultades) {
            for (Carrera carrera : facu.getCarreras()){
                for (Materia materia : carrera.getMaterias()){
                    for (Catedra catedra : materia.getCatedras()){
                        if (catedra.getId() == id){
                            return catedra;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Materia buscarMateria(int idMateria) {
        for (Facultad facu: facultades) {
            for (Carrera carrera : facu.getCarreras()){
                for (Materia materia : carrera.getMaterias()){
                    if (materia.getCodigoID() == idMateria){
                        return materia;
                    }
                }
            }
        }
        return null;
    }

    public Carrera buscarCarrera(String nombrecarrera) {
        for (Facultad facu: facultades) {
            for (Carrera carrera : facu.getCarreras()){
                if (carrera.getNombre().equals(nombrecarrera)){
                    return carrera;
                }
            }
        }
        return null;
    }

    public Facultad buscarFaculta(String nombreFacultad) {
        for (Facultad facu: facultades) {
            if (facu.getNombre().equals(nombreFacultad)) {
                return facu;
            }
        }
        System.out.println(nombreFacultad);
        return null;
    }


    public List<Carrera> getCarrerasDesde(String nombreFacultad) {
        List<Carrera> carreras = new ArrayList<>();
        for (Facultad facultad : facultades) {
            for (Carrera carrera : facultad.getCarreras()) {
                if (carrera.getNombre().equals(nombreFacultad)) {
                    carreras.add(carrera);
                }
            }
        }
        return carreras;
    }

    public List<Facultad> getFacultades(){
        return facultades;
    }

    public Facultad fromCarreraGetFacultad(String nombreCarrera) {
        for (Facultad facu : facultades) {
            for (Carrera carrera : facu.getCarreras()){
                if (carrera.getNombre().equals(nombreCarrera)) {
                    return facu;
                }
            }
        }
        return null;
    }

    public void agregarCorrelativa(int idMateria,int idCorrelativa){
        Materia materia = buscarMateria(idMateria);
        Materia correlativa = buscarMateria(idCorrelativa);
        materia.agregarCorrelativaAnterior(correlativa);
    }

    public void reset(){
        facultades.clear();
    }

    public List<Catedra> getAllCatedras() {
        List<Catedra> catedras = new ArrayList<Catedra>();
        for (Facultad facultad : facultades){
            for (Carrera carrera : facultad.getCarreras()){
                for (Materia materia : carrera.getMaterias()){
                    for (Catedra catedra : materia.getCatedras()){
                        catedras.add(catedra);
                    }
                }
            }
        }
        return catedras;
    }
}
