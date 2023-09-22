package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class miException1 extends RuntimeException{
    static Scanner scanner = new Scanner(System.in);

    //construtor
    miException1(String mensaje){
        super(mensaje);
    }

    public static void ingregarEdad() throws miException1, InputMismatchException {

        // Leer un entero
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        // Limpiar el búfer de nueva línea
        scanner.nextLine();

        if(edad<0){
            throw new miException1("no podes tener menos de 0 anios");
        }else if (edad>120){
            throw new miException1("no hay chances que tengas mas de 120 anios");
        }

    }

    public static void main(String[] args) {
        try {
            ingregarEdad();
        }catch (miException1 objetoPropio){
            System.out.println(objetoPropio.getMessage());
        }catch (InputMismatchException objetoHeredado){
            System.out.println("caracter invalido");

        }
    }


}
