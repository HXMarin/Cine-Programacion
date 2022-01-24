package Models;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import com.sun.jdi.request.InvalidRequestStateException;

public class Sala {
    private int filasLength;
    private int columnasLength;
    private final int MAX_COLUMNA = 9;
    private final int MAX_FILA = 5;
    private Butaca[][] matrizButaca;
    private int recaudacion;
    private final String filas = "ABCDE";

    public Sala(int filas, int columnas) {
        setFilas(filas);
        setColumnas(columnas);
        matrizButaca = new Butaca[filas][columnas];
        recaudacion = 0;
    }

    public int getFilas() {
        return filasLength;
    }

    public void setFilas(int filas) {
        if (filas < 1 || filas > MAX_FILA){
            throw new InvalidRequestStateException("La fila debe estar entre 1 y 5.");
        }else{
            this.filasLength = filas;
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
    public boolean itsFree(char fila, int columna){
        return (matrizButaca[filas.indexOf(fila)][columna - 1].getEstado() == EstadoButacas.LIBRE);
    }
    public Sala reservaButacas(char fila,int columna){
        if (itsFree(fila,columna)){
            matrizButaca[filas.indexOf(fila)][columna - 1].setEstado(EstadoButacas.RESERVADA);
        }else{
            System.out.println("La butaca está ocupada, elija otra.");
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
        com.diogonunes.jcolor.Attribute gb = Attribute.GREEN_BACK();
        com.diogonunes.jcolor.Attribute rb = Attribute.RED_BACK();
        com.diogonunes.jcolor.Attribute bb = Attribute.BLUE_BACK();
        for (int i = 0; i < MAX_FILA; i++) {
            System.out.print(filas.charAt(i));
            for (int j = 0; j < MAX_COLUMNA; j++) {
                if (matrizButaca[i][j].getEstado() == EstadoButacas.LIBRE){
                    System.out.print(Ansi.colorize("["+j+"]",gb));
                }else if (matrizButaca[i][j].getEstado()==EstadoButacas.RESERVADA){
                    System.out.print(Ansi.colorize("["+j+"]",bb));
                }else
                    System.out.print(Ansi.colorize("["+j+"]",rb));
            }
            System.out.println("");
        }
    }
}

