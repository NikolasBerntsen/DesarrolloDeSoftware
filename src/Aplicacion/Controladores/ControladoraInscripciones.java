package Aplicacion.Controladores;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;

public class ControladoraInscripciones {
    private static ControladoraInscripciones instancia = null;

    private ControladoraInscripciones() {}

    public static ControladoraInscripciones getInstancia() {
        if (instancia == null) {
            instancia = new ControladoraInscripciones();
        }
        return instancia;
    }

    public void validarCorrelativas(Estudiante estudiante){}
    public void validarCargaHoraria(Estudiante estudiante, Materia materia){}
    public void inscribirseEnCatedra(Estudiante estudiante, Catedra catedra){}
    public void bajaDeMateria(Estudiante estudiante, Catedra catedra){}
    public void pagar(int monto){}
    public void validarDiaInscripcion(Carrera carrera){}

}
