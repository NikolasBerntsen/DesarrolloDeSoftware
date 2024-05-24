package Infraestructura.MedioDePago;

import Aplicacion.Interfaz.MetodoPago;

public class PagoMisCuentas implements MetodoPago {

    public void pagar(int monto) { System.out.println("Pagado con Pago Mis Cuentas");}
}
