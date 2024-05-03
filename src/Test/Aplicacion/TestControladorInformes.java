package Test.Aplicacion;

import Dominio.Universidad.Catedra;
import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;

public class TestControladorInformes {
    static public void exportarInformeCursada(){
        Docente docente = new Docente();

        Catedra catedra1 = new Catedra(0,"314","martes","tarde");
        for (int i = 0; i < 10; i++) {
            catedra1.agregarAlumno(new Estudiante());
        }
        Catedra catedra2 = new Catedra(55,"601","jueves","mañana");
        for (int i = 0; i < 22; i++) {
            catedra2.agregarAlumno(new Estudiante());
        }
        Catedra catedra3 = new Catedra(12,"764A","lunes","virtual");
        for (int i = 0; i < 66; i++) {
            catedra3.agregarAlumno(new Estudiante());
        }

        docente.agregarCatedra(catedra1);
        docente.agregarCatedra(catedra2);
        docente.agregarCatedra(catedra3);

        docente.crearInforme();
    }
}
