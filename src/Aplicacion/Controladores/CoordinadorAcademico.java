package Aplicacion.Controladores;

import Dominio.Universidad.Catedra;
import Dominio.Usuarios.Docente;

public class CoordinadorAcademico {
    static public void asignarCatedras(){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();

        for (Catedra catedra : Uni.getAllCatedras()){
            for (Docente docente : users.getDocentes()){
                String turno = catedra.getTurno().getTurno();
                String dia = catedra.getDia();
                if (
                        users.validarDisponibilidadDocente(docente.getLegajo(),dia,turno)
                                &&
                        !catedra.hayDocente()
                ){
                    catedra.agregarDocente(docente);
                    docente.agregarCatedra(catedra);
                    break;
                }
            }
        }
    }
}
