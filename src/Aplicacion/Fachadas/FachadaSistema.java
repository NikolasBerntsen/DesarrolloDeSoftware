package Aplicacion.Fachadas;

import Aplicacion.Controladores.*;
import Aplicacion.Fachadas.*;
import Dominio.Usuarios.*;
import Dominio.Universidad.*;
import Dominio.utils.Fecha;

public class FachadaSistema {

    static public void sincronizarDatos() {
        // AUTOCARGAR DATOS
    }

    // Gestión de catedra
    static public void crearCatedra(
            int idMateria,
            int idCatedra,
            int aula,
            int capacidad,
            String turno,
            String dia
    ) {
        ControladorUniversidad.getInstancia()
            .crearCatedra(
                 idMateria,
                 idCatedra,
                 aula,
                 capacidad,
                 turno,
                 dia
        );
    }
    static public void actualizarCatedra(
        int id,
        int aula,
        int capacidad,
        String turno,
        String dia
    ) {
        ControladorUniversidad.getInstancia()
                .ModificarCatedra(
                        id,
                        aula,
                        capacidad,
                        turno,
                        dia
                );
    }
    static public void eliminarCatedra(int id) {
        ControladorUniversidad.getInstancia().borrarCatedra(id);
    }

    // Gestión de materias
    static public void crearMateria(
        String nombreCarrera,
        String nombre,
        int codigoID,
        int cargaHoraria
    ) {
        ControladorUniversidad.getInstancia()
                .crearMateria(
                        nombreCarrera,
                        nombre,
                        codigoID,
                        cargaHoraria
                );
    }
    static public void actualizarMateria() {}
    static public void eliminarMateria() {}

    // Gestión de carreras
    static public void crearCarrera(
            String nombreFacultad,
            String nombreCarrera,
            int cargaHorariaMaxima
            ) {
        ControladorUniversidad.getInstancia()
                .crearCarrera(
                        nombreFacultad,
                        nombreCarrera,
                        cargaHorariaMaxima
                );
    }
    static public void actualizarCarrera() {}
    static public void eliminarCarrera() {}

    // Gestión de facultades
    static public void crearFacultad(
            String nombre,
            Fecha diaLimiteDeInscripcion
    ) {
        ControladorUniversidad.getInstancia()
                .crearFacultad(nombre,diaLimiteDeInscripcion);
    }
    static public void actualizarFacultad() {}
    static public void eliminarFacultad() {}

    // Inscripción de estudiantes
    static public void mostrarCatedrasDisponibles() {}
    static public void registrarInscripcionEstudiante() {}

    // Gestión de docentes
    static public void registrarDisponibilidadDocente() {}
    static public void actualizarDisponibilidadDocente() {}
    static public void generarInformeHorariosAulasAsignadas() {}
    static public void asignarCatedrasDocentes(int idcatedra, String legajo) {}


    // Integración con otros sistemas
    static public void cargaHorariaDocente() {}
    static public void cantidadInscriptosPorCatedra() {}
}