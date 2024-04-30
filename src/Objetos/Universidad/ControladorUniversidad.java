public class ControladorUniversidad {
    private static ControladorUniversidad instancia = null;

    private ControladorUniversidad() {}

    public static ControladorUniversidad getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUniversidad();
        }
        return instancia;
    }
    public void getCatedra(){}
    public void setCatedra(){}
    public void crearCatedra(){}
    public void getMateria(){}
    public void setMateria(){}
    public void crearMateria(){}
    public void getCarrera(){}
    public void setCarrera(){}
    public void crearCarrera(){}
    public void getFacultad(){}
    public void setFacultad(){}
    public void crearFacultad(){}

}
