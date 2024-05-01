package Dominio.Universidad;
import java.util.List;
import java.util.ArrayList;

public class Universidad {
    private List<Facultad> facultades;

    public Universidad() {
        facultades = new ArrayList<>();
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    // No necesitamos un setter para la lista, ya que la inicializamos en el constructor
}
