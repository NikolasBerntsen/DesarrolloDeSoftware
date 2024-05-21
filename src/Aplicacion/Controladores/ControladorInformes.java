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
    private Exportar documento;
    public void setDocumento(Exportar tipoDocumento){
        this.documento = tipoDocumento;
    }

    public void exportarInformeCursada(List<Catedra> horarioSemanal){
        documento.exportar(horarioSemanal);
    }

}
