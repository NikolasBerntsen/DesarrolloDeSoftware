package Aplicacion.Controladores;

import Aplicacion.Fachadas.FachadaInscripcion;
import Dominio.Universidad.Carrera;
import Dominio.Universidad.Materia;
import Dominio.Usuarios.Docente;
import Dominio.Usuarios.Estudiante;
import Dominio.Usuarios.Usuario;
import Dominio.utils.Turno;

import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarios {
    private List<Estudiante> estudiates = new ArrayList<Estudiante>();
    private List<Docente> docentes = new ArrayList<Docente>();
    private static ControladorUsuarios instancia = null;

    private ControladorUsuarios() {}

    public static ControladorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }

    public void cargarEstudiante(
            String nombre,
            int legajo,
            int DNI,
            String carrera
    ){
        Estudiante student = new Estudiante(nombre, legajo, DNI, carrera);
        estudiates.add(student);
    }
    public void cargarDocente(
        String nombre,
        int legajo,
        int DNI
    ){
            Docente docente = new Docente(nombre, legajo, DNI);
            docentes.add(docente);
    }

    public void setCarreraEstudiante(int legajo, String carrera){
        for (Estudiante auxStudent : estudiates){
            if (auxStudent.getLegajo() == legajo){
                auxStudent.setCarrera(carrera);
                return;
            }
        }
    }

    public Estudiante getEstudiante(int legajo) {
        for (Estudiante usuario : estudiates){
            if (usuario.getLegajo() == legajo){
                return usuario;
            }
        }
        return null;
    }

    public void inscribirEstudiateA(int legajo, int idCatedra) {
        FachadaInscripcion.InscribirseCatedra(legajo,idCatedra);
    }

    public void reset(){
        estudiates.clear();
        docentes.clear();
    }

    public void addAprobada(int legajo, int idMateria) {
        Materia materia = ControladorUniversidad.getInstancia().buscarMateria(idMateria);
        getEstudiante(legajo).addAprobada(materia);
    }

    public Docente getDocente(int legajo){
        for (Docente usuario : docentes){
            if (usuario.getLegajo() == legajo){
                return usuario;
            }
        }
        return null;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public boolean validarDisponibilidadDocente(int legajo, String dia,String turno){
        Docente docente = getDocente(legajo);
        return docente.estaDisponible(dia,turno);
    }
}
