package scanner;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer un entero
        System.out.print("Ingrese un número entero: ");
        int numeroEntero = scanner.nextInt();
        System.out.println("Número entero ingresado: " + numeroEntero);

        // Limpiar el búfer de nueva línea
        scanner.nextLine();

        // Leer una cadena de texto
        System.out.print("Ingrese una cadena de texto: ");
        String cadena = scanner.nextLine();
        System.out.println("Cadena ingresada: " + cadena);

        // Leer un número en punto flotante
        System.out.print("Ingrese un número en punto flotante: ");
        double numeroDecimal = scanner.nextDouble();
        System.out.println("Número en punto flotante ingresado: " + numeroDecimal);

        // Leer un carácter (solo el primer carácter)
        System.out.print("Ingrese un carácter: ");
        char caracter = scanner.next().charAt(0);
        System.out.println("Carácter ingresado: " + caracter);

        // Leer un booleano
        System.out.print("Ingrese un booleano (true/false): ");
        boolean esVerdadero = scanner.nextBoolean();
        System.out.println("Booleano ingresado: " + esVerdadero);

        // Cerrar el scanner
        scanner.close();
    }
}
