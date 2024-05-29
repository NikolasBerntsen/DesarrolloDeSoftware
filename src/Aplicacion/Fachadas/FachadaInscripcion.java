package Aplicacion.Fachadas;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladorUsuarios;
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
    static public void InscribirseCatedra(int legajo, int idCatedra){
        ControladoraInscripciones Inscripciones = ControladoraInscripciones.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        Estudiante estudiante = users.getEstudiante(legajo);
        Catedra catedra = Uni.buscarCatedra(idCatedra);

        Materia materia = catedra.getMateria();

        Inscripciones.validarDiaInscripcion(estudiante.getCarrera());
        Inscripciones.validarCargaHoraria(legajo, idCatedra);
        Inscripciones.validarCorrelativas(legajo, materia.getCodigoID());
        Inscripciones.inscribirseEnCatedra(legajo, idCatedra);
        Inscripciones.pagar(500);
    }
}
