package Dominio.Universidad;
import java.util.List;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private int codigoID;
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

    public void setID(int codigoID) {
        this.codigoID = codigoID;
    }


    public void agregarCorrelativaPosterior(Materia materia) {
        correlativasPosteriores.add(materia);
    }

    public void agregarCatedra(Catedra catedra) {
        catedras.add(catedra);
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Catedra> getCatedras() {
        return catedras;
    }

    public List<Materia> getCorrelativasAnteriores() {
        return correlativasAnteriores;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoID() {
        return codigoID;
    }

    public List<Materia> getCorrelativasPosteriores() {
        return correlativasPosteriores;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCargaHoraria(int cargaHoraria) {this.cargaHoraria = cargaHoraria;}

    public void borrarCatedra(int id){
        for (Catedra catedra: catedras){
            if (catedra.getId() == id){
                catedras.remove(catedra);
                return;
            }
        }
    }
}
