package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

//en los ejercicios es recomendable que arroje la excepcion mas cercana al error
public class ejemplo1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ingresarNumeroException();

    }

    //con esto informamos que en este metodo es probable que suceda una de esas excepciones (declaramos la excepcion)
    public static void evaluarNumero() throws InputMismatchException, RuntimeException{
        System.out.print("ingrese un numero: ");
        int numero= scanner.nextInt();
        System.out.println(numero);
    }

    //tratamos exception con try-catch
    //ejecutamos el metodo y segun la excepcion se ejecutan diferentes catchs
    public static void ingresarNumeroException(){
        try{
            evaluarNumero();
        }catch (InputMismatchException e){
            System.out.println("excepcion de inputMisma");
            //JOptionPane.showMessageDialog(null, "expecion en ventana emergente :)");
        }catch (RuntimeException e){
            System.out.println("excepcion de RuntimeException");
        }finally {
            System.out.println("programa terminado");
        }

    }

}
