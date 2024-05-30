package Dominio.utils;

public class HorarioDocente {
    private boolean[][] matriz = new boolean[5][3];

    public int[] deTurnoADireccion (String dia,String turno){
        int[] xy = new int[2];
        switch (dia){
            case("lunes"):
                xy[0] = 0;
                break;
            case("martes"):
                xy[0] = 1;
                break;
            case("miercoles"):
                xy[0] = 2;
                break;
            case("jueves"):
                xy[0] = 3;
                break;
            case("viernes"):
                xy[0] = 4;
                break;
        }
        switch (turno){
            case("mañana"):
                xy[1] = 0;
                break;
            case("tarde"):
                xy[1] = 0;
                break;
            case("noche"):
                xy[1] = 0;
                break;
        }
        return xy;
    }

    public boolean getdisponibilidad(String dia,String turno){
        int[] xy = deTurnoADireccion(dia, turno);
        return matriz[xy[0]][xy[1]];
    }

    public void habilitarHorario(String dia,String turno){
        int[] xy = deTurnoADireccion(dia, turno);
        matriz[xy[0]][xy[1]] = true;
    }
    public void deshabilitarHorario(String dia,String turno){
        int[] xy = deTurnoADireccion(dia, turno);
        matriz[xy[0]][xy[1]] = false;
    }

    public void setMatriz(boolean[][] matriz) {
        this.matriz = matriz;
    }
}
