package Test.Aplicacion;

import Aplicacion.Controladores.ControladorUniversidad;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Facultad;
import Dominio.utils.Fecha;

import java.util.List;

public class TestControladorUniversidad {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static public void testFromCarreraGetFacultad(){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();

        for (int i = 0; i<10; i++){
            Uni.crearFacultad(Integer.toString(i),new Fecha(0,0,0));
            for (int j = 0; j < 5; j++) {
                Uni.crearCarrera(Integer.toString(i),Integer.toString(j),30);
            }
        }
        Uni.crearCarrera("8","Objetivo",39);

        if (Uni.fromCarreraGetFacultad("Objetivo").getNombre().equals("8")){
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "se puede encontrar una facultad en base su carrera");
        }else{
            System.out.println(ANSI_RED + "Prueba Fallida: " +
                    ANSI_RESET + "NO se puede encontrar una facultad en base su carrera");
        }
        Uni.reset();
    }
}
