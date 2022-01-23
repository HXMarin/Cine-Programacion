package Utils;
import java.util.Scanner;

public class Input {

    //Lectura de una línea por teclado
    Scanner sc = new Scanner(System.in);
    public String readLine(){
        String line = "";
        do {
            line = sc.nextLine();
        }while(line.length() > 0);
        return line;
    }

    //Lectura de un entero por teclado
    public int readInt(){
        int i = 0;
        boolean ok = false;
        do{
            try{
                i = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error, no has introducido un número entero");
                sc.next();
            }
        } while (!ok);
        return i;
    }
}

