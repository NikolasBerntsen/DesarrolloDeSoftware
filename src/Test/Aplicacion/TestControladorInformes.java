package Test.Aplicacion;

import Aplicacion.Controladores.ControladorInformes;
import Dominio.Universidad.Catedra;
import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;
import Infraestructura.Exportar.Excel;
import Infraestructura.Exportar.PDF;

public class TestControladorInformes {
    static public void exportarInformeCursada(){
        Docente docente = new Docente();

        Catedra catedra1 = new Catedra(0,314,"martes","tarde",1400,1800);
        for (int i = 0; i < 10; i++) {
            catedra1.agregarAlumno(new Estudiante());
        }
        Catedra catedra2 = new Catedra(55,601,"jueves","mañana",745,1145);
        for (int i = 0; i < 22; i++) {
            catedra2.agregarAlumno(new Estudiante());
        }
        Catedra catedra3 = new Catedra(12,764,"lunes","virtual",815,1215);
        for (int i = 0; i < 66; i++) {
            catedra3.agregarAlumno(new Estudiante());
        }

        docente.agregarCatedra(catedra1);
        docente.agregarCatedra(catedra2);
        docente.agregarCatedra(catedra3);

        ControladorInformes.getInstancia().setDocumento(new PDF());
        docente.crearInforme();
        ControladorInformes.getInstancia().setDocumento(new Excel());
        docente.crearInforme();
    }
}
