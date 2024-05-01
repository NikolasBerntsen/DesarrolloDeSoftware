package Dominio.Universidad;
import java.util.List;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private String codigoID;
    private int cargaHoraria;
    private List<Materia> correlativasAnteriores;
    private List<Materia> correlativasPosteriores;
    private List<Catedra> catedras;

    public Materia() {
        correlativasAnteriores = new ArrayList<>();
        correlativasPosteriores = new ArrayList<>();
        catedras = new ArrayList<>();
    }

    // No necesitamos setters para las listas, ya que las inicializamos en el constructor

    public void agregarCorrelativaAnterior(Materia materia) {
        correlativasAnteriores.add(materia);
    }

    public void agregarCorrelativaPosterior(Materia materia) {
        correlativasPosteriores.add(materia);
    }

    public void agregarCatedra(Catedra catedra) {
        catedras.add(catedra);
    }
}