package Dominio.Universidad;
import java.util.List;
import java.util.ArrayList;

public class Carrera {
    private  String nombre;
    private List<Materia> materias;
    private int cargaHorariaMaxima;

    public Carrera() {
        materias = new ArrayList<>();
    }
    public Carrera(
            String nombreCarrera,
            int cargaHorariaMaxima
            ) {
        this.nombre = nombreCarrera;
        this.cargaHorariaMaxima = cargaHorariaMaxima;
        materias = new ArrayList<>();
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public List<Catedra> getCatedras(Materia materia){
        return materia.getCatedras();
    }

    // No necesitamos un setter para la lista, ya que la inicializamos en el constructor

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public int getCargaHorariaMaxima() {
        return cargaHorariaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCargaHorariaMaxima(int cargaHorariaMaxima){this.cargaHorariaMaxima=cargaHorariaMaxima;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
