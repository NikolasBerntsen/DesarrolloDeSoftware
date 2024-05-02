package Infraestructura.Exportar;

import Aplicacion.Interfaz.Exportar;
import Dominio.Universidad.Catedra;

import java.util.List;

public class PDF implements Exportar {
    @Override
    public void exportar(List<Catedra> horarioSemanal) {
        System.out.println("Exportado a PDF");
    }
}