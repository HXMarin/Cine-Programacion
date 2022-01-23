package Models;

import com.sun.jdi.request.InvalidRequestStateException;

public class Sala {
    private int filasLength;
    private int columnasLength;
    private final int MAX_COLUMNA = 9;
    private final int MAX_FILA = 5;
    private Butaca[][] matrizButaca;

    public Sala(int filas, int columnas) {
        setFilas(filas);
        setColumnas(columnas);
        matrizButaca = new Butaca[filas][columnas];
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
}

