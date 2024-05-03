package Test.Aplicacion;

import Aplicacion.Controladores.ControladoraInscripciones;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;

public class TestControladoraInscripciones {
    // Códigos de escape ANSI para colores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static public void testValidarCorrelativas(){
        //given
        Materia co0 = new Materia();
        co0.setNombre("algebra");
        Materia co1 = new Materia();
        co1.setNombre("calculo1");
        Materia co2 = new Materia();
        co2.setNombre("calculo2");
        Materia materia = new Materia();
        materia.agregarCorrelativaAnterior(co0);
        materia.agregarCorrelativaAnterior(co1);
        materia.agregarCorrelativaAnterior(co2);

        //try
        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();
        boolean resultado = true;
        Estudiante estudiante = new Estudiante();
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :0");
        }
        estudiante.addAprobada(co0);
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :1");
        }
        estudiante.addAprobada(co1);
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :2");
        }
        estudiante.addAprobada(co2);
        if (!cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante NO se puede anotar a una materia CUMPLIENDO sus correlativas");
        }
        //result
        if (resultado){
            System.out.println(ANSI_GREEN + "Prueba Superada: " + ANSI_RESET + "los estudiantes deben cumplir con las correlativas para anotarse a una materia");
        }
    }

    static public void testValidarCargaHoraria(){
        // given
        Carrera carrera = new Carrera();
        carrera.setCargaHorariaMaxima(75);
        Estudiante estudiante = new Estudiante();
        estudiante.setCargaHoraria(40);
        estudiante.setCarrera(carrera);
        Materia materia0 = new Materia();
        materia0.setCargaHoraria(30);
        Materia materia1 = new Materia();
        materia1.setCargaHoraria(40);

        // try

        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();

        if (cont.validarCargaHoraria(estudiante,materia1)){
            System.out.println(ANSI_RED + "Fallo una prueba: " + ANSI_RESET + "Un estudiante NO se puede anotar a una materia si con esta SUPERA la carga horaria máxima de la carrera");
        }

        if (cont.validarCargaHoraria(estudiante,materia0)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " + ANSI_RESET + "Los estudiantes se pueden anotar a una materia si con esta NO SUPERAN la carga horaria máxima de la carrera");
        }
    }

}
