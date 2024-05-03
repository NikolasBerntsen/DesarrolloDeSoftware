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

    public boolean validarCorrelativas(Estudiante estudiante, Materia materia){
        List<Materia> correlativas = materia.getCorrelativasAnteriores();
        List<Materia> aprovadas = estudiante.getMateriasAprobadas();
        for (Materia correlativa : correlativas){
            boolean esta = false;
            for(Materia matAprovada : aprovadas){
                if (matAprovada.getNombre().equals(correlativa.getNombre())) {
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
    public boolean validarCargaHoraria(Estudiante estudiante, Materia materia){
        return ((estudiante.getCargaHoraria() + materia.getCargaHoraria()) <= estudiante.getCarrera().getCargaHorariaMaxima());
    }
    public void inscribirseEnCatedra(Estudiante estudiante, Catedra catedra){
        estudiante.inscribirA(catedra);
        catedra.agregarAlumno(estudiante);
    }
    public void bajaDeMateria(Estudiante estudiante, Catedra catedra){
        estudiante.bajarDe(catedra);
    }
    public void pagar(int monto){
        metodoPago.pagar(monto);
    }
    public boolean validarDiaInscripcion(Carrera carrera){
        Fecha fechaActual = new Fecha(0,0,0);
        fechaActual.fechaActual();

        Facultad facultad = ControladorUniversidad.getInstancia().fromCarreraGetFacultad(carrera);
        return fechaActual.esAnteriorA(facultad.getDiaLimiteDeInscripcion());
    }

}
