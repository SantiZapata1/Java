package ejercicios.JuegoAdivinanza;
import java.util.Random;
import java.util.Scanner;


public class Aplicacion {
    public static void main(String[] args) {

        //inicializacion del juego
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(5,4);

        //metodo para jugar
        juego1.Juega();
    }

}

//clase abstracta Juego
abstract class Juego{
    public abstract void Juega();
    public abstract void ReiniciaPartida();
    public abstract boolean QuitaVida();
    public abstract void ActualizaRecord();

}



//clase JuegoAdivinaNumero
class JuegoAdivinaNumero extends Juego{

    Scanner scanner = new Scanner(System.in);

    //atributos
    private int vidas;
    private int numAdivinar;
    private int numIngresado;
    private int record;

    //constructor
    JuegoAdivinaNumero(int vidas, int numAdivinar){
        this.vidas=vidas;
        this.numAdivinar=numAdivinar;
        this.record=0;
    }

    //metodos
    @Override
    public void Juega() {

        ReiniciaPartida();

        boolean respuesta=true;

        while(respuesta){

            System.out.println("vidas: "+this.vidas);
            System.out.println("record:"+this.record);
            System.out.println("num a adivinar:"+this.numAdivinar);


            System.out.print("Adivine el numero (0-10): ");
            numIngresado = scanner.nextInt();
            scanner.nextLine();

            if (this.numAdivinar==numIngresado){
                System.out.println("acertaste capo");
                Random random = new Random();
                this.numAdivinar=random.nextInt(10);

                ActualizaRecord();
            }else {
                respuesta=QuitaVida();
            }

        }

        System.out.println("FIN DEL JUEGO ;)");
        System.out.println("tu record: "+this.record);

    }

    @Override
    public void ReiniciaPartida() {
            this.record=0;
    }

    @Override
    public void ActualizaRecord(){
        this.record+=1;
    }

    @Override
    public boolean QuitaVida(){
        this.vidas-=1;

        if(this.vidas>0) {
            if (numIngresado < numAdivinar) {
                System.out.println("erraste, el numero es mayor");
            } else {
                System.out.println("erraste, el numero es menor");
            }
            return true;
        }else{
            return false;
        }

    }

}

