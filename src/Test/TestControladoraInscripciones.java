package Test;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladoraInscripciones;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Facultad;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;
import Dominio.utils.Fecha;

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
        carrera.setCargaHorariaMaxima(70);
        Materia materia0 = new Materia();
        materia0.setCargaHoraria(35);
        Materia materia35 = new Materia();
        materia35.setCargaHoraria(35);
        Materia materia40 = new Materia();
        materia40.setCargaHoraria(40);

        Estudiante estudiante = new Estudiante();
        estudiante.setCarrera(carrera);
        Catedra catedra = new Catedra();
        catedra.setMateria(materia0);
        estudiante.inscribirA(catedra);

        // try

        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();

        if (cont.validarCargaHoraria(estudiante,materia40)){
            System.out.println(ANSI_RED + "Fallo una prueba: " + ANSI_RESET + "Un estudiante NO se puede anotar a una materia si con esta SUPERA la carga horaria máxima de la carrera");
        }

        if (cont.validarCargaHoraria(estudiante,materia35)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " + ANSI_RESET + "Los estudiantes se pueden anotar a una materia si con esta NO SUPERAN la carga horaria máxima de la carrera");
        }
    }

    static public void testValidarDiaInscripcion(){
        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();
        ControladorUniversidad contUni = ControladorUniversidad.getInstancia();

        Facultad facultad = new Facultad();
        contUni.crearFacultad(facultad);

        Fecha fechaActual = new Fecha(0,0,0);
        fechaActual.fechaActual();

        Fecha fechaLimite = new Fecha(0,0,0);

        Carrera carrera = new Carrera();
        carrera.setNombre("Ingenieria Informatica");
        facultad.agregarCarrera(carrera);

        fechaLimite.fechaActual();
        facultad.setDialimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "sobre la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "sobre la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(1,0,0);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un dia antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un dia antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(-1,1,0);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un mes antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un mes antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(0,-1,1);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un año antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un año antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(0,0,-2);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un año despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un año despues de la fecha limite, te podes anotar");
        }

        fechaLimite.restarFecha(0,-1,1);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un mes despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un mes despues de la fecha limite, te podes anotar");
        }

        fechaLimite.restarFecha(-1,1,0);
        facultad.setDialimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(carrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un dia despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un dia despues de la fecha limite, te podes anotar");
        }
        contUni.resetFacultades();
    }
}
