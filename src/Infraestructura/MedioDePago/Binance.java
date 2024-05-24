package Infraestructura.MedioDePago;

import Aplicacion.Interfaz.MetodoPago;

public class Binance implements MetodoPago {

    public void pagar(int monto) { System.out.println("Pagado con Binance");}
}
