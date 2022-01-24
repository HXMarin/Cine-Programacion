package Models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import com.sun.jdi.request.InvalidRequestStateException;

public class Sala {
    private int filasLength;
    private int columnasLength;
    private final int MAX_COLUMNA = 9;
    private final int MAX_FILA = 5;
    private final String LETRAS = "ABCDE";

    private Butaca[][] matrizButaca;
    private Butaca[][] sitios;
    private int recaudacion;
    private int butacasLibres;
    private int butacasReservadas;
    private int butacasOcupadas;



    public Sala(int filas, int columnas) {
        setLetras(filas);
        setColumnas(columnas);
        setMatrizButaca(matrizButaca);
        butacasLibres = MAX_FILA * MAX_COLUMNA;
        butacasReservadas = 0;
        butacasOcupadas = 0;
        recaudacion = 0;
    }

    public int getLetras() {
        return filasLength;
    }

    public void setLetras(int letras) {
        if (letras < 1 || letras > MAX_FILA){
            throw new InvalidRequestStateException("La fila debe estar entre 1 y 5.");
        }else{
            this.filasLength = letras;
        }
    }

    public int getColumnas() {
        return columnasLength;
    }

    public void setColumnas(int columnas) {
        if (columnas < 1 || columnas > MAX_COLUMNA){
            throw new InvalidRequestStateException("La columna debe estar entre 1 y 9.");
        }else{
            this.columnasLength = columnas;
        }
    }

    private Butaca[][] getMatrizButaca() {
        return matrizButaca;
    }

    private void setMatrizButaca(Butaca[][] matrizButaca) {
        this.matrizButaca = matrizButaca;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }
    public int increaseRecaudacion(){
        setRecaudacion(getRecaudacion() + 6);
        return getRecaudacion();
    }
    public int decreaseRecaudacion(){
        if (getRecaudacion() >= 6){
            setRecaudacion(getRecaudacion() - 6);
            return getRecaudacion();
        }else return -1;
    }

    public int getButacasLibres() {
        return butacasLibres;
    }

    public void setButacasLibres(int butacasLibres) {
        this.butacasLibres = butacasLibres;
    }

    public int getButacasReservadas() {
        return butacasReservadas;
    }

    public void setButacasReservadas(int butacasReservadas) {
        this.butacasReservadas = butacasReservadas;
    }

    public int getButacasOcupadas() {
        return butacasOcupadas;
    }

    public void setButacasOcupadas(int butacasOcupadas) {
        this.butacasOcupadas = butacasOcupadas;
    }

    public boolean itsFree(char fila, int columna){
        return (matrizButaca[LETRAS.indexOf(fila)][columna - 1].getEstado() == EstadoButacas.LIBRE);
    }
    public boolean itsReserved(char fila, int columna){
        return (matrizButaca[LETRAS.indexOf(fila)][columna - 1].getEstado() == EstadoButacas.RESERVADA);
    }
    public Sala reservaButacas(char fila,int columna){
        if (itsFree(fila,columna)){
            matrizButaca[LETRAS.indexOf(fila)][columna - 1].setEstado(EstadoButacas.OCUPADA);
        }else{
            System.out.println("La butaca está Reservada, elija otra.");
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < matrizButaca.length; i++) {
            for (int j = 0; j < matrizButaca[i].length; j++) {
             result += matrizButaca[i][j];
            }
            result+= "\n";
        }
        return result;
    }

    public void printSala(){
        Attribute gb = Attribute.GREEN_BACK();
        Attribute rb = Attribute.RED_BACK();
        Attribute bb = Attribute.BLUE_BACK();
        for (int i = 0; i < filasLength; i++) {
            System.out.print(LETRAS.charAt(i));
            for (int j = 0; j < columnasLength; j++) {
                if (matrizButaca[i][j].getEstado() == EstadoButacas.LIBRE){
                    System.out.print(Ansi.colorize("["+j+"]",gb));
                }else if (matrizButaca[i][j].getEstado()==EstadoButacas.RESERVADA){
                    System.out.print(Ansi.colorize("["+j+"]",bb));
                }else
                    System.out.print(Ansi.colorize("["+j+"]",rb));
            }
            System.out.println("");
        }
        System.out.println(" 1 2 3 4 5 6 7 8 9 ");
    }
}

