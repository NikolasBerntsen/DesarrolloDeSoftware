package Test.Aplicacion;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladorUsuarios;
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
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        ControladoraInscripciones insc = ControladoraInscripciones.getInstancia();

        Uni.crearFacultad("FAIN",new Fecha(0,0,0));
        Uni.crearCarrera("FAIN","Ing.Informatica", 35);

        Uni.crearMateria("Ing.Informatica","algebra",35,1);
        Uni.crearMateria("Ing.Informatica","calculo1",35,2);
        Uni.crearMateria("Ing.Informatica","calculo2",40,3);

        int idMateria = 123;
        Uni.crearMateria("Ing.Informatica", "Simulacion Virtual", 35, idMateria);
        Uni.agregarCorrelativa(idMateria, 1);
        Uni.agregarCorrelativa(idMateria, 2);
        Uni.agregarCorrelativa(idMateria, 3);

        int legajo = 1234;
        users.cargarEstudiante("pepe", legajo, 1234, "Ing.Informatica");

        boolean resultado = true;
        if (insc.validarCorrelativas(legajo, idMateria)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :0");
        }
        users.addAprobada(legajo,1);
        if (insc.validarCorrelativas(legajo, idMateria)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :1");
        }
        users.addAprobada(legajo,2);
        if (insc.validarCorrelativas(legajo, idMateria)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :2");
        }
        users.addAprobada(legajo,3);
        if (!insc.validarCorrelativas(legajo, idMateria)){
            resultado = false;
            System.out.println(ANSI_RED + "fallo una prueba: " + ANSI_RESET + "un estudiante NO se puede anotar a una materia CUMPLIENDO sus correlativas");
        }
        //result
        if (resultado){
            System.out.println(ANSI_GREEN + "Prueba Superada: " + ANSI_RESET + "los estudiantes deben cumplir con las correlativas para anotarse a una materia");
        }
        users.reset();
        Uni.reset();
    }

    static public void testValidarCargaHoraria(){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();
        ControladoraInscripciones insc = ControladoraInscripciones.getInstancia();

        Uni.crearFacultad("FAIN",new Fecha(0,0,0));
        Uni.crearCarrera("FAIN","Ing.Informatica", 70);

        // given
        Uni.crearMateria("Ing.Informatica","algebra",35,0);
        Uni.crearMateria("Ing.Informatica","Elementos de algebra",35,1);
        Uni.crearMateria("Ing.Informatica","Calculo I",40,2);

        int legajo = 1234;
        users.cargarEstudiante("pepe",legajo,4321, "Ing.Informatica");

        Uni.crearCatedra(0,0,304,60,"noche",1800,2200,"martes");

        users.inscribirEstudiateA(legajo,0);

        // try

        if (!insc.validarCargaHoraria(legajo,1)){
            System.out.println(ANSI_RED + "Fallo una prueba: " + ANSI_RESET + "Un estudiante NO se deberian anotar a una materia si con esta SUPERA la carga horaria máxima de la carrera");
        }

        if (!insc.validarCargaHoraria(legajo,2)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " + ANSI_RESET + "Los estudiantes se pueden anotar a una materia si con esta NO SUPERAN la carga horaria máxima de la carrera");
        }
        users.reset();
        Uni.reset();
    }

    static public void testValidarDiaInscripcion(){
        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        String nombreCarrera = "Ing.Informatica";
        String nombreFacultad = "FAIN";
        Fecha fechaLimite = new Fecha(0,0,0);
        fechaLimite.fechaActual();
        Uni.crearFacultad(nombreFacultad,fechaLimite);
        Uni.crearCarrera("FAIN",nombreCarrera,30);

        Fecha fechaActual = new Fecha(0,0,0);
        fechaActual.fechaActual();

        Carrera carrera = Uni.buscarCarrera(nombreCarrera);
        Facultad facultad = Uni.buscarFaculta(nombreFacultad);

        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "sobre la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "sobre la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(1,0,0);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un dia antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un dia antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(-1,1,0);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un mes antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un mes antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(0,-1,1);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un año antes de la fecha limite, te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un año antes de la fecha limite, NO te podes anotar");
        }

        fechaLimite.restarFecha(0,0,-2);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un año despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un año despues de la fecha limite, te podes anotar");
        }

        fechaLimite.restarFecha(0,-1,1);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un mes despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un mes despues de la fecha limite, te podes anotar");
        }

        fechaLimite.restarFecha(-1,1,0);
        facultad.setDiaLimiteInscripcion(fechaLimite);
        if(!cont.validarDiaInscripcion(nombreCarrera)){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "un dia despues de la fecha limite,NO te podes anotar");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "un dia despues de la fecha limite, te podes anotar");
        }
        Uni.reset();
    }
}
