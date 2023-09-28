
import java.util.ArrayList;
import java.util.Scanner;


public class Hotel {
    public static void main(String[] args) {

        System.out.println("\n\n");
        Scanner scanner = new Scanner(System.in);

        ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

        Habitacion habitacion1 = new Habitacion(false,3,3);
        Habitacion habitacion2 = new Habitacion(false,5,6);
        Habitacion habitacion3 = new Habitacion(false,7,8);
        Habitacion habitacion4 = new Habitacion(false,1,1);
        Habitacion habitacion5 = new Habitacion(false,10,15);

        listaHabitaciones.add(habitacion1);
        listaHabitaciones.add(habitacion2);
        listaHabitaciones.add(habitacion3);
        listaHabitaciones.add(habitacion4);
        listaHabitaciones.add(habitacion5);


        String mensajeBienvenida="\nBienvenido al sistema de administracion de Habitaciones \n \t\t\t ¿que desea hacer?";
        System.out.println(mensajeBienvenida);

        int cont=0;
        while(true){


            cont+=1;
            System.out.println("\n vuelta num: "+cont);

            String opciones = "\n 1- Ver la lista de habitaciones \n 2- Reservar una habitación \n 3- Cancelar una reserva.  \n 4- Guardar reservas en un archivo  \n 5- Cargar reservas desde un archivo.  \n 6- SALIR  ";
            System.out.println(opciones);

            System.out.print("\n eleccion:");
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {

                //Ver la lista de habitaciones
                case 1:
                    System.out.println("\n lista de habitaciones: \n");
                        listarHabitaciones(listaHabitaciones);
                    break;

                //Reservar una habitación
                case 2:
                    System.out.println("\n Reservar una habitacion: \n");


                    break;

                //Cancelar una reserva.
                case 3:
                    System.out.println("\n Cancelar una reserva: \n");


                    break;

                //Guardar reservas en un archivo
                case 4:
                    System.out.println("\n Guardar reservas en un archivo: \n");




                    break;

                //Cargar reservas desde un archivo.
                case 5:

                    System.out.println("\n Cargar reservas desde un archivo: \n");



                    break;

                //salir
                case 6:
                    System.out.println("\n SALIMOS DEL PROGRAMA \n");

                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }




        }

    }
    public static void listarHabitaciones( ArrayList<Habitacion> listaHabitaciones){

        for (Habitacion habitacion: listaHabitaciones) {
            System.out.println(habitacion.mostrarInformacion());
        }

    }
}

class Habitacion{

    private boolean estado;
    private int cantidadCamas;
    private int capacidadHuespedes;


    public Habitacion(boolean estado, int cantidadCamas, int capacidadHuespedes) {
        this.estado = estado;
        this.cantidadCamas = cantidadCamas;
        this.capacidadHuespedes = capacidadHuespedes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public int getCapacidadHuespedes() {
        return capacidadHuespedes;
    }

    public void setCapacidadHuespedes(int capacidadHuespedes) {
        this.capacidadHuespedes = capacidadHuespedes;
    }


    public String mostrarInformacion() {
        return "Habitacion{" +
                "estado=" + (estado ? "Ocupado" : "Libre") +
                ", cantidadCamas=" + cantidadCamas +
                ", capacidadHuespedes=" + capacidadHuespedes +
                '}';
    }
}

abstract class persona{
    protected String nombre;
    protected int edad;

    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
interface Metodos{
    String mostrarInformacion();
}
class Huesped extends persona implements Metodos{

    private String nacionalidad;

    public Huesped(String nombre, int edad, String nacionalidad) {
        super(nombre, edad);
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String mostrarInformacion() {
        return "Huesped{" +
                "nacionalidad='" + nacionalidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

}
