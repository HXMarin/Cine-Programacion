import Models.Sala;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Sala sala = new Sala(5, 9);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        char letra = ' ';
        int columna = 0;
        do {
            option = menuCreator();
            switch (option) {
                //Salir del programa
                case 0:
                    System.out.println("Buena tarde");
                    break;

                //Ver la sala
                case 1:
                    sala.ImprimirSala();
                    break;

                //Comprar la entrada
                case 2:
                    sala.ImprimirSala();
                    letra = colocacionLetra();
                    columna = colocacionColumna();
                    if (sala.itsFree(letra, columna)) {
                        sala.buyButaca(letra, columna);
                    } else {
                        System.out.println("La butaca está ocupada, elija otra.");
                    }
                    break;

                //Reserva de la entrada:
                case 3:
                    sala.ImprimirSala();
                    letra = colocacionLetra();
                    columna = colocacionColumna();
                    if (sala.itsFree(letra, columna)) {
                        sala.reservaButacas(letra, columna);
                    } else {
                        System.out.println("La Butaca está reservada u Ocupada, elija otra por favor.");
                    }
                    break;

                //Confirmar reserva(Pendiente de hacer)
                case 4:
                    break;
                //Cancelar la entrada(pendiente de hacer)
                case 5:
                    break;
                //Estado de la sala.
                case 6:
                    sala.salaEstado();
                    break;
            }
        }
        while (option != 0);
    }

    private static int menuCreator() {
        int cont = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Opciones: ");
        do {
            System.out.println("0-Salir");
            System.out.println("1-Ver la Sala");
            System.out.println("2-Comprar Entrada");
            System.out.println("3-Reserva de Entrada");
            System.out.println("4-Confirmar Reserva");
            System.out.println("5-Anular Reserva");
            System.out.println("6-Estado de la sala");
            try {
                cont = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce una opcion valida (0-6)");
                sc.next();
            }
        }while(cont < 0 || cont >6);
        return cont;
    }

    public static char colocacionLetra() {
        Scanner sc = new Scanner(System.in);
        char letra;
        String fila;
        System.out.println("Seleccione una fila:");
        fila = sc.next().toUpperCase(Locale.ROOT);
        letra = fila.charAt(0);
        return letra;
    }

    public static int colocacionColumna() {
        Scanner sc = new Scanner(System.in);
        int columna;
        System.out.println("Seleccione el número de columna:");
        columna = sc.nextInt();
        return columna;
    }

}
