package Test.Aplicacion;

import Aplicacion.Controladores.ControladorUniversidad;
import Aplicacion.Controladores.ControladorUsuarios;
import Aplicacion.Controladores.CoordinadorAcademico;
import Aplicacion.Fachadas.FachadaSistema;
import Dominio.Universidad.Catedra;
import Dominio.Usuarios.Docente;
import Infraestructura.Persistencia.CargadorDatosPrueba;

public class TestCoordinadorAcademico {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static public void testAsignarCatedras(){
        FachadaSistema.sincronizarDatos(new CargadorDatosPrueba());
        CoordinadorAcademico.asignarCatedras();

        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();

        boolean hayDocente = true;
        for (Catedra catedra : Uni.getAllCatedras()){
            if (!catedra.hayDocente()) {
                hayDocente = false;
            }
        }

        if (!hayDocente){
            System.out.println(ANSI_RED + "Prueba Fallida:"  +
                    ANSI_RESET + "El asignador de Docentes dejo Catedras sin docente");
        } else{
            System.out.println(ANSI_GREEN + "Prueba Superada: " +
                    ANSI_RESET + "El asignador de Docentes Asigno un docente a todas las Catedras");
        }
    }
}
