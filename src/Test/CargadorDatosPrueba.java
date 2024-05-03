import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;
import Dominio.utils.Fecha;
import Aplicacion.Controladores.ControladorUniversidad;

import java.util.List;

public class CargadorDatosPrueba {

    public static void cargarDatos() {
        cargarUniversidad();
        cargarUsuarios();
    }

    private static void cargarUniversidad() {

        ControladorUniversidad controladorUniversidad = ControladorUniversidad.getInstancia();

        // Crear facultades
        Facultad facultadInformatica = new Facultad();
        facultadInformatica.setNombre("Facultad de Informática");
        Fecha fechaLimiteInscripcion = new Fecha(2024, 6, 30);
        facultadInformatica.setDiaLimiteInscripcion(fechaLimiteInscripcion);

        // Crear carreras
        Carrera carreraInformatica = new Carrera();
        carreraInformatica.setNombre("Ingeniería en Informática");
        carreraInformatica.setCargaHorariaMaxima(70);
        facultadInformatica.agregarCarrera(carreraInformatica);

        // Crear materias
        Materia algebra = new Materia();
        algebra.setNombre("Álgebra");
        algebra.setCargaHoraria(40);
        carreraInformatica.agregarMateria(algebra);
        Materia calculo1 = new Materia();
        calculo1.setNombre("Cálculo I");
        calculo1.setCargaHoraria(40);
        carreraInformatica.agregarMateria(calculo1);
        Materia calculo2 = new Materia();
        calculo2.setNombre("Cálculo II");
        calculo2.setCargaHoraria(40);
        carreraInformatica.agregarMateria(calculo2);

        // Crear catedras
        Catedra catedraAlgebra = new Catedra();
        catedraAlgebra.setMateria(algebra);
        Catedra catedraCalculo1 = new Catedra();
        catedraCalculo1.setMateria(calculo1);
        Catedra catedraCalculo2 = new Catedra();
        catedraCalculo2.setMateria(calculo2);

        // Asignar catedras a materias
        algebra.agregarCatedra(catedraAlgebra);
        calculo1.agregarCatedra(catedraCalculo1);
        calculo2.agregarCatedra(catedraCalculo2);

        // Agregar facultades a la universidad
        controladorUniversidad.crearFacultad(facultadInformatica);
    }

    private static void cargarUsuarios() {
        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan");
        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("María");

        // Asignar carrera a los estudiantes
        Carrera carreraInformatica = ControladorUniversidad.getInstancia().getFacultades().get(0).getCarreras().get(0);
        estudiante1.setCarrera(carreraInformatica);
        estudiante2.setCarrera(carreraInformatica);

        // Crear docentes
        Docente docente1 = new Docente();
        docente1.setNombre("Profesor1");
        Docente docente2 = new Docente();
        docente2.setNombre("Profesor2");

        // Asignar catedras a los docentes
        List<Catedra> catedrasDocente1 = carreraInformatica.getMaterias().get(0).getCatedras();
        List<Catedra> catedrasDocente2 = carreraInformatica.getMaterias().get(1).getCatedras();
        docente1.agregarCatedra(catedrasDocente1.get(0));
        docente2.agregarCatedra(catedrasDocente2.get(0));
    }

}