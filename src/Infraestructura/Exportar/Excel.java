package Infraestructura.Exportar;

import Aplicacion.Interfaz.Exportar;
import Dominio.Universidad.Catedra;

import java.util.List;

public class Excel implements Exportar {

    public void exportar(List<Catedra> horarioSemanal) {
        // Imprimir el contenido de la lista de horario semanal
        System.out.println("Contenido de la lista de horario semanal:");

        for (int i = 0; i < horarioSemanal.size(); i++)
            System.out.println("Índice " + i + ": " + horarioSemanal.get(i));

        // Indicar que se ha exportado a Excel
        System.out.println("Exportado a Excel");
    }
}
