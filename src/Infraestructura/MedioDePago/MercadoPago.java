package Infraestructura.MedioDePago;

import Aplicacion.Interfaz.MetodoPago;

public class MercadoPago implements MetodoPago {
    public void pagar(int monto) {
        System.out.println("Pagado con Mercado Pago");
    }
}