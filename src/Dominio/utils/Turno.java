package Dominio.utils;

public class Turno {
    String turno;
    int horaInicio;
    int horaFin;

    public void cargarTurno(String turno, int horaI, int HoraF){

        this.turno=turno;
        this.horaInicio=horaI;
        this.horaFin=HoraF;

    }

    public void mostrarTurno(){
        System.out.println("Turno: " +this.turno+ ", Hora inicio: "+this.horaInicio+", Hora fin: "+ this.horaFin);
    }
}
