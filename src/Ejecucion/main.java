package Ejecucion;

import Aplicacion.Controladores.ControladoraInscripciones;
import Infraestructura.MedioDePago.MercadoPago;

public class main {

    public static void Main(String[] args) {
        ControladoraInscripciones.getInstancia().setMetodoPago(new MercadoPago());
    }
}