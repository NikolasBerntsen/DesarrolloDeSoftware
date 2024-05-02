package Test.Aplicacion;

import Aplicacion.Controladores.ControladoraInscripciones;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Estudiante;

public class TestControladoraInscripciones {
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
        materia.agregarCorrelativaPosterior(co1);
        materia.agregarCorrelativaPosterior(co2);

        //try
        ControladoraInscripciones cont = ControladoraInscripciones.getInstancia();
        boolean resultado = true;
        Estudiante estudiante = new Estudiante();
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println("fallo una prueba: un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :0");
        }
        estudiante.addAprobada(co0);
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println("fallo una prueba: un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :1");
        }
        estudiante.addAprobada(co1);
        if (cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println("fallo una prueba: un estudiante se puede anotar a una materia SIN CUMPLIR sus correlativas :2");
        }
        estudiante.addAprobada(co2);
        if (!cont.validarCorrelativas(estudiante, materia)){
            resultado = false;
            System.out.println("fallo una prueba: un estudiante NO se puede anotar a una materia CUMPLIENDO sus correlativas");
        }
        //result
        if (resultado){
            System.out.println("Pruba Superada: los estudiantes deben cumplir con las correlativas para anotarse a una materia");
        }
    }
}
