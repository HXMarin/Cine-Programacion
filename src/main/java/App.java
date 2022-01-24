import Models.Sala;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        char fila = ' ';
        int columna = 0;
        int numSala = 0;

    }

    private static int getNumSala(Sala[]sala, Scanner sc) {
        System.out.println("Salas que están disponibles: ");
        for (int i = 0; i < sala.length; i++) {
            System.out.println("Sala"+(i+1));
        }
        System.out.println("Seleccione un Número de Sala");
        int numSala = sc.nextInt();
        return numSala -1;
    }

    private static int menu() {
        int caso = -1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Opciones del menu: ");
        do {
            System.out.println("0.Salir");
            System.out.println("1.Ver Sala");
            System.out.println("2.Reservar");
            System.out.println("3.Confirmar Reserva");
            System.out.println("4.Anular Reserva");
            System.out.println("5.Resumen");
            try {
                caso = sc.nextInt();
            }catch (Exception e){
                System.out.println("Introduzca una opción de 0-5");
                sc.next();
            }
        }while (caso < 0 || caso > 5);
        return caso;
    }
}
