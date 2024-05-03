package Aplicacion.Controladores;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Facultad;
import Dominio.Usuarios.Estudiante;

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
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public void getCatedra(){}
    public void setCatedra(){}
    public void crearCatedra(){}
    public void getMateria(){}
    public void setMateria(){}
    public void crearMateria(){}
    public void getCarreras(String nombre){
    }
    public void setCarrera(){}
    public void crearCarrera(Carrera carrera, Facultad facultad){
        int indiceFacu = facultades.indexOf(facultad);
        facultad.crearCarrera(carrera);
        facultades.set(indiceFacu,facultad);
    }
    public List<Facultad> getFacultades(){
        return facultades;
    }
    public void setFacultad(){}
    public void crearFacultad(Facultad facultad){
        facultades.add(facultad);
    }

    public Facultad fromCarreraGetFacultad(Carrera carrera) {
        for (Facultad facu : facultades) {
            if (facu.getCarreras().contains(carrera)) {
                return facu;
            }
        }
        return null;
    }

    public void resetFacultades(){
        facultades = new ArrayList<Facultad>();
    }

}
