package Dominio.utils;
import java.util.Date;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Método para obtener la fecha actual
    public void fechaActual() {
        Date fechaActual = new Date();
        this.dia = fechaActual.getDate();
        this.mes = fechaActual.getMonth() + 1; // Sumamos 1 porque en Date el mes empieza desde 0
        this.anio = fechaActual.getYear() + 1900; // Sumamos 1900 porque en Date el año está en formato "año actual - 1900"
    }

    public boolean esAnteriorA(Fecha fecha){
        if (fecha.getAnio() < anio){
            return true;
        }
        if (fecha.getMes() < mes){
            return true;
        }
        if (fecha.getDia() <= dia){
            return true;
        }
        return false;
    }

    // Getters y setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Método para imprimir la fecha en formato dd/mm/aaaa
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}