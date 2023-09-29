package ejercicios.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


//clase principal
public class Hotel implements Serializable {


    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.println("\n");

        String direccionArchivo ="src" + File.separator + "ejercicios" + File.separator +"Hotel"+File.separator+"archivo.txt";

        escribirTextoEnArchivo(direccionArchivo,"HOTEL TRANSILVANIA");
        System.out.println(leerArchivo(direccionArchivo));

        //en el hotel creamo un arrayList de habitaciones
        ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

        Habitacion habitacion1 = new Habitacion(1, false,3,3);
        Habitacion habitacion2 = new Habitacion(2, false,5,6);
        Habitacion habitacion3 = new Habitacion(3, false,7,8);
        Habitacion habitacion4 = new Habitacion(4, false,1,2);
        Habitacion habitacion5 = new Habitacion(5, false,10,5);

        listaHabitaciones.add(habitacion1);
        listaHabitaciones.add(habitacion2);
        listaHabitaciones.add(habitacion3);
        listaHabitaciones.add(habitacion4);
        listaHabitaciones.add(habitacion5);

        //menu de administracion
        System.out.println("\n");
        String mensajeBienvenida="\nBienvenido al sistema de administracion de Habitaciones \n \t\t\t ¿que desea hacer?";
        System.out.println(mensajeBienvenida);

        int cont=0;

        while(true){

            cont+=1;
            System.out.println("\n --------------- accion numero "+cont+" ---------------");

            String opciones = "\n 1- Ver la lista de habitaciones \n 2- Reservar una habitación \n 3- Cancelar una reserva.  \n 4- Guardar reservas en un archivo  \n 5- Cargar reservas desde un archivo.  \n 6- SALIR  ";
            System.out.println(opciones);

            System.out.print("\n eleccion:");
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            String titulo;

            switch (eleccion) {

                //Ver la lista de habitaciones
                case 1:

                    titulo = "\n lista de habitaciones: \n";
                    System.out.println(titulo);

                    listarHabitaciones(listaHabitaciones);//item 1 funciona :)

                    break;

                //Reservar una habitación
                case 2:

                    titulo = "\n Reservar una habitacion \n";
                    System.out.println(titulo);

                    //ingresamos que habitacion deseamos reservar
                    System.out.println("Que habitacion que desea reservar?");
                    System.out.print("\n eleccion:");
                    int nroHabitacion = scanner.nextInt();
                    scanner.nextLine();

                    //buscamos habitacion
                    for (Habitacion habitacion: listaHabitaciones) {
                        if (habitacion.getNumeroHabitacion()==nroHabitacion){

                            habitacion.reservar();//metodo reservar funciona :)

                        }

                    }


                    break;

                //Cancelar una reserva.
                case 3:
                    titulo = "\n Cancelar una reserva: \n";
                    System.out.println(titulo);

                    //ingresamos que habitacion deseamos reservar
                    System.out.println("de que habitacion desea cancelar la reserva?");
                    System.out.print("\n eleccion:");
                    int nroHabitacion2 = scanner.nextInt();
                    scanner.nextLine();

                    //buscamos habitacion
                    for (Habitacion habitacion: listaHabitaciones) {
                        if (habitacion.getNumeroHabitacion()==nroHabitacion2){

                            habitacion.cancelarReserva();//metodo reservar funciona :)

                        }

                    }

                    break;

                //Guardar reservas en un archivo
                case 4:

                    titulo = "\n Guardar reservas en un archivo: \n";
                    System.out.println(titulo);

                    serializarArrayList(listaHabitaciones, "src" + File.separator + "ejercicios" + File.separator +"Hotel"+File.separator+"Datos.txt");


                    break;

                //Cargar reservas desde un archivo.
                case 5:

                    titulo = "\n Cargar reservas desde un archivo: \n";
                    System.out.println(titulo);

                    ArrayList<Habitacion> listaDeserializada = deserializarArrayList("src" + File.separator + "ejercicios" + File.separator +"Hotel"+File.separator+"Datos.txt");

                    listarHabitaciones(listaDeserializada);
                    break;

                //salir
                case 6:

                    titulo = "\n SALIMOS :) \n";
                    System.out.println(titulo);

                    return;
                default:
                    titulo = "\n Opcion invalida, intente devuelta. \n";
                    System.out.println(titulo);

            }




        }

    }

    //metodo par alistar las habitaciones
    public static void listarHabitaciones( ArrayList<Habitacion> listaHabitaciones){
        int cont=0;
        for (Habitacion habitacion: listaHabitaciones) {
            cont+=1;
            System.out.println(cont+" - "+habitacion.mostrarInformacion());
        }
    }

    public static void escribirTextoEnArchivo(String nombreArchivo, String texto) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
                escritor.write(texto);
                System.out.println("Texto escrito en " + nombreArchivo + " correctamente.");
            } catch (IOException e) {
                System.err.println("Error al escribir el texto en " + nombreArchivo + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

    public static String leerArchivo(String nombreArchivo) {
            StringBuilder contenido = new StringBuilder();

            try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
                e.printStackTrace();
            }

            return contenido.toString();
        }


    // Método para serializar un ArrayList
    public static void serializarArrayList(ArrayList<Habitacion> lista, String nombreArchivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            outputStream.writeObject(lista);
            System.out.println("ArrayList serializado y guardado en " + nombreArchivo + " correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el ArrayList en " + nombreArchivo + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static ArrayList<Habitacion> deserializarArrayList(String nombreArchivo) {
        ArrayList<Habitacion> listaDeserializada = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            listaDeserializada = (ArrayList<Habitacion>) inputStream.readObject();
            System.out.println("ArrayList deserializado correctamente desde " + nombreArchivo + ".");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el ArrayList desde " + nombreArchivo + ": " + e.getMessage());
            e.printStackTrace();
        }
        return listaDeserializada;
    }






}

//clase habitacion
class Habitacion implements Serializable {
    transient Scanner scanner2 = new Scanner(System.in);

    //atributos
    private int numeroHabitacion;
    private boolean estado;
    private int cantidadCamas;
    private int capacidadHuespedes;
    ArrayList<Huesped> listaHuespedes;

    //getters y setters
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
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


    //constructores
    public Habitacion(int numeroHabitacion, boolean estado, int cantidadCamas, int capacidadHuespedes) {
        this.numeroHabitacion=numeroHabitacion;
        this.estado = estado;
        this.cantidadCamas = cantidadCamas;
        this.capacidadHuespedes = capacidadHuespedes;
        this.listaHuespedes=new ArrayList<>();
    }

    public Habitacion() {
    }

    //metodos
    public String mostrarInformacion() {
        return "Habitacion  {" +
                " nro=" + numeroHabitacion +
                ", estado=" + (estado?"ocupado":"libre") +
                ", cant Camas=" + cantidadCamas +
                ", cant Huespedes=" + capacidadHuespedes +
                ", huespedes="+this.mostrarListaHuespedes()+" }";
    }

    public void reservar(){

        if (!this.estado) {
            this.setEstado(true);
            System.out.println("se reservo la habitacion");


            for(int x =0;x<this.capacidadHuespedes;x++ ){

                System.out.println("------"+(x+1)+"/"+this.capacidadHuespedes+"------");
                System.out.print("ingrese nombre del huesped: ");
                String nombre = scanner2.next();

                System.out.print("ingrese edad del huesped: ");
                int edad = scanner2.nextInt();

                System.out.print("ingrese nacionalidad del huesped: ");
                String nacionalidad = scanner2.next();
                System.out.println("------------");

                Huesped huesped = new Huesped(nombre, edad, nacionalidad);

                agregarHuesped(huesped);

            }

            mostrarHuespedes();

        } else {
            System.out.println("esa habitacion ya esta reservada");
        }
    }

    public void agregarHuesped(Huesped huesped){
        this.listaHuespedes.add(huesped);
        System.out.println("huesped agregado");
    }

    public void mostrarHuespedes(){
        System.out.println("\nlista de huespedes:");
        for (Huesped huesped:this.listaHuespedes){

            System.out.println(huesped.mostrarInformacion());

        }
    }

    public String mostrarListaHuespedes() {
        String lista=" ";

        for (Huesped huesped : this.listaHuespedes) {
            lista += huesped.getNombre() ;
        }
        return lista;
    }

    public void cancelarReserva(){

        if(this.estado){
            this.setEstado(false);
            System.out.println("se cancelo la reserva");

            this.listaHuespedes.clear();

        }else{
            System.out.println("esta habitacion no esta reservada");
        }

    }

}

//subclase Hesped
class Huesped extends persona implements Metodos,Serializable{

    //atributos
    private String nacionalidad;

    //getters y setters
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //constructor
    public Huesped(String nombre, int edad, String nacionalidad) {
        super(nombre, edad);
        this.nacionalidad = nacionalidad;
    }


    //metodos
    @Override
    public String mostrarInformacion() {
        return "Huesped{" +
                "nacionalidad='" + nacionalidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }




}

//superclase persona
abstract class persona implements Serializable{

    //atributo
    protected String nombre;
    protected int edad;

    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //contructor
    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public persona() {
    }
}

//interfaz con metodo para mostrar informacion
interface Metodos{
    String mostrarInformacion();
}

