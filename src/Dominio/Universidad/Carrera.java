package Dominio.Universidad;
import java.util.List;
import java.util.ArrayList;

public class Carrera {
    private List<Materia> materias;
    private int cargaHorariaMaxima;

    public Carrera() {
        materias = new ArrayList<>();
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // No necesitamos un setter para la lista, ya que la inicializamos en el constructor

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
}
