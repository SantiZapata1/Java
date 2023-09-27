package ejercicios.ConsecionariaCHAT;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Interfaz para la serialización
interface Serializable {
    void guardar(String archivo) throws IOException;
    Serializable cargar(String archivo) throws IOException, ClassNotFoundException;
}

// Clase abstracta Vehiculo
abstract class Vehiculo implements java.io.Serializable {
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public abstract double calcularImpuesto();

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: $" + precio);
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + precio;
    }

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double nuevoPrecio) {
        this.precio=nuevoPrecio;
    }
}

// Clase Coche que hereda de Vehiculo
class Coche extends Vehiculo implements java.io.Serializable {
    public Coche(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        return getPrecio() * 0.18;
    }
}

// Clase Moto que hereda de Vehiculo
class Moto extends Vehiculo implements java.io.Serializable {
    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        return getPrecio() * 0.15;
    }
}

// Clase Concesionaria que implementa la interfaz Serializable
class Concesionaria implements Serializable, java.io.Serializable {
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado.");
    }

    public void eliminarVehiculo(String marca, String modelo) {
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)) {
                iterator.remove();
                System.out.println("Vehículo eliminado.");
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    public void editarPrecio(String marca, String modelo, double nuevoPrecio) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)) {
                vehiculo.mostrarInformacion();
                vehiculo.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado.");
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la concesionaria:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
            System.out.println("Impuesto a pagar: $" + vehiculo.calcularImpuesto());
            System.out.println("---------------------------");
        }
    }

    @Override
    public void guardar(String archivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(this);
            System.out.println("Datos guardados en " + archivo + ".");
        }
    }

    @Override
    public Serializable cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
            Concesionaria concesionariaCargada = (Concesionaria) inputStream.readObject();
            System.out.println("Datos cargados desde " + archivo + ".");
            return concesionariaCargada;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionaria concesionaria = new Concesionaria();

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Eliminar vehículo");
            System.out.println("3. Editar precio");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Guardar datos");
            System.out.println("6. Cargar datos");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la línea en blanco después de nextInt()

            switch (opcion) {
                case 1:
                    agregarVehiculo(scanner, concesionaria);
                    break;
                case 2:
                    eliminarVehiculo(scanner, concesionaria);
                    break;
                case 3:
                    editarPrecio(scanner, concesionaria);
                    break;
                case 4:
                    concesionaria.mostrarInventario();
                    break;
                case 5:
                    guardarDatos(scanner, concesionaria);
                    break;
                case 6:
                    cargarDatos(scanner, concesionaria);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarVehiculo(Scanner scanner, Concesionaria concesionaria) {
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Coche");
        System.out.println("2. Moto");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume la línea en blanco después de nextInt()

        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consume la línea en blanco después de nextDouble()

        Vehiculo vehiculo;
        if (tipo == 1) {
            vehiculo = new Coche(marca, modelo, precio);
        } else if (tipo == 2) {
            vehiculo = new Moto(marca, modelo, precio);
        } else {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }

        concesionaria.agregarVehiculo(vehiculo);
    }

    private static void eliminarVehiculo(Scanner scanner, Concesionaria concesionaria) {
        System.out.print("Ingrese la marca del vehículo a eliminar: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo a eliminar: ");
        String modelo = scanner.nextLine();
        concesionaria.eliminarVehiculo(marca, modelo);
    }

    private static void editarPrecio(Scanner scanner, Concesionaria concesionaria) {
        System.out.print("Ingrese la marca del vehículo a editar: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo a editar: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine(); // Consume la línea en blanco después de nextDouble()
        concesionaria.editarPrecio(marca, modelo, nuevoPrecio);
    }

    private static void guardarDatos(Scanner scanner, Concesionaria concesionaria) {
        System.out.print("Ingrese el nombre del archivo para guardar los datos: ");
        String archivo = scanner.nextLine();
        try {
            concesionaria.guardar(archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo.");
        }
    }

    private static void cargarDatos(Scanner scanner, Concesionaria concesionaria) {
        System.out.print("Ingrese el nombre del archivo para cargar los datos: ");
        String archivo = scanner.nextLine();
        try {
            Serializable datosCargados = concesionaria.cargar(archivo);
            if (datosCargados != null && datosCargados instanceof Concesionaria) {
                concesionaria = (Concesionaria) datosCargados;
                System.out.println("Datos cargados correctamente.");
            } else {
                System.out.println("Los datos no pudieron cargarse correctamente.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos desde el archivo.");
        }
    }
}
