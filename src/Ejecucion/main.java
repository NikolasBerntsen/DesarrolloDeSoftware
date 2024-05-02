package Ejecucion;

import Aplicacion.Controladores.ControladorInformes;
import Aplicacion.Controladores.ControladoraInscripciones;
import Infraestructura.Exportar.PDF;
import Infraestructura.MedioDePago.MercadoPago;

public class main {

    public static void main(String[] args) {
        ControladoraInscripciones.getInstancia().setMetodoPago(new MercadoPago());
        ControladorInformes.getInstancia().setExportador(new PDF());
    }
}