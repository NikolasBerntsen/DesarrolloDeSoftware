package Aplicacion.Fachadas;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladoraInscripciones;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;

import java.util.List;

public class FachadaInscripcion {
    static public List<Catedra> catedrasDisponibles(int idMateria){
        return ControladorUniversidad.getInstancia().buscarMateria(idMateria).getCatedras();
    }
    static public void InscribirseCatedra(Catedra catedra, Estudiante estudiante){
        ControladoraInscripciones ConIns = ControladoraInscripciones.getInstancia();
        Materia materia = catedra.getMateria();
        Carrera carrera = estudiante.getCarrera();
        ConIns.validarDiaInscripcion(carrera);
        ConIns.validarCargaHoraria(estudiante, materia);
        ConIns.validarCorrelativas(estudiante, materia);
        ConIns.inscribirseEnCatedra(estudiante, catedra);
        ConIns.pagar(500);
    }
}
