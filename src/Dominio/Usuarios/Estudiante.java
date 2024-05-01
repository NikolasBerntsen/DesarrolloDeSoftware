package Dominio.Usuarios;

import Dominio.Universidad.Carrera;
import Dominio.Universidad.Catedra;
import Dominio.Universidad.Materia;

import java.util.List;

public class Estudiante {
    private List<Carrera> carreras;
    private List<Materia> materiasAprobadas;
    private List<Catedra> catedrasInscriptas;
    private Integer cargaHoraria;

}
