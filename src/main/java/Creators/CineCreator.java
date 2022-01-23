package Creators;
import Utils.Input;
public class CineCreator {

    public CineCreator() {
      int fila = filaReader();
      int columna = columnaReader();
    }

    private int filaReader() {
        Input input = new Input();
        boolean isOk = false;
        int fila = -1;
        do {
            System.out.println("Selección de la columna de la butaca 1 al 5: ");
            fila = input.readInt();
            if (fila < 1 || fila > 5){
                System.err.println("El dato introducido no es válido.");
            }else{
                isOk = true;
            }
        }while(!isOk);
        return fila;
    }

    private int columnaReader() {
        Input input = new Input();
        boolean isOk = false;
        int columna = -1;
        do {
            System.out.println("Selección de la columna de la butaca 1 al 9: ");
            columna = input.readInt();
            if (columna < 1 || columna > 9){
                System.err.println("El dato introducido no es válido.");
            }else{
                isOk = true;
            }
        }while(!isOk);
        return columna;
    }

}
