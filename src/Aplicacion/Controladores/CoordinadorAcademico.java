package Aplicacion.Controladores;

import Dominio.Universidad.Catedra;
import Dominio.Usuarios.Docente;

public class CoordinadorAcademico {
    static public void asignarCatedras(){
        ControladorUniversidad Uni = ControladorUniversidad.getInstancia();
        ControladorUsuarios users = ControladorUsuarios.getInstancia();

        for (Catedra catedra : Uni.getAllCatedras()){
            for (Docente docente : users.getDocentes()){
                if (users.validarDisponibilidadDocente(docente.getLegajo(),catedra.getTurno())){
                    // Inscribir Docente:
                    // cambiar la disponibilidad del docente, en el horario del turno estara indisponible
                    // asignar docente a la catedra
                }
            }
        }
    }
}
