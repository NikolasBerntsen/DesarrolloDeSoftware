package Aplicacion.Controladores;

import Aplicacion.Interfaz.MetodoPago;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;
import Dominio.utils.Fecha;

import java.util.List;

public class ControladoraInscripciones {
    private static ControladoraInscripciones instancia = null;

    private ControladoraInscripciones() {}

    public static ControladoraInscripciones getInstancia() {
        if (instancia == null) {
            instancia = new ControladoraInscripciones();
        }
        return instancia;
    }

    private MetodoPago metodoPago;
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean validarCorrelativas(int legajo, int idMateria){
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        Estudiante estudiante = users.getEstudiante(legajo);
        Materia materia = Uni.buscarMateria(idMateria);

        List<Materia> correlativas = materia.getCorrelativasAnteriores();
        List<Materia> aprobadas = estudiante.getMateriasAprobadas();
        for (Materia correlativa : correlativas){
            boolean esta = false;
            for(Materia matAprobada : aprobadas){
                if (matAprobada.getNombre().equals(correlativa.getNombre())) {
                    esta = true;
                    break;
                }
            }
            if (!esta){
                return false;
            }
        }
        return true;
    }
    public boolean validarCargaHoraria(int legajo, int idMateria){
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        Estudiante estudiante = users.getEstudiante(legajo);
        Carrera carrera = Uni.buscarCarrera(estudiante.getCarrera());
        Materia materia = Uni.buscarMateria(idMateria);

        return ((estudiante.getCargaHoraria() + materia.getCargaHoraria()) <= carrera.getCargaHorariaMaxima());
    }

    public void inscribirseEnCatedra(int legajo, int idCatedra){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();

        Catedra catedra = Uni.buscarCatedra(idCatedra);
        Estudiante estudiante = users.getEstudiante(legajo);

        estudiante.inscribirA(catedra);
        catedra.agregarAlumno(estudiante);
    }
    public void bajaDeMateria(int legajo, int idCatedra){
        ControladorUsuarios.getInstancia()
                .getEstudiante(legajo)
                    .bajarDe(ControladorUniversidad.getInstancia()
                        .buscarCatedra(idCatedra));
    }
    public void pagar(int monto){
        metodoPago.pagar(monto);
    }
    public boolean validarDiaInscripcion(String nombreCarrera){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        Facultad facultad = Uni.fromCarreraGetFacultad(nombreCarrera);

        Fecha fechaActual = new Fecha(0,0,0);
        fechaActual.fechaActual();

        return fechaActual.esAnteriorA(facultad.getDiaLimiteDeInscripcion());
    }

}
