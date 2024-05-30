package Aplicacion.Fachadas;

import Aplicacion.Controladores.*;
import Aplicacion.Fachadas.*;
import Aplicacion.Interfaz.Exportar;
import Aplicacion.Interfaz.Persistencia;
import Dominio.Usuarios.*;
import Dominio.Universidad.*;
import Dominio.utils.Fecha;

import java.util.List;

public class FachadaSistema {

    static public void sincronizarDatos(Persistencia BaseDatos) {
        BaseDatos.descargarDatos();
    }

    // Gestión de catedra
    static public void crearCatedra(
            int idMateria,
            int idCatedra,
            int aula,
            int capacidad,
            String turno,
            int horaInicio,
            int horaFinal,
            String dia
    ) {
        ControladorUniversidad.getInstancia()
            .crearCatedra(
                 idMateria,
                 idCatedra,
                 aula,
                 capacidad,
                 turno,
                 horaInicio,
                 horaFinal,
                 dia
        );
    }
    static public void actualizarCatedra(
        int id,
        int aula,
        int capacidad,
        String dia
    ) {
        ControladorUniversidad.getInstancia()
                .ModificarCatedra(
                        id,
                        aula,
                        capacidad,
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
    static public void actualizarMateria(int idMateria, String nombreNuevo, int cargaHoraria) {
        Materia materia = ControladorUniversidad.getInstancia().buscarMateria(idMateria);
        materia.setNombre(nombreNuevo);
        materia.setCargaHoraria(cargaHoraria);
    }
    static public void eliminarMateria(String nombreCarrera, int idMateria) {
        ControladorUniversidad.getInstancia().borrarMateria(nombreCarrera, idMateria);
    }

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
    static public void actualizarCarrera(String nombreViejo, String nombreNuevo, int cargaHoraria) {
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        Carrera carrera = Uni.buscarCarrera(nombreViejo);
        carrera.setNombre(nombreNuevo);
        carrera.setCargaHorariaMaxima(cargaHoraria);
    }
    static public void eliminarCarrera(String nombreCarrera) {
        ControladorUniversidad.getInstancia().borrarCarrera(nombreCarrera);
    }

    // Gestión de facultades
    static public void crearFacultad(
            String nombre,
            Fecha diaLimiteDeInscripcion
    ) {
        ControladorUniversidad.getInstancia()
                .crearFacultad(nombre,diaLimiteDeInscripcion);
    }
    static public void actualizarFacultad(String nombreActual, String nombreNuevo, Fecha diaLimite) {
        ControladorUniversidad.getInstancia().buscarFaculta(nombreActual).setNombre(nombreNuevo);
        ControladorUniversidad.getInstancia().buscarFaculta(nombreActual).setDiaLimiteInscripcion(diaLimite);
    }
    static public void eliminarFacultad(String nombreFacultad) {
        ControladorUniversidad.getInstancia().borrarFacultad(nombreFacultad);
    }

    // Inscripción de estudiantes
    static public List<Catedra> mostrarCatedrasDisponibles(int idMateria) {
        return FachadaInscripcion.catedrasDisponibles(idMateria);
    }
    static public void registrarInscripcionEstudiante(int legajo, int idCatedra)  {
        FachadaInscripcion.InscribirseCatedra(legajo, idCatedra);
    }

    // Gestión de docentes
    static public void setPreferenciaDocente(int legajo,boolean[][] matrizHorario) {
        ControladorUsuarios.getInstancia().getDocente(legajo).setPreferencia(matrizHorario);
    }

    static public void asignarCatedrasDocentes() {
        CoordinadorAcademico.asignarCatedras();
    }

    static public void exportarInformeDocente(int legajo, Exportar tipoDocumento){
        ControladorInformes.getInstancia().setDocumento(tipoDocumento);
        ControladorUsuarios.getInstancia().getDocente(legajo).crearInforme();
    }

    static public int cargaHorariaDocente(int legajo) {
        return ControladorUsuarios.getInstancia().getDocente(legajo).getCargaHoraria();
    }
    static public int cantidadInscriptosPorCatedra(int idCatedra) {
        return ControladorUniversidad.getInstancia().buscarCatedra(idCatedra).getCantidadInscriptos();
    }
}