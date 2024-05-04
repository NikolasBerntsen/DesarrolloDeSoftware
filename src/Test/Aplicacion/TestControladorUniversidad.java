package Test.Aplicacion;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladoraInscripciones;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Facultad;

import java.util.List;

public class TestControladorUniversidad {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static public void testFromCarreraGetFacultad(){
        ControladorUniversidad contUni = ControladorUniversidad.getInstancia();
        for (int i = 0; i<10; i++){
            Facultad facultad = new Facultad(null);
            for (int j = 0; j < 5; j++) {
                Carrera carrera = new Carrera();
            }
            contUni.crearFacultad(null);
        }

        contUni.crearFacultad("Facultad de ingenieria");
        List<Facultad> facultades = contUni.getFacultades();
        contUni.crearCarrera("Ingenieria informatica", "Facultad de ingenieria");



        if (contUni.fromCarreraGetFacultad(){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "se puede encontrar una facultad en base su carrera");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "NO se puede encontrar una facultad en base su carrera");
        }
        contUni.resetFacultades();
    }
}
