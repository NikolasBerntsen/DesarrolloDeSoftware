package Ejecucion;

import Aplicacion.Controladores.ControladorInformes;
import Aplicacion.Controladores.ControladoraInscripciones;
import Infraestructura.Exportar.PDF;
import Infraestructura.MedioDePago.MercadoPago;

import Test.TestControladorUniversidad;
import Test.TestControladoraInscripciones;

import Test.Aplicacion.TestControladorInformes;
import Test.Aplicacion.TestControladorUniversidad;
import Test.Aplicacion.TestControladoraInscripciones;


public class main {

    public static void main(String[] args) {
        ControladoraInscripciones.getInstancia().setMetodoPago(new MercadoPago());
        ControladorInformes.getInstancia().setExportador(new PDF());

        TestControladoraInscripciones.testValidarCorrelativas();
        TestControladoraInscripciones.testValidarCargaHoraria();
        TestControladoraInscripciones.testValidarDiaInscripcion();

        TestControladorUniversidad.testFromCarreraGetFacultad();

        TestControladorInformes.exportarInformeCursada();

    }
}