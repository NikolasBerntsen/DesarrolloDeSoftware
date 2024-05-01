package Aplicacion.Controladores;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Facultad;

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

    private List<Facultad> facultades;

    public void getCatedra(){}
    public void setCatedra(){}
    public void crearCatedra(){}
    public void getMateria(){}
    public void setMateria(){}
    public void crearMateria(){}
    public void getCarrera(){}
    public void setCarrera(){}
    public void crearCarrera(){}
    public List<Facultad> getFacultad(){
        return facultades;
    }
    public void setFacultad(){}
    public void crearFacultad(){}

    public Facultad fromCarreraGetFacultad(Carrera carrera){
        for (Facultad facu : facultades){
            if (facu.getCarrera().includes(carrera)){
                return facu;
            }
        }
        return null;
    }
}
