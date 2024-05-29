package Dominio.Usuarios;

public abstract class Usuario {
    protected String nombre;
    protected int legajo;
    protected int DNI;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public int getDNI() {
        return DNI;
    }
}
