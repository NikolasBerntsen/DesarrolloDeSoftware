package Aplicacion.Controladores;

import Aplicacion.Interfaz.Exportar;
import Dominio.Universidad.Catedra;

import java.util.List;

public class ControladorInformes {
    private static ControladorInformes instancia = null;

    private ControladorInformes() {}

    public static ControladorInformes getInstancia() {
        if (instancia == null) {
            instancia = new ControladorInformes();
        }
        return instancia;
    }
    private Exportar exportar;
    public void setExportador (Exportar exportador){
        this.exportar = exportador;
    }

    public void exportarInformeCursada(List<Catedra> horarioSemanal){
        exportar.exportar(horarioSemanal);
    }

}
